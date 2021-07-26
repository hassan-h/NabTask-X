package com.nab.task;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;


/**
 * 
 * @author Hassan Hanif
 * @Date 2021-07-26
 * JUNIT 5
 */

class Question3Tests {

	private Question3 question3;
	
	@Test
	void testThatConstructorCanLoadFilesSuccessfully() {
		assertDoesNotThrow(() -> question3 = new Question3("input_basic.properties", "template_basic.btl"));
		assertDoesNotThrow(() -> question3 = new Question3("input_adv.properties", "template_adv.btl"));
	}
	
	@Test
	void testGetPropertyMethodForBasic() {
		try {
			question3 = new Question3("input_basic.properties", "template_basic.btl");
		} catch (Exception e) {
			System.out.println("testGetPropertyMethod: Err " + e.getMessage());
		}
		
		assert(question3.getProperty("firstname").equals("John"));
		assert(question3.getProperty("lastname").equals("Simons"));
	}
	
	@Test
	void testParseStringForPropertiesMethodForBasic() {
		try {
			question3 = new Question3("input_basic.properties", "template_basic.btl");
		} catch (Exception e) {
			System.out.println("testGetPropertyMethod: Err " + e.getMessage());
		}
		
		assert(question3.parseStringForProperties("Hello! ${firstname}").equals("Hello! John"));
		assert(question3.parseStringForProperties("Hello! ${lastname}").equals("Hello! Simons"));
	}
	
	@Test
	void testGenerateTextMethodForBasic() {
		try {
			question3 = new Question3("input_basic.properties", "template_basic.btl");
		} catch (Exception e) {
			System.out.println("testGetPropertyMethod: Err " + e.getMessage());
		}
		
		assert(question3.generateText().equals("Hello Simons, John!"));
	}
	
	@Test
	void testGetPropertyMethodForAdv() {
		try {
			question3 = new Question3("input_adv.properties", "template_adv.btl");
		} catch (Exception e) {
			System.out.println("testGetPropertyMethod: Err " + e.getMessage());
		}
		
		assert(question3.getProperty("firstname").equals("John"));
		assert(question3.getProperty("lastname").equals("Simons"));
		assert(question3.getProperty("longname").equals("John Simons"));
		assert(question3.getProperty("dob").equals("1st April 1990"));
		assert(question3.getProperty("company") == null);
	}
	
	@Test
	void testParseStringForPropertiesMethodForAdv() {
		try {
			question3 = new Question3("input_adv.properties", "template_adv.btl");
		} catch (Exception e) {
			System.out.println("testGetPropertyMethod: Err " + e.getMessage());
		}
		
		assert(question3.parseStringForProperties("Hello! ${firstname}").equals("Hello! John"));
		assert(question3.parseStringForProperties("Hello! ${lastname}").equals("Hello! Simons"));
		assert(question3.parseStringForProperties("Hello! ${longname}").equals("Hello! John Simons"));
		assert(question3.parseStringForProperties("Your DOB is! ${dob}").equals("Your DOB is! 1st April 1990"));
		assert(question3.parseStringForProperties("Your Company is! ${company}").equals("Your Company is! ${company}"));
	}
	
	@Test
	void testGenerateTextMethodForAdv() {
		try {
			question3 = new Question3("input_adv.properties", "template_adv.btl");
		} catch (Exception e) {
			System.out.println("testGetPropertyMethod: Err " + e.getMessage());
		}
		
		assert(question3.generateText().equals("Hello John Simons! Your dob is 1st April 1990. Welcome to ${company}!"));
	}
}
