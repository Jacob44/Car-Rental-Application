package com.miu.edu.CarFleetManagement.controllers;

import com.miu.edu.CarFleetManagement.services.CarDTO;
import com.miu.edu.CarFleetManagement.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarService carService;



    public void addCar() {
        CarDTO car1 = new CarDTO("AA001", "Toyota", "Prius", 10000.0);
        CarDTO car2 = new CarDTO("AA002", "Toyota", "Prius", 10000.0);

        carService.addCar(car1);
        carService.addCar(car2);
    }

    public int getQuantity(String brand, String type) {
        return carService.getQuantity(brand, type);
    }
}
