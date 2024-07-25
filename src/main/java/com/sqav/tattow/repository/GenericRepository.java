package com.sqav.tattow.repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {

	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	private static final String YYYY_MM_DD_HH_MM_SS_N = "yyyy-MM-dd HH:mm:ss.n";
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	private static final String HH_MM_SS = "HH:mm:ss";
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	protected NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	protected String getStringValue(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return object[position - 1].toString();
		}
		return null;
	}
	
	protected <T extends Enum<T>> T getEnumValue(Object[] object, Integer position, Class<T> enumClass) {
		if (object[position - 1] != null) {
				return Enum.valueOf(enumClass, object[position - 1].toString());
		}
		return null;
	}
	
	protected Long getLongValue(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return Long.valueOf(object[position - 1].toString());
		}
		return null;
	}
	
	protected Integer getIntegerValue(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return Integer.valueOf(object[position - 1].toString());
		}
		return null;
	}
	
	protected BigDecimal getBigDecimalValue(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return new BigDecimal(object[position - 1].toString());
		}
		return null;
	}
	
	protected LocalDateTime getLocalDateTime(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return LocalDateTime.parse(object[position - 1].toString(), DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
		}
		return null;
	}
	
	protected LocalDateTime getFullLocalDateTime(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return LocalDateTime.parse(object[position - 1].toString(), DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS_N));
		}
		return null;
	}
	
	protected LocalTime getLocalTime(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return LocalTime.parse(object[position - 1].toString(), DateTimeFormatter.ofPattern(HH_MM_SS));
		}
		return null;
	}
	
	protected LocalDate getLocalDate(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			return LocalDate.parse(object[position - 1].toString(), DateTimeFormatter.ofPattern(YYYY_MM_DD));
		}
		return null;
	}
	
	protected Boolean getBooleanValuePrimitive(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			if (object[position - 1].toString().equals("1")) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		}
		return null;
	}
	
	protected boolean getBooleanValue(Object[] object, Integer position) {
		if (object[position - 1] != null) {
			if (object[position - 1].toString().equals("1")) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		}
		return false;
	}
	
	@SuppressWarnings("removal")
	protected Short getShortValue(Object[] object, Integer position) {
		if(object[position -1] != null) {
			return new Short(object[position - 1].toString());
		}
		return null;
	}

}