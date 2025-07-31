package ru.ivanov.spring.scanner.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ivanov.spring.scanner.models.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    Sensor findBySensorName(String sensorName);
}
