package test;

import com.buaa.parkingManager.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class ParkinManagerForTest {
    private String _parkingManagerNum;
    private ArrayList<ParkingPlace> parkingPlaces;
    @Before
    public void initParkingManagerInstance()
    {
        _parkingManagerNum = "PM001";
        int maxParkingNum =1;
        ParkingPlace packingPlace = new ParkingPlace("PNum001",maxParkingNum);
        parkingPlaces.add(packingPlace);
    }

    @Test
    public void should_parkingManager_park_car()
    {
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(_parkingManagerNum, parkingPlaces);
        try
        {
            CarTicket ticket = parkingManager.parking(car);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        //Assert.assertEquals(maxParkingNum - 1, packingPlace.getiParkingLeftCount());

    }
}
