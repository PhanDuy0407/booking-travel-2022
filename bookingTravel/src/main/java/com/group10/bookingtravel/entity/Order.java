package com.group10.bookingtravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "adult_count")
    private int adultCount;

    @Column(name = "children_count")
    private int childrenCount;

    @Column(name = "kid_count")
    private int kidCount;

    @Column(name = "baby_count")
    private int babyCount;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "status")
    private String status;
}
