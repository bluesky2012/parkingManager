package com.buaa.parkingManager;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class ParkFullException extends RuntimeException{
    public ParkFullException() {
    }
    public ParkFullException(String message) {
        super(message);
    }
}
