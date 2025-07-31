package ru.ivanov.spring.scanner.util;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ivanov.spring.scanner.dto.SensorDTO;
import ru.ivanov.spring.scanner.models.Sensor;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-27T13:11:46+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class SensorMapperImpl implements SensorMapper {

    @Override
    public Sensor toSensor(SensorDTO sensorDTO) {
        if ( sensorDTO == null ) {
            return null;
        }

        Sensor.SensorBuilder sensor = Sensor.builder();

        sensor.sensorName( sensorDTO.getSensorName() );

        return sensor.build();
    }

    @Override
    public SensorDTO toSensorDTO(Sensor sensor) {
        if ( sensor == null ) {
            return null;
        }

        SensorDTO sensorDTO = new SensorDTO();

        sensorDTO.setSensorName( sensor.getSensorName() );

        return sensorDTO;
    }
}
