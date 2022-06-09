package com.group10.bookingtravel.controller;


import com.group10.bookingtravel.entity.Tour;
import com.group10.bookingtravel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    private ResponseEntity<List<Tour>> getTour(){
     return new ResponseEntity<>(tourService.getDataFromTour(), HttpStatus.OK);
    }
}
