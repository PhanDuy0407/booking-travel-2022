package com.group10.bookingtravel.controller;

import com.group10.bookingtravel.entity.Guide;
import com.group10.bookingtravel.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping("/guides")
    public List<Guide> getGuideList(@RequestParam(name = "nameGuide" , required = false) String name,
                                    @RequestParam(name = "phoneGuide", required = false) String phone){
        return guideService.getListGuideByNameAndPhone(name,phone);
    };
}
