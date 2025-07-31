package ru.ivanov.spring.scanner.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sensor")
@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sensor_name")
    @NotNull(message = "The sensor`s name shouldn`t be empty")
    private String sensorName;

    @OneToMany(mappedBy = "sensor")
    List<Measurement> measurementList;
}
