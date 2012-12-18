package main.java.org.gradle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingChooser {
    ParkingPlace getAvailablePark(List<ParkingPlace> parkPlaceList);
}
