package com.spring.boot.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceInterface {

	/**
	 * 
	 * @param n
	 * @return
	 */
	private static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	/**
	 * get n value and return nth fibonacci number
	 * 
	 * @param n
	 * @return
	 */
	@Override
	public int getFibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Input value should be greater than 0: ");
		}

		return fib(n);
	}

	/**
	 * get three integers and return sorted array created by merging three arrays,
	 * which don't have duplicates
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public JSONObject mergeRemoveDupSortIt(int[] a, int[] b, int[] c) {
		int[] d = mergeIt(a, b, c);
		int[] e = removeIt(d);
		int[] f = sortIt(e);

		JSONObject json = new JSONObject();
		json.put("Array", f);

		return json;
	}

	/**
	 * return merged array
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private int[] mergeIt(int[] a, int[] b, int[] c) {
		int[] d = new int[a.length + b.length + c.length];
		int k = 0;
		for (int n : a)
			d[k++] = n;
		for (int n : b)
			d[k++] = n;
		for (int n : c)
			d[k++] = n;
		return d;
	}

	/**
	 * removes duplicates in an array
	 * 
	 * @param d
	 * @return
	 */
	private int[] removeIt(int[] d) {
		int len = d.length;
		for (int i = 0; i < len - 1; i++)
			for (int j = i + 1; j < len; j++)
				if (d[i] == d[j]) {
					for (int k = j; k < len - 1; k++)
						d[k] = d[k + 1];
					--len;
				}
		int[] r = new int[len];
		for (int i = 0; i < r.length; i++)
			r[i] = d[i];
		return r;
	}

	/**
	 * 
	 * return sorted array
	 * 
	 * @param a
	 * @return
	 */
	private int[] sortIt(int[] a) {
		for (int index = 0; index < a.length - 1; index++)
			for (int i = index + 1; i < a.length; i++)
				if (a[index] > a[i]) {
					int temp = a[index];
					a[index] = a[i];
					a[i] = temp;
				}
		return a;
	}

	/**
	 * get string and return reversewords of the given string
	 * 
	 * @param str
	 * @return
	 */
	@Override
	public String getReverseWords(String str) {

		String[] words = str.split(" ");
		String reversedString = "";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverseWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				/*
				 * The charAt() function returns the character at the given position in a string
				 */
				reverseWord = reverseWord + word.charAt(j);
			}

			reversedString = i < words.length - 1 ? reversedString + reverseWord + " " : reversedString + reverseWord;
		}

		return reversedString;
	}

	/**
	 * get input values a,b,c and return triangle type based on inputs
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public String getTriangleType(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return "Invalid"; // added test
		if (a == b && b == c)
			return "Equilateral";
		if (a > b + c || c > b + a || b > a + c)
			return "Invalid";
		if (b == c || a == b || c == a)
			return "Isosceles";
		return "Scalene";
	}

}
