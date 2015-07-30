package examples.f.dev.myconcept;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment1 extends Fragment {

    private static final String ARG_TITLE = "TITLE";

    @Bind(R.id.textViewFragment1)
    TextView textViewFragmentUno;

    //Constructor publico y estatico para cuando se instancie el fragmento
    public static MyFragment1 newInstance(String title){
        MyFragment1 myFragment1 = new MyFragment1();
        //A mapping from String values to various Parcelable types.
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        return myFragment1;

    }


    public MyFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflado del layout con la vista
        View viewRoot = inflater.inflate(R.layout.my_fragment1, container, false);

        //Se hace el bind hasta que se tiene la vista inflada
        ButterKnife.bind(this,viewRoot);

        //Paso del argumento definido como variable estatica en el fragmento
        //Uso de la instancia definida despues del bind en el Fragment
        textViewFragmentUno.setText(getArguments().getString(ARG_TITLE));
        //textViewFragmentUno.setText("Just testing F1");

        // Inflate the layout for this fragment
        return viewRoot;
    }


}
