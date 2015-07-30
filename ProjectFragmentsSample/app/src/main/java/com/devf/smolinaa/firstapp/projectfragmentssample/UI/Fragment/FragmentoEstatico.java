package com.devf.smolinaa.firstapp.projectfragmentssample.UI.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devf.smolinaa.firstapp.projectfragmentssample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Salvador on 30/06/2015.
 */
public class FragmentoEstatico extends Fragment{

    /**
     * Created by Salvador on 25/06/2015.
     @Nullable
     @Override
     */
    Pockemon pockemonres;

    onFragmentInteractionListener onfragmentinteractionlistener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // sele pone root porque es la vista raiz

        //R.tipo de recurso (Layout) id del contenedor
        // false para que no se conecte a la gerarquia de la actividad
        //Viewgroup significa (FrameLayout, LinearLayout, RelativeLayout, etc) en el static fragment es el archivo xml
        // en el dynamic es el id del ViewGroup declarado en el activity_main.xml

        View roote = inflater.inflate(R.layout.fragmentoestatico, container, false);

        ButterKnife.inject(this, roote);

        return roote;

}

    //Override e Inyecion de vistas con ButterKnifeas
    @OnClick({R.id.Pockemon1, R.id.Pockemon2, R.id.Pockemon3})
    public void OwnClick(View view) {
        switch (view.getId()) {
            case R.id.pockemon1:
                pockemonres = new Pockemon("Pikachu");
                //getActivity extiende de contexto
/*                Toast.makeText(getActivity(), pockemonres.nombre , Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), pockemonres.escudo.toString() , Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), pockemonres.espada.toString() , Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), pockemonres.rayo.toString() , Toast.LENGTH_LONG).show();*/
                break;
            case R.id.pockemon2:
                pockemonres = new Pockemon("Raichu");
                //Toast.makeText(getActivity(), "Hello from Pockemon2", Toast.LENGTH_LONG).show();
                break;
            case R.id.pockemon3:
                pockemonres = new Pockemon("MagicKarp");
                //Toast.makeText(getActivity(), "Hello from Pockemon3", Toast.LENGTH_LONG).show();
                break;
        }
    }


/*    public void onAttach(Activity a){
        fragmentinteractionlistener = (FragmentoDinamico.onFragmentInteractionListener) a;

    }*/

    public interface onFragmentInteractionListener{
        void onPokemonSelected(Pockemon pockemon);
    }

}
