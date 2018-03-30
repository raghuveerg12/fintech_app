package com.web.isonsoft.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;

import com.web.isonsoft.controller.BaseController;

@PropertySource("classpath:config.properties")
public class GetUrlBasedOnId {
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(BaseController.class);

	public String  getUrlFromId(String id){
		String url=null;
		try{
		Properties pro=new Properties();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("config.properties").getFile());
		InputStream input=new FileInputStream(file);
		logger.info("  id is {} ",id);
		pro.load(input);
		 url=pro.getProperty(id);
		logger.info("  url  is {} ",url);

		}catch(Exception e){
			e.printStackTrace();
		}
		return url;
	}

	
	public static void main(String[] args) {
		new GetUrlBasedOnId().getUrlFromId("12");
	}
}
