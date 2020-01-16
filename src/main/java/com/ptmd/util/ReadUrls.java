package com.ptmd.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ptmd.controller.WeatherReportController;

/**
 * Read Urls from the given xml file
 * 
 * @author ANNI
 *
 */
@Component
public class ReadUrls {

	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WeatherReportController.class);

	/**
	 * Read the xml file and bind the data into a bindig class 
	 * and return binding class for the retrive the data
	 * 
	 * @param xmlFile
	 * @return binding class object
	 */
	public RequestURLs read(String xmlFile) {
		JAXBContext jaxbContext = null;
		RequestURLs urls = null;
		try {
			jaxbContext = JAXBContext.newInstance(RequestURLs.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			LOG.info("Convert the xml file into a binding object ::: "+xmlFile);
			urls = (RequestURLs) jaxbUnmarshaller.unmarshal(new File(xmlFile));

		} catch (JAXBException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return urls;
	}
}
