package ru.ivanov.spring.scanner.exceptions.measurement;

public class MeasurementWithoutSensorName extends RuntimeException {
    public MeasurementWithoutSensorName(String message) {
        super(message);
    }
}
