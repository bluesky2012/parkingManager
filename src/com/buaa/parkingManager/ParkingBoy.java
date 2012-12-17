package com.buaa.parkingManager;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    private String _parkingBoyNum = null;
    private ArrayList<ParkingPlace> _parkingPlaces = null;
    private final ParkingChooser _parkingChooser;

    public ParkingBoy(String parkingBoyNum,ArrayList<ParkingPlace> parkPlaces, ParkingChooser parkingChooser) {
        _parkingBoyNum =  parkingBoyNum;
        this._parkingPlaces=parkPlaces;
        this._parkingChooser = parkingChooser;
    }

    public CarTicket parking(Car car){
        int index =0;
        int iMax = 0;
        for(int i=0; i< _parkingPlaces.size(); i++)
        {
            if (_parkingPlaces.get(i).getiParkingLeftCount() > iMax)
            {
                iMax = _parkingPlaces.get(i).getiParkingLeftCount();
                index = i;
            }
        }

        if (_parkingPlaces.get(index).getiParkingLeftCount() > 0)
        {
            return _parkingPlaces.get(index).parkIn(car);
        }

        throw new ParkFullException("没有空余车位。");
    }

    public Car parkingOut(CarTicket ticket){
        Car car = null;
        for(int i=0; i< _parkingPlaces.size(); i++)
        {
            car =  _parkingPlaces.get(i).parkOut(ticket);
            if(car != null)
            {
                break;
            }
        }
        if (car != null)
        {
            return car;
        }
        else
        {
            throw new NoCarException("停车场没有找到车，是不是丢了？");
        }
    }

    public void printInformation()
    {
        System.out.println();
        System.out.println("    " + _parkingBoyNum);
        if (_parkingPlaces != null)
        {
            int iTotalLeft =0;
            int iTotalCount = 0;
            for(int i=0;i<_parkingPlaces.size();i++)
            {
                System.out.println("        停车场编号：" + _parkingPlaces.get(i).get_parkingPlaceNum());
                System.out.println("            车位数：" + _parkingPlaces.get(i).getiTotalParkingCount());
                iTotalCount += _parkingPlaces.get(i).getiTotalParkingCount();
                System.out.println("            空位数：" + _parkingPlaces.get(i).getiParkingLeftCount());
                iTotalLeft += _parkingPlaces.get(i).getiParkingLeftCount();
            }
            System.out.println("    " + _parkingBoyNum + "所有停车场的车位数：" + iTotalCount);
            System.out.println("    " + _parkingBoyNum + "所有停车场的空位数：" + iTotalLeft);
        }
    }
}
