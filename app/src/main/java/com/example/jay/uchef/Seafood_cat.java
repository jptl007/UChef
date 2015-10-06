package com.example.jay.uchef;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JAY on 10/6/2015.
 */
public class Seafood_cat extends Categories {
    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        ListView lv;
        TextView tx;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seafood_cat_activity);
        lv = (ListView) findViewById(R.id.listView1);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        tx = (TextView) findViewById(R.id.seafood_id);
        Typeface face_veg = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        //tx.setTypeface(face);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView()
    {

        //Array list of countries
        ArrayList<Cusines_methods> stateList = new ArrayList<Cusines_methods>();

        Cusines_methods _states = new Cusines_methods("Fish",false);
        stateList.add(_states);
        _states = new Cusines_methods("Chicken",false);
        stateList.add(_states);
        _states = new Cusines_methods("Beef",false);
        stateList.add(_states);
        _states = new Cusines_methods("Pork",false);
        stateList.add(_states);
        _states = new Cusines_methods("Goat",false);
        stateList.add(_states);
        _states = new Cusines_methods("Lettuce",false);
        stateList.add(_states);
        _states = new Cusines_methods("Olives",false);
        stateList.add(_states);
        _states = new Cusines_methods("Cauliflower",false);
        stateList.add(_states);
        _states = new Cusines_methods("Zucchini",false);
        stateList.add(_states);
        _states = new Cusines_methods("Capsicum",false);
        stateList.add(_states);
        _states = new Cusines_methods("Carrots",false);
        stateList.add(_states);
        _states = new Cusines_methods("Spinach",false);
        stateList.add(_states);


        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,R.layout.veg_ing_chkbx_activity, stateList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // When clicked, show a toast with the TextView text
                Cusines_methods state = (Cusines_methods) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Clicked on Row: " + state.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<Cusines_methods>
    {

        private ArrayList<Cusines_methods> ingredientsList;

        public MyCustomAdapter(Context context, int textViewResourceId,

                               ArrayList<Cusines_methods> stateList)
        {
            super(context, textViewResourceId, stateList);
            this.ingredientsList = new ArrayList<Cusines_methods>();
            this.ingredientsList.addAll(stateList);
        }

        private class ViewHolder
        {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

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

                holder.name.setOnClickListener( new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        CheckBox cb = (CheckBox) v;
                        Cusines_methods _state = (Cusines_methods) cb.getTag();

                        Toast.makeText(getApplicationContext(), "Selected Item: " + cb.getText(),
                                Toast.LENGTH_SHORT).show();

                        _state.setSelected(cb.isChecked());
                    }
                });


            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            Cusines_methods state = ingredientsList.get(position);

            //holder.code.setText(" " + state.getCode() + " ");
            holder.name.setText(state.getName());
            holder.name.setChecked(state.isSelected());

            holder.name.setTag(state);

            return convertView;
        }

    }

    private void checkButtonClick()
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
    }
}
