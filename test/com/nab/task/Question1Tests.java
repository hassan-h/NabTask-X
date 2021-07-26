package com.nab.task;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Question1Tests {

	private Question1 question1;

    @BeforeEach                                         
    public void setUp() throws Exception {
        question1 = new Question1();
    }
    
	@Test
	void testThatSubArrayExistsWithIndex() {
		List<Integer> dataList = Arrays.asList(10, 1, 0, 1, 0);
		List<Integer> searhcList = Arrays.asList(1, 0);
		assert(question1.findInList(dataList, searhcList) == 1);
	}
	
	@Test
	void testThatIndexIsMinusOneWhenNotExists() {
		List<Integer> dataList = Arrays.asList(10, 1, 0, 1, 0);
		List<Integer> searhcList = Arrays.asList(2, 0);
		assert(question1.findInList(dataList, searhcList) == -1);
	}

}
