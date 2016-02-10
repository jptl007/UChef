package com.example.jay.myapplication;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by JAY on 10/7/2015.
 */
public class India_cat extends Look_for_recipes {
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mydb = new DBHelper(this);
        ListView lv;
        TextView tx;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.indian_cat);

        lv = (ListView) findViewById(R.id.curry_desc);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        tx = (TextView) findViewById(R.id.text_id);
        Typeface face_veg = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");

        displayListView();


    }
    private void displayListView() {
        Cursor Alling = mydb.getcurryrec();
        String[] getingnames = new String[]{
                DBHelper.REC_DESC_COL
        };
        int[] getingid = new int[]{R.id.text_id};

        //create an ArrayAdaptar from the String Array
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
                this, R.layout.veg_ing_chkbx_activity, Alling, getingnames, getingid);
        ListView listView = (ListView) findViewById(R.id.curry_desc);
        listView.setAdapter(myCursorAdapter);
        // Assign adapter to ListView

    }
}
