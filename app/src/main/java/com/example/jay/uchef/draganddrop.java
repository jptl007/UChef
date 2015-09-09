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
import android.view.View.DragShadowBuilder;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class draganddrop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tx;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draganddrop);
        tx = (TextView) findViewById(R.id.vegetables);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/CURLZ.TTF");
        tx.setTypeface(face);
        findViewById(R.id.potato).setOnLongClickListener(longlisten);
        findViewById(R.id.tomato).setOnLongClickListener(longlisten);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draganddrop, menu);
        return true;
    }

    OnLongClickListener longlisten = new OnLongClickListener()
    {


        @Override
    public boolean onLongClick(View v)
        {

            DragShadow dragShadow = new DragShadow(v);
            ClipData data= ClipData.newPlainText("","");
            v.startDrag(data,dragShadow, v, 0);
            return false;
        }

    };

    private class DragShadow extends View.DragShadowBuilder
    {
        ColorDrawable greyBox;
        public DragShadow(View view)
        {
            super(view);
            greyBox = new ColorDrawable(Color.LTGRAY);
        }


        public void OnDragShadow(Canvas canvas)
        {
           greyBox.draw(canvas);
        }


        public void OnProvideShadowMatrics(Point shadowSize, Point shadowTouchPoint)
        {

            View v = getView();
            int height = (int)v.getHeight()/2;
            int width = (int)v.getWidth()/2;
            greyBox.setBounds(0,0,width,height);
            shadowSize.set(width, height);
            shadowTouchPoint.set((int)width,(int)height);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
