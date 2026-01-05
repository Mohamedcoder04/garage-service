package com.renault.mobility.garage.exception;

public class GarageCapacityExceededException extends RuntimeException {
    public GarageCapacityExceededException(String message) {
        super(message);
    }
}
