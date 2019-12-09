package com.example.gugymformation;

public class Hours {
    private String dayOfWeek;
    private String gymHours;
    private String poolHours;

    public Hours(String dayOfWeek, String gymHours, String poolHours){
        this.dayOfWeek = dayOfWeek;
        this.gymHours = gymHours;
        this.poolHours = poolHours;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getGymHours() {
        return gymHours;
    }

    public void setGymHours(String gymHours) {
        this.gymHours = gymHours;
    }

    public String getPoolHours() {
        return poolHours;
    }

    public void setPoolHours(String poolHours) {
        this.poolHours = poolHours;
    }
}
