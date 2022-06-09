package com.group10.bookingtravel.repository;


import com.group10.bookingtravel.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    @Query("select distinct new com.group10.bookingtravel.entity.Tour(t.id,t.name,t.shortDesc,t.startTime,t.period,t.startPlaceId,t.endPlaceId,t.mainImageUrl,t.guideId,t.placeOrderMax,t.code,t.status) from Tour t")
    List<Tour> tourList();

}
