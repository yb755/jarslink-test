package com.vbgps.jarslink;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-context.xml");
	}
}
