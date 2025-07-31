package ru.ivanov.spring.scanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ivanov.spring.scanner.models.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    Measurement findMeasurementByMeasurementId(int measurementId);

    @Query(value = "select count(*) from measurement where raining = true", nativeQuery = true)
    int countRainingMeasurements();
}
