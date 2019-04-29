package com.example.zingotv.Models.Converters;

import com.example.zingotv.Models.MenuItems;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class DataTypeconverterMenu {
    private static Gson gson = new Gson();
    @TypeConverter
    public static List<MenuItems> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<MenuItems>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<MenuItems> someObjects) {
        return gson.toJson(someObjects);
    }
}
