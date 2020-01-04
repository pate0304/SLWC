package ml.jaypatel.slwc.Retrofit;


import ml.jaypatel.slwc.PexelData.POJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by shiva on 2017-03-17.
 */

public interface ApiInterface {


    @GET("/qod")
    void getImage();

    @Headers("Authorization:563492ad6f9170000100000173bf2b6950c941874a69e51336571302")
    @GET("/v1/search?query=nature+query&per_page=40&page=1")
     Call<POJO> getPexel();
}
