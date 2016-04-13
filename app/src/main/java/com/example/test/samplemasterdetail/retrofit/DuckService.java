package com.example.test.samplemasterdetail.retrofit;

import com.example.test.samplemasterdetail.entities.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DuckService {
    @GET("?format=json")
    Call<Result> listCharacters(@Query("q") String q);
}
