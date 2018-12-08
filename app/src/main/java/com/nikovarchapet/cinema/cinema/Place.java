package com.nikovarchapet.cinema.cinema;

import java.io.Serializable;

public class Place implements Serializable {
    boolean free=true;
//    User user;
    int rownumber;
    int seatnumber;

    public Place(int rownumber , int seatnumber){
        this.rownumber=rownumber;
        this.seatnumber=seatnumber;
    }
}
