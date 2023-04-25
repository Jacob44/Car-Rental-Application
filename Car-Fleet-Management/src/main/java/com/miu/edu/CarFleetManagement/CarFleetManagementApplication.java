package com.miu.edu.CarFleetManagement;

import com.miu.edu.CarFleetManagement.controllers.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;


@SpringBootApplication
public class CarFleetManagementApplication implements CommandLineRunner {

	@Autowired
	CarController carController;

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CarFleetManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dropDatabase();
		carController.addCar();
		System.out.println(carController.getQuantity("Toyota", "Prius"));
	}

	public void dropDatabase() {
		mongoTemplate.getDb().drop();
	}
}
