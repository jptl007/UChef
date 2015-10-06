package com.example.jay.uchef;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by mahak on 10/6/2015.
 */
public class look_for_recipe extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton asian;
        ImageButton american;
        ImageButton italian;
        ImageButton indian;
        ImageButton mexican;
        TextView br;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_recipes);
    br = (TextView) findViewById(R.id.browse_list);
    Typeface face_1 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.tff");
    br.setTypeface(face_1);
}
    }
