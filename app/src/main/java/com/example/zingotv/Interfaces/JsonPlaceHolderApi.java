package com.example.zingotv.Interfaces;

import com.example.zingotv.Models.JSONData;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("categories_xml_android.php")
    Call<JSONData> getApiData(@QueryMap Map<String, String> parameters);

    @GET
    Call<JSONData>getVideoData(@Url String argstring);
}
