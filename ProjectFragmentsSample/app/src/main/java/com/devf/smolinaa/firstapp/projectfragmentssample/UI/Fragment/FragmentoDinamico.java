package com.devf.smolinaa.firstapp.projectfragmentssample.UI.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devf.smolinaa.firstapp.projectfragmentssample.R;

/**
 * Created by Salvador on 30/06/2015.
 */
public class FragmentoDinamico extends Fragment{

    //Pockemon[] pockemons;
    //

    @Nullable
    @Override
    //Inflater es una vista que es "inflada"
    //ViewGroup Linear, frame layout etc.
    // Bundle savedInstanceState para salvar la vista


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // sele pone root porque es la vista raiz
        View root = inflater.inflate(R.layout.fragmentdinamico, container, false);
        return root;
    }

    public void changeData(Pockemon pokemons){

    }

    /**
     ** Interfaz que tendra que implementar la clase que quiera escuchar
     **/

}
