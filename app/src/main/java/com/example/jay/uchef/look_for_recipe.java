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

       asian=  (ImageButton) findViewById(R.id.asian_btn);
        american=  (ImageButton) findViewById(R.id.american_btn);
        italian=  (ImageButton) findViewById(R.id.italian_btn);
        indian=  (ImageButton) findViewById(R.id.indian_btn);
        mexican=  (ImageButton) findViewById(R.id.mexican_btn);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_recipes);
    br = (TextView) findViewById(R.id.browse_list);
    Typeface face_1 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.tff");
    br.setTypeface(face_1);
}
    }
