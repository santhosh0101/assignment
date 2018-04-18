package com.spring.boot.service;

import org.json.JSONObject;

public interface ServiceInterface {

	public int getFibonacci(int num);

	public String getReverseWords(String str);

	public String getTriangleType(int a, int b, int c);

	public JSONObject mergeRemoveDupSortIt(int[] a, int[] b, int[] c);
}
