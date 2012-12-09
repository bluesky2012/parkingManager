package test;

import com.buaa.parkingManager.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public class parkingManagerTest {
    private ParkingPlace parkingPlace = null;
    @Before
    public void initParkingManagerInstance()
    {
        int iTotalParkingCount = 5;
        this.parkingPlace = new ParkingPlace(iTotalParkingCount);
    }

    @Test
    public void should_car_park_in_full_parking_area()
    {
        CarTicket carTick = null;
        Car car = new Car();
        carTick = parkingPlace.parkIn(car);
        Assert.assertNotNull(carTick);
    }

    @Test
    public void could_car_park_in_parking_area()
    {
        CarTicket carTick = null;
        Car car = new Car();
        carTick = parkingPlace.parkIn(car);
        Assert.assertNotNull(carTick);

    }

    @Test
    public void could_park_out_oneself_car()
    {
        CarTicket carTick = null;
        Car car = new Car();
        carTick = parkingPlace.parkIn(car);
        System.out.println("剩余车位:" + parkingPlace.getiParkingLeftCount());
        car = null;
        car = parkingPlace.parkOut(carTick);
        Assert.assertNotNull(car);
        System.out.println("剩余车位:" + parkingPlace.getiParkingLeftCount());
    }

    @Test
    public void paringBoy_ShoudParkCar(){
        Car car = new Car();
        int maxParkingNum =1;
        ParkingPlace packingPlace = new ParkingPlace(maxParkingNum);
        ArrayList<ParkingPlace> parkingPlaces = new ArrayList<ParkingPlace>();
        parkingPlaces.add(packingPlace);

        ParkingBoy parkingBoy = new ParkingBoy(parkingPlaces, new FirstAvailableParkingChooser());
        try
        {
            CarTicket ticket = parkingBoy.parking(car);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        Assert.assertEquals(maxParkingNum-1, packingPlace.getiParkingLeftCount());
    }

    @Test
    public void paringBoy_ShoudParkout_Car(){
        Car car = new Car();
        int maxParkingNum =2;
        ParkingPlace packingPlace = new ParkingPlace(maxParkingNum);
        ArrayList<ParkingPlace> parkingPlaces = new ArrayList<ParkingPlace>();
        parkingPlaces.add(packingPlace);

        ParkingBoy parkingBoy = new ParkingBoy(parkingPlaces, new FirstAvailableParkingChooser());

        CarTicket ticket = null;
        try
        {
            ticket = parkingBoy.parking(car);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        Assert.assertEquals(maxParkingNum-1, packingPlace.getiParkingLeftCount());

        try
        {
            car = parkingBoy.parkingOut(ticket);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        Assert.assertEquals(maxParkingNum, packingPlace.getiParkingLeftCount());

    }

}
