package in.ladvas.uchef;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Categories extends Activity {
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ImageButton veg;
        ImageButton fruit;
        ImageButton dairy;
        ImageButton meat;
        ImageButton seafood;
        ImageButton herbs;
        ImageButton bakery;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);


        veg = (ImageButton) findViewById(R.id.vegetable);
        fruit = (ImageButton) findViewById(R.id.fruit);
        dairy = (ImageButton) findViewById(R.id.dairy);
        meat = (ImageButton) findViewById(R.id.meat);
        seafood = (ImageButton) findViewById(R.id.sea_food);
        herbs = (ImageButton) findViewById(R.id.herbs);
        bakery = (ImageButton) findViewById(R.id.bakery);

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veg = new Intent(Categories.this, Vegetable_cat.class);
                startActivity(veg);

            }
        });

        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fruit = new Intent(Categories.this, Fruits_cat.class);
                startActivity(fruit);

            }
        });

        dairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dairy = new Intent(Categories.this, Dairy_cat.class);
                startActivity(dairy);

            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meat = new Intent(Categories.this, Meat_cat.class);
                startActivity(meat);

            }
        });

        seafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meat = new Intent(Categories.this, Seafood_cat.class);
                startActivity(meat);

            }
        });
        herbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent herb = new Intent(Categories.this, Herbs_cat.class);
                startActivity(herb);

            }
        });
        bakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bak = new Intent(Categories.this, Bakery_cat.class);
                startActivity(bak);

            }
        });
    }


    @Override
        protected void onDestroy(){
        super.onDestroy();
    
           }
}