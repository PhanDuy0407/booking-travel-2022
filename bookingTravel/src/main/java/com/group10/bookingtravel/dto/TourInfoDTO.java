package com.group10.bookingtravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class TourInfoDTO {
    private Long id;
    private String code;
    private String name;
    private String shortDesc;
    private Date startTime;
    private Integer period;
    private Integer startPlaceId;
    private String startPlaceName;
    private Integer endPlaceId;
    private String endPlaceName;
    private String mainImageUrl;
    private Integer guideId;
    private Integer placeOrderMax;
    private Integer status;

    public TourInfoDTO(Long id, String code, String name, String shortDesc, Date startTime, Integer period, Integer startPlaceId, String startPlaceName, Integer endPlaceId, String endPlaceName, String mainImageUrl, Integer guideId, Integer placeOrderMax, Integer status) throws ParseException {
        this.id = id;
        this.code = code;
        this.name = name;
        this.shortDesc = shortDesc;
        this.startTime = startTime;
        this.period = period;
        this.startPlaceId = startPlaceId;
        this.startPlaceName = startPlaceName;
        this.endPlaceId = endPlaceId;
        this.endPlaceName = endPlaceName;
        this.mainImageUrl = mainImageUrl;
        this.guideId = guideId;
        this.placeOrderMax = placeOrderMax;
        this.status = status;

    }
}
