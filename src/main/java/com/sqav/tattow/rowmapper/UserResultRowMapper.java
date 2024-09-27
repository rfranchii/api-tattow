package com.sqav.tattow.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sqav.tattow.enumerate.Profile;
import com.sqav.tattow.model.UserResult;
import com.sqav.tattow.support.ResultSetAdapter;

public class UserResultRowMapper implements RowMapper<UserResult> {
	
	@Override
	public UserResult mapRow(ResultSet rs, int rowNum) throws SQLException {

		ResultSetAdapter resultSet = new ResultSetAdapter(rs);

		UserResult user = new UserResult();
		user.setUserId(resultSet.getLong("userId"));
		user.setName(resultSet.getString("name"));
		user.setProfile(Profile.valueOf(resultSet.getString("profile")));
		user.setAcceptTerm(resultSet.getBoolean("acceptTerm"));
		user.setPhoto(resultSet.getString("photo"));

		return user;

	}

}
