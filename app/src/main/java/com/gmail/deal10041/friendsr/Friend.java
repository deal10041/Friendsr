package com.gmail.deal10041.friendsr;

import java.io.Serializable;

/**
 * Created by Dylan Wellner on 20-2-2018.
 * Implements the friend class
 */

public class Friend implements Serializable{

    // variables of class
    private String name, bio;
    private int drawableId;

    public Friend(String aName, String aBio, int aDrawableId) {
        name = aName;
        bio = aBio;
        drawableId = aDrawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
