package com.nikovarchapet.cinema.cinema;

import java.io.Serializable;
import java.util.Date;

public class Seans implements Serializable {
    Hall hall;
    Date date;
    int price;

    public Seans(Hall hall, Date date, int price) {
        this.hall = hall;
        this.date = date;
        this.price = price;
    }
}
