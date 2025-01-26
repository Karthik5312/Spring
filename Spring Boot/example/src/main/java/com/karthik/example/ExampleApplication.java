package com.karthik.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

		//var ctx = SpringApplication.run(ExampleApplication.class, args);

		//MyFirstClass myFirstClass = new MyFirstClass();
		//System.out.println(myFirstClass.sayHello());

		//ctx means instance of ApplicationContext class
		//MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		//MyFirstClass myFirstClass = ctx.getBean("firstBean", MyFirstClass.class);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());
		System.out.println(myFirstService.getJavaVersion());
		System.out.println(myFirstService.getOsName());
		System.out.println(myFirstService.readProp());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomProperty());
		System.out.println(myFirstService.getCustom_2_PropertyFromAnotherFile());

	}

	//@Bean
	//public MyFirstClass myFirstClass() {
		//return new MyFirstClass();
	//}

}
