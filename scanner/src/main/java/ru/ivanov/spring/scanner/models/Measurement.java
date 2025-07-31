package ru.ivanov.spring.scanner.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "measurement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int measurementId;

    @Column(name = "measurement")
    @NotNull(message = "The measurement shouldn`t be empty")
    private String measurement;

    @Column(name = "created_date")
    private Date measurementTime;

    @Column(name = "temperature")
    @NotNull(message = "The temperature shouldn`t be empty")
    private float temperature;

    @Column(name = "raining")
    @NotNull(message = "The raining status shouldn`t be empty")
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

}

