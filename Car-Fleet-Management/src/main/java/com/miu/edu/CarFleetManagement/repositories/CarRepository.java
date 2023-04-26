package com.miu.edu.CarFleetManagement.repositories;

import com.miu.edu.CarFleetManagement.domains.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CarRepository extends MongoRepository<Car, String> {
     Car findByLicensePlate(String licensePlate);

     List<Car> findByCarType(String type);
     List<Car> findByBrand(String brand);
     List<Car> findByPrice(double price);
     List<Car> findByPriceLessThan(double price);
     List<Car> findByPriceGreaterThan(double price);

     Integer countByBrandAndCarType(String brand, String type);

}
