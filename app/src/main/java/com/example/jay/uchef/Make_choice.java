package com.example.jay.uchef;

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
public class Make_choice extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton btn;
        TextView tx;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_choice_activity);

        btn =  (ImageButton) findViewById(R.id.mix_ingredients_btn);
        btn.setOnClickListener(this);

        tx = (TextView) findViewById(R.id.text_or);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/CURLZ.TTF");
        tx.setTypeface(face);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,Categories.class);
        startActivity(i);
        setContentView(R.layout.categories);
    }
}
