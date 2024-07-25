package com.sqav.tattow.support;

import static java.util.Objects.nonNull;

import java.text.Normalizer;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import org.apache.commons.lang3.StringUtils;

/**
 * Metodos estaticos utilitarios para trabalhar com Strings ou colecoes de Strings
 *
 * @author WDEV
 */
public class Strings {

	/**
	 * Normaliza o CEP colocando tamanho 8 e preenchendo com zeros a esquerda se necessario
	 *
	 * @param cep CEP original
	 * @return CEP normalizado
	 */
	public static String normalizeZipCode(String zipCode) {
		if (StringUtils.isBlank(zipCode)) {
			return null;
		}
		return StringUtils.leftPad(removeNonNumericCharacters(zipCode), 8, '0');
	}

	/**
	 * Desnormaliza o CPF removendo toda a formatacao, mantendo apenas os numeros
	 *
	 * @param cpf CPF original
	 * @return CPF normalizado
	 */
	public static String denormalizeCpf(String cpf) {
		if (StringUtils.isNotBlank(cpf)) {
			return completeCpf(cpf);
		}
		return null;
	}

	/**
	 * Desnormaliza o CPF removendo toda a formatacao, mantendo apenas os numeros
	 *
	 * @param cpf CPF original
	 * @return CPF normalizado
	 */
	public static Long denormalizeCpfForNumeric(String cpf) {
		if (StringUtils.isNotBlank(cpf)) {
			return Long.valueOf(removeNonNumericCharacters(cpf));
		}
		return null;
	}

	/**
	 * Remove os caracteres nao numericos do cpf e preenche com zeros a esquerda se necessario
	 *
	 * @param cpf CPF original
	 * @return CPF apenas com caracteres numéricos e com zeros a esquerda se necessário
	 */
	protected static String completeCpf(String cpf) {
		return StringUtils.leftPad(removeNonNumericCharacters(cpf), 11, '0');
	}

	/**
	 * Normaliza o CNPJ mantendo-o com tamanho 14 e com zeros a esquerda se necessario
	 *
	 * @param cnpj cnpj original
	 * @return cnpj normalizado
	 */
	public static String normalizeCnpj(String cnpj) {
		if (cnpj == null) {
			return null;
		}
		return StringUtils.leftPad(removeNonNumericCharacters(cnpj), 14, '0');
	}

	public static String removeNonNumericCharacters(String texto) {
		if(texto != null) {
			return texto.replaceAll("[^\\d]", "");
		}
		return null;
	}

	/**
	 * A partir de uma lista de Strings retorna um Set com os valores duplicados dessa lista.
	 *
	 * @param lista Lista completa com as Strings
	 * @return Set com as strings duplicadas
	 */
	public static Set<String> findDuplicates(List<String> lista) {
		List<String> copia = new ArrayList<String>(lista);
		for (String value : new HashSet<String>(lista)) {
			copia.remove(value);
		}
		return new HashSet<String>(copia);
	}

	public static String normalizeCellphone(String cellphone) {
		if (StringUtils.isBlank(cellphone)) {
			return null;
		}
		return removeNonNumericCharacters(cellphone);
	}

	public static String uppercase(String texto) {
		if (StringUtils.isBlank(texto)) {
			return null;
		}
		return texto.toUpperCase();
	}

	/**
	 * Metodo responsavel por verificar se a String e vazia ou nula.
	 *
	 * @param string - objeto a ser verificado.
	 * @return boolean - true/false
	 */
	public static boolean isBlankOrNull(String string) {
		return StringUtils.isBlank(string);
	}

	public static boolean isNotBlankOrNull(String string) {
		return !isBlankOrNull(string);
	}

	public static boolean isNotValidMaxFieldSize(String field, int size) {
		return StringUtils.length(field) > size;
	}

	/**
	 * Retorna uma String vazia com o tamanho informado
	 *
	 * @param tamanho - referente tamanho da string
	 * @return String vazia com o tamanho informado
	 */
	public static String spaces(int size) {
		return StringUtils.leftPad("", size, " ");
	}

	public static String formatString(String value, String pattern) {
		MaskFormatter mf;
		try {
			mf = new MaskFormatter(pattern);
			mf.setValueContainsLiteralCharacters(false);
			String retorno = mf.valueToString(value);
			if (pattern.replace("#", " ").equals(retorno)) return "";
			return retorno;
		} catch (ParseException ex) {
			return value;
		}
	}

