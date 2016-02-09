package com.example.jay.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
        ImageButton seafood;
        ImageButton dessert;
        ImageButton bakery;
        TextView select_cat;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        veg = (ImageButton) findViewById(R.id.vegetable);
        fruit = (ImageButton) findViewById(R.id.fruit);
        dairy = (ImageButton) findViewById(R.id.dairy);
        meat = (ImageButton) findViewById(R.id.meat);
        seafood = (ImageButton) findViewById(R.id.sea_food);
        dessert = (ImageButton) findViewById(R.id.dessert);
        //bakery = (ImageButton) findViewById(R.id.bakery);

        select_cat = (TextView) findViewById(R.id.category);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        select_cat.setTypeface(face);



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

        seafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meat = new Intent(Categories.this, Seafood_cat.class);
                startActivity(meat);

            }
        });

        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent herbs = new Intent(Categories.this, Dessert_cat.class);
                startActivity(herbs);

            }
        });

        /*bakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bakery = new Intent(Categories.this, Bakery_cat.class);
                startActivity(bakery);

            }
        });*/
    }
}
