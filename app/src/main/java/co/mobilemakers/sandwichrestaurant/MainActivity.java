package co.mobilemakers.sandwichrestaurant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    Button mButtonPlaceOrder;
    CheckBox mCheckBoxTomato;
    CheckBox mCheckBoxPickles;
    CheckBox mCheckBoxExtraCheese;
    CheckBox mCheckBoxBacon;
    CheckBox mCheckBoxLettuce;
    CheckBox mCheckBoxEgg;
    CheckBox mCheckBoxOlives;
    CheckBox mCheckBoxOnion;
    RadioButton mRadioButtonWhite;
    RadioButton mRadioButtonWheat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonPlaceOrder= (Button) findViewById(R.id.button_place_order);
        View.OnClickListener buttonPlaceOrderListener=(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,OrderView.class);
                prepareRadioButtons();
                intent.putExtra("bread",getBread());
                intent.putExtra("topping",getToppingOptions());
                startActivity(intent);
            }
        });
        prepareCheckBoxs();
        mButtonPlaceOrder.setOnClickListener(buttonPlaceOrderListener);


    }

    private String getToppingOptions(){
        String toppingOptions="";
        if (mCheckBoxTomato.isChecked()) toppingOptions+="Tomato,";
        if (mCheckBoxPickles.isChecked()) toppingOptions+="Pickles,";
        if (mCheckBoxExtraCheese.isChecked()) toppingOptions+="Extra Cheese,";
        if (mCheckBoxBacon.isChecked()) toppingOptions+="Bacon,";
        if (mCheckBoxLettuce.isChecked()) toppingOptions+="Lettuce,";
        if (mCheckBoxEgg.isChecked()) toppingOptions+="Egg,";
        if (mCheckBoxOlives.isChecked()) toppingOptions+="Olives,";
        if (mCheckBoxOnion.isChecked()) toppingOptions+="Onion.";
        if (toppingOptions.equals("")) toppingOptions="You didn't pick any topping options";
        return toppingOptions;
    }

    private String getBread() {
        String breadChoice;
        if (mRadioButtonWhite.isChecked()){
            breadChoice="White";
        }else{
            if (mRadioButtonWheat.isChecked()){
                breadChoice="Wheat";
            }else{
                breadChoice="Rye";
            }
        }
        return breadChoice;
    }

    private void prepareRadioButtons() {
        mRadioButtonWhite=(RadioButton) findViewById(R.id.radio_button_white);
        mRadioButtonWheat=(RadioButton) findViewById(R.id.radio_button_wheat);
    }

    private void prepareCheckBoxs() {
        mCheckBoxTomato=(CheckBox) findViewById(R.id.checkbox_tomato);
        mCheckBoxPickles=(CheckBox)findViewById(R.id.checkbox_pickles);
        mCheckBoxExtraCheese=(CheckBox)findViewById(R.id.checkbox_extra_cheese);
        mCheckBoxBacon=(CheckBox) findViewById(R.id.checkbox_bacon);
        mCheckBoxLettuce=(CheckBox) findViewById(R.id.checkbox_lettuce);
        mCheckBoxEgg=(CheckBox) findViewById(R.id.checkbox_egg);
        mCheckBoxOlives=(CheckBox) findViewById(R.id.checkbox_olives);
        mCheckBoxOnion=(CheckBox) findViewById(R.id.checkbox_onion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
