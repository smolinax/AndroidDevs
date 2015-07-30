package examples.f.dev.retrofit.io;

import retrofit.RestAdapter;

/**
 * Created by Salvador on 14/07/2015.
 */
public class LastFMApiClient {

    private  static LastFMApiService API_SERVICE;

    public static LastFMApiService getInstance(){

        if(API_SERVICE == null){
            //proceso de creacion del servicio

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            API_SERVICE = restAdapter.create(LastFMApiService.class);
        }

        return API_SERVICE;
    }

}
