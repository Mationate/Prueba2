package com.mationate.prueba2.models;

import com.orm.SugarRecord;

public class Thing extends SugarRecord {
    public Thing() {
    }

    private String thing;
    private String description;
    private boolean founded;


    public Thing(String thing, String description, boolean founded) {
        this.thing = thing;
        this.description = description;
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

    public boolean isFounded() {
        return founded;
    }

    public void setFounded(boolean founded) {
        this.founded = founded;
    }
}


