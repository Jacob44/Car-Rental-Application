package com.miu.edu.CarFleetManagement.controllers;

import com.miu.edu.CarFleetManagement.Errors.CarError;
import com.miu.edu.CarFleetManagement.services.CarDTO;
import com.miu.edu.CarFleetManagement.services.CarDTOs;
import com.miu.edu.CarFleetManagement.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cars")
@RestController
public class CarController {

    @Autowired
    private CarService carService;


    @PostMapping("/")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) {
        try {
            CarDTO car = carService.addCar(carDTO);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CarError(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCars() {
        CarDTOs cars = new CarDTOs(carService.getAllCars());
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> getQuantity(@RequestParam(value = "brand") String brand, @RequestParam(value = "type") String type) {
        int quantity = carService.getQuantity(brand, type);
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }

    @PutMapping("/{licensePlate}")
    public ResponseEntity<?> updateCar(@PathVariable String licensePlate, @RequestBody CarDTO carDTO) {
        try {
            CarDTO car = carService.updateCar(licensePlate, carDTO);
            return new ResponseEntity<>(car, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new CarError(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{licensePlate}")
    public ResponseEntity<?> deleteCar(@PathVariable String licensePlate){
        try {
            carService.removeCar(licensePlate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(new CarError(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/search/{type}")
    public ResponseEntity<CarDTOs> searchCarByType(@PathVariable String type) {
        CarDTOs carDTOs = new CarDTOs(carService.searchCarByType(type));
        return ResponseEntity.ok(carDTOs);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<CarDTOs> searchCarByBrand(@PathVariable String brand) {
        CarDTOs carDTOs = new CarDTOs(carService.searchCarByBrand(brand));
        return ResponseEntity.ok(carDTOs);
    }

    @GetMapping("/price")
    public ResponseEntity<CarDTOs> searchByPrice(@RequestParam double price, @RequestParam String operation) {

                CarDTOs carDTOs = new CarDTOs(carService.searchByPrice(price, operation));
                return ResponseEntity.ok(carDTOs);

    }


}


