package com.nab.task;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 
 * @author Hassan Hanif
 * @Date 2021-07-26
 * JDK: 11
 */

public class Question1 {

	public Question1() {
	}
	
	public int findInList(List<Integer> dataList, List<Integer> searhcList) {
		return Collections.indexOfSubList(dataList, searhcList);
	}

	public static void main(String[] args) {
		
		List<Integer> dataList = Arrays.asList(10, 1, 0, 1, 0);
		List<Integer> searhcList = Arrays.asList(1, 0);
		
		Question1 q1 = new Question1();
		System.out.print(q1.findInList(dataList, searhcList));
	}

}
