package ru.ivanov.spring.scanner.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;
import ru.ivanov.spring.scanner.dto.MeasurementDTO;
import ru.ivanov.spring.scanner.models.Measurement;
import ru.ivanov.spring.scanner.models.Sensor;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {


    @Mapping(target = "measurementId", ignore = true)
    @Mapping(target = "sensor", source = "sensor")
    Measurement toMeasurement(MeasurementDTO dto);

    MeasurementDTO toMeasurementDTO(Measurement measurement);

    default Sensor mapSensorName(String sensorName) {
        if (sensorName == null) return null;
        Sensor sensor = new Sensor();
        sensor.setSensorName(sensorName);
        return sensor;
    }
}
