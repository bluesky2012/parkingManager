package main.java.org.gradle;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager {
    private String _parkingManagerNum;
    private ArrayList<ParkingPlace> _parkingPlaces = null;
    private ParkingBoy managerParking;
    private ArrayList<ParkingBoy> _parkingBoys = null;
    private int iParkingTotalLeftCount;

    public ParkingManager(String parkingManagerNum, ArrayList<ParkingPlace> parkingPlaces, ArrayList<ParkingBoy> parkingBoys)
    {
        _parkingManagerNum = parkingManagerNum;
        _parkingPlaces =  parkingPlaces;
        _parkingBoys = parkingBoys;
        managerParking = new ParkingBoy(_parkingManagerNum,_parkingPlaces, new FirstAvailableParkingChooser());
    }

    public CarTicket parking(Car car){
        return managerParking.parking(car);
    }

    public Car parkingOut(CarTicket ticket) {
        return managerParking.parkingOut(ticket);
    }

    public void printInformation()
    {
        System.out.println(_parkingManagerNum);
        if (_parkingPlaces != null)
        {
            int iTotalLeft =0;
            int iTotalCount = 0;
            for(int i=0; i< _parkingBoys.size();i++)
            {
                _parkingBoys.get(i).printInformation();
            }
            managerParking.printInformation();
            for(int i=0;i<_parkingPlaces.size();i++)
            {
                //System.out.println("  停车场编号：" + _parkingPlaces.get(i).get_parkingPlaceNum());
                //System.out.println("    车位数：" + _parkingPlaces.get(i).getiTotalParkingCount());
                iTotalCount += _parkingPlaces.get(i).getiTotalParkingCount();
                //System.out.println("    空位数：" + _parkingPlaces.get(i).getiParkingLeftCount());
                iTotalLeft += _parkingPlaces.get(i).getiParkingLeftCount();
            }
            System.out.println(_parkingManagerNum + "Total Left:" + iTotalCount);
            System.out.println(_parkingManagerNum + "Total:" + iTotalLeft);
        }
    }

    public int getiParkingTotalLeftCount() {
        int iParkingTotalLeftCount = 0;
        for(int i=0; i< _parkingPlaces.size();i++)
        {
            iParkingTotalLeftCount += _parkingPlaces.get(i).getiParkingLeftCount();
        }

        return iParkingTotalLeftCount;

    }

    public CarTicket arrangeParkingBoyToParkingCar(ParkingBoy parkingBoy, Car car) {
        CarTicket carTicket = null;
        for(int i =0; i < _parkingBoys.size(); i++)
        {
            if(_parkingBoys.get(i).equals(parkingBoy))
            {
                carTicket = _parkingBoys.get(i).parking(car);
            }
        }
        return carTicket;
    }

    public Car arrangeParkingBoyParkingOut(ParkingBoy parkingBoy, CarTicket ticket) {
        Car car = null;
        for(int i =0; i < _parkingBoys.size(); i++)
        {
            if(_parkingBoys.get(i).equals(parkingBoy))
            {
                car = _parkingBoys.get(i).parkingOut(ticket);
            }
        }
        return car;
    }
}
