package com.example.jay.uchef;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by JAY on 10/6/2015.
 */
public class Look_for_recipes extends Activity {

    TextView cat_browse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_for_recipes);

        cat_browse = (TextView) findViewById(R.id.browse_cat);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        cat_browse.setTypeface(face);
    }

}
