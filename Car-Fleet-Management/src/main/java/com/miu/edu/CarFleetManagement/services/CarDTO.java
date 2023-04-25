package com.miu.edu.CarFleetManagement.services;


public class CarDTO {

    private String licensePlate;
    private String brand;
    private String carType;
    private double price;

    public CarDTO() {
    }

    public CarDTO(String licensePlate, String brand, String carType, double price) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.carType = carType;
        this.price = price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
