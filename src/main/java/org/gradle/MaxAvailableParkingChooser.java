package main.java.org.gradle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
public class MaxAvailableParkingChooser implements ParkingChooser {
    public ParkingPlace getAvailablePark(List<ParkingPlace> parkPlaceList){
        int maxsizeIndex=0;
        for(int i=1;i< parkPlaceList.size();i++){
            if(parkPlaceList.get(i).getiParkingLeftCount()> parkPlaceList.get(maxsizeIndex).getiParkingLeftCount()

                    )
                maxsizeIndex=i;
        }
        if(parkPlaceList.get(maxsizeIndex).getiParkingLeftCount()==0)
            throw new ParkFullException("All Places are full.");
        return   parkPlaceList.get(maxsizeIndex);
    }

}
