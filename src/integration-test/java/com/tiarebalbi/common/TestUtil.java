package com.tiarebalbi.common;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

/**
 * @author Tiarê Balbi Bonamini
 *
 */
public class TestUtil {

	/**
	 * 
	 */
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	/**
	 * 
	 */
	public static final MediaType TEXT_HTML_UTF8 = new MediaType(
			MediaType.TEXT_HTML.getType(),
			MediaType.TEXT_HTML.getSubtype(), Charset.forName("utf8"));

}
