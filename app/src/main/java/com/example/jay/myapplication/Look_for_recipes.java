package com.example.jay.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by JAY on 10/6/2015.
 */
public class Look_for_recipes extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView cat_browse;
        ImageButton asian;
        ImageButton american;
        ImageButton indian;
        ImageButton italian;
        ImageButton mexican;

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
                Intent asian = new Intent(Look_for_recipes.this, Asia_cat.class);
                startActivity(asian);

            }
        });

        american.setOnClickListener(new View.OnClickListener() {
            TextView cheesy_potato_name;
            @Override
            public void onClick(View v) {


                /*String Strrec = cheesy_potato_name.getText().toString();
                DBHelper mydb = null;
                String recipename;
                Cursor cursor = mydb.getData(Strrec);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        recipename = cursor.getString(cursor.getColumnIndex(DBHelper.REC_NAME_COL));
                    }

                cursor.close();
                }
*/
                Intent american = new Intent(Look_for_recipes.this, America_cat.class);
                startActivity(american);

            }
        });

        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indian = new Intent(Look_for_recipes.this, India_cat.class);
                startActivity(indian);

            }
        });

        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent italian = new Intent(Look_for_recipes.this, Italy_cat.class);
                startActivity(italian);

            }
        });

        mexican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mexican = new Intent(Look_for_recipes.this, Mexico_cat.class);
                startActivity(mexican);

            }
        });
    }

}
