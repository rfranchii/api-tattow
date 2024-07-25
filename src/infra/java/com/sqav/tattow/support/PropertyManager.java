package com.sqav.tattow.support;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyManager {

	@Autowired
	private Properties applicationProperties;
	
	public String getProperty(String key) {
		return applicationProperties.getProperty(key);
	}
	
	public String getString(String key) {
		return getProperty(key);
	}
	
	public Integer getInteger(String key) {
		return Integer.valueOf(getProperty(key));
	}
	
	public Long getLong(String key) {
		return Long.valueOf(getProperty(key));
	}
	
	public BigDecimal getBigDecimal(String key) {
		return new BigDecimal(getProperty(key));
	}
	
	private String getEnv(String key) {
		return System.getenv(key);
	}
	
	private String getSystemProperty(String key) {
		return System.getProperty(key);
	}
	
	public String getEnvironmentProperty(String key) throws Exception {
		String property = this.getEnv(key);
		
		if (StringUtils.isBlank(property)) {
			property = this.getSystemProperty(key);
		}
		
		if (StringUtils.isBlank(property)) {
			property = getProperty(key);
		}
		
		if (StringUtils.isBlank(property)) {
			throw new Exception("Variavel de ambiente nao criada/encontrada [" + key + "]");
		}
		
		return property;
	}
	
}