package com.sqav.tattow.service;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqav.tattow.enumerate.Sex;
import com.sqav.tattow.exception.TattowException;
import com.sqav.tattow.model.Budget;
import com.sqav.tattow.model.BudgetDashboard;
import com.sqav.tattow.repository.BudgetRepository;
import com.sqav.tattow.support.CellphoneValidator;
import com.sqav.tattow.vo.BudgetRequest;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	public BudgetDashboard getBudgetByCollaborator(Long collaboratorId) {
		
		return null;
	}
	
	public Budget getBudgetById(Long collaboratorId, Long budgetId) {
		if (collaboratorId == null) {
			throw new TattowException("ID do colaborador não informado.");
		}
		
		if (budgetId == null) {
			throw new TattowException("ID do orçamento não informado.");
		}
		
		return budgetRepository.getBudgetByIdAndCollaborator(collaboratorId, budgetId);
	}
	
	@Transactional
	public void saveBudget(BudgetRequest budgetRequest) {
		validateBudgetFields(budgetRequest);
		budgetRepository.createBudget(budgetRequest);
	}

	private void validateBudgetFields(BudgetRequest request) {
		if (request == null) {
			throw new TattowException("Dados do orçamento não informado.", "INFO");
		}
		
		if (request.getCollaboratorId() == null) {
			throw new TattowException("Colaborador não informado.", "INFO");			
		}
		
		if (StringUtils.isBlank(request.getClientName())) {
			throw new TattowException("Nome do cliente não informado.", "INFO");
		}
		
		if (StringUtils.isBlank(request.getClientCpf())) {
			throw new TattowException("CPF do cliente não informado.", "INFO");
		}
		
		if (request.getClientSex() == null) {
			request.setClientSex(Sex.UNDEFINED);
		}
		
		if (StringUtils.isBlank(request.getClientMail())) {
			throw new TattowException("Email do cliente não informado.", "INFO");
		}		

		if (StringUtils.isBlank(request.getClientPhone())) {
			throw new TattowException("Telefone do cliente não informado.", "INFO");
		}		
		
		if (!CellphoneValidator.isCellphone(request.getClientPhone())) {
			throw new TattowException("Telefone do cliente inválido.", "INFO");
		}
		
	}

	public void approveBudget(Long collaboratorId, Long budgetId) {
		if (budgetId == null) {
			throw new TattowException("ID do orçamento não informado.", "INFO"); 
		}
		
		Budget budget = budgetRepository.getBudgetByIdAndCollaborator(collaboratorId, budgetId);
		
		if (budget == null) {
			throw new TattowException("Orçamento não encontrado.");
		}
		
		if (budget.getApproved()) {
			throw new TattowException("Orçamento já foi aprovado.");
		}
		
		budgetRepository.approveBudget(budgetId);
	}
	
	public void reproveBudget(Long collaboratorId, Long budgetId) {
		if (budgetId == null) {
			throw new TattowException("ID do orçamento não informado.", "INFO"); 
		}
		
		Budget budget = budgetRepository.getBudgetByIdAndCollaborator(collaboratorId, budgetId);
		
		if (budget == null) {
			throw new TattowException("Orçamento não encontrado.");
		}
		
		if (budget.getReproved()) {
			throw new TattowException("Orçamento já foi reprovado.");
		}
		
		budgetRepository.reproveBudget(budgetId);
	}

	public void addDate(BudgetRequest request) {
		if (request == null) {
			throw new TattowException("Informações do orçamento não foram informadas.", "INFO");
		}
		
		if (request.getBudgetId() == null) {
			throw new TattowException("ID do orçamento não informado.", "INFO");
		}
		
		if (request.getCollaboratorId() == null) {
			throw new TattowException("Colaborador não informado.", "INFO");
		}
		
		if (request.getAppointmentDate() == null) {
			throw new TattowException("Data do serviço não informado.", "INFO");
		}		
		
		if (request.getAppointmentDate().isBefore(LocalDateTime.now())) {
			throw new TattowException("Data do serviço não pode ser menor que a data atual.", "INFO");
		}			
		
		Budget budget = budgetRepository.getBudgetByIdAndCollaborator(request.getCollaboratorId(), request.getBudgetId());
		
		if (budget == null) {
			throw new TattowException("Orçamento não encontrado.");
		}
		
		if (budgetRepository.existBudgetForThatDate(request.getCollaboratorId(), request.getAppointmentDate())) {
			throw new TattowException("Já existe um orçamento nessa data.");
		}
		
		budgetRepository.addDate(request.getBudgetId(), request.getAppointmentDate());
	}
	
}