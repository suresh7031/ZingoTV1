package com.example.zingotv.ViewModel;
import android.app.Application;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;
import com.example.zingotv.Models.ListsEvents;
import com.example.zingotv.Repositories.authItemRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;


public class authItemViewmodel extends AndroidViewModel implements LifecycleOwner {
    private authItemRepository repository;
    private LiveData<List<JSONData>> allData;

    public authItemViewmodel(@NonNull Application application) {
        super(application);
        repository=new authItemRepository(application);
        allData=repository.getData();

    }

    public void insert(JSONData data){
        repository.insert(data);
    }
    public void insertLists(List<Lists> lists){
        repository.insertLists(lists);
    }
    public void insertListsEvents(List<ListsEvents> listsEvents){
        repository.insertEvents(listsEvents);
    }
    public LiveData<List<JSONData>> getData(){
       return allData;
    }


    public void deleteAllrecords(){
        repository.deleteAllRecords();
    }
    public void deleteAllLists(){
        repository.deleteAllLists();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
