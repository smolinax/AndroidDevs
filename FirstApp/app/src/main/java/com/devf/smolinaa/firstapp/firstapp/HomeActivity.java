package com.devf.smolinaa.firstapp.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends AppCompatActivity {


    /*
    * Este metodo provee un intent para lanzar (@link HomeActivity)
    *
    * @param from Contexto desde donde se va a lanzar (o desde donde viene) (@link HomeActivity)
     *
     * @param params Arreglo de Strings, cual debera contenet el username y el password
     *
     * String... params  esto automaticamente crea un arreglo
     */

    @InjectView(R.id.txtvUserName)
    TextView txtvUserName;

    @InjectView(R.id.txtvPassword)
    TextView txtvPassword;


    public static Intent provideIntent(Context from, String... params){
        Intent homeIntent = new Intent(from, HomeActivity.class);
        if(params.length < 2 )
            throw new IllegalArgumentException("Los parametros deben ser dos: User Name and Password");
        homeIntent.putExtra(Constant.EXTRA_USERNAME, params[0]);
        homeIntent.putExtra(Constant.EXTRA_PASSWORD, params[1]);

        return homeIntent;
    }

    private String obtainUserNameFromExtras(){
        return getIntent().getStringExtra("username");
    }
    private String obtainPasswordFromExtras(){
        return getIntent().getStringExtra("password");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.inject(this);

        this.txtvUserName.setText(obtainUserNameFromExtras());
        this.txtvPassword.setText(obtainPasswordFromExtras());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
