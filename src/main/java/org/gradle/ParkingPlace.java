package main.java.org.gradle;

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
    public String get_parkingPlaceNum() {
        return _parkingPlaceNum;
    }
    private String _parkingPlaceNum;
    private int iTotalParkingCount = 0;
    public int getiTotalParkingCount() {
        return iTotalParkingCount;
    }

    private int iParkingLeftCount = 0;
    public int getiParkingLeftCount() {
        return iParkingLeftCount;
    }

    private Map<CarTicket, Car> carMap = new HashMap<CarTicket, Car>();

    public ParkingPlace(String parkingPlaceNum,int iParkingCount) {
        iTotalParkingCount = iParkingCount;
        iParkingLeftCount = iParkingCount;
        _parkingPlaceNum = parkingPlaceNum;
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
            result = car;
            carMap.remove(carTick);
            iParkingLeftCount ++;
        }
        return result;
    }
}
