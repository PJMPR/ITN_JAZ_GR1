package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);

		//FirstComponent first = new FirstComponent();
		//SecondComponent second = new SecondComponent(first);
		//ThirdComponent third = new ThirdComponent(second);

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.scan("com.example.demo");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//context.refresh();

		ThirdComponent  third = context.getBean("third",ThirdComponent.class);
			third.SayHi();

		PersonDb personDb = context.getBean("persondb", PersonDb.class);

		PersonRepository repository = context.getBean("repository", PersonRepository.class);
	}

}
