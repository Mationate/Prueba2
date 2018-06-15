package com.mationate.prueba2.main;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mationate.prueba2.R;
import com.mationate.prueba2.adapters.ThingListener;
import com.mationate.prueba2.adapters.ThingsAdapter;
import com.mationate.prueba2.models.Thing;

public class MainActivity extends AppCompatActivity implements ThingListener {

    private ThingsAdapter adapter;

    public static final String THING_ID = "com.mationate.prueba2.views.main.KEY.THING_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_thing);

                Button button = dialog.findViewById(R.id.saveThingBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText nameInput = dialog.findViewById(R.id.thingNameEt);
                        String name = nameInput.getText().toString();

                        EditText descriptionInput = dialog.findViewById(R.id.thingDescriptionEt);
                        String description = descriptionInput.getText().toString();

                        if (name.trim().length()>0 && description.trim().length() >0){
                            Thing thing = new Thing();
                            thing.setThing(name);
                            thing.setDescription(description);
                            thing.save();

                            updateList(thing);

                            Log.e("SAVE", String.valueOf(thing.getThing()));
                        } else {
                            Toast.makeText(MainActivity.this, "Debes rellenar los campos o no se guardará", Toast.LENGTH_SHORT).show();
                        }

                        dialog.dismiss();


                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });


        RecyclerView recyclerView = findViewById(R.id.thingRv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        /*for (int i = 0; i < 12; i++) {
            Thing thing = new Thing();
            thing.setThing(String.valueOf(i));
            thing.setDescription(String.valueOf(i));
            thing.save();*/


        /*}*/


        adapter = new ThingsAdapter(this,this);
        recyclerView.setAdapter(adapter);
    }

    public void updateList(Thing thing){
        adapter.update(thing);
        Log.d("UPDATE",thing.getThing());

    }

    @Override
    public void ClickedID(long id) {
        Intent intent = new Intent(MainActivity.this, DetailThingActivity.class);
        intent.putExtra(THING_ID, id);
        intent.putExtra("name",id);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        adapter.updateList();
    }
}









