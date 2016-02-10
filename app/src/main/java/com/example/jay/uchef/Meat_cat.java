package in.ladvas.uchef;

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
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import in.ladvas.uchef.R;

import java.util.ArrayList;

/**
 * Created by JAY on 9/4/2015.
 */
public class Meat_cat extends Categories {

    DBHelper mydb;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        mydb = new DBHelper(this);
        ListView lv;
        TextView tx;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat_cat);

        //GridView gridview = (GridView) findViewById(R.id.gridview);
        //gridview.setAdapter(new ImageAdapter(this));
        lv = (ListView) findViewById(R.id.listviewM);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        tx = (TextView) findViewById(R.id.veg_id);
        Typeface face_veg = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        //tx.setTypeface(face);



        //Generate list View from ArrayList
        displayListView();

        // checkButtonClick();

    }

    private void displayListView() {
        Cursor Alling = mydb.gethotdogrec();
        String[] getingnames = new String[]{
                DBHelper.REC_DESC_COL
        };
        int[] getingid = new int[]{R.id.veg_id};

        //create an ArrayAdaptar from the String Array
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
                this, R.layout.veg_ing_chkbx_activity, Alling, getingnames, getingid);
        ListView listView = (ListView) findViewById(R.id.listviewM);
        listView.setAdapter(myCursorAdapter);
        // Assign adapter to ListView

    }



   /* private void checkButtonClick()
    {

        ImageButton myButton = (ImageButton) findViewById(R.id.findSelected);

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("You have selected\n");

                ArrayList<Cusines_methods> stateList = dataAdapter.ingredientsList;

                for (int i = 0; i < stateList.size(); i++) {
                    Cusines_methods state = stateList.get(i);

                    if (state.isSelected()) {
                        responseText.append("\n" + state.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_SHORT).show();
            }
        });
    } */
}
