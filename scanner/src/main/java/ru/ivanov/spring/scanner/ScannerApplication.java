package ru.ivanov.spring.scanner;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ivanov.spring.scanner.dto.SensorDTO;
import ru.ivanov.spring.scanner.models.Sensor;
import ru.ivanov.spring.scanner.util.SensorMapper;

@SpringBootApplication(scanBasePackages = "ru.ivanov.spring.scanner")
public class ScannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScannerApplication.class, args);
    }

    @Bean
    public SensorMapper sensorMapper() {
        return Mappers.getMapper(SensorMapper.class);
    }
}
