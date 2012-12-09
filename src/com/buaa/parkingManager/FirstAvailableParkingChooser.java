package com.buaa.parkingManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class FirstAvailableParkingChooser implements  ParkingChooser{
    @Override
    public ParkingPlace getAvailablePark(List<ParkingPlace> parkPlaceList)
    {
        for(ParkingPlace parkPlace:parkPlaceList){
            if(parkPlace.getiParkingLeftCount()>0) return parkPlace;
        }
        throw new ParkFullException("所有的停车场都已满");
    }
}
