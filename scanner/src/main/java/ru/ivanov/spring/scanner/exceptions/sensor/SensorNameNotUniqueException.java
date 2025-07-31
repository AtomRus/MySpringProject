package ru.ivanov.spring.scanner.exceptions.sensor;

public class SensorNameNotUniqueException extends RuntimeException {
    public SensorNameNotUniqueException(String message) {
        super(message);
    }
}
