package com.sqav.tattow.repository;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.sqav.tattow.exception.TattowException;
import com.sqav.tattow.model.Budget;
import com.sqav.tattow.rowmapper.BudgetRowMapper;
import com.sqav.tattow.support.MapSqlParameter;
import com.sqav.tattow.vo.BudgetRequest;

@Repository
public class BudgetRepository extends GenericRepository {
	
	public void createBudget(BudgetRequest budgetRequest) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO budget (collaboratorId, clientName, clientCpf, clientSex, clientMail, clientPhone, insertDate) " );
		sql.append(" VALUES (:collaboratorId, :clientName, :clientCpf, :clientSex, :clientMail, :clientPhone, :insertDate) ");
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("collaboratorId", budgetRequest.getCollaboratorId());
		params.addValue("clientName", budgetRequest.getClientName());
		params.addValue("clientCpf", budgetRequest.getClientCpf());
		params.addValue("clientSex", budgetRequest.getClientSex().name());
		params.addValue("clientMail", budgetRequest.getClientMail());
		params.addValue("clientPhone", budgetRequest.getClientPhone());
		params.addValue("insertDate", LocalDateTime.now());
		
		getJdbcTemplate().update(sql.toString(), params);
	}

	public void approveBudget(Long budgetId) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE budget set approved = :true, reproved = :false WHERE budgetId = :budgetId " );
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("true", Boolean.TRUE);
		params.addValue("false", Boolean.FALSE);
		params.addValue("budgetId", budgetId);
		
		getJdbcTemplate().update(sql.toString(), params);
		
	}
	
	public void reproveBudget(Long budgetId) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE budget set reproved = :true, approved = :false WHERE budgetId = :budgetId " );
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("true", Boolean.TRUE);
		params.addValue("false", Boolean.FALSE);
		params.addValue("budgetId", budgetId);
		
		getJdbcTemplate().update(sql.toString(), params);
		
	}

	public void addDate(Long budgetId, LocalDateTime appointmentDate) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE budget set appointmentDate = :appointmentDate WHERE budgetId = :budgetId " );
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("appointmentDate", appointmentDate);
		params.addValue("budgetId", budgetId);
		
		getJdbcTemplate().update(sql.toString(), params);
	}

	public Budget getBudgetByIdAndCollaborator(Long collaboratorId, Long budgetId) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT b.budgetId, b.clientName, b.clientCpf, b.clientSex, b.clientMail, ");
		sql.append(" b.clientPhone, b.approved, b.reproved, b.appointmentDate ");
		sql.append(" FROM budget b ");
		sql.append(" WHERE b.budgetId = :budgetId ");
		sql.append(" AND b.collaboratorId = :collaboratorId ");
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("budgetId", budgetId);
		params.addValue("collaboratorId", collaboratorId);
		
		try {
			return getJdbcTemplate().queryForObject(sql.toString(), params, new BudgetRowMapper());
		} catch (EmptyResultDataAccessException er) {
			return null;
		} catch (Exception e) {
			throw new TattowException(e.getMessage());
		}
		
	}

	public boolean existBudgetForThatDate(Long collaboratorId, LocalDateTime appointmentDate) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) FROM budget b WHERE b.collaboratorId = :collaboratorId and b.reproved = :false ");
		sql.append(" AND b.appointmentDate = :appointmentDate ");
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("collaboratorId", collaboratorId);
		params.addValue("appointmentDate", appointmentDate);
		params.addValue("false", Boolean.FALSE);
		
		return getJdbcTemplate().queryForObject(sql.toString(), params, Boolean.class);
	}	

}