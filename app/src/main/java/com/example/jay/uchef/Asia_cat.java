package com.example.jay.myapplication;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JAY on 10/7/2015.
 */
public class Asia_cat extends Look_for_recipes {
    DBHelper mydb;
    String rec;
    String recipe;
    @Override
    public void onCreate (Bundle savedInstanceState){

        mydb = new DBHelper(this);
        ListView lv;
        TextView tx;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asian_cat);

        lv = (ListView) findViewById(R.id.dimsum_desc);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
        tx = (TextView) findViewById(R.id.text_id);
        Typeface face_veg = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");

        displayListView();
                /*mydb.insert_cat(1, "Vegetables");
                mydb.insert_cat(2, "Fruits");
                mydb.insert_cat(3, "Dairy");
                mydb.insert_cat(4, "Meat");
                mydb.insert_cat(5, "Seafood");

                mydb.insert_cat(6,"Bakery"); */
        // mydb.insert_ing(1, "Potato", 1);
        //mydb.insert_ing(2, "Tomato", 1);
              /*  mydb.insert_ing(3,"Cabbage", 1);
                mydb.insert_ing(4,"Mushroom", 1);
                mydb.insert_ing(5,"Onion", 1);
                mydb.insert_ing(6,"Lettuce", 1);
                mydb.insert_ing(7,"Olives", 1);
                mydb.insert_ing(8,"Cauliflower", 1);
                mydb.insert_ing(9,"Zucchini", 1);
                mydb.insert_ing(10,"Capsicum", 1);
                mydb.insert_ing(11,"Carrots", 1);
                mydb.insert_ing(12,"Spinach", 1);
                mydb.insert_ing(13,"Apple", 2);
                mydb.insert_ing(14,"Banana", 2);
                mydb.insert_ing(15,"Mango", 2);
                mydb.insert_ing(16,"Strawberry", 2);
                mydb.insert_ing(17,"Blueberry", 2);
                mydb.insert_ing(18,"Passion Fruit", 2);
                mydb.insert_ing(19,"Custard Apple", 2);
                mydb.insert_ing(20,"Pineapple", 2);
                mydb.insert_ing(21,"Cherry", 2);
                mydb.insert_ing(22,"Grapes", 2);
                mydb.insert_ing(23,"Watermelon", 2);
                mydb.insert_ing(24,"Orange", 2);
                mydb.insert_ing(25,"Kiwi", 2);
                mydb.insert_ing(26,"Pomegranate", 2);
                mydb.insert_ing(27,"Papaya", 2);
                mydb.insert_ing(28,"Plum", 2);
                mydb.insert_ing(29, "Sapota", 2);
                mydb.insert_ing(30, "Milk", 3);
                mydb.insert_ing(31, "Cheese", 3);
                mydb.insert_ing(32, "Yogurt", 3);
                mydb.insert_ing(33, "Butter", 3);
                mydb.insert_ing(34, "Goat Cheese", 3);
                mydb.insert_ing(35, "Cream", 3);
                mydb.insert_ing(36, "Margarine", 3);
                mydb.insert_ing(37, "Ice Cream", 3);
                mydb.insert_ing(38, "Chicken", 4);
                mydb.insert_ing(39, "Beef", 4);
                mydb.insert_ing(40, "Pork", 4);
                mydb.insert_ing(41, "Lamb", 4);
                mydb.insert_ing(42, "Mutton", 4);
                mydb.insert_ing(43, "Bacon", 4);
                mydb.insert_ing(44, "Crabs", 5);
                mydb.insert_ing(45, "Salmon", 5);
                mydb.insert_ing(46, "Shrimp", 5);
                mydb.insert_ing(47, "Prawns", 5);
                mydb.insert_ing(48, "Lobsters", 5);
                mydb.insert_ing(49, "Oysters", 5);
                mydb.insert_ing(50, "Skate", 5);
                mydb.insert_ing(51, "Baking Soda", 6);
                mydb.insert_ing(52, "Yeast", 6);
                mydb.insert_ing(53, "Honey", 6);
                mydb.insert_ing(54, "Choco Powder", 6);
                mydb.insert_ing(55, "Icing Sugar", 6);*/

