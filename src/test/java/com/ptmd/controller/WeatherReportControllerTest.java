package com.ptmd.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * spring boot application test cases 
 * 
 * @author ANNI
 *
 */
@SpringBootTest
public class WeatherReportControllerTest {

	/**
	 * Controller 
	 */
	@Autowired
	private WeatherReportController controller;
	
	/**
	 * test the insert all record method
	 */
	@Test
	public void insertAllRecordTest(){
		int result = controller.insertAllRecord();
		assertEquals(10, result);
	}
}
