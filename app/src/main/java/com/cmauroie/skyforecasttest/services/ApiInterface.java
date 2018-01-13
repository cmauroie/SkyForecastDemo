package com.cmauroie.skyforecasttest.services;

import com.cmauroie.skyforecasttest.entities.ModelDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mauricio on 12/1/18.
 */

public interface ApiInterface {
    @GET("forecast/{key}/{location}")
    Call<ModelDataResponse> getForecast(@Path("key") String key ,
                                        @Path("location") String location,
                                        @Query("lang") String lang,
                                        @Query("exclude") String exclude,
                                        @Query("units") String units);
}
