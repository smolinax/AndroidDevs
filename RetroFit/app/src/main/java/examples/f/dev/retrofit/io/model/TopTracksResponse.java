package examples.f.dev.retrofit.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import examples.f.dev.retrofit.domain.Artist;
import examples.f.dev.retrofit.domain.Track;

/**
 * Created by Salvador on 14/07/2015.
 */
public class TopTracksResponse {
    @SerializedName("tracks")
    TracksData tracksData;

    public TracksData getTrackData(){
        return tracksData;
    }

    public class TracksData {

        @SerializedName("track")
        ArrayList<Track> tracks;

        public TracksData() {
            this.tracks = new ArrayList<>();
        }

        public ArrayList<Track> getTracks(){
            return  tracks;
        }
    }
}
