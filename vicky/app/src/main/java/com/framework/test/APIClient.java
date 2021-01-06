package com.framework.test;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient { private static Retrofit retrofit = null;
    static Retrofit getClient() {
        try {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.plos.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }catch (Exception e) {
        e.printStackTrace();
        }
            return retrofit;

    }
}
