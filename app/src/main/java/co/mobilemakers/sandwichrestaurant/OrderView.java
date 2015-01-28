package co.mobilemakers.sandwichrestaurant;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class OrderView extends ActionBarActivity {
    ArrayList<Sandwich> mSandwiches;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view);
        TextView sandwichesText= (TextView) findViewById(R.id.text_sandwiches);
        Bundle mBundle=this.getIntent().getExtras();
        mSandwiches=mBundle.getParcelableArrayList("orders");
        int cant=1;
        String resultString="";
        for (Sandwich s:mSandwiches){
            resultString+=("Sandwich "+Integer.toString(cant)+": "+s.getBread()+"(bread). Extras:"+s.getToppingOptions())+"\n";
            cant++;
        }
        sandwichesText.setText(resultString);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order_view, menu);
        return true;
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
