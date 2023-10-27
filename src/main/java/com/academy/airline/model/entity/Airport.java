package com.academy.airline.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;
    @OneToMany
    @JoinColumn(name = "airport_id")
    List<Gate> gates;
}
