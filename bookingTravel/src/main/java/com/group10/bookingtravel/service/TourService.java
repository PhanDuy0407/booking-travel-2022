package com.group10.bookingtravel.service;

import com.group10.bookingtravel.entity.Tour;
import com.group10.bookingtravel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getDataFromTour(){
        return tourRepository.tourList();
    }
}
