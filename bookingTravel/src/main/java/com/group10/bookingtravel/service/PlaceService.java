package com.group10.bookingtravel.service;

import com.group10.bookingtravel.entity.Place;
import com.group10.bookingtravel.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getListPlace(){
        return placeRepository.placeList();
    }
}
