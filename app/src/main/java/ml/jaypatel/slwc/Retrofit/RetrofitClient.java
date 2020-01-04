package ml.jaypatel.slwc.Retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shiva on 2017-03-17.
 */

public class RetrofitClient {
    public static final String BASE_URL = "http://quotes.rest/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static final String Pexel_url = "https://api.pexels.com/v1/";
    public static Retrofit pretrofit = null;




    public static Retrofit getPexelRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        "563492ad6f9170000100000173bf2b6950c941874a69e51336571302");

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        if (pretrofit == null) {
            pretrofit = new Retrofit.Builder()
                    .baseUrl(Pexel_url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return pretrofit;
    }


}
