package examples.f.dev.retrofit.io;
import examples.f.dev.retrofit.io.model.TopTracksResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Salvador on 13/07/2015.
 */
public interface LastFMApiService {

    //nunca poner el slach al final de la URL
    //@GET("/?method=chart.gettoptracks&api_key=123ae7ccee87798c55c82b64c792a083&format=json")

    @GET(ApiConstants.URL_TOP_TRACKS)

    void getTopsTracks(@Query(ApiConstants.PARAM_KEY) String apiKey, Callback<TopTracksResponse> serverCallback);

}
