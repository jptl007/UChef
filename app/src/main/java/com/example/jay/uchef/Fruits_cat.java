package com.example.jay.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JAY on 9/4/2015.
 */
public class Fruits_cat extends Categories {
    DBHelper mydb;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        mydb = new DBHelper(this);
        ListView lv;
        TextView tx;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruits_cat);

        //GridView gridview = (GridView) findViewById(R.id.gridview);
        //gridview.setAdapter(new ImageAdapter(this));
        lv = (ListView) findViewById(R.id.listView_fruit);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        tx = (TextView) findViewById(R.id.veg_id);
        Typeface face_veg = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        //tx.setTypeface(face);



        //Generate list View from ArrayList
        displayListView();

        // checkButtonClick();

    }


    private void displayListView() {
        Cursor Alling = mydb.getfruitsIng();
        String[] getingnames = new String[]{
                DBHelper.ING_NAME_COL
        };
        int[] getingid = new int[]{R.id.veg_id};

        //create an ArrayAdaptar from the String Array
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
                this, R.layout.veg_ing_chkbx_activity, Alling, getingnames, getingid);
        ListView listView = (ListView) findViewById(R.id.listView_fruit);
        listView.setAdapter(myCursorAdapter);
        // Assign adapter to ListView

    }

}