package com.group10.bookingtravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "land_tour_price")
@Entity
public class LandTourPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "adult")
    private int adult;

    @Column(name = "children")
    private int children;

    @Column(name = "kid")
    private int kid;

    @Column(name = "baby")
    private int baby;

    @Column(name = "surcharge")
    private int surcharge;
}
