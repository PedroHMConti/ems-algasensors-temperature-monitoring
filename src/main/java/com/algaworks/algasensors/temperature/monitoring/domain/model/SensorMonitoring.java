package com.algaworks.algasensors.temperature.monitoring.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorMonitoring {
    @Id
    @AttributeOverride(name = "value",column = @Column(name = "id", columnDefinition = "bigint"))
    private SensorId id;
    private Double lastTemperature;
    private OffsetDateTime updatedAt;
    private Boolean enabled;

}
