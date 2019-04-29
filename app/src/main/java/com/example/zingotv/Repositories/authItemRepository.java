package com.example.zingotv.Repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.zingotv.DataBase.authItemDatabase;
import com.example.zingotv.Interfaces.ListEventsDAO;
import com.example.zingotv.Interfaces.ListsDAO;
import com.example.zingotv.Interfaces.authItemDAO;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;
import com.example.zingotv.Models.ListsEvents;

import java.util.List;

import androidx.lifecycle.LiveData;

public class authItemRepository {
private authItemDAO authItemDAO;
private ListsDAO listsDAO;
private ListEventsDAO listEventsDAO;

private LiveData<List<JSONData>> allData;


    public authItemRepository(Application application) {
        authItemDatabase database = authItemDatabase.getInstance(application);
        authItemDAO = database.authItemDAO();
        listsDAO=database.listsDAO();
        listEventsDAO=database.listEventsDAO();
        allData=authItemDAO.getData();


    }
    public void insertEvents(List<ListsEvents> listsEvents){
        new InsertEventsAsyncTask(listEventsDAO).execute(listsEvents);
    }
    public void insertLists(List<Lists> lists){
        new InsertListsAsyncTask(listsDAO).execute(lists);
    }
    public void insert(JSONData data) {
        new InsertDataAsyncTask(authItemDAO).execute(data);
    }
    public void deleteAllRecords(){
        new deleteAllrecordsAsyncTask();
    }
    public void deleteAllLists(){
        new deleteAllListsAsyncTask();
    }
  public LiveData<List<JSONData>> getData(){
        return allData;
    }



    private class InsertDataAsyncTask extends AsyncTask<JSONData,Void,Void> {
        authItemDAO authItemDAO;

        public InsertDataAsyncTask(authItemDAO authItemDAO) {
            this.authItemDAO=authItemDAO;
        }

        @Override
        protected Void doInBackground(JSONData... jsonData) {
            authItemDAO.insert(jsonData[0]);
            return null;
        }
    }

    private class deleteAllrecordsAsyncTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            authItemDAO.deleteAllData();
            return null;
        }
    }


    private class InsertListsAsyncTask extends AsyncTask<List<Lists>,Void,Void> {
        ListsDAO listsDAO;
        public InsertListsAsyncTask(ListsDAO listsDAO) {
            this.listsDAO=listsDAO;
        }


        @Override
        protected Void doInBackground(List<Lists>... lists) {

            listsDAO.insertLists(lists[0]);
            return null;
        }
    }

    private class deleteAllListsAsyncTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            listsDAO.deleteAllList();
            return null;
        }
    }

    private class InsertEventsAsyncTask extends AsyncTask<List<ListsEvents>,Void,Void> {
        ListEventsDAO listEventsDAO;
        public InsertEventsAsyncTask(ListEventsDAO listEventsDAO) {
        this.listEventsDAO=listEventsDAO;
        }

        @Override
        protected Void doInBackground(List<ListsEvents>... lists) {
            listEventsDAO.insertevents(lists[0]);
            return null;
        }
    }
}

