package com.nikovarchapet.cinema.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hall implements Serializable {

    public static final Hall HALL_1 = new Hall("Hall 1", 7 , 10);
    public static final Hall HALL_2 = new Hall("Hall 2", 12 , 24);
    public static final Hall HALL_3 = new Hall("Hall 3", 30 , 30);
    public static final Hall VIP_HALL = new Hall("VIP Hall", 2 , 4);
    String name;
    int rowCount;
    int seatCount;
    List<Place> places;
    public Hall(String name, int rowCount, int seatCount ){
        places = new ArrayList<>();
        this.name = name;
        this.rowCount=rowCount;
        this.seatCount = seatCount;
        addPlaces(rowCount, seatCount);
    }

    private void addPlaces(int row, int seatCount) {
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < seatCount; j++) {
                Place place = new Place(i,j);
                places.add(place);
            }
        }
    }
}
