package examples.f.dev.retrofit.domain;

/**
 * Created by Salvador on 14/07/2015.
 */

import com.google.gson.annotations.SerializedName;


/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Pedro Hernndez on 07/2015.
 */
public class Track {

    @SerializedName("name")
    String name;

    @SerializedName("duration")
    String duration;

    @SerializedName("artist")
    //Artist es una clase
    Artist artist;

    @SerializedName("playcount")
    int playCount;

    @SerializedName("listeners")
    int listeners;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
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
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", artistName='" + artist.getArtistName() + '\'' +
                ", playCount=" + playCount +
                ", listeners=" + listeners +
                '}';
    }
}

