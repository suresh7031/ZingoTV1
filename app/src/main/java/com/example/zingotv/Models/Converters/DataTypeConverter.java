package com.example.zingotv.Models.Converters;

import com.example.zingotv.Models.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class DataTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Lists> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Lists>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<Lists> someObjects) {
        return gson.toJson(someObjects);
    }
}

