package com.example.jay.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by JAY on 9/3/2015.
 */

public class Make_choice extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton mix_ingredients;
        ImageButton look_recipe;
        TextView or_option;
        TextView title;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_choice_activity);

        mix_ingredients=  (ImageButton) findViewById(R.id.mix_ingredients_btn);
        look_recipe= (ImageButton) findViewById(R.id.look_for_recipes_btn);

        or_option = (TextView) findViewById(R.id.text_or);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/CURLZ.TTF");
        or_option.setTypeface(face);

        title = (TextView) findViewById(R.id.text_choice);
        Typeface face_2 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        title.setTypeface(face_2);


        mix_ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mix = new Intent(Make_choice.this, Categories.class);
                startActivity(mix);
            }

        });

        look_recipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent look_recipe = new Intent(Make_choice.this, Look_for_recipes.class);
                startActivity(look_recipe);
            }

        });
    }
}
