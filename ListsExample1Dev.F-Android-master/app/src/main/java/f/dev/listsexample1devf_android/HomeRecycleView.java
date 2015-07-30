package f.dev.listsexample1devf_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeRecycleView extends AppCompatActivity {


    @Bind(R.id.recycleView)
    RecyclerView recycleView;

    //private static final String[] desAlumnos = {"Fernanda", "Salvador", "Emilio", "Angel", "Gerrardo", "Sebastian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_viw_home);

        ButterKnife.bind(this);

        setupRecycleView();
    }

    private void setupRecycleView() {
        //porque  LinearLayoutManager sea vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        MyAdapterRecycleView myAdapterRecycleView = new MyAdapterRecycleView(this, createGuests());
        recycleView.setAdapter(myAdapterRecycleView);

        myAdapterRecycleView.setOnItemclickListener(new MyAdapterRecycleView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(HomeRecycleView.this, "posicion: " + position, Toast.LENGTH_SHORT).show();
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
