package com.sqav.tattow.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sqav.tattow.vo.StandardObjectReturn;

import static com.sqav.tattow.support.RequestProps.REQUEST_ID;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@ControllerAdvice({
	"com.sqav.tattow.rest"
})
public class ResourceExceptionHandlerRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceExceptionHandlerRest.class);
	
	@ExceptionHandler(TattowException.class)
	public ResponseEntity<StandardObjectReturn> tattowException(TattowException e, HttpServletRequest request) {
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
		escreverErroNoLog("TattowException", e, e.getLevel());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}
	
	@ExceptionHandler(SecurityException.class)
	public ResponseEntity<StandardObjectReturn> securityException(SecurityException e, HttpServletRequest request) {
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
		escreverErroNoLog("SecurityException", e, "INFO");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}
	
	@ExceptionHandler(RequestLimitException.class)
	public ResponseEntity<StandardObjectReturn> requestLimitException(@RequestAttribute(REQUEST_ID) UUID uuid, RequestLimitException e) {
		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(new StandardObjectReturn(HttpStatus.TOO_MANY_REQUESTS.value(), e.getMessage()));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardObjectReturn> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
		if (e.getCause() != null && e.getCause() instanceof InvalidFormatException) {
			InvalidFormatException exc = (InvalidFormatException) e.getCause();
			String fieldName = getInvalidFormatExceptionFieldName(exc);
			
			String message = "O valor do campo não possui um formato válido.";
			if (StringUtils.isNotBlank(fieldName)) {
				message = "O valor do campo não possui um formato válido: ".concat(fieldName);
			}
			
			StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), message);
			escreverErroNoLog("InvalidFormatException", e, "ERROR");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro inesperado. Tente novamente, se persistir nos avise. (Erro E100)");
		escreverErroNoLog("HttpMessageNotReadableException", e, "ERROR");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	private String getInvalidFormatExceptionFieldName(InvalidFormatException exc) {
		for (JsonMappingException.Reference r : exc.getPath()) {
			return r.getFieldName();
		}
		
		return null;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardObjectReturn> numberFormatException(NumberFormatException e, HttpServletRequest request) {
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), "Ocorreu um erro inesperado. Verifique a formatação dos números enviados. (Erro E096)");
		escreverErroNoLog("NumberFormatException", e, "ERROR");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(JsonParseException.class)
	public ResponseEntity<StandardObjectReturn> jsonParseException(JsonParseException e, HttpServletRequest request) {
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), "Ocorreu um erro inesperado. Verifique os dados de entrada do serviço. (Erro E097)");
		escreverErroNoLog("JsonParseException", e, "ERROR");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<StandardObjectReturn> invalidFormatException(InvalidFormatException e, HttpServletRequest request) {
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), "Ocorreu um erro inesperado. Verifique os dados informados(Campos data e campos numéricos). (Erro E098)");
		escreverErroNoLog("InvalidFormatException", e, "ERROR");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}	
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<StandardObjectReturn> dateTimeParseException(DateTimeParseException e, HttpServletRequest request){
		String mensage;
		if (e.getMessage() != null && e.getMessage().contains("Invalid value for HourOfDay")){
			mensage = "O formato de hora informado é inválido. Tente o padrão HH:mm";
		}else {
			mensage = "O formato de data/hora informado é inválido. Tente o padrão dd/MM/yyyy ou dd/MM/yyyy HH:mm";
		}

		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), mensage);

		escreverErroNoLog("Exception", e, "ERROR");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardObjectReturn> allExceptions(Exception e, HttpServletRequest request){
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro inesperado. Tente novamente, se o problema persistir, nos avise. (Erro E100)");
		escreverErroNoLog("Exception", e, "ERROR");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<StandardObjectReturn> forbiddenException(ForbiddenException e, HttpServletRequest request){
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.FORBIDDEN.value(), e.getMessage());
		escreverErroNoLog("ForbiddenException", e, e.getLevel());
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
							 .contentType(MediaType.APPLICATION_JSON)
							 .body(error);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<StandardObjectReturn> timeoutException(ResourceAccessException e, HttpServletRequest request){
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.GATEWAY_TIMEOUT.value(), "Ocorreu um erro inesperado. Tente novamente, se o problema persistir, nos avise.");
		escreverErroNoLog("ResourceAccessException", e, "ERROR");
		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(error);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardObjectReturn> badRequestExceptionHandler(BadRequestException e, HttpServletRequest request){
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		escreverErroNoLog("BadRequestException", e, "ERROR");
		return ResponseEntity.badRequest()
							 .body(error);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardObjectReturn> recursoNaoEncontradoExceptionHandler(NotFoundException e, HttpServletRequest request){
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.NOT_FOUND.value(), e.getMessage());
		escreverErroNoLog(e.getClass().getName(), e, "ERROR");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .body(error);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<StandardObjectReturn> ArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e , HttpServletRequest request) {
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), "Ocorreu um erro inesperado. Verifique os dados de entrada, se o problema persistir, nos avise.");
		escreverErroNoLog(e.getClass().getName(), e, "ERROR");
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(error);
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> bindException(BindException ex) {
		List<String> errors = new ArrayList<>();

		for (FieldError error : ex.getBindingResult().getFieldErrors())
			errors.add(error.getField() + ": " + error.getDefaultMessage());

		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		Map<String, Object> error = new LinkedHashMap<>();
		error.put("status", HttpStatus.BAD_REQUEST.value());
		error.put("msg", errors);
		error.put("object", null);
		error.put("timestamp", new Date().getTime());

		escreverErroNoLog("BindException", ex, "ERROR");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParamHandler(MissingServletRequestParameterException e) {
		String mensagem = "O parametro "+e.getParameterName()+" está inválido.";
		Map<String, Object> error = new LinkedHashMap<>();
		error.put("status", HttpStatus.BAD_REQUEST.value());
		error.put("msg", mensagem);
		error.put("object", null);
		error.put("timestamp", new Date().getTime());

		escreverErroNoLog("MissingServletRequestParameterException", e, "ERROR");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(TattowJwtException.class)
	public ResponseEntity<?> errorJwt(TattowJwtException e) {
		return ResponseEntity.status(UNAUTHORIZED)
							 .body("O token está expirado ou teve seu conteúdo modificado!");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> errorBeanValidation(MethodArgumentNotValidException exception) {
		BindingResult bindingResult = exception.getBindingResult();

		if(Objects.nonNull(bindingResult)) {
			List<String> fields = bindingResult.getFieldErrors()
											   .stream()
											   .map(FieldError::getField)
											   .collect(Collectors.toList());
			return ResponseEntity.badRequest()
					 .body(String.format("Erro de validação na requisição no campo: %s", StringUtils.join(fields, ",")));
		}
		return ResponseEntity.badRequest()
				 .body("Houve um erro de validação na requisição. Não foi possível obter dados do erro.");
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardObjectReturn> handle(IllegalArgumentException exc) {
		escreverErroNoLog("IllegalArgumentException", exc, "ERROR");
		StandardObjectReturn error = new StandardObjectReturn(HttpStatus.BAD_REQUEST.value(), exc.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}	
	
	
	private void escreverErroNoLog(String exceptionType, Throwable e, String level) {
		if (e != null) {
			String message = e.getMessage() != null ? e.getMessage() : "";
			
			if (level == null || "ERROR".equalsIgnoreCase(level)) {
				LOGGER.error("***ERROR ".concat(exceptionType).concat(" ===> ".concat(message)), e);
				return;
			}
			
			if ("INFO".equalsIgnoreCase(level)) {
				LOGGER.info("***INFO ".concat(exceptionType).concat(" ===> ".concat(message)), e);
				return ;
			}
			
			if ("WARN".equalsIgnoreCase(level)) {
				LOGGER.info("***WARN ".concat(exceptionType).concat(" ===> ".concat(message)), e);
				return ;
			}
		}
	}
}
