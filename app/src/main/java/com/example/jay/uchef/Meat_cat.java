package in.ladvas.uchef;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
public class Meat_cat extends Categories{

    DBHelper mydb;
    CheckBox c;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        mydb = new DBHelper(this);
        ListView lv;
        TextView tx;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat_cat);
        //c = (CheckBox) findViewById(R.id.veg_id);
        CheckBox c = (CheckBox) findViewById(R.id.checkBox1);
        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox1", false);
        c.setChecked(checked);

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
        Cursor Alling = mydb.getvegIng();
        String[] getingnames = new String[]{
                DBHelper.ING_NAME_COL
        };
        int[] getingid = new int[]{R.id.veg_id};

        //create an ArrayAdaptar from the String Array
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
                this, R.layout.veg_ing_chkbx_activity, Alling, getingnames, getingid);
        ListView listView = (ListView) findViewById(R.id.listviewM);
        listView.setAdapter(myCursorAdapter);
        // Assign adapter to ListView

    }

    public class myCursorAdapter extends SimpleCursorAdapter {
        private Cursor c;
        private Context context;
        private Cursor Alling;
        private ArrayList<Boolean> itemChecked = new ArrayList<Boolean>();

// itemChecked will store the position of the checked items.

        public myCursorAdapter(Context context, int layout, Cursor c, String[] from,
                             int[] to) {
            super(context, layout, c, from, to);
            this.c = c;
            this.context = context;

            for (int i = 0; i < this.getCount(); i++) {
                itemChecked.add(i, false); // initializes all items value with false
            }

        }
        private class ViewHolder
        {

            CheckBox name;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            TextView code;
            //View view = convertView;
            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));
            if (convertView == null)
            {

                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.veg_ing_chkbx_activity, null);
                holder = new ViewHolder();
                //holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);
                CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
                holder.name.setOnClickListener( new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        CheckBox cb = (CheckBox) v.findViewById(R.id.checkBox1);
                        if (cb.isChecked()) {
                            SharedPreferences preferences = context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE);
                            preferences.edit().putBoolean("checked", true).commit();
                            itemChecked.set(position, true);
                            // do some operations here
                        } else if (!cb.isChecked()) {
                            itemChecked.set(position, false);
                            // do some operations here
                        }
                    }});
                holder.name.setChecked(itemChecked.get(position));
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            code = null;
            //holder.name.setText(convertView.get(position).toString());
            //holder.code.setText(" " + state.getCode() + " ");
            //holder.name.setText(convertView.getName());
            holder.name.setChecked(code.isSelected());

            holder.name.setTag(code);

            return code;
        }
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
