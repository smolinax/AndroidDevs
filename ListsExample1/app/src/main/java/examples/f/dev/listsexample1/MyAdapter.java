package examples.f.dev.listsexample1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Salvador on 06/07/2015.
 */
public class MyAdapter extends ArrayAdapter<String> {


    String[] desAlumnos;
    private LayoutInflater inflater;

    @Bind(R.id.myTextView)
    TextView myTextView;

    public MyAdapter(Context context, int resource, String[] objects){
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        desAlumnos = objects;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View viewItem = inflater.inflate(R.layout.item_list,parent, false);
        ButterKnife.bind(this, viewItem);

        myTextView.setText(desAlumnos[position]);
        myTextView.setTag(desAlumnos);

        return viewItem;
/*        myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int myPosition = (int) v.getTag();



            }
        });*/




    }

}
