package examples.f.dev.thefirstclient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.ListIterator;

import examples.f.dev.thefirstclient.io.VolleySingleton;
import examples.f.dev.thefirstclient.track.Track;


public class HomeJsonDirect extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    public static final String LOG_TAG = "Esta es la Url";
    public static final String URL_TOP_TRACKS = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=123ae7ccee87798c55c82b64c792a083&format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // la forma inicial
        //La peticion
        JsonObjectRequest topTracks = new JsonObjectRequest (Request.Method.GET,
                URL_TOP_TRACKS, this, this);

        //añadir a la cola
        VolleySingleton.getInstance(this)
                .addToRequestQueue(topTracks);

    }


    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();

        try {
            parseTracksArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Toast.makeText(this,"Ocurrio un Error", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Track> parseTracksArray(JSONObject jsonResponse)  throws JSONException{

        JSONObject jsonTracks = jsonResponse.getJSONObject("tracks");
        JSONArray tracksArray = jsonTracks.getJSONArray("track");

        for(int i = 0; i < tracksArray.length(); i++){

            JSONObject jsonTrack = tracksArray.getJSONObject(i);
            Track currentTrack = new Track();

            String name = jsonTrack.getString("name");
            String duration = jsonTrack.getString("duration");
            String playcount = jsonTrack.getString("playcount");
            String listeners = jsonTrack.getString("listeners");

            JSONObject artist = jsonTrack.getJSONObject("artist");

            String artistName = artist.getString("name");

            currentTrack.setName(name);
            currentTrack.setDuration(duration);
            currentTrack.setPlaycount(Integer.parseInt(playcount));
            currentTrack.setListeners(Integer.parseInt(listeners));
            currentTrack.setArtistName(artistName);

            Log.i(LOG_TAG, currentTrack.toString());
        }
        return null;
    }
}