                /*mydb.insert_recipe(1,"DIM SIM", "STEP-1: Place the mince, chilli, garlic, ginger, coriander and fish sauce in a bowl. Mix until well combined. Lay the wonton wrappers out in a single layer on a clean surface. Spoon teaspoonfuls of the mixture into the centre of each wonton. Brush the edges of one wonton and bring the edges up to tightly enclose the filling. Press to seal.\n" +
                        "STEP-2: Line a large steamer basket with non-stick baking paper. Arrange the wontons over the base of the basket in a single layer. Place the basket over a wok of barely simmer water (making sure the water doesn't touch the base). Cover and steam for 8-10 minutes or until cooked. Transfer to a serving plate and cover loosely with foil to keep warm. Repeat with remaining dim sims.\n" +
                        "STEP-3: Meanwhile, to make the dipping sauce, combine the sweet chilli sauce, lime juice and fish sauce in a small bowl.\n");

               /*Cursor hotdogrec = mydb.gethotdogrec();
                hotdogrec.moveToFirst();
                while (!hotdogrec.isAfterLast()){
                    String Name = hotdogrec.getString(1);
                    Log.i("Rec Desc", Name);
                    hotdogrec.moveToNext();
                }*/

                /*Cursor veging = mydb.getvegIng();
                //ArrayList<String> Alling = mydb.getAllCatNames();
              // for (String name : Alling){
                  // Log.i("Veg_ing", name);
               veging.moveToFirst();
                while (!veging.isAfterLast()){
                   String Name = veging.getString(1);
                    Log.i("Ing_name", Name);
                    veging.moveToNext();
                }
*/
                Cursor fruitsing = mydb.getdimsimrec();
                fruitsing.moveToFirst();
                while (!fruitsing.isAfterLast()){
                    String Name = fruitsing.getString(2);
                    Log.i("Ing_name", Name);
                    fruitsing.moveToNext();
                }


/*
                Cursor meating = mydb.getmeatIng();
                dairying.moveToFirst();
                while (!meating.isAfterLast()){
                    String Name = meating.getString(1);
                    Log.i("Ing_name", Name);
                    meating.moveToNext();
                }

                Cursor seaing = mydb.getseafoodIng();
                seaing.moveToFirst();
                while (!seaing.isAfterLast()){
                    String Name = seaing.getString(1);
                    Log.i("Ing_name", Name);
                    seaing.moveToNext();
                }

                Cursor bakerying = mydb.getbakeryIng();
                bakerying.moveToFirst();
                while (!bakerying.isAfterLast()){
                    String Name = bakerying.getString(1);
                    Log.i("Ing_name", Name);
                    bakerying.moveToNext();
                }
                /*Cursor Allcat = mydb.getIng();

                Allcat.moveToFirst();

                while (!Allcat.isAfterLast()) {

                    String Name = Allcat.getString(1);
                    Log.i("Catname", Name);

                    //int number = Allcat.getInt(2);

                    Allcat.moveToNext();

                }*/


           /* Cursor catnames = mydb.getAllCatNames(catname);
            if (catnames != null){
                if(catnames.moveToFirst()){
                    rec = catnames.getString(catnames.getColumnIndex(DBHelper.CAT_ID_COL));
                    Toast.makeText(getApplicationContext(),"hello" + catname)
                }
            }

*/
        //AsiaRecipe asiaRecipe = new AsiaRecipe();

        /**asian_recipe = (TextView) findViewById(R.id.dimsum);
         Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
         asian_recipe.setTypeface(face);

         textview_asian = (TextView) findViewById(R.id.textView);
         Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
         textview_asian.setTypeface(face2);

         textview1_asian = (TextView) findViewById(R.id.textView);
         Typeface face3 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
         textview1_asian.setTypeface(face3);

         textview2_asian = (TextView) findViewById(R.id.textView2);
         Typeface face4 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
         textview2_asian.setTypeface(face4);

         textview3_asian = (TextView) findViewById(R.id.textView);
         Typeface face5 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
         textview3_asian.setTypeface(face5);

         textview4_asian = (TextView) findViewById(R.id.textView);
         Typeface face6 = Typeface.createFromAsset(getAssets(), "fonts/Avalon.ttf");
         textview4_asian.setTypeface(face6);
         */

    }
    private void displayListView() {
        Cursor Alling = mydb.getdimsimrec();
        String[] getingnames = new String[]{
                DBHelper.REC_DESC_COL
        };
        int[] getingid = new int[]{R.id.text_id};

        //create an ArrayAdaptar from the String Array
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
                this, R.layout.veg_ing_chkbx_activity, Alling, getingnames, getingid);
        ListView listView = (ListView) findViewById(R.id.dimsum_desc);
        listView.setAdapter(myCursorAdapter);
        // Assign adapter to ListView

    }
}
