package com.group10.bookingtravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tour")
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "period")
    private int period;

    @Column(name = "start_place_id")
    private int startPlaceId;

    @Column(name = "end_place_id")
    private int endPlaceId;

    @Column(name = "main_image_url")
    private String mainImageUrl;

    @Column(name = "guide_id")
    private int guideId;

    @Column(name = "place_order_max")
    private int placeOrderMax;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private int status;



}
