package com.mationate.prueba2.data;

import com.mationate.prueba2.models.Thing;

import java.util.List;

public class Queries {

    public List<Thing> things() {

        List<Thing> things = Thing.find(Thing.class, "founded = 0");
        return things;
    }

    public Thing byId(long idThing) {
        Thing thing;
        thing = Thing.findById(Thing.class, idThing);
        return thing;
    }
}
