package com.example.spring_rest_sample;

import com.example.spring_rest_sample.dao.UserDao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringRestSampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringRestSampleApplication.class, args);

		UserDao userdao = ctx.getBean(UserDao.class);
		userdao.getUserList().stream().forEach(System.out::println);
	}
}
