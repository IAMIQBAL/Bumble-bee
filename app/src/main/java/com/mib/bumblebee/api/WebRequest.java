package com.mib.bumblebee.api;

import android.util.Log;

import com.mib.bumblebee.Constants;

import org.json.JSONArray;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MUHAMMAD IQBAL on 10/12/2016.
 */

public class WebRequest {
    public static String url;
    public static String userName;
    public static String reqMethod;
    public static String responseData1;

    public static JSONArray getJsonArray(String url){
        JSONArray jsonArray = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            int contentLength = connection.getContentLength();
            char[] chars = new char[contentLength];
            reader.read(chars);
            String responseData = new String(chars);
            System.out.println(responseData);
            jsonArray = new JSONArray(responseData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static void updateLocation(double lat, double lng, String token) {


        try {
            URL url1 = new URL(Constants.END_POINT + "map/" + token);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(String.format("{\n" +
                    "    \"latitude\":\""+lat+"\",\n" +
                    "    \"longitude\":\""+lng+"\"\n" +
                    "}"));
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void postLocation(String userName) {
        int rCode = 0;
        try {
            URL url1 = new URL(Constants.END_POINT + "map/post");
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(String.format("{\n" +
                    "    \"username\": \""+userName+"\",\n" +
                    "    \"latitude\":\"0\",\n" +
                    "    \"longitude\":\"0\"\n" +
                    "  }"));
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
            rCode = connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SubmitContacts(String username, String number) {
        URL url = null;
        try {
            url = new URL(Constants.END_POINT + "contacts/post");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(String.format("{\n" +
                    "\"username\": \""+username+"\",\n" +
                    "\"contacts\": \""+number+"\"\n" +
                    "}"));
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int login(String url){
        int responseCode = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            int contentLength = connection.getContentLength();
            char[] chars = new char[contentLength];
            reader.read(chars);
            responseData1 = new String(chars);
//            System.out.println(responseData1);
            responseCode = connection.getResponseCode();
//            System.out.println(responseData1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }

    public static int checkToken(String username, String token){
        int responseCode = 0;
        try {
            URL obj = new URL(Constants.END_POINT + "find/" + username + "/" + token);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            int contentLength = connection.getContentLength();
            char[] chars = new char[contentLength];
            reader.read(chars);
            String responseData = new String(chars);
            System.out.println(responseData);
            responseCode = connection.getResponseCode();
            System.out.println(responseData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("Code", "Request" + responseCode);
        return responseCode;
    }

    public static void SignUp(String email, String name, String password, String username, String imei) {
        URL url = null;
        try {
            url = new URL(Constants.END_POINT + "profile/post");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
//            String number = list.toString();
            osw.write(String.format("{\n" +
                    "    \"email\": \""+email+"\",\n" +
                    "    \"fullname\": \""+name+"\",\n" +
                    "    \"password\": \""+password+"\",\n" +
                    "    \"imei\": \""+imei+"\",\n" +
                    "    \"username\": \""+username+"\"\n" +
                    "  }"));
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int logOut(String token) {
        int responseCode = 0;
        try {
            URL url1 = new URL(Constants.END_POINT + "accounts/" + token);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
//            osw.write(String.format("{\n" +
//                    "    \"username\": \"mib\",\n" +
//                    "    \"latitude\":\""+lat+"\",\n" +
//                    "    \"longitude\":\""+lng+"\"\n" +
//                    "  }"));
            osw.flush();
            osw.close();
            responseCode = connection.getResponseCode();
            System.err.println(connection.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }

}
