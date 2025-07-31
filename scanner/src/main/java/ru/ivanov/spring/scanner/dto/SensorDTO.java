package ru.ivanov.spring.scanner.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {

    @NotNull(message = "The sensor`s name shouldn`t be empty")
    private String sensorName;

}