	/**
	 * 	Formata a mensagem usando dangling metacharacter({}) como sinal para atribuição.
	 * 	<br/><b>Exemplo de uso:</b>
	 * 	<br/><code>String.format("Paciente: {}, idade {}, sexo {}, flag ativo {}", "Jesus de Nazaré", 33, "M", true)</code>
	 * 	<br/><b>Resultado:</b> <i>Paciente: Jesus de Nazaré, idade 33, sexo M, flag ativo true</i>
	 * @param templateMessage
	 * @param attributes
	 * @return Mensagem formatada de acordo com o template e atributos fornecidos.
	 */
	public static String format(String templateMessage, Object... attributes) {
		for (Object attribute : attributes) {
			templateMessage = templateMessage.replaceFirst("\\{\\}", (attribute != null ? attribute.toString() : "null"));
		}
		return templateMessage;
	}

	public static String formatZipCode(String cep) {
		String denormalizeZipCode = denormalizeZipCode(cep);
		if (denormalizeZipCode != null) {
			return formatString(denormalizeZipCode, "#####-###");
		}
		return "";
	}

	public static String formatCpf(String cpf) {
		if (cpf != null) {
			return formatString(cpf, "###.###.###-##");
		}
		return "";
	}

	public static String formatCellphone(String cellphone) {
		if (nonNull(cellphone)) {
			cellphone = Strings.removeNonNumericCharacters(cellphone);
			if (cellphone.length() == 11) {
				return formatString(cellphone, "(##)#####-####");
			}
			if (cellphone.length() == 10) {
				return formatString(cellphone, "(##)####-####");
			}
		}
		return "";
	}

	public static String formatCellphonePattern(String cellphone, String pattern) {
		if (StringUtils.isNotBlank(cellphone) && StringUtils.isNotBlank(pattern)) {
			return formatString(Strings.removeNonNumericCharacters(cellphone), pattern);
		}
		return "";
	}

	public static String formatCnpj(String cnpj) {
		if (cnpj != null) {
			return formatString(cnpj, "##.###.###/####-##");
		}
		return "";
	}

	//TODO - PEGAR O FILENAMEUTILS
//	public static String normalizeFileName(String fileName) {
//		String extension = FilenameUtils.getExtension(fileName);
//		return gerarTokenUnico().concat(".").concat(extension);
//	}

	public static String generateUniqueToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String cleanHtmlTags(String text) {
		if (text == null) {
			return null;
		}
		return text.replaceAll("<[^>]*>", " ").replaceAll("&nbsp;", " ").replaceAll("\n", "").replaceAll("\t", "");
	}

	public static String generateTemporaryPassword() {
		return generateUniqueToken().substring(0, 9);
	}

	public static boolean isValidZipCode(String zipCode) {
		if (zipCode != null) {
			return zipCode.length() <= 9;
		}
		return false;
	}

	public static String denormalizeZipCode(String zipCode) {
		if (zipCode != null) {
			return zipCode.replace("-", "").replace(".", "");
		}
		return null;
	}

	public static String removeBlankSpaces(String str) {
		if (StringUtils.isNotBlank(str)) {
			return str.replaceAll("\\s+", "");
		}
		
		return null;
	}

//	public static String gerarUrlWhatsApp(String celular, String mensagem) {
//		if (StringUtils.isBlank(celular)) {
//			return null;
//		}
//
//		String celularNormalizado = "55".concat(celular.replace("-", "").replace("(", "").replace(")", ""));
//		if (StringUtils.isBlank(mensagem)) {
//			return Constantes.URL_WHATSAPP.concat(celularNormalizado);
//		} else {
//			return Constantes.URL_WHATSAPP.concat(celularNormalizado).concat("&text=").concat(mensagem);
//		}
//	}

	public static String applyFirstLetterCapital(String value) {
		StringBuilder formatValue = new StringBuilder();
		if(!StringUtils.isBlank(value)) {
			int contador = 0;
			String[] array = value.split(" ");

			for (String s : array) {
				contador++;
				if (StringUtils.isNotBlank(s)) {
					formatValue.append(StringUtils.capitalize(s.toLowerCase()));
					if (contador < array.length) {
						formatValue.append(" ");
					}
				}
			}
		}

		return formatValue.toString();
	}

	public static String firstNameWithFirstLetterCapital(String name) {
		if (StringUtils.isNotBlank(name)) {
			name = name.toLowerCase();
			String formatName = StringUtils.capitalize(name.toLowerCase());
			String[] nameSplit = name.split(" ");
			if (nameSplit.length > 1) {
				formatName = nameSplit[0];
			}
			return StringUtils.capitalize(formatName);
		}
		return "";
	}

	public static String removeAccents(String str) {
		if(str != null) {
			return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}
		return str;
	}

