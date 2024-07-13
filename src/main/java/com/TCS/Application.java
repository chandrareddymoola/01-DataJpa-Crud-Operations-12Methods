package com.TCS;

import com.TCS.entities.UserMasterEntity;
import com.TCS.repository.UserMasterRepo;
import com.TCS.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		UserService userService=context.getBean(UserService.class);
		//userService.saveUser();
		//userService.getUser();
		//userService.getUsers();
		//userService.deleteUsers();
		//userService.test();
		//userService.testFindByMethods();
		//userService.findBygender();
		//userService.findByAgeGraterThanEqualTo();
		//userService.findbygenderandcity();
		//userService.testCustomQueries();
		//userService.getAllUsers();
		//userService.CustomQueryDeleteAndUpdate();
		//userService.CustomQueryUpdate();
		userService.CustomQueryDelete();

	}

}
