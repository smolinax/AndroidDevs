package examples.f.dev.thefirstclient.track;

/**
 * Created by Salvador on 13/07/2015.
 */
public class Track {
    String Name;
    String duration;
    String artistName;
    int playcount;
    int listeners;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }

    @Override
    public String toString() {
        return "Track{" +
                "Name='" + Name + '\'' +
                ", duration='" + duration + '\'' +
                ", artistName='" + artistName + '\'' +
                ", playcount=" + playcount +
                ", listeners=" + listeners +
                '}';
    }
}
