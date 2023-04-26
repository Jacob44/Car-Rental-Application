package com.miu.edu.CarFleetManagement.services;

import java.util.List;

public class CarDTOs {
    List<CarDTO> carDTOsList;

    public CarDTOs(List<CarDTO> carDTOsList) {
        this.carDTOsList = carDTOsList;
    }

    public List<CarDTO> getCarsList() {
        return carDTOsList;
    }
}
