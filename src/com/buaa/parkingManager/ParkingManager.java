package com.buaa.parkingManager;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager{
    private String _parkingManagerNum;
    private ArrayList<ParkingPlace> _parkingPlaces = null;
    private ParkingBoy managerParking = new ParkingBoy(_parkingManagerNum,_parkingPlaces, new FirstAvailableParkingChooser());

    public ParkingManager(String parkingManagerNum, ArrayList<ParkingPlace> parkingPlaces)
    {
        _parkingManagerNum = parkingManagerNum;
        _parkingPlaces =  parkingPlaces;
    }

    public CarTicket parking(Car car){
        return managerParking.parking(car);
    }

    public void printInformation()
    {
        System.out.println("我的编号是：" + _parkingManagerNum);
        if (_parkingPlaces != null)
        {
            int iTotalLeft =0;
            int iTotalCount = 0;
            for(int i=0;i<_parkingPlaces.size();i++)
            {
                System.out.println("  停车场编号：" + _parkingPlaces.get(i).get_parkingPlaceNum());
                System.out.println("    车位数：" + _parkingPlaces.get(i).getiTotalParkingCount());
                iTotalCount += _parkingPlaces.get(i).getiTotalParkingCount();
                System.out.println("    空位数：" + _parkingPlaces.get(i).getiParkingLeftCount());
                iTotalLeft += _parkingPlaces.get(i).getiParkingLeftCount();
            }
            System.out.println("我所有停车场的车位数：" + iTotalCount);
            System.out.println("我所有停车场的空位数：" + iTotalLeft);
        }
    }
}
