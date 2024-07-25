package com.sqav.tattow.repository;

import java.time.LocalDateTime;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.sqav.tattow.model.Collaborator;
import com.sqav.tattow.model.User;
import com.sqav.tattow.support.Cryptography;
import com.sqav.tattow.support.MapSqlParameter;

@Repository
public class UserRepository extends GenericRepository {
	
	public User createUser(User user) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO user (login, password, profile, active, activationDate, insertDate) VALUES (?, ?, ?, ?, ?, ?)" );
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("login", user.getLogin());
		params.addValue("password", Cryptography.encrypt(user.getPassword()));
		params.addValue("profile", user.getProfile().name());
		params.addValue("active", user.getActive());
		params.addValue("activationDate", user.getActivationDate());
		params.addValue("insertDate", LocalDateTime.now());
		
		GeneratedKeyHolder key = new GeneratedKeyHolder();
		
		getJdbcTemplate().update(sql.toString(), params, key);
		
		user.setUserId(key.getKey().longValue());
		
		return user;
	}
	
	public void createCollaborator(Collaborator collaborator) {
		
	}
	
}
