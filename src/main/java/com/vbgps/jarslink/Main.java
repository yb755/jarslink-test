package com.vbgps.jarslink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleManager;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-context.xml");
		System.out.println("classloader="+Main.class.getClassLoader());
		InputStream is = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			while (true) {
				String line = reader.readLine();
				if ("list".equals(line)) {
					ModuleManager moduleManager = (ModuleManager) applicationContext.getBean("moduleManager");
					List<Module> modules = moduleManager.getModules();
					if (modules.isEmpty()) {
						System.out.println("没有加载的模块列表");
					}
					for (Module module : modules) {
						System.out.println(module.getName() + ":" + module.getVersion());
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
