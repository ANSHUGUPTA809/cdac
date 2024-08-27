package com.javatpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication

@ComponentScan("com.javatpoint")
public class SpringBootThymeleafViewExampleApplication 
{
public static void main(String[] args) 
{
	
	
	
	System.out.println();
SpringApplication.run(SpringBootThymeleafViewExampleApplication.class, args);
}
}