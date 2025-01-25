package com.karthik.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(ExampleApplication.class, args);

		//MyFirstClass myFirstClass = new MyFirstClass();
		//System.out.println(myFirstClass.sayHello());

		//ctx means instance of ApplicationContext class
		//MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		//MyFirstClass myFirstClass = ctx.getBean("firstBean", MyFirstClass.class);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());


	}

	//@Bean
	//public MyFirstClass myFirstClass() {
		//return new MyFirstClass();
	//}

}
