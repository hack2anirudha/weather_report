package com.ptmd.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the Read urls from the xml file 
 * 
 * @author ANNI
 *
 */
public class ReadUrlsTest {

	/**
	 * ReadUrls binding class 
	 */
	private static ReadUrls rdUrls = null;

	/**
	 * Before test case please set instance for ReadUrls.
	 */
	@BeforeAll
	public static void init() {
		rdUrls = new ReadUrls();
	}

	/** 
	 * test case for read method is able to read the xml or not
	 */
	@Test
	public void readTest() {
		RequestURLs requestURLs = rdUrls.read("RequestURLs.xml");
		assertNotNull(requestURLs);
	}
}
