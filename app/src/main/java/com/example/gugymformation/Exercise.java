package com.example.gugymformation;

import java.io.Serializable;

public class Exercise implements Serializable {
    private String name;
    private String type;
    private int image;

    public Exercise(String name, String type, int image){
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
