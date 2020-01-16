package com.ptmd.webservice;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ptmd.pojo.WeatherReport;

/**
 * FetchWeatherImple implements the FetchWeather and send the get request as per
 * the given url
 * 
 * @author ANNI
 *
 */
@Component
public class FetchWeatherImpl implements FetchWeather {

	/**
	 * LOG
	 */
	private static final Logger LOG = LoggerFactory.getLogger(FetchWeatherImpl.class);

	/**
	 * get the web report as a json file from the web request and convert the json
	 * file into the binding class object WeatherReport and return binding class
	 * object.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public WeatherReport getWeatherReport(final String url) {
		WeatherReport body = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			URI uri = new URI(ApplicationId.appendId(url));

			HttpHeaders headers = new HttpHeaders();

			@SuppressWarnings("rawtypes")
			HttpEntity requestEntity = new HttpEntity(headers);

			LOG.info("request a get method by given url ::" + uri);
			ResponseEntity<WeatherReport> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
					WeatherReport.class);

			body = result.getBody();
			LOG.info("resopnse got successfully :: " + body);

		} catch (Exception e) {
			// TODO: handle exception
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return body;
	}

}
