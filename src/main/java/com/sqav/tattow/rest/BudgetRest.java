package com.sqav.tattow.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqav.tattow.service.BudgetService;
import com.sqav.tattow.vo.BudgetRequest;

@RestController
@RequestMapping(value="/budget")
public class BudgetRest extends BaseRest {

	@Autowired
	private BudgetService budgetService;
	
	@GetMapping(value="/{collaboratorId}")
	public ResponseEntity<?> getBudgetByCollaborator(@PathVariable Long collaboratorId) {
		return createObjectReturn(budgetService.getBudgetByCollaborator(collaboratorId));
	}
	
	@GetMapping(value="/{collaboratorId}/{budgetId}")
	public ResponseEntity<?> getBudgetById(@PathVariable Long collaboratorId, @PathVariable Long budgetId) {
		return createObjectReturn(budgetService.getBudgetById(collaboratorId, budgetId));
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<?> saveBudget(@RequestBody BudgetRequest budgetRequest) {
		budgetService.saveBudget(budgetRequest);
		return createObjectReturn(Boolean.TRUE);
	}
	
	@PutMapping(value="/approve/{collaboratorId}/{budgetId}")
	public ResponseEntity<?> approve(@PathVariable Long collaboratorId, @PathVariable Long budgetId) {
		budgetService.approveBudget(collaboratorId, budgetId);
		return createObjectReturn(Boolean.TRUE);
	}
	
	@PutMapping(value="/reprove/{collaboratorId}/{budgetId}")
	public ResponseEntity<?> reprove(@PathVariable Long collaboratorId, @PathVariable Long budgetId) {
		budgetService.reproveBudget(collaboratorId, budgetId);
		return createObjectReturn(Boolean.TRUE);
	}
	
	@PutMapping(value="/add-date")
	public ResponseEntity<?> addDate(@RequestBody BudgetRequest budgetRequest) {
		budgetService.addDate(budgetRequest);
		return createObjectReturn(Boolean.TRUE);
	}
	
}
