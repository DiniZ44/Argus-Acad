/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.util;

import java.util.Base64;

/**
 *
 * @author Hakkinen
 */
public class Segurança {
    
    	public static String cryptography(byte[] base) {
		return Base64.getEncoder().encodeToString(base);
	}
    	
        
        public static String decryption(String password) {
		byte[] decode = Base64.getDecoder().decode(password);
		String decoded = new String(decode);
		return decoded;
	}
        
        public static boolean isEncrypted(String password) {
		boolean is64 = password.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");
		try {
			if(is64) {
				password = decryption(password);
				is64 = password.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			is64 = false;
		}
		
		return is64;
	}
}
