package com.example.jay.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by JAY on 10/7/2015.
 */
public class America_cat extends Look_for_recipes {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView american_recipe;
        TextView desc_american;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.american_cat);

        american_recipe = (TextView) findViewById(R.id.cheesypotato);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        american_recipe.setTypeface(face);

        desc_american = (TextView) findViewById(R.id.cheesypotato_desc);
        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        desc_american.setTypeface(face2);

    }
}
