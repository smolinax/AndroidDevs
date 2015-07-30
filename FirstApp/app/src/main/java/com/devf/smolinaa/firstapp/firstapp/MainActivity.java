package com.devf.smolinaa.firstapp.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/*
ActionBarActivity implements View.OnClickListener */
public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();
    public Button btnmain;
    public TextView txtvforgot;

    //ButterKinfe
    //P: porque se hace el InjectView de solo estos campos y no de todos los componentes de la vista
    @InjectView(R.id.editTextUserName)
    EditText editTextUserName;

    @InjectView(R.id.editTextPassword)
    EditText editTextPassword;

    //OofButterKnife

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //ButterKnife injectio

        ButterKnife.inject(this);

        //ButterKnife injectio

        /* definicion para la implementacion de botones, onclick en el XML
        btnmain = (Button) findViewById(R.id.btnmain);


 /* Implementacion del Listener con clase anonima
            getFragmentManager().findFragmentById(R.id.fdmaincontainer);
            txtvforgot.setOnClickListener(this);
            txtvforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello from txtvforgot", Toast.LENGTH_LONG).show();
            }
        });*/
    }
    //Override e Inyecion de vistas con ButterKnifeas
    @OnClick({R.id.btnmain, R.id.buttonLogin, R.id.txtvforgot})
    public void OwnClick(View view){
        switch (view.getId()){
            case R.id.txtvforgot:
                //Toast.makeText(MainActivity.this, "Hello from switch", Toast.LENGTH_LONG).show();
                launchAction();
                break;
            case R.id.buttonLogin:
                camposLlenos();
                break;
            case R.id.btnmain:
                launchActivity(ActivityRegister.class);
                break;
        }
        //Intents
/*        if(view.getId() == R.id.btnmain) {
            Intent intent = new Intent(this, activity_register.class);
            startActivity(intent);
        }*/
    }

    //Usada para mandar a ejecutar diferentes aplicaciones de Android
    private void launchAction(){

        Uri uri = Uri.parse("http://developer.android.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    private void camposLlenos(){
        if(!TextUtils.isEmpty(editTextUserName.getText()) && !TextUtils.isEmpty(editTextPassword.getText())){
            launchHomeActivity();
        } else {
            Toast.makeText(MainActivity.this, "Miss username or password", Toast.LENGTH_LONG).show();
        }
    }

    private void launchHomeActivity() {
        try {
            Intent homeActivity = HomeActivity.provideIntent(this, this.editTextUserName.getText().toString(),
                     this.editTextPassword.getText().toString());
            startActivity(homeActivity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void launchActivity(Class MyClass){
        Intent intent = new Intent(MainActivity.this, MyClass);
        startActivity(intent);
    }

/*    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.txtvforgot)
            Toast.makeText(MainActivity.this, "Hello from txtvforgot implements", Toast.LENGTH_LONG).show();
    }*/

    // version para definir la accion del botton, via XML ()
  /*  public void clickBtnmain(View view){
        Toast.makeText(this, "Hello from btnmain ?", Toast.LENGTH_LONG).show();
    }*/

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
