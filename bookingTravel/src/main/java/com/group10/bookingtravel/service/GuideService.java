package com.group10.bookingtravel.service;

import com.group10.bookingtravel.entity.Guide;
import com.group10.bookingtravel.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;

    public List<Guide> getListGuideByNameAndPhone(String name, String phone){
        if(name == null || name.equals("null")){
            name = "";
        }
        if(phone == null || phone.equals("null")){
            phone = "";
        }
        List<Guide> guideList = new ArrayList<>();
        if(guideRepository.listGuide(name,phone).isPresent()){
            return guideRepository.listGuide(name,phone).get();
        }
        return guideList;
    }
}
