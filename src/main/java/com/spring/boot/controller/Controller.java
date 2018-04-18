package com.spring.boot.controller;

import com.spring.boot.exceptions.ErrorResponse;
import com.spring.boot.service.ServiceInterface;
import com.spring.boot.util.SpringUtil;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {


	@Autowired
	private ServiceInterface service;

	/**
	 * 
	 * @param parm
	 * @return
	 * @throws ErrorResponse
	 */
	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public int fibonacci(@RequestParam(value = "n", defaultValue = "1") String parm) throws Exception {
		int num = 0;
		try {
			num = Integer.valueOf(parm);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ErrorResponse("400", "Please check your input farmat");
		}

		return service.getFibonacci(num);
	}

	/*@Autowired
	@Qualifier("ReverseWordsService")
	private ReverseWordsServiceImpl reverseWordsService;*/

	/**
	 * 
	 * @param sentence
	 * @return
	 */
	@RequestMapping(value = "/ReverseWords", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public String ReverseWords(@RequestParam(value = "sentence") String sentence) {
		return service.getReverseWords(sentence);
	}

	/*@Autowired
	@Qualifier("TriangleTypeService")
	private TriangleTypeServiceImpl triangleTypeService;*/

	/**
	 * 
	 * @param side1
	 * @param side2
	 * @param side3
	 * @return
	 */
	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public String TriangleType(@RequestParam(value = "a") String side1, @RequestParam(value = "b") String side2,
			@RequestParam(value = "c") String side3) throws Exception {
		int a;
		int b;
		int c;
		try {
			a = Integer.valueOf(side1);
			b = Integer.valueOf(side2);
			c = Integer.valueOf(side3);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ErrorResponse("400", "Please check your input farmat");
		}

		return service.getTriangleType(a, b, c);
	}

	/*@Autowired
	@Qualifier("MakeOneArrayService")
	private MakeOneArrayServiceImpl makeOneArrayService;*/

	/**
	 * 
	 * @param payload
	 * @return
	 */
	@RequestMapping(value = "/makeonearray", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public String makeonearray(@RequestBody String payload) throws Exception {
		JSONObject json = new JSONObject(payload);
		int[] Array1;
		int[] Array2;
		int[] Array3;
		try {
			Array1 = SpringUtil.convertTOArray(json.getJSONArray("Array1"));
			Array2 = SpringUtil.convertTOArray(json.getJSONArray("Array2"));
			Array3 = SpringUtil.convertTOArray(json.getJSONArray("Array3"));
		} catch (Exception e) {
			// TODO: handle exception
			throw new ErrorResponse("400", "Please check your input json");
		}

		return service.mergeRemoveDupSortIt(Array1, Array2, Array3).toString();
	}

}
