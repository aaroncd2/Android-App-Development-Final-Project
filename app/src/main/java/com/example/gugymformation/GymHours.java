package com.example.gugymformation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GymHours {
    int opens;
    int closes;

    public GymHours(int opens, int closes){
        this.opens = opens;
        this.closes = closes;
    }

    public int getOpens() {
        return opens;
    }

    public int getCloses() {
        return closes;
    }

    public void setOpens(int opens) {
        this.opens = opens;
    }

    public void setCloses(int closes) {
        this.closes = closes;
    }
}
