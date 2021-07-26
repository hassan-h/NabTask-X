package com.nab.task;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Hassan Hanif
 * @Date 2021-07-26
 * JDK: 11
 */

public class Question3 {
		
	private Properties prop;
	private Pattern regex = Pattern.compile("\\$\\{(.*?)\\}");
	private String templateBasicText; 
	
	public Question3(String propFileName, String templateFileName) throws Exception {	
		this.prop = new Properties();
		this.templateBasicText = "";
		
		try {
			this.prop.load(getClass().getClassLoader().getResourceAsStream(propFileName));
			this.templateBasicText = new String(getClass().getClassLoader().getResourceAsStream(templateFileName).readAllBytes());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
	}
	public String getProperty(String propertyName) {
		
		String propertyValue = prop.getProperty(propertyName);		
		String populatedString = "";
		
		if (propertyValue != null && !propertyValue.trim().equalsIgnoreCase("")) {
			populatedString = parseStringForProperties(propertyValue);
		}
		return populatedString.equalsIgnoreCase("")?propertyValue:populatedString;		
	}
	
	public String parseStringForProperties(String parseString) {
		
		int lastIndex = 0;
		Matcher regexMatcher = regex.matcher(parseString);
		StringBuffer sb = new StringBuffer("");
		
		while (regexMatcher.find()) {
			sb.append(parseString, lastIndex, regexMatcher.start())
		      .append(getProperty(regexMatcher.group(1))==null?"${"+regexMatcher.group(1)+"}":getProperty(regexMatcher.group(1)));
			lastIndex = regexMatcher.end();
		}
		
		if (lastIndex < parseString.length()) {
		    sb.append(parseString, lastIndex, parseString.length());
		}
		return sb.toString();
		
	}
	
	public String generateText() {
		return this.parseStringForProperties(this.templateBasicText);
	}

	public static void main(String[] args) {
		
		Question3 q3a = null;
		Question3 q3b = null;
		try {
			q3a = new Question3("input_basic.properties", "template_basic.btl");		
			q3b = new Question3("input_adv.properties", "template_adv.btl");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(q3a.generateText());	
		System.out.println(q3b.generateText());	
	}

}
