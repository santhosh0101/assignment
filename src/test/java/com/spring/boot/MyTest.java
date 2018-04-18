package com.spring.boot;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;
import com.spring.boot.exceptions.ErrorResponse;
import com.spring.boot.service.ServiceImpl;
import com.spring.boot.util.SpringUtil;

public class MyTest {

	ServiceImpl service = new ServiceImpl();

	@Test
	public void testFibonacciWith10() {
		assertEquals(55, service.getFibonacci(10));
	}

	@Test
	public void testReverseWords() {
		assertEquals("woh era uoy", service.getReverseWords("how are you"));
	}

	@Test
	public void testTriangleType() {
		assertEquals("Equilateral", service.getTriangleType(1, 1, 1));
	}
	
	@Test
	public void makeOneArray() throws ErrorResponse {
		int[] array1 = {1,2,3,4};
		int[] array2 = {3,4,5,6};
		int[] array3 = {6,1,3,4};
		
		JSONObject json = new JSONObject();
		json.put("Array1", array1);
		json.put("Array2", array2);
		json.put("Array3", array3);
		
		try {
			array1 = SpringUtil.convertTOArray(json.getJSONArray("Array1"));
			array2 = SpringUtil.convertTOArray(json.getJSONArray("Array2"));
			array3 = SpringUtil.convertTOArray(json.getJSONArray("Array3"));
		} catch (Exception e) {
			// TODO: handle exception
			throw new ErrorResponse("400", "Please check your input json");
		}
		int[] array = {1,2,3,4,5,6,11};
		JSONObject result = new JSONObject();
		json.put("Array", array);
		
		assertEquals(json.toString(), service.mergeRemoveDupSortIt(array1, array2, array3).toString());
	}

}
