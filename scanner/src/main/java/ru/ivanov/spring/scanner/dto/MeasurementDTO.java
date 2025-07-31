package ru.ivanov.spring.scanner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO {

    private String measurement;

    private float temperature;

    private boolean raining;

    private SensorDTO sensor;
}
