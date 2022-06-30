package com.group10.bookingtravel.service;

import com.group10.bookingtravel.dto.TourInfoDTO;
import com.group10.bookingtravel.entity.*;
import com.group10.bookingtravel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourPriceRepository tourPriceRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private LandTourPriceRepository landTourPriceRepository;

    @Autowired
    private TourScheduleRepository tourScheduleRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public List<TourInfoDTO> getDataFromTour(){
        return tourRepository.tourList();
    }

    public Price getPriceByIdTour(Long id){
        Optional<Price> price = priceRepository.getPriceById(id);
        if(price.isPresent()){
            return price.get();
        } else {
            return new Price();
        }
    }
    public Discount getDiscountPrice(Long id){
        Price p = this.getPriceByIdTour(id);
        if(p.getId() != null){
            Optional<Discount> discount = discountRepository.findByTourid(p.getId());
            if(discount.isPresent()){
                return discount.get();
            } else{
                return new Discount();
            }
        }
        return new Discount();
    }
    public TourPrice getTourPriceByIdPrice(Long id){
        Price p = this.getPriceByIdTour(id);
        if(p.getTourPriceId() != null){
            Optional<TourPrice> tourPrice = tourPriceRepository.getTourPriceById(p.getTourPriceId());
            if(tourPrice.isPresent()){
               return tourPrice.get();
            } else {
              return new TourPrice();
            }
        }
        return new TourPrice();
    }

    public LandTourPrice getLandTourPriceByIdPrice(Long id){
        Price p = this.getPriceByIdTour(id);
        if(p.getLandTourPriceId() != null){
            Optional<LandTourPrice> landTourPrice = landTourPriceRepository.getLandTourPriceById(p.getLandTourPriceId());
            if(landTourPrice.isPresent()){
                return landTourPrice.get();
            } else {
                return new LandTourPrice();
            }
        }
        return new LandTourPrice();
    }

    public List<TourSchedule> getTourSchedulebyTourId(Long id){
        Optional<List<TourSchedule>> tourScheduleListOpt =  tourScheduleRepository.getTourScheduleByTourId(id);
        List<TourSchedule> tourScheduleList = new ArrayList<>();
        if(tourScheduleListOpt.isPresent()){
          return tourScheduleListOpt.get();
        } else {
            return tourScheduleList;
        }
    }

    public List<Orders> getListOrderByTourId(Long id){
        List<Orders> ordersList = new ArrayList<>();
        Price p = this.getPriceByIdTour(id);
        if(p.getId() != null){
            Optional<List<Orders>> listOrdersOpt = ordersRepository.listOrdersByPriceId(p.getId());
            if(listOrdersOpt.isPresent()){
                return listOrdersOpt.get();
            }
        }
        return ordersList;
    }
}
