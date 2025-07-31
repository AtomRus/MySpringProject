package ru.ivanov.spring.scanner.exceptions.sensor;

public class SensorValidateException extends RuntimeException {
    public SensorValidateException(String message) {
        super(message);
    }
}
