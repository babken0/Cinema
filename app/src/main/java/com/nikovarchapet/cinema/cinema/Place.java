package com.nikovarchapet.cinema.cinema;

public class Place {
    boolean free=true;
//    User user;
    int rownumber;
    int seatnumber;

    public Place(int rownumber , int seatnumber){
        this.rownumber=rownumber;
        this.seatnumber=seatnumber;
    }
}
