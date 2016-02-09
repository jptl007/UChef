package com.example.jay.myapplication;

import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JAY on 9/4/2015.
 */
public class Fruits_cat extends Categories {

    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        ListView lv;
        TextView tx;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruits_cat);

        lv = (ListView) findViewById(R.id.listView1);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        tx = (TextView) findViewById(R.id.fruits_id);
        Typeface face_veg = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");

        displayListView();
        checkButtonClick();
    }

    private void displayListView()
    {


        ArrayList<Cusines_methods> ingredientsList = new ArrayList<Cusines_methods>();

        Cusines_methods _ingredients = new Cusines_methods("Apple",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Banana",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Mango",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Strawberry",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Blueberry",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Passion Fruit",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Custard Apple",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Pineapple",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Cherry",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Grapes",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Watermelon",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Orange",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Kiwi",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Pomegranate",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Papaya",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Plum",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Pear",false);
        ingredientsList.add(_ingredients);
        _ingredients = new Cusines_methods("Sapota",false);
        ingredientsList.add(_ingredients);

        dataAdapter = new MyCustomAdapter(this,R.layout.veg_ing_chkbx_activity, ingredientsList);
        ListView listView = (ListView) findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // When clicked, show a toast with the TextView text
                Cusines_methods ingredients = (Cusines_methods) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Clicked on Row: " + ingredients.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<Cusines_methods>
    {
        private ArrayList<Cusines_methods> ingredientsList;

        public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<Cusines_methods> ingredientsList)
        {
            super(context, textViewResourceId, ingredientsList);
            this.ingredientsList = new ArrayList<Cusines_methods>();
            this.ingredientsList.addAll(ingredientsList);
        }

        private class ViewHolder
        {
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
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);
                holder.name.setOnClickListener( new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        CheckBox cb = (CheckBox) v;
                        Cusines_methods _ingredients = (Cusines_methods) cb.getTag();
                        _ingredients.setSelected(cb.isChecked());
                    }
                });
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            Cusines_methods ingredients = ingredientsList.get(position);
            holder.name.setText(ingredients.getName());
            holder.name.setChecked(ingredients.isSelected());
            holder.name.setTag(ingredients);
            return convertView;
        }
    }

    private void checkButtonClick()
    {

        Button myButton = (Button) findViewById(R.id.find_recipe_btn);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("You have selected\n");

                ArrayList<Cusines_methods> ingredientsList = dataAdapter.ingredientsList;

                for (int i = 0; i < ingredientsList.size(); i++) {
                    Cusines_methods ingedients = ingredientsList.get(i);

                    if (ingedients.isSelected()) {
                        responseText.append("\n" + ingedients.getName());
                    }
                }
                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
