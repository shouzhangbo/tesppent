package com.my.test.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	 public static Gson g = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	 
	 private static Gson t = null;
	 
	 public static String objectToJson(Object ts) {
		 t = g;
        String jsonStr = null;
        if(t != null) {
            jsonStr = t.toJson(ts);
        }

        return jsonStr;
    }
	public static Object jsonToBean(String jsonStr, Class<?> cl) {
        Object obj = null;
        if(t != null) {
            obj = t.fromJson(jsonStr, cl);
        }
        return obj;
    }
}
