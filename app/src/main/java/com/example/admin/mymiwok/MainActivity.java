package com.example.admin.mymiwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TextView family = (TextView) findViewById(R.id.family) ;
            family.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                    startActivity(intent);
                }
            });

            TextView colours = (TextView) findViewById(R.id.colours) ;
            colours.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ColoursActivity.class);
                    startActivity(intent);
                }
            });

            TextView numbers = (TextView) findViewById(R.id.numbers);
            numbers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                    startActivity(intent);
                }
            });

            TextView calender = (TextView) findViewById(R.id.calender) ;
            calender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CalenderActivity .class);
                    startActivity(intent);
                }
            });




        }

}
