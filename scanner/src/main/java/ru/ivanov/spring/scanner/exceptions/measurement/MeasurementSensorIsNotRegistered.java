package ru.ivanov.spring.scanner.exceptions.measurement;

public class MeasurementSensorIsNotRegistered extends RuntimeException {
    public MeasurementSensorIsNotRegistered(String message) {
        super(message);
    }
}
