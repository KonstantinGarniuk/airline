package com.academy.airline.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    Flight flight;
    @ManyToOne
    @JoinColumn(name = "seat_id")
    Seat seat;
    @Column(name = "luggage")
    Integer luggage;
    @Column(name = "price")
    Integer price;
    @ManyToOne
    @JoinColumn(name = "status_id")
    TicketStatus status;
}
