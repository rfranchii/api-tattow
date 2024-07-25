package com.sqav.tattow.support;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sqav.tattow.exception.TattowException;

public class Cryptography {
	
	static Cipher cipher; 
	 
	public Cryptography() {
		super();
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Cryptography.class);
	private static final String ALGORITHM_AES = "AES";
	
    public static String encrypt(String plainText) {
        try {
        	byte[] plainTextByte = plainText.getBytes();
	        cipher.init(Cipher.ENCRYPT_MODE, generateKey());
	        byte[] encryptedByte = cipher.doFinal(plainTextByte);
	        Base64.Encoder encoder = Base64.getEncoder();
	        String encryptedText = encoder.encodeToString(encryptedByte);
	        return encryptedText;
        } catch (Exception e) {
        	LOGGER.error("Erro ao tentar criptografar o valor informado.");
        	throw new TattowException("Ocorreu um erro inesperado. Favor tentar novamente mais tarde.");
        }
    }

    public static String decrypt(String encryptedText) {
    	try {
	        Base64.Decoder decoder = Base64.getDecoder();
	        byte[] encryptedTextByte = decoder.decode(encryptedText);
	        cipher.init(Cipher.DECRYPT_MODE, generateKey());
	        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
	        String decryptedText = new String(decryptedByte);
	        return decryptedText;
	    } catch (Exception e) {
	    	LOGGER.error("Erro ao tentar descriptografar o valor informado.");
	    	throw new TattowException("Ocorreu um erro inesperado. Favor tentar novamente mais tarde.");
	    }
    }
    
    public static SecretKey generateKey() throws NoSuchAlgorithmException { 
    	KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_AES);
    	keyGenerator.init(128);
    	return keyGenerator.generateKey();
    }
	
}