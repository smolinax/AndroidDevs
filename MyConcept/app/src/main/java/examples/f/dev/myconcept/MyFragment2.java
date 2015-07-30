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
public class MyFragment2 extends Fragment {


    private static final String ARG_TITLE_F2 = "Title Fragment 2";

    @Bind(R.id.textViewFragment2)
    TextView textViewFragmentDos;

    //Constructor publico y estatico para cuando se instancie el fragmento
    public static MyFragment2 newInstance(String title){
        MyFragment2 myFragment2 = new MyFragment2();
        //A mapping from String values to various Parcelable types.
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE_F2, title);

        return myFragment2;

    }


    public MyFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflado del layout con la vista
        View viewRoot = inflater.inflate(R.layout.my_fragment2, container, false);

        //Se hace el bind hasta que se tiene la vista inflada
        ButterKnife.bind(this, viewRoot);

        //Paso del argumento definido como variable estatica en el fragmento
        //Uso de la instancia definida despues del bind en el Fragment
        textViewFragmentDos.setText(getArguments().getString(ARG_TITLE_F2));

        // Inflate the layout for this fragment
        return viewRoot;
    }


}
