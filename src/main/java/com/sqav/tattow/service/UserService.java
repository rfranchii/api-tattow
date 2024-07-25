package com.sqav.tattow.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sqav.tattow.enumerate.Profile;
import com.sqav.tattow.exception.TattowException;
import com.sqav.tattow.model.Collaborator;
import com.sqav.tattow.model.User;
import com.sqav.tattow.repository.UserRepository;
import com.sqav.tattow.support.Strings;
import com.sqav.tattow.vo.LoginRequest;
import com.sqav.tattow.vo.UserRequest;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> login(LoginRequest loginRequest) {
		
		if (loginRequest == null) {
			throw new TattowException("Dados do login não informado.");
		}
		
		if (StringUtils.isBlank(loginRequest.getLogin())) { 
			throw new TattowException("Login não informado.");
		}

		if (StringUtils.isBlank(loginRequest.getPassword())) { 
			throw new TattowException("Senha não informada.");
		}
		
		return Lists.newArrayList(new User());
	}

	public void registerCollaboratorUser(UserRequest userRequest) {
		validateCollaboratorFields(userRequest);
		validatePassword(userRequest.getPassword());
		
		User userDb = userRepository.createUser(new User(userRequest, Profile.COLLABORATOR));
		
//		userRepository.createCollaborator(new Collaborator(userDb.getUserId(), userRequest.getCollaborator()));
	}

	private void validateCollaboratorFields(UserRequest request) {
		if (request == null) {
			throw new TattowException("Dados do usuário não informado.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getLogin())) {
			throw new TattowException("Login não informado.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getPassword())) {
			throw new TattowException("Senha não informada.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getPasswordConfirmation())) {
			throw new TattowException("Confirmação de senha não informada.", "INFO");
		}
		
		if (!request.getPassword().equals(request.getPasswordConfirmation())) {
			throw new TattowException("As senhas não coincidem.", "INFO");			
		}
		
		if (request.getCollaborator() == null) {
			throw new TattowException("Dados do colaborador não informados.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getCollaborator().getName())) {
			throw new TattowException("Nome do colaborador não informado.", "INFO");
		}		

		if (StringUtils.isBlank(request.getCollaborator().getMail())) {
			throw new TattowException("Email não informado.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getCollaborator().getCpf()) || StringUtils.isBlank(request.getCollaborator().getCnpj())) {
			throw new TattowException("Cpf ou Cnpj não informado.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getCollaborator().getPhone())) {
			throw new TattowException("Telefone não informado.", "INFO");
		}		
		
		if (request.getCollaborator().getBirthDate() == null) {
			throw new TattowException("Data de nascimento não informada.", "INFO");
		}
		
		if (request.getCollaborator().getBirthDate().isAfter(LocalDate.now())) {
			throw new TattowException("Data de nascimento inválida.", "INFO");			
		}
		
		if (StringUtils.isBlank(request.getCollaborator().getZipCode())) {
			throw new TattowException("CEP não informado.", "INFO");
		}		

		if (StringUtils.isBlank(request.getCollaborator().getFullAddres())) {
			throw new TattowException("Endereço não informado.", "INFO");
		}		
	}
	
	private void validatePassword(String password) {
		Boolean hasNumber = Strings.hasNumericCharacters(password);
		Boolean hasLetters = Strings.hasNonNumericCharacters(password);
		
		if (password.trim().length() < 8) {
			throw new TattowException("A senha deve conter ao menos 8 caracteres", "INFO");
		}
		
		if (!hasNumber) {
			throw new TattowException("A senha deve ter ao menos um caracter Númerico.");
		}
		if (!hasLetters) {
			throw new TattowException("A senha deve ter ao menos uma letra.");
		}
	}

}
