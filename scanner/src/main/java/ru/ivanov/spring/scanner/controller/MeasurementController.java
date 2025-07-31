package ru.ivanov.spring.scanner.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.spring.scanner.dto.MeasurementDTO;
import ru.ivanov.spring.scanner.exceptions.measurement.MeasurementValidateException;
import ru.ivanov.spring.scanner.models.Measurement;
import ru.ivanov.spring.scanner.services.MeasurementService;
import ru.ivanov.spring.scanner.util.MeasurementMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementMapper measurementMapper;

    @Autowired
    public MeasurementController(MeasurementService measurementService, MeasurementMapper measurementMapper) {
        this.measurementService = measurementService;
        this.measurementMapper = measurementMapper;
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDTO>> getMeasurements() {
        List<Measurement> measurements = measurementService.getMeasurements();
        List<MeasurementDTO> measurementDTOS = new ArrayList<>();
        for (Measurement measurement : measurements) {
            measurementDTOS.add(measurementMapper.toMeasurementDTO(measurement));
        }
        return new ResponseEntity<>(measurementDTOS, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MeasurementDTO> createMeasurement(@Valid @RequestBody MeasurementDTO measurementDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new MeasurementValidateException(validateBindingResult(bindingResult).toString());
        }
        return ResponseEntity.ok(measurementMapper.toMeasurementDTO(measurementService.createMeasurement(measurementMapper.toMeasurement(measurementDTO))));
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Integer> countRainingMeasurements() {



        return ResponseEntity.ok(measurementService.countRainingMeasurements());
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
