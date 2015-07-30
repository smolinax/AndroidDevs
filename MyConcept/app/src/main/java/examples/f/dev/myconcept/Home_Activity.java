package examples.f.dev.myconcept;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class Home_Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.drawerlayout)
    DrawerLayout drawerLayout;

    @Bind(R.id.navigationView)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Como ya son layouts en el activity_home.xml o incluidos, por eso se instancian
        ButterKnife.bind(this);

        //Set a Toolbar to act as the ActionBar for this Activity window.
        replaceToolbar();

        //Set Listener and behavior the NavigationView "inyectada"
        setupNavigationView();
    }

    private void setupNavigationView() {
        //Metodo anonimo que implementa el Listener y la decision de cual opcion fue selecionada
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.drafragment1:
                        replaceFragment(MyFragment1.newInstance(menuItem.getTitle().toString()));
                        break;
                    case R.id.drafragment2:
                        replaceFragment(MyFragment2.newInstance(menuItem.getTitle().toString()));
                        break;
                    case R.id.draList:
                        replaceFragment(MyFragment1.newInstance(menuItem.getTitle().toString()));
                        break;
                    case R.id.dratab:
                        replaceFragment(MyFragment2.newInstance(menuItem.getTitle().toString()));
                        break;
                }

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }


    //Funcion para hacer la transacion de reemplazar el fragmento y hacer el commit
    private void replaceFragment(MyFragment1 newFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, newFragment)
                .commit();
    }

    private void replaceFragment(MyFragment2 newFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, newFragment)
                .commit();
    }

    private void replaceToolbar() {

        //Set a Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(toolbar);

        //Set the primary ActionBar iquals to the previous set of toolbar
        ActionBar actionBar = getSupportActionBar();


        if (actionBar != null) {
            //Show actionbar
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setHomeAsUpIndicator(R.drawable.ic_headline_white);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        if (id == R.id.action_fragment1) {
            Toast.makeText(getApplicationContext(),"Fragment1", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
