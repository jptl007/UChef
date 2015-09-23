package com.example.jay.uchef;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by JAY on 8/25/2015.
 */
public class Categories extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton veg;
        ImageButton fruit;
        ImageButton dairy;
        ImageButton meat;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        veg = (ImageButton) findViewById(R.id.vegetable);
        fruit = (ImageButton) findViewById(R.id.fruit);
        dairy = (ImageButton) findViewById(R.id.dairy);
        meat = (ImageButton) findViewById(R.id.meat);

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veg = new Intent(Categories.this, Vegetable_cat.class);
                startActivity(veg);

            }
        });

        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fruit = new Intent(Categories.this, Fruits_cat.class);
                startActivity(fruit);

            }
        });

        dairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dairy = new Intent(Categories.this, Dairy_cat.class);
                startActivity(dairy);

            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meat = new Intent(Categories.this, Meat_cat.class);
                startActivity(meat);

            }
        });
    }
}
