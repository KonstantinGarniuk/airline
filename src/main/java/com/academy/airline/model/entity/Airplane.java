package com.academy.airline.model.entity;

import jakarta.persistence.*;
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
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private AirplaneType type;
    @Column(name = "side_number")
    private String sideNumber;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private AirplaneStatus status;
    @Column(name = "service_time")
    private LocalDate serviceTime;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "airplane_id")
    private List<Seat> seats;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "airplane_id")
    private List<Crew> crew;
}
