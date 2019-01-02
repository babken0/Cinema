package com.nikovarchapet.cinema.cinema;

import java.io.Serializable;
import java.util.Date;

public class
Seans implements Serializable {
    Hall hall;
    String date;
    int price;

    public Seans(Hall hall, String date, int price) {
        this.hall = hall;
        this.date = date;
        this.price = price;
    }
}
