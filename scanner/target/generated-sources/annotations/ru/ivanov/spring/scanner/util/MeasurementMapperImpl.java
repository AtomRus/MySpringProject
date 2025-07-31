package ru.ivanov.spring.scanner.util;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.ivanov.spring.scanner.dto.MeasurementDTO;
import ru.ivanov.spring.scanner.dto.SensorDTO;
import ru.ivanov.spring.scanner.models.Measurement;
import ru.ivanov.spring.scanner.models.Sensor;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-27T13:11:47+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class MeasurementMapperImpl implements MeasurementMapper {

    @Override
    public Measurement toMeasurement(MeasurementDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Measurement measurement = new Measurement();

        measurement.setSensor( sensorDTOToSensor( dto.getSensor() ) );
        measurement.setMeasurement( dto.getMeasurement() );
        measurement.setTemperature( dto.getTemperature() );
        measurement.setRaining( dto.isRaining() );

        return measurement;
    }

    @Override
    public MeasurementDTO toMeasurementDTO(Measurement measurement) {
        if ( measurement == null ) {
            return null;
        }

        MeasurementDTO measurementDTO = new MeasurementDTO();

        measurementDTO.setMeasurement( measurement.getMeasurement() );
        measurementDTO.setTemperature( measurement.getTemperature() );
        measurementDTO.setRaining( measurement.isRaining() );
        measurementDTO.setSensor( sensorToSensorDTO( measurement.getSensor() ) );

        return measurementDTO;
    }

    protected Sensor sensorDTOToSensor(SensorDTO sensorDTO) {
        if ( sensorDTO == null ) {
            return null;
        }

        Sensor.SensorBuilder sensor = Sensor.builder();

        sensor.sensorName( sensorDTO.getSensorName() );

        return sensor.build();
    }

    protected SensorDTO sensorToSensorDTO(Sensor sensor) {
        if ( sensor == null ) {
            return null;
        }

        SensorDTO sensorDTO = new SensorDTO();

        sensorDTO.setSensorName( sensor.getSensorName() );

        return sensorDTO;
    }
}
