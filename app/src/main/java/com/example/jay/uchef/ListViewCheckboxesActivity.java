<<<<<<< HEAD
package in.ladvas.uchef;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnDragListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
=======
package com.example.jay.uchef;

import android.app.Activity;
import android.content.Context;
>>>>>>> origin/master
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

<<<<<<< HEAD

=======
/**
 * Created by JAY on 10/3/2015.
 */
>>>>>>> origin/master
public class ListViewCheckboxesActivity extends Activity {
    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
<<<<<<< HEAD
        TextView tx;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tx = (TextView) findViewById(R.id.findSelected);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/CURLZ.TTF");
        tx.setTypeface(face);
=======
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
>>>>>>> origin/master

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView()
    {

        //Array list of countries
        ArrayList<States> stateList = new ArrayList<States>();

        States _states = new States(" ","Potato",false);
        stateList.add(_states);
        _states = new States(" ","Tomato",false);
        stateList.add(_states);
        _states = new States("3","Cheese",false);
        stateList.add(_states);
        _states = new States("JK","Jammu & Kashmir",false);
        stateList.add(_states);
        _states = new States("KA","Karnataka",false);
        stateList.add(_states);
        _states = new States("KL","Kerala",false);
        stateList.add(_states);
        _states = new States("RJ","Rajasthan",false);
        stateList.add(_states);
        _states = new States("WB","West Bengal",false);
        stateList.add(_states);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,R.layout.state_info, stateList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // When clicked, show a toast with the TextView text
                States state = (States) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Clicked on Row: " + state.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<States>
    {

        private ArrayList<States> stateList;

        public MyCustomAdapter(Context context, int textViewResourceId,

                               ArrayList<States> stateList)
        {
            super(context, textViewResourceId, stateList);
            this.stateList = new ArrayList<States>();
            this.stateList.addAll(stateList);
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

                convertView = vi.inflate(R.layout.state_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);

                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        CheckBox cb = (CheckBox) v;
                        States _state = (States) cb.getTag();

                        Toast.makeText(getApplicationContext(), "Selected Item: " + cb.getText() + " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();

                        _state.setSelected(cb.isChecked());
                    }
                });

            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            States state = stateList.get(position);

            holder.code.setText(" " + state.getCode() + " ");
            holder.name.setText(state.getName());
            holder.name.setChecked(state.isSelected());

            holder.name.setTag(state);

            return convertView;
        }

    }

    private void checkButtonClick()
    {

<<<<<<< HEAD
        ImageButton myButton = (ImageButton) findViewById(R.id.findSelected);
=======
        Button myButton = (Button) findViewById(R.id.findSelected);
>>>>>>> origin/master

        myButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                StringBuffer responseText = new StringBuffer();
                responseText.append("You have selected...\n");

                ArrayList<States> stateList = dataAdapter.stateList;

                for(int i=0;i<stateList.size();i++)
                {
                    States state = stateList.get(i);

                    if(state.isSelected())
                    {
                        responseText.append("\n" + state.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();
            }
        });
    }
}