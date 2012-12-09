package com.buaa.parkingManager;

import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
public class ParkingPlace {
    private int iTotalParkingCount = 0;

    public int getiParkingLeftCount() {
        return iParkingLeftCount;
    }

    private int iParkingLeftCount = 0;


    private Map<CarTicket, Car> carMap = new HashMap<CarTicket, Car>();

    public ParkingPlace(int iParkingCount) {
        iTotalParkingCount = iParkingCount;
        iParkingLeftCount = iParkingCount;
    }

    public CarTicket parkIn(Car car) {
        CarTicket result = null;
        if(iParkingLeftCount > 0)
        {
            iParkingLeftCount --;
            CarTicket carTick = new CarTicket();
            carMap.put(carTick, car);
            result = carTick;
        }
        return result;

    }

    public Car parkOut(CarTicket carTick) {
        Car result = null;
        if (carMap.containsKey(carTick))
        {
            Car car = carMap.get(carTick);
            carMap.remove(carTick);
            iParkingLeftCount ++;
            result = car;
        }
        return result;
    }
}
