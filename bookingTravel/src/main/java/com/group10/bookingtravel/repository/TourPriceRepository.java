package com.group10.bookingtravel.repository;

import com.group10.bookingtravel.entity.LandTourPrice;
import com.group10.bookingtravel.entity.TourPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourPriceRepository extends JpaRepository<TourPrice,Long> {

    @Query("select distinct new com.group10.bookingtravel.entity.TourPrice(l.id,l.adult,l.children,l.kid,l.baby,l.surcharge) from TourPrice l where l.id = ?1")
    public Optional<TourPrice> getTourPriceById(Long id);
}