	public static String recoverFileExtension(String fileName) {
		try {
			if(fileName != null) {
				return StringUtils.right(fileName, 4).replace(".", "");
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public static String mischaracterizeEmail(String email) {
		if (StringUtils.isBlank(email)) {
			return null;
		}
		return email.replaceAll("^(.{3}).*?(@)", "$1*****$2");
	}

	public static String mischaracterizeCellphone(String cellphone) {
		if (StringUtils.isBlank(cellphone)) {
			return null;
		}
		return "(XX)XXXXX-".concat(StringUtils.right(cellphone, 4));
	}

	public static String mischaracterizeCpf(String cpf) {
		if (StringUtils.isBlank(cpf)) {
			return null;
		}
		return String.format("***%.6s**", cpf);
	}

	public static String mischaracterizeDate(LocalDate date) {
		if(date != null) {
			return date.format(DateTimeFormatter.ofPattern("dd/MM")) + "/XXXX";
		}
		return null;
	}

	public static String mischaracterizeCreditCard(String cardNumber) {
		if (StringUtils.isBlank(cardNumber)) {
			return null;
		}
		return "xxx xxx xxx ".concat(cardNumber);
	}

//	public static String obterValorFormatado(BigDecimal valor) {
//		NumberFormat nf = new DecimalFormat( "#.00" );
//		return nf.format(valor.setScale(2));
//	}

	public static String trim(String value) {
		return StringUtils.trim(value);
	}

	public static Double calcBase64SizeInKBytes(String base64String) {
		Double result = -1.0;
		if(StringUtils.isNotEmpty(base64String)) {
			Integer padding = 0;
			if(base64String.endsWith("==")) {
				padding = 2;
			}
			else {
				if (base64String.endsWith("=")) padding = 1;
			}
			result = (Math.ceil(base64String.length() / 4) * 3) - padding;
		}
		return result / 1024;
	}

	public static String mischaracterizeZipCode(String cep) {
		if (StringUtils.isBlank(cep)) {
			return null;
		}
		return "xxx".concat(cep.substring(3, cep.length()));
	}

	public static String mischaracterizeNeighborhoodOrCity(String string) {
		if (StringUtils.isBlank(string)) {
			return null;
		}

		int sizeHalfString = string.length() / 2;
		return StringUtils.repeat("*", sizeHalfString).concat(string.substring(sizeHalfString+1));
	}

	public static String mischaracterizeAddress(String address) {
		if (StringUtils.isBlank(address)) {
			return null;
		}
		return address.replaceAll("\\s{1}\\w..", "*****");
	}

    public static boolean isValidName(String name) {
		Boolean validTwoNames = Pattern.matches(".*[a-zA-Z]\\s[a-zA-Z].*", name);
		Boolean hasInvalidCharacters = Pattern.matches(".*([a-zA-Z]\\d).*|.*(\\d[a-zA-Z]).*|.*(\\d{3,}).*", name);

		return (!hasInvalidCharacters && validTwoNames);
	}

	public static boolean hasOnlyLetters(String value) {
		Boolean hasInvalidCharacters = Pattern.matches("[a-zA-Z]+", value);

		return (!hasInvalidCharacters);
	}

    public static boolean hasNumericCharacters(String value) {
		return value.matches(".*\\d.*");
	}
    public static Boolean hasNonNumericCharacters(String value) {
        return value.matches(".*[a-zA-Z].*");
    }

	public static String removeSpecialsCharacters(String value) {
		if (value == null) {
			return null;
		}

		return StringUtils
				.stripAccents(value)
				.replaceAll("[^\\w\\s]", "")
				.trim()
				.replaceAll("\\s+", " ");
	}

	/**
	 * <p>Metodo responsavel por limpar a string, mantendo apenas números e letras sem ascentuação.</p>
     *
     * <pre>
     * Strings.removeCaracteresNaoLetraEhNumero(null)                = null
     * Strings.removeCaracteresNaoLetraEhNumero("")                  = ""
     * Strings.removeCaracteresNaoLetraEhNumero("   ")               = ""
     * Strings.removeCaracteresNaoLetraEhNumero("Frase montada")     = "Frasemontada"
     * Strings.removeCaracteresNaoLetraEhNumero("Ração De c@ch0R#o") = "RacaoDecch0Ro"
     * Strings.removeCaracteresNaoLetraEhNumero("RaÇçãoDeC@c#oRr()!@#$%*()-_=+/*.\"'`'~^|\\<>:?,.;/") = "RaCcaoDeCcoRr"
     * </pre>
	 *
	 * @param textoParaLimpeza - String a ser tratada.
	 * @return string - String apenas com letras e números
	 */
	public static String removeAllCharactersNonNumericAndNonLetters(String value) {
		if (value == null) {
			return null;
		}

		return StringUtils
				.stripAccents(value)
				.replaceAll("[^a-zA-Z0-9]", "")
				.trim();
	}

	public static String getValueOrEmpty(String value) {
		return Optional.ofNullable(value).orElse(org.apache.logging.log4j.util.Strings.EMPTY);
	}

	public static boolean hasValidPassword(String value) {
		return value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$");
	}

}