package test.java.org.gradle;

import junit.framework.Assert;
import main.java.org.gradle.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoyChoosing {
    private ParkingPlace parkingPlace = null;
    @Before
    public void initParkingManagerInstance()
    {
        int iTotalParkingCount = 5;
        this.parkingPlace = new ParkingPlace("PNum001",iTotalParkingCount);
    }

    @Test
    public void shoud_smartboy_parkCar()
    {
        Car car=new Car();
        int maxParkingNum=5;
        ParkingPlace parkPlace=new ParkingPlace("PNum001", maxParkingNum);
        ArrayList<ParkingPlace> parkPlaces=new ArrayList<ParkingPlace>();
        parkPlaces.add(parkPlace) ;
        ParkingBoy parkingBoy= new ParkingBoy("PB001",parkPlaces, new FirstAvailableParkingChooser());
        CarTicket ticket=parkingBoy.parking(car);
        Assert.assertEquals(maxParkingNum, parkingPlace.getiParkingLeftCount());

    }
}
