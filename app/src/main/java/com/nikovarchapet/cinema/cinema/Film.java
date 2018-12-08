package com.nikovarchapet.cinema.cinema;

import java.util.List;

public class Film {
    int imageId;
    String name;
    List<Seans> seanses;

    public Film(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;

    }
    public void addSeans(Seans seans){
        seanses.add(seans);
    }
}
