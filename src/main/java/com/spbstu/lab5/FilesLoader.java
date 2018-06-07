package com.spbstu.lab5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.lab5.entities.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class FilesLoader {
    /************************FOR LOAD A FILE**************************/
    private static Map<String, Data> DATA;
    static {
        try {
            load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void load() throws FileNotFoundException {
        FileReader fileReader = new FileReader(FilesLoader.class.getClassLoader().getResource("data.json").getFile());
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, Data>>() {
        }.getType();

        DATA = new Gson().fromJson(jsonReader, type);

    }

    public static Data getData(String subData) {
        return DATA.get(subData);
    }

    public static Object[] getAllData() {
            //System.out.println(DATA.values());
        return DATA.values().toArray();
    }
/*********************************************************************/
}
