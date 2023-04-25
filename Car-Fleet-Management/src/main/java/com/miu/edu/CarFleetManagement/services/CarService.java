package com.miu.edu.CarFleetManagement.services;

import com.miu.edu.CarFleetManagement.domains.Car;
import com.miu.edu.CarFleetManagement.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public int getQuantity(String brand, String carType){
        return carRepository.countByBrandAndCarType(brand, carType);
    }

    public CarDTO addCar(CarDTO carDTO) {

        Car car = CarAdapter.carDToToCar(carDTO);
        carRepository.save(car);

        return carDTO;
    }

    public void removeCar(String licensePlate) {
        Car car = carRepository.findByLicensePlate(licensePlate);
        carRepository.delete(car);
    }

    public CarDTO updateCar(String licensePlate, double price) {
        Car car = carRepository.findByLicensePlate(licensePlate);
        car.setPrice(price);
        carRepository.save(car);
        return CarAdapter.carToCarDTO(car);
    }

    public CarDTO getCarByLicensePlate(String licensePlate) {
        Car car = carRepository.findByLicensePlate(licensePlate);
        return CarAdapter.carToCarDTO(car);
    }

    public List<CarDTO> searchCarByType(String type) {
        List<Car> carList = carRepository.findByCarType(type);
       return CarAdapter.carListToCarDToList(carList);
    }

    public List<CarDTO> searchCarByBrand(String brand) {
        List<Car> carList = carRepository.findByBrand(brand);
        return CarAdapter.carListToCarDToList(carList);
    }

    public List<CarDTO> searchByPrice(double price, String operation) {

        switch (operation) {
            case "equal": {
                List<Car> carList = carRepository.findByPriceEquals(price);
                return CarAdapter.carListToCarDToList(carList);
            }
            case "less": {
                List<Car> carList = carRepository.findByPriceGreaterThan(price);
                return CarAdapter.carListToCarDToList(carList);
            }
            case "greater": {
                List<Car> carList = carRepository.findByPriceLessThan(price);
                return CarAdapter.carListToCarDToList(carList);
            }
        }
        return null;
    }
}
