package f.dev.listsexample1devf_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    @Bind(R.id.listView)
    ListView listView;

    private static final String[] desAlumnos = {"Fernanda", "Salvador", "Emilio", "Angel", "Gerrardo", "Sebastian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setupListView();
    }

    private void setupListView() {


        MyAdapter myAdapter = new MyAdapter(this, 0, createGuests());

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(HomeActivity.this, desAlumnos[position], Toast.LENGTH_SHORT).show();

            }
        });
    }


    private static List<GuestModel> createGuests() {

        int[] nameGuests = {R.string.name_guest_1, R.string.name_guest_2, R.string.name_guest_3, R.string.name_guest_4};
        int[] imageGuets = {R.drawable.guest_1, R.drawable.guest_2, R.drawable.guest_3, R.drawable.guest_4};

        List<GuestModel> guestModels = new ArrayList<>();


        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < nameGuests.length; j++) {
                guestModels.add(new GuestModel(imageGuets[j], nameGuests[j]));
            }
        }


        return guestModels;
    }





}
