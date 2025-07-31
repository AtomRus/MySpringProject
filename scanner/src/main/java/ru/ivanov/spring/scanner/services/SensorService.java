package ru.ivanov.spring.scanner.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.spring.scanner.exceptions.sensor.SensorNameNotUniqueException;
import ru.ivanov.spring.scanner.models.Sensor;
import ru.ivanov.spring.scanner.repositories.SensorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    @Transactional
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Transactional
    public Sensor findById(int id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Transactional
    public Sensor findByName(String name) {
        return sensorRepository.findBySensorName(name);
    }

    @Transactional
    public Sensor save(Sensor sensor) {
        if (sensorRepository.findBySensorName(sensor.getSensorName()) != null) {
            throw new SensorNameNotUniqueException("Sensor name already exists");
        }
        return sensorRepository.save(sensor);

    }
}
