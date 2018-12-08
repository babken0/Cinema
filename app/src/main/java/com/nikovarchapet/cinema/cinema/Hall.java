package com.nikovarchapet.cinema.cinema;

import java.util.List;

public class Hall {
    int rowCount;
    int seatCount;
    List<Place> places;
    public Hall(int rowCount, int seatCount ){
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
