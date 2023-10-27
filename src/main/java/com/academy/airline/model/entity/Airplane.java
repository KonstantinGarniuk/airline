package com.academy.airline.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    AirplaneType type;
    @Column(name = "side_number")
    String sideNumber;
    @ManyToOne
    @JoinColumn(name = "status_id")
    AirplaneStatus status;
    @Column(name = "service_time")
    LocalDate serviceTime;
    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;
    @OneToMany
    @JoinColumn(name = "airplane_id")
    List<Seat> seats;
    @OneToMany
    @JoinColumn(name = "crew_id")
    List<Crew> crew;
}
