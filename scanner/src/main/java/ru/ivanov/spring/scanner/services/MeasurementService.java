package ru.ivanov.spring.scanner.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.spring.scanner.exceptions.measurement.MeasurementWithoutSensorName;
import ru.ivanov.spring.scanner.exceptions.measurement.MeasurementSensorIsNotRegistered;
import ru.ivanov.spring.scanner.models.Measurement;
import ru.ivanov.spring.scanner.repositories.MeasurementRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorService sensorService;

    @Transactional
    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    @Transactional
    public Measurement findMeasurementById(int id) {
        return measurementRepository.findMeasurementByMeasurementId(id);
    }

    @Transactional
    public Measurement createMeasurement(Measurement measurement) {
        if (measurement.getSensor().getSensorName() == null) {
            throw new MeasurementWithoutSensorName("Sensor name is required");
        }
        if (sensorService.findAll().stream().noneMatch(sensor -> sensor.getSensorName().equals(measurement.getSensor().getSensorName()))) {
            throw new MeasurementSensorIsNotRegistered("This sensor is not registered");
        }
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getSensorName()));
        measurement.getSensor().getMeasurementList().add(measurement);
        measurement.setMeasurementTime(new Date());
        return measurementRepository.save(measurement);
    }


    public int countRainingMeasurements() {
        return measurementRepository.countRainingMeasurements();
    }
}
