package com.group10.bookingtravel.repository;

import com.group10.bookingtravel.entity.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourScheduleRepository extends JpaRepository<TourSchedule,Long> {

    public Optional<List<TourSchedule>> getTourScheduleByTourId(Long id);
}
