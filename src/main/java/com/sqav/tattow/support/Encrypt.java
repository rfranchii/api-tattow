package com.sqav.tattow.support;

public class Encrypt {
	
	public static void main(String[] args) throws Exception {
		String password = "Teste@123";
		
		System.out.println(new Cryptography().encrypt(password));
	}
    
}
