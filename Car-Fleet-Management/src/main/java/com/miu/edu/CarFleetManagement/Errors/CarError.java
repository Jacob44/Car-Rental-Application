package com.miu.edu.CarFleetManagement.Errors;

public class CarError {
    String errorMessage;

    public CarError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
