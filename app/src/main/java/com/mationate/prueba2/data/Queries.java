package com.mationate.prueba2.data;

import com.mationate.prueba2.models.Thing;

import java.util.List;

public class Queries {

    public List<Thing>  things(){
        /*List<Thing> things = new ArrayList<>();
        List<Thing> thingList = Thing.listAll(Thing.class);
        if (thingList != null && thingList.size() >0){
            things.addAll(thingList);

        }*/
        List<Thing> things = Thing.find(Thing.class,"founded = 0");
        return things;
    }

    public Thing byId (long idpending){
        Thing pending;
        pending = Thing.findById(Thing.class, idpending);
        return pending;
    }
}
