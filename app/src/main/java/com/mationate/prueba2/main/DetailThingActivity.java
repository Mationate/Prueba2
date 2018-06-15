package com.mationate.prueba2.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mationate.prueba2.R;
import com.mationate.prueba2.data.Queries;
import com.mationate.prueba2.models.Thing;

public class DetailThingActivity extends AppCompatActivity {

    private long thing_id;
    private Thing thing;
    TextView thingTv, descriptionTv;
    Button foundedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_thing);

        thing_id = getIntent().getLongExtra(MainActivity.THING_ID,0);

        thing = new Queries().byId(thing_id);
        thingTv = findViewById(R.id.thingResult);
        descriptionTv = findViewById(R.id.descriptionResult);
        foundedBtn = findViewById(R.id.foundedBtn);

        thingTv.setText(thing.getThing());
        descriptionTv.setText(thing.getDescription());

        getSupportActionBar().setTitle(thing.getThing());

        foundedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailThingActivity.this);
                builder.setTitle("Encontraste tu artículo?");
                builder.setMessage("Estamos felices de que hayas encontrado tu artículo, pero debemos estar seguros de aquello...");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("DetailActivity", "Delete this");
                        /*int auxPosition = holder.getAdapterPosition();
                        Thing auxPending = things.get(auxPosition);
                        auxPending.save();
                        things.remove(auxPosition);
                        notifyItemRemoved(auxPosition);*/

                        thing.setFounded(true);
                        thing.save();
                        finish();
                        // Se borra la fila, pero no en tiempo real, tengo que cerrar la app y abrirla para notar el cambio..


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("DetailActivity", "keep in details activity");
                    }
                });
                builder.show();
            }
        });






    }
}
