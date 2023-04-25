package com.miu.edu.CarFleetManagement.services;

import com.miu.edu.CarFleetManagement.domains.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter {

    public static CarDTO carToCarDTO(Car car){
        return new CarDTO(car.getLicensePlate(), car.getBrand(), car.getCarType(), car.getPrice());
    }

    public static Car carDToToCar(CarDTO carDTO){
        return new Car(carDTO.getLicensePlate(), carDTO.getBrand(), carDTO.getCarType(), carDTO.getPrice());
    }

    public static List<CarDTO> carListToCarDToList(List<Car> cars){
        List<CarDTO> carDTOs = new ArrayList<>();

        for(Car car: cars){
            carDTOs.add(carToCarDTO(car));
        }
        return carDTOs;
    }
}
