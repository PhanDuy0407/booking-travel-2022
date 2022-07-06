package com.group10.bookingtravel.controller;


import com.group10.bookingtravel.dto.DataAddTourDTO;
import com.group10.bookingtravel.dto.DataUpdateTourDTO;
import com.group10.bookingtravel.dto.TourInfoDTO;
import com.group10.bookingtravel.entity.*;
import com.group10.bookingtravel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    private ResponseEntity<List<TourInfoDTO>> getTour(@RequestParam(name = "codeTour", required = false) String codeTour,
                                                      @RequestParam(name = "nameTour", required = false) String nameTour){
     return new ResponseEntity<>(tourService.getDataFromTour(codeTour,nameTour), HttpStatus.OK);
    }

    @GetMapping("/tour-price/{id}")
    public TourPrice getTourPriceByIdPrice(@PathVariable Long id){
        return tourService.getTourPriceByIdPrice(id);
    }

    @GetMapping("/discount/{id}")
    public Discount getDiscountById(@PathVariable Long id){
        return tourService.getDiscountPrice(id);
    }

    @GetMapping("/land-tour-price/{id}")
    public LandTourPrice getLandTourPriceByIdPrice(@PathVariable Long id){
        return tourService.getLandTourPriceByIdPrice(id);
    }

    @GetMapping("/tour-schedule/{id}")
    public List<TourSchedule> getTourScheduleByTourId(@PathVariable Long id){
        return tourService.getTourSchedulebyTourId(id);
    }

    @GetMapping("/tour-orders/{id}")
    public List<Orders> getTourOrdersByTourId(@PathVariable Long id){
        return tourService.getListOrderByTourId(id);
    }

    @GetMapping("/tour-schedule/maxid")
    public Integer getMaxIdTourSchedule(){
        return tourService.getMaxIdTourSchedule();
    }

    @PostMapping("/tour")
    public DataAddTourDTO addNewTour(@RequestBody DataAddTourDTO dataAddTourDTO) throws ParseException {
        tourService.addNewTour(dataAddTourDTO);
        return dataAddTourDTO;
    }

    @PostMapping("/tour/update")
    public DataUpdateTourDTO updateTour(@RequestBody DataUpdateTourDTO dataUpdateTourDTO) throws ParseException {
        tourService.updateTour(dataUpdateTourDTO);
        return dataUpdateTourDTO;
    }
}
