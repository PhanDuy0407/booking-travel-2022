package com.group10.bookingtravel.repository;

import com.group10.bookingtravel.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    @Query("select distinct new com.group10.bookingtravel.entity.Place(p.id,p.regionId,p.name) from Place p")
    List<Place> placeList();
}
