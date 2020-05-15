package com.myproject;
//主程序入口，扫描com.myproject包下
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.myproject")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
