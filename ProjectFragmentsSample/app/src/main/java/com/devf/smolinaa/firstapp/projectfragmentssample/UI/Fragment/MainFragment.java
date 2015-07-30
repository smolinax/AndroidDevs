package com.devf.smolinaa.firstapp.projectfragmentssample.UI.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.devf.smolinaa.firstapp.projectfragmentssample.R;

/**
 * Created by Salvador on 25/06/2015.
 */
public class MainFragment extends Fragment {

    public static final String LOG_TAG = MainActivity.class.getName();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //log.i.(LOG_TAG, "on Create()");

    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        Log.i(LOG_TAG, "On Attach");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(LOG_TAG, "On ViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "On Start");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "On Resume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "On Stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(LOG_TAG, "On DestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "On Destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(LOG_TAG, "On Detach");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "On Pause");
    }
}
