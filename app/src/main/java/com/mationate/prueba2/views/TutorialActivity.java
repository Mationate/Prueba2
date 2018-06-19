package com.mationate.prueba2.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mationate.prueba2.R;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);



        Button button = findViewById(R.id.tutorialBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}



/* Boolean firstTime = null;
 *//**
 * Checks if the user is opening the app for the first time.
 * Note that this method should be placed inside an activity and it can be called multiple times.
 * @return boolean
 *//*
        private boolean isFirstTime() {
            if (firstTime == null) {
                SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
                firstTime = mPreferences.getBoolean("firstTime", true);
                if (firstTime) {
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                }
            }
            return firstTime;
        }*/
