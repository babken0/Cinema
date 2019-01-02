package com.nikovarchapet.cinema.cinema;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable {
    String imageUri;
    String name;
    List<Seans> seanses;

    public Film(String imageUri, String name) {
        seanses = new ArrayList<>();
        this.imageUri = imageUri;
        this.name = name;
    }

    public Film(List<Seans> seanses , String imageUri, String name) {
        this.seanses = seanses;
        this.imageUri = imageUri;
        this.name = name;
    }



    public void addSeans(Seans seans){
        seanses.add(seans);
    }
}
