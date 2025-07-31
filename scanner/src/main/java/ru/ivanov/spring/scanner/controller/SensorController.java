package ru.ivanov.spring.scanner.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.spring.scanner.dto.SensorDTO;
import ru.ivanov.spring.scanner.exceptions.sensor.SensorValidateException;
import ru.ivanov.spring.scanner.models.Sensor;
import ru.ivanov.spring.scanner.services.SensorService;
import ru.ivanov.spring.scanner.util.SensorMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @Autowired
    public SensorController(SensorService sensorService, SensorMapper sensorMapper) {
        this.sensorService = sensorService;
        this.sensorMapper = sensorMapper;
    }

    @GetMapping
    public ResponseEntity<List<SensorDTO>> getAllSensors() {
        List<Sensor> sensors = sensorService.findAll();
        List<SensorDTO> sensorDTOs = new ArrayList<>();
        for (Sensor sensor : sensors) {
            sensorDTOs.add(sensorMapper.toSensorDTO(sensor));
        }
        return ResponseEntity.ok(sensorDTOs);
    }

    @PostMapping("/registration")
    public ResponseEntity<SensorDTO> createSensor(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new SensorValidateException(validateBindingResult(bindingResult).toString());
        }

        return ResponseEntity.ok(sensorMapper.toSensorDTO(sensorService.save(sensorMapper.toSensor(sensorDTO))));
    }

    private StringBuilder validateBindingResult(BindingResult bindingResult) {
        StringBuilder errors = new StringBuilder();
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                errors.append(objectError.getDefaultMessage());
                errors.append(" ");
            }
        }
        return errors;
    }
}
