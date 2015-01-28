package co.mobilemakers.sandwichrestaurant;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class StartActivity extends ActionBarActivity {
    Button mButtonGoToOrder;
    EditText mEditOrderCount;
    int sandwichCount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        prepareButton();
        mEditOrderCount= (EditText) findViewById(R.id.edit_sandwich_count);
        mEditOrderCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(mEditOrderCount.getText())){
                    mButtonGoToOrder.setEnabled(true);
                    sandwichCount=Integer.parseInt(mEditOrderCount.getText().toString());
                }else{
                    mButtonGoToOrder.setEnabled(false);
                }


            }
        });

    }

    private void prepareButton() {
        mButtonGoToOrder=(Button) findViewById(R.id.button_goto_selection);
        mButtonGoToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((0<sandwichCount)&&(sandwichCount<6)){
                    Intent intent=new Intent(StartActivity.this,MainActivity.class);
                    intent.putExtra("count",sandwichCount);
                    ArrayList<Sandwich> array= new ArrayList<Sandwich>();
                    intent.putParcelableArrayListExtra("orders",array);
                    startActivity(intent);
                }else{
                    Toast.makeText(StartActivity.this,"Enter a number from 1 to 5",Toast.LENGTH_SHORT);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
