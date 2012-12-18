package test.java.org.gradle;

import junit.framework.Assert;
import main.java.org.gradle.*;
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
    private ArrayList<ParkingPlace> parkingPlaces = new ArrayList<ParkingPlace>();
    private ArrayList<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();
    int maxParkingNum =20;

    @Before
    public void initParkingManagerInstance()
    {
        _parkingManagerNum = "Manager:PM001";
        for(int i=0;i<6;i++)
        {
            parkingPlaces.add(i, new ParkingPlace("ParkingPlace:PPNum" + i, maxParkingNum));
        }

        //ParkingBoy parkingBoy = new ParkingBoy()
    }

    @Test
    public void should_parkingManager_parking_and_parkingOut_car()
    {
        Car car = new Car();
        ParkingManager parkingManager = new ParkingManager(_parkingManagerNum, parkingPlaces, null);
        try
        {
            CarTicket ticket = parkingManager.parking(car);
            car = parkingManager.parkingOut(ticket);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        Assert.assertEquals(maxParkingNum * 6, parkingManager.getiParkingTotalLeftCount());
    }

    @Test
    public void should_parkingManager_manager_one_parkingBoy()
    {
        ParkingBoy parkingBoy = new ParkingBoy("ParkingBoy:PB001", parkingPlaces, new FirstAvailableParkingChooser());
        parkingBoys.add(0,parkingBoy);
        ParkingManager parkingManager = new ParkingManager(_parkingManagerNum, parkingPlaces, parkingBoys);

        Car car = new Car();
        try
        {
            CarTicket ticket = parkingManager.arrangeParkingBoyToParkingCar(parkingBoy, car);
            car = parkingManager.arrangeParkingBoyParkingOut(parkingBoy, ticket);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        Assert.assertEquals(maxParkingNum * 6, parkingManager.getiParkingTotalLeftCount());
    }

    @Test
    public void should_parkingManager_manager_two_parkingBoy()
    {
        ArrayList<ParkingPlace>  parkingPlacesForParkingBoy1 = new ArrayList<ParkingPlace>();
        parkingPlacesForParkingBoy1.add(parkingPlaces.get(0));
        parkingPlacesForParkingBoy1.add(parkingPlaces.get(1));
        parkingPlacesForParkingBoy1.add(parkingPlaces.get(2));
        ParkingBoy parkingBoy1 = new ParkingBoy("ParkingBoy:PB001", parkingPlacesForParkingBoy1, new FirstAvailableParkingChooser());
        ArrayList<ParkingPlace>  parkingPlacesForParkingBoy2 = new ArrayList<ParkingPlace>();
        parkingPlacesForParkingBoy2.add(parkingPlaces.get(3));
        parkingPlacesForParkingBoy2.add(parkingPlaces.get(4));
        parkingPlacesForParkingBoy2.add(parkingPlaces.get(5));
        ParkingBoy parkingBoy2 = new ParkingBoy("ParkingBoy:PB002", parkingPlacesForParkingBoy2, new FirstAvailableParkingChooser());

        parkingBoys.add(0,parkingBoy1);
        parkingBoys.add(1, parkingBoy2);
        ParkingManager parkingManager = new ParkingManager(_parkingManagerNum, parkingPlaces, parkingBoys);

        Car car = new Car();
        try
        {
            CarTicket ticket = parkingManager.arrangeParkingBoyToParkingCar(parkingBoy1, car);
            car = parkingManager.arrangeParkingBoyParkingOut(parkingBoy1, ticket);

            ticket = parkingManager.arrangeParkingBoyToParkingCar(parkingBoy2, car);
            car = parkingManager.arrangeParkingBoyParkingOut(parkingBoy2, ticket);

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        Assert.assertEquals(maxParkingNum * 6, parkingManager.getiParkingTotalLeftCount());
    }

    @Test
    public void should_parkingManager_manager_three_parkingBoys_and_printInfo()
    {
        ArrayList<ParkingPlace>  parkingPlacesForParkingBoy1 = new ArrayList<ParkingPlace>();
        parkingPlacesForParkingBoy1.add(parkingPlaces.get(0));
        parkingPlacesForParkingBoy1.add(parkingPlaces.get(1));
        parkingPlacesForParkingBoy1.add(parkingPlaces.get(2));
        ParkingBoy parkingBoy1 = new ParkingBoy("ParkingBoy:PB001", parkingPlacesForParkingBoy1, new FirstAvailableParkingChooser());
        ArrayList<ParkingPlace>  parkingPlacesForParkingBoy2 = new ArrayList<ParkingPlace>();
        parkingPlacesForParkingBoy2.add(parkingPlaces.get(3));
        parkingPlacesForParkingBoy2.add(parkingPlaces.get(4));
        ParkingBoy parkingBoy3 = new ParkingBoy("ParkingBoy:PB002", parkingPlacesForParkingBoy2, new MaxAvailableParkingChooser());
        ArrayList<ParkingPlace>  parkingPlacesForParkingBoy3 = new ArrayList<ParkingPlace>();
        parkingPlacesForParkingBoy3.add(parkingPlaces.get(5));
        ParkingBoy parkingBoy2 = new ParkingBoy("ParkingBoy:PB003", parkingPlacesForParkingBoy3, new FirstAvailableParkingChooser());

        parkingBoys.add(0,parkingBoy1);
        parkingBoys.add(1, parkingBoy2);
        parkingBoys.add(2, parkingBoy3);
        ParkingManager parkingManager = new ParkingManager(_parkingManagerNum, parkingPlaces, parkingBoys);

        Car car = new Car();
        try
        {
            CarTicket ticket = parkingManager.arrangeParkingBoyToParkingCar(parkingBoy1, car);
            car = new Car();
            ticket = parkingManager.arrangeParkingBoyToParkingCar(parkingBoy2, car);
            car = new Car();
            ticket = parkingManager.arrangeParkingBoyToParkingCar(parkingBoy3, car);
            car = new Car();
            ticket = parkingManager.parking(car);
            parkingManager.printInformation();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        Assert.assertEquals(maxParkingNum * 6 - 4, parkingManager.getiParkingTotalLeftCount());
    }
}
