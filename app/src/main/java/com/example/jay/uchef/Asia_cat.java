package com.example.jay.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by JAY on 10/7/2015.
 */
public class Asia_cat extends Look_for_recipes {
    @Override
     protected void onCreate(Bundle savedInstanceState) {
        TextView asian_recipe;
        TextView desc_asian;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asian_cat);

        asian_recipe = (TextView) findViewById(R.id.dimsum);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        asian_recipe.setTypeface(face);

        desc_asian = (TextView) findViewById(R.id.dimsum_desc);
        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        desc_asian.setTypeface(face2);

    }
}
