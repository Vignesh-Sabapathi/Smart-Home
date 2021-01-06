package com.framework.test;


import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {


        @GET("/search?q=title:DNA")
        Call<MyData> doGetListResources();

}
