package com.sqav.tattow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sqav.tattow.enumerate.Sex;
import com.sqav.tattow.model.Budget;
import com.sqav.tattow.support.ResultSetAdapter;

public class BudgetRowMapper implements RowMapper<Budget> {
	
	@Override
	public Budget mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetAdapter resultSet = new ResultSetAdapter(rs);

		Budget budget = new Budget();
		budget.setBudgetId(resultSet.getLong("budgetId"));
		budget.setClientName(resultSet.getString("clientName"));
		budget.setClientCpf(resultSet.getString("clientCpf"));
		budget.setClientSex(Sex.valueOf(resultSet.getString("clientSex")));
		budget.setClientMail(resultSet.getString("clientMail"));
		budget.setClientPhone(resultSet.getString("clientPhone"));
		budget.setApproved(resultSet.getBoolean("approved"));
		budget.setReproved(resultSet.getBoolean("reproved"));
		budget.setAppointmentDate(resultSet.getLocalDateTime("appointmentDate"));
		
		return budget;
	}
	
}
