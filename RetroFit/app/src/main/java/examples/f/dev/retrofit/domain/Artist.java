package examples.f.dev.retrofit.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salvador on 14/07/2015.
 */
public class Artist {

    @SerializedName("name")
    String artistName;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



}
