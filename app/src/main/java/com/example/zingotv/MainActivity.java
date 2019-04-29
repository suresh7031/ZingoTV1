package com.example.zingotv;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.zingotv.DataBase.authItemDatabase;
import com.example.zingotv.Fragments.CategoryFragment;
import com.example.zingotv.Fragments.FeedFragment;
import com.example.zingotv.Fragments.GuideFragment;
import com.example.zingotv.Interfaces.JsonPlaceHolderApi;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;
import com.example.zingotv.Models.ListsEvents;
import com.example.zingotv.ViewModel.authItemViewmodel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteDatabase;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements GuideFragment.OnFragmentInteractionListener, CategoryFragment.OnFragmentInteractionListener, FeedFragment.OnFragmentInteractionListener {
    public final String TAG = "arjun";
    private authItemViewmodel authItemViewmodel;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private int channelNo;
   // authItemDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* database = Room.databaseBuilder(this, authItemDatabase.class, "post_database").allowMainThreadQueries().build();
        SupportSQLiteDatabase sqLiteDatabase = database.getOpenHelper().getWritableDatabase();
        sqLiteDatabase.delete("events_table",null,null);*/
        authItemViewmodel = ViewModelProviders.of(this).get(authItemViewmodel.class);

        authItemViewmodel.getData().observe(this, new Observer<List<JSONData>>() {
            @Override
            public void onChanged(List<JSONData> jsonData) {

                for (JSONData data : jsonData) {
                    /* Log.i(TAG, "onChanged: "+data.getResponse().getContentView());*/
                    switch (data.getResponse().getContentView()) {
                        case "guide":
                            startTVGuide();
                            break;
                        case "feed":
                            startFeed();
                            break;
                        case "category":
                            startCategory();
                            break;
                        default:
                            break;
                    }
                }


            }

        });
     /*   authItemViewmodel.getLists().observe(this, new Observer<List<Lists>>() {
            @Override
            public void onChanged(List<Lists> lists) {
                for (Lists lists1:lists){
                    Log.i(TAG, "onChanged: "+lists.get(45).getCategory());
                }
            }
        });*/
        getWebData();

    }

    public void startCategory() {

        CategoryFragment categoryFragment = new CategoryFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mani_activity, categoryFragment, "category").commit();

    }

    public void startFeed() {
        Log.i(TAG, "startFeed: ");
        FeedFragment feedFragment = new FeedFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mani_activity, feedFragment, "feed").commit();
    }

    public void startTVGuide() {
        GuideFragment guideFragment = new GuideFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mani_activity, guideFragment, "guide").commit();
    }


    public void getWebData() {
        Log.i(TAG, "getWebData: ");
        Gson gson = new GsonBuilder().serializeNulls().create();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zingovod.zingotv.com/android/zingotv/xml/")
                .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("regToken", "15565389381OLM3");
        parameters.put("ver_name", "setupbox3");
        parameters.put("ver_code", "5");
        final Call<JSONData> call = jsonPlaceHolderApi.getApiData(parameters);
        call.enqueue(new Callback<JSONData>() {
            @Override
            public void onResponse(Call<JSONData> call, Response<JSONData> response) {
                if (response.isSuccessful()) {
                    JSONData data = response.body();

                    Log.i(TAG, "onResponse: " + data.getResponse().isShowCategoryHeader());
                    authItemViewmodel.insert(data);
                    List<Lists> lists = data.getResponse().getItems().getLists();

                    Log.i(TAG, "onResponse: " + lists.size());
                    authItemViewmodel.insertLists(lists);

                    //channelNo=lists.get(i).getChNo();
                    //lists.get(i).getEvents().get(j).setPchNo(channelNo);
                    for(int i=0;i<lists.size();i++){

                            List<ListsEvents>listsEvents1= lists.get(i).getEvents();
                            authItemViewmodel.insertListsEvents(listsEvents1);

                    }
                } else {
                    switch (response.code()) {
                        case 404:
                            Log.i(TAG, "onResponse: not found");

                            break;
                        case 500:
                            Log.i(TAG, "onResponse: not logged in or server broken");
                            break;
                        default:
                            Log.i(TAG, "onResponse: unknown error");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<JSONData> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
