package com.mationate.prueba2.models;

import com.orm.SugarRecord;

public class Thing extends SugarRecord {
    public Thing() {
    }

    private String thing, description, days;
    private boolean founded;




    public Thing(String thing, String description, String date, boolean founded) {
        this.thing = thing;
        this.description = description;
        this.days = date;
        this.founded = founded;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public boolean isFounded() {
        return founded;
    }

    public void setFounded(boolean founded) {
        this.founded = founded;
    }
}


