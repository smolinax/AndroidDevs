package com.devf.smolinaa.firstapp.projectfragmentssample.UI.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devf.smolinaa.firstapp.projectfragmentssample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements FragmentoEstatico.onFragmentInteractionListener {
//
    public static final String LOG_TAG = MainActivity.class.getName();

    FragmentoDinamico fragmentodinamico;

    /**
    * Regresa una nueva instacia de la clase (@link MainFragment)
     *
    * @param  color para el background del
    *
     */

/*    public static MainFragment getInstance(ColorDrawable background){
        //Simepre al construir un fragment se llama al constructor
        MainFragment fragment = new MainFragment();

        Bundle args = new Bundle;
        args.putInt("color", background.getColor());

        fragment.setArguments();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "On Create Main Activity");
        setContentView(R.layout.activity_main);

        fragmentodinamico
        //BEGINTRANSACTION regresa un tipo fragmenttransaction
        //que agrega el fragmento dinamico apuntado por su contenedor dfcontainer
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.dfcontainer, new FragmentoDinamico()).commit();
    }

    @Override
    public void onPokemonselected(Pockemon pockemon) {



    }
/*    @Override
    public void onInteraction(Pockemon pockemon) {
        Fragment fd = getFragmentManager().findFragmentById(R.id.fdmaincontainer);
        View view = findViewById(R.id.dfcontainer);
        TextView txtname = (TextView) view.findViewById(R.id.nombre);
        TextView iespada = (TextView) view.findViewById(R.id.espada);
        TextView iescudo = (TextView) view.findViewById(R.id.escudo);
        TextView irayo = (TextView) view.findViewById(R.id.rayo);
        ImageView imagensrc = (ImageView) view.findViewById(R.id.Cara);
        txtname.setText(pockemon.nombre);
        iespada.setText(pockemon.espada);
        iescudo.setText(pockemon.escudo);
        irayo.setText(pockemon.rayo);
        imagensrc.setImageDrawable(pockemon.src);
    }*/


/*        private void setupMainFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.dinamicfragment, MainFragment.getInstance(new color))
                .commit();
    }*/


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
