package com.devf.smolinaa.firstapp.toolbarexampledevf;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

/*        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

    private void replaceToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        //Habilitar el icono de hamburgesa en la esquina sup izq
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Habilitar el icono que seleccionemos para la ezquina sup. izq
        actionBar.setHomeAsUpIndicator(R.drawable.draft);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    private void setupNavigationView(){
       // NavigationVie.(new NavigationView.OnNavigationItemSelectedListener);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // este es el escuchador del actionbar
        int id = item.getItemId();

        //Obtiene la instancia del drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        //
        if (id == android.R.id.home) {
            Toast.makeText(this,"Navigation Drawer", Toast.LENGTH_LONG).show();
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Setting 1", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_settings2) {
            Toast.makeText(this,"Setting 2", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_settings3) {
            Toast.makeText(this,"Setting 3", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_settings4) {
            Toast.makeText(this,"Setting 4", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
