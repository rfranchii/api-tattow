package com.sqav.tattow.repository;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.sqav.tattow.enumerate.Profile;
import com.sqav.tattow.exception.TattowException;
import com.sqav.tattow.model.Collaborator;
import com.sqav.tattow.model.User;
import com.sqav.tattow.model.UserResult;
import com.sqav.tattow.rowmapper.UserResultRowMapper;
import com.sqav.tattow.support.MapSqlParameter;

@Repository
public class UserRepository extends GenericRepository {
	
	public User createUser(User user) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO user (login, password, profile, active, activationDate, insertDate) " );
		sql.append(" VALUES (:login, :password, :profile, :active, :activationDate, :insertDate) ");
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("login", user.getLogin());
		params.addValue("password", user.getPassword());
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
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO collaborator (userId, name, mail, cpf, cnpj, photo, phone, birthDate, studioName, sex, zipCode, fullAddress, insertDate) " );
		sql.append(" VALUES (:userId, :name, :mail, :cpf, :cnpj, :photo, :phone, :birthDate, :studioName, :sex, :zipCode, :fullAddress, :insertDate) ");
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("userId", collaborator.getUserId());
		params.addValue("name", collaborator.getName());
		params.addValue("mail", collaborator.getMail());
		params.addValue("cpf", collaborator.getCpf());
		params.addValue("cnpj", collaborator.getCnpj());
		params.addValue("photo", collaborator.getPhoto());
		params.addValue("phone", collaborator.getPhone());
		params.addValue("birthDate", collaborator.getBirthDate());
		params.addValue("studioName", collaborator.getStudioName());
		params.addValue("sex", collaborator.getSex().name());
		params.addValue("zipCode", collaborator.getZipCode());
		params.addValue("fullAddress", collaborator.getFullAddress());
		params.addValue("insertDate", LocalDateTime.now());
		
		getJdbcTemplate().update(sql.toString(), params);
	}

	public UserResult getUserByLoginAndPasswordAndProfile(String login, String password, Profile profile) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT u.userId, c.name, u.profile, u.acceptTerm, c.photo ");
		sql.append(" FROM user u INNER JOIN collaborator c ON c.userId = u.userId ");
		sql.append(" WHERE u.login = :login AND u.password = :password AND u.profile = :profile ");
		sql.append(" AND u.active = :true AND u.blocked = :false ");
		
		MapSqlParameter params = new MapSqlParameter();
		params.addValue("login", login);
		params.addValue("password", password);
		params.addValue("profile", profile.name());
		params.addValue("true", Boolean.TRUE);
		params.addValue("false", Boolean.FALSE);
		
		try {
			return getJdbcTemplate().queryForObject(sql.toString(), params, new UserResultRowMapper());
		} catch (EmptyResultDataAccessException er) {
			return null;
		} catch (Exception e) {
			throw new TattowException(e.getMessage());
		}
	}
	
}