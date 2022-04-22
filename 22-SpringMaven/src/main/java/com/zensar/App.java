package com.zensar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	String appName;

	public App() {
		super();
	}

	public App(String appName) {
		super();
		this.appName = appName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Override
	public String toString() {
		return "App [appName=" + appName + "]";
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		String cmp = (String) applicationContext.getBean("company");
		System.out.println(cmp);

		int totalPercentage = (int) applicationContext.getBean("IntNum");
		System.out.println(totalPercentage);

		App app = (App) applicationContext.getBean("applicationName");
		System.out.println(app);
		
		System.out.println(applicationContext.getBean("employee"));
		System.out.println(applicationContext.getBean("student"));

	}
}
