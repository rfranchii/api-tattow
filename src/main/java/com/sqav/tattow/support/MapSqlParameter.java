package com.sqav.tattow.support;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class MapSqlParameter extends MapSqlParameterSource {

	public MapSqlParameterSource addValue(String paramName) {
		return super.addValue(paramName, null);
	}

	public MapSqlParameterSource addValue(String paramName, LocalDate date) {
		if (date == null) {
			return super.addValue(paramName, null);
		}
		return super.addValue(paramName, date.atStartOfDay());
	}

	public MapSqlParameterSource addValue(String paramName, Calendar date) {
		if (date == null) {
			return super.addValue(paramName, null);
		}
		return super.addValue(paramName, new Timestamp(date.getTime().getTime()));
	}

	public MapSqlParameterSource addValue(String paramName, String string) {
		if (string == null) {
			return super.addValue(paramName, null, Types.VARCHAR);
		}
		return super.addValue(paramName, getUpperString(string), Types.VARCHAR);
	}

	public MapSqlParameterSource addValue(String paramName, Object object) {
		if (object == null) {
			return super.addValue(paramName, null);
		}
		return super.addValue(paramName, object);
	}

	private String getUpperString(String paramName) {
		if (null == paramName) {
			return paramName;
		} else {
			return paramName.toUpperCase();
		}
	}

	public MapSqlParameterSource addValueLowerCase(String paramName, String valor) {
		if (StringUtils.isNotEmpty(valor)) {
			return super.addValue(paramName, valor.toLowerCase());
		}
		return super.addValue(paramName, null, Types.VARCHAR);
	}
}