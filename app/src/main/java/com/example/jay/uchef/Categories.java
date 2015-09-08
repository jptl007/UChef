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
public class Categories extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton btn;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        btn =  (ImageButton) findViewById(R.id.vegetable);
        btn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        Intent i = new Intent(this,Vegetable_cat.class);
        startActivity(i);
        setContentView(R.layout.vegetable_cat);
    }

}
