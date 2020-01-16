package com.ptmd.util;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
/**
 * Binding class object to store the xml data.
 * 
 * @author ANNI
 *
 */
@Data
@XmlRootElement(name = "urls")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RequestURLs implements Serializable {

	/**
	 * for the serialization
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * data store as a list
	 */
	private List<String> url;

}
