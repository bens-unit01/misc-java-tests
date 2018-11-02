package com.pratiques.regex;

//import org.apache.commons.lang3.StringUtils;

public class StringHelper {

/**
 * Check if a string is empty  	
 * @param s  input string
 * @return  true if empty, false if it's not empty 
 */
	public static boolean empty( final String s ) {
		  return s == null || s.trim().isEmpty();
	}
	public static String getFirstProperty(String input ) {
        String[] s = input.split(" "); 
        return s[1]; 
	}
	
	
	public static boolean isNumeric(String input ) {
 //      return StringUtils.isNumeric(input); 
		return false; 
	}

}
