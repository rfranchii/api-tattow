package com.sqav.tattow.support;

public class Decrypt {

	public static void main(String[] args) throws Exception {
		String passwordEncrypted = "qZqVEMOhQsI=";
		
		System.out.println(new Cryptography().decrypt(passwordEncrypted));
	}
	
}
