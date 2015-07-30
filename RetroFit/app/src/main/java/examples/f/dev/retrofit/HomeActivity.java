package examples.f.dev.retrofit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import examples.f.dev.retrofit.domain.Track;
import examples.f.dev.retrofit.io.LastFMApiClient;
import examples.f.dev.retrofit.io.model.TopTracksResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HomeActivity extends AppCompatActivity implements Callback<TopTracksResponse> {

    public static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LastFMApiClient.getInstance()
                .getTopsTracks(BuildConfig.LAST_FM_API_KEY, this);

    }

    @Override
    public void success(TopTracksResponse topTracksResponse, Response response) {
        ArrayList<Track> topTracks = topTracksResponse.getTrackData().getTracks();

        for (Track track : topTracks){
            Log.i(LOG_TAG, track.toString());
        }
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
