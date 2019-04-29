package com.example.zingotv.DataBase;

import android.content.Context;
import android.util.Log;

import com.example.zingotv.Interfaces.ListEventsDAO;
import com.example.zingotv.Interfaces.ListsDAO;
import com.example.zingotv.Interfaces.authItemDAO;
import com.example.zingotv.Models.Converters.DataTypeConverter;
import com.example.zingotv.Models.Converters.DataTypeConverterListsEvents;
import com.example.zingotv.Models.Converters.DataTypeconverterAuth;
import com.example.zingotv.Models.Converters.DataTypeconverterFilterDetails;
import com.example.zingotv.Models.Converters.DataTypeconverterMenu;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.Models.Lists;
import com.example.zingotv.Models.ListsEvents;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {JSONData.class, Lists.class, ListsEvents.class},version =6,exportSchema = false)
@TypeConverters({DataTypeconverterMenu.class ,DataTypeconverterAuth.class, DataTypeconverterFilterDetails.class, DataTypeConverterListsEvents.class,DataTypeConverter.class})
public abstract class authItemDatabase extends RoomDatabase {
    private static authItemDatabase instance;
public abstract authItemDAO authItemDAO();
public abstract ListsDAO listsDAO();
public abstract ListEventsDAO listEventsDAO();
    public static synchronized authItemDatabase getInstance(Context context){
        Log.i("db", "getInstance: db");
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),authItemDatabase.class,"post_database")
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
