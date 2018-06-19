package com.mationate.prueba2.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mationate.prueba2.R;
import com.mationate.prueba2.data.Queries;
import com.mationate.prueba2.models.Thing;

import java.util.ArrayList;
import java.util.List;

public class ThingsAdapter extends RecyclerView.Adapter<ThingsAdapter.ViewHolder> {

    private List<Thing> things = new ArrayList<>();
    private ThingListener thingListener;

    public ThingsAdapter(ThingListener listener) {
        this.thingListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_thing, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Thing thing = things.get(position);
        holder.thingName.setText(thing.getThing());
        holder.thingDescription.setText(thing.getDescription());

        holder.thingName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thing auxThing = things.get(holder.getAdapterPosition());
                thingListener.ClickedID(auxThing.getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return things.size();
    }

    public void update(Thing thing) {
        things.add(thing);
        notifyDataSetChanged();

    }

    public void updateListMain() {
        List<Thing> things = new Queries().things();
        this.things.clear();
        this.things.addAll(things);
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView thingName, thingDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            thingName = itemView.findViewById(R.id.thingNameTv);
            thingDescription = itemView.findViewById(R.id.thingDescriptionTv);
        }
    }

}
