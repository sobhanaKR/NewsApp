package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkInterface {


    @GET("v2/everything?q=bitcoin&from=2019-06-27&sortBy=publishedAt&apiKey=97c81d730b6b4174af3db9f0ebe87bf3")
    Call<ListingModel> getProductList();
}
