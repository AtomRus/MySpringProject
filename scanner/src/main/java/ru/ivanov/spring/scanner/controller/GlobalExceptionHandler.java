package ru.ivanov.spring.scanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ivanov.spring.scanner.exceptions.measurement.MeasurementValidateException;
import ru.ivanov.spring.scanner.exceptions.measurement.MeasurementWithoutSensorName;
import ru.ivanov.spring.scanner.exceptions.measurement.MeasurementSensorIsNotRegistered;
import ru.ivanov.spring.scanner.exceptions.sensor.SensorNameNotUniqueException;
import ru.ivanov.spring.scanner.exceptions.sensor.SensorValidateException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SensorValidateException.class)
    public ResponseEntity<ErrorResponse> SensorValidateException(SensorValidateException e) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        e.getMessage(),
                        "Sensor validate conflict",
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                )
        );
    }
    @ExceptionHandler(SensorNameNotUniqueException.class)
    public ResponseEntity<ErrorResponse> SensorValidateException(SensorNameNotUniqueException e) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        e.getMessage(),
                        "Sensor validate conflict",
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(MeasurementSensorIsNotRegistered.class)
    public ResponseEntity<ErrorResponse> SensorValidateException(MeasurementSensorIsNotRegistered e) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        e.getMessage(),
                        "Measurement validate conflict",
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(MeasurementValidateException.class)
    public ResponseEntity<ErrorResponse> SensorValidateException(MeasurementValidateException e) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        e.getMessage(),
                        "Measurement validate conflict",
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                )

        );
    }

    @ExceptionHandler(MeasurementWithoutSensorName.class)
    public ResponseEntity<ErrorResponse> SensorValidateException(MeasurementWithoutSensorName e) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        e.getMessage(),
                        "Measurement validate conflict",
                        HttpStatus.BAD_REQUEST.value(),
                        LocalDateTime.now()
                )

        );
    }
}
