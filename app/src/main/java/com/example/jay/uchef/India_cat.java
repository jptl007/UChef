package com.example.jay.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by JAY on 10/7/2015.
 */
public class India_cat extends Look_for_recipes {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView indian_recipe;
        TextView desc_indian;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.indian_cat);

        indian_recipe = (TextView) findViewById(R.id.indian_curry);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        indian_recipe.setTypeface(face);

        desc_indian = (TextView) findViewById(R.id.curry_desc);
        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        desc_indian.setTypeface(face2);

    }
}
