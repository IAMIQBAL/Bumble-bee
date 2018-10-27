//package com.mib.bumblebee.api;
//
//import com.mib.bumblebee.api.Info;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
///**
// * Created by MUHAMMAD IQBAL on 10/12/2016.
// */
//
//public class Parser {
//
//    public static JSONObject parserJsonObject(String url, ArrayList<Info> b){
//
//        JSONArray jsonArray = WebRequest.getJsonArray(url);
//        JSONObject jsonObject1 = new JSONObject();
//
//        try {
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                jsonObject1 = jsonArray.getJSONObject(i);
//                b.add(new Info(jsonObject1.getString("username"),
//                        jsonObject1.getDouble("latitude"),
//                        jsonObject1.getDouble("longitude"),
//                        jsonObject1.getInt("status")
//                ));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonObject1;
//    }
//
//
//}
