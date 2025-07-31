package ru.ivanov.spring.scanner.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ru.ivanov.spring.scanner.dto.SensorDTO;
import ru.ivanov.spring.scanner.models.Sensor;


@Mapper(componentModel = "spring")
public interface SensorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "measurementList", ignore = true)
    Sensor toSensor(SensorDTO sensorDTO);


    SensorDTO toSensorDTO(Sensor sensor);
}
