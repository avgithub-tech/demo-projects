package com.avtech.springcloud.springcloudfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionApplication.class, args);
	}


	@Bean
	public Function<String,String> upperCase(){
		return (input) -> input.toUpperCase();
	}

	@Bean
	public Supplier<Employee> getEmployee(){
		return () -> new Employee(1,"Amit");
	}

	@Bean
	public Consumer<String> writeString(){
		return (input) -> System.out.printf(input);
	}

}
