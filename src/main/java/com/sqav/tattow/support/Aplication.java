package com.sqav.tattow.support;

public class Aplication {
	
	public static enum Environment {
		DESENVOLVIMENTO("dev"),
		HOMOLOGACAO("hml"),
		PRODUCAO("prod");
		
		private final String shortname;
		
		Environment(String shortname) {
			this.shortname = shortname;
		}
		
		public String getShortname() {
			return shortname;
		}
	}
	
	public static Environment getEnvironment() {
		String environmentPropValue = System.getProperty("AMBIENTE");
		if (environmentPropValue == null) {
			environmentPropValue = System.getenv("AMBIENTE");
		}
		
		Environment environment = Environment.DESENVOLVIMENTO;
		if (environmentPropValue != null) {
			environment = Environment.valueOf(environmentPropValue);
		}
		
		return environment;
	}

}
