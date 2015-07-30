package com.devf.smolinaa.firstapp.toolbarexampledevf;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private static final String ARG_TITLE ="Title";

    public static void getInstance(String title) {
        // Required empty public constructor
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.my_fragment, container, false);
    }


}
