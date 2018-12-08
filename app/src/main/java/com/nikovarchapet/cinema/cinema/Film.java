package com.nikovarchapet.cinema.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable {
    int imageId;
    String name;
    List<Seans> seanses;

    public Film(int imageId, String name) {
        seanses = new ArrayList<>();
        this.imageId = imageId;
        this.name = name;

    }
    public void addSeans(Seans seans){
        seanses.add(seans);
    }
}
