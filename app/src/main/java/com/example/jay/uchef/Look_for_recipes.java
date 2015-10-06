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
    ImageButton asian;
    ImageButton american;
    ImageButton indian;
    ImageButton italian;
    ImageButton mexican;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_for_recipes);

        asian = (ImageButton) findViewById(R.id.asian_btn);
        american = (ImageButton) findViewById(R.id.american_btn);
        indian = (ImageButton) findViewById(R.id.indian_btn);
        italian = (ImageButton) findViewById(R.id.italian_btn);
        mexican = (ImageButton) findViewById(R.id.mexican_btn);


        cat_browse = (TextView) findViewById(R.id.browse_cat);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        cat_browse.setTypeface(face);

        asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent asian = new Intent(Look_for_recipes.this, Vegetable_cat.class);
                startActivity(asian);

            }
        });

        american.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent american = new Intent(Look_for_recipes.this, Vegetable_cat.class);
                startActivity(american);

            }
        });

        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indian = new Intent(Look_for_recipes.this, Vegetable_cat.class);
                startActivity(indian);

            }
        });

        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent italian = new Intent(Look_for_recipes.this, Vegetable_cat.class);
                startActivity(italian);

            }
        });

        mexican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mexican = new Intent(Look_for_recipes.this, Vegetable_cat.class);
                startActivity(mexican);

            }
        });
    }

}
