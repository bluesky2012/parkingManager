package com.buaa.parkingManager;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public class NoCarException extends RuntimeException{
    public NoCarException() {
    }
    public NoCarException(String message) {
        super(message);
    }
}
