package com.group10.bookingtravel.repository;


import com.group10.bookingtravel.dto.TourInfoDTO;
import com.group10.bookingtravel.entity.Place;
import com.group10.bookingtravel.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    @Query("select distinct new com.group10.bookingtravel.dto.TourInfoDTO(t.id,t.code,t.name,t.shortDesc,t.startTime,t.period,t.startPlaceId,p1.name,t.endPlaceId,p2.name,t.mainImageUrl,t.guideId,t.placeOrderMax,t.status) from Tour t, Place p1, Place p2 where p1.id = t.startPlaceId and p2.id = t.endPlaceId")
    List<TourInfoDTO> tourList();

}
