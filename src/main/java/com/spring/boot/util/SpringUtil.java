package com.spring.boot.util;

import org.json.JSONArray;

public class SpringUtil {

	/**
	 * get json array and return array
	 * 
	 * @param json
	 * @return
	 */
	public static int[] convertTOArray(JSONArray json) {
		int[] array = new int[json.length()];
		for (int i = 0; i < json.length(); i++) {
			array[i] = json.getInt(i);
		}
		return array;
	}
}
