//package com.example.muhammadiqbal.IMAP.api;
//
//import com.example.muhammadiqbal.IMAP.extras.Constants;
//import com.example.muhammadiqbal.IMAP.pojo.Messages;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//
///**
// * Created by MUHAMMAD IQBAL on 1/25/2017.
// */
//
//public class ChatWebRequest {
//
////    public static void postMessage(String userName, String message) {
////        int rCode = 0;
////        try {
////            URL url1 = new URL(Constants.API_URL + "chat/post");
////            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
////            connection.setRequestMethod("POST");
////            connection.setDoOutput(true);
////            connection.setRequestProperty("Content-Type", "application/json");
////            connection.setRequestProperty("Accept", "application/json");
////            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
////            osw.write(String.format("{\n" +
////                    "\"username\":\""+userName+"\",\n" +
////                    "\"message\":\""+message+"\"\n" +
////                    "}"));
////            osw.flush();
////            osw.close();
////            System.err.println(connection.getResponseCode());
////            rCode = connection.getResponseCode();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public static JSONObject parserMessages(String url, ArrayList<Messages> b){
//
//        JSONArray jsonArray = WebRequest.getJsonArray(url);
//        JSONObject jsonObject1 = new JSONObject();
//
//        try {
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                jsonObject1 = jsonArray.getJSONObject(i);
//                b.add(new Messages(jsonObject1.getString("username"),
//                        jsonObject1.getString("message")
//                ));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonObject1;
//    }
//
//}
