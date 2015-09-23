package com.example.jay.uchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


/**
 * Created by JAY on 9/3/2015.
 */
public class Make_choice extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton btn;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_choice_activity);

        btn =  (ImageButton) findViewById(R.id.mix_ingredients_btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,Categories.class);
        startActivity(i);
    }
}
