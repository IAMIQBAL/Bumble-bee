package com.mib.bumblebee.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.mib.bumblebee.Constants;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MUHAMMAD IQBAL on 2/12/2017.
 */

public class HttpRequest {

    public static int ppReq(String jsonData, String url, String requestMethod) {
        int rCode = 0;
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(String.format(jsonData));
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
            rCode = connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rCode;
    }

    public int uploadImage(String jsonData, String url, String mUsername,
                              String token ,String picType){
        int rCode = 0;
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("username", mUsername);
            connection.setRequestProperty("token", token);
            connection.setRequestProperty("pictype", picType);
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(String.format(jsonData));
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
            rCode = connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rCode;
    }

    public static Bitmap getImage(String url){
        URL url1 = null;
        Bitmap myBitmap = null;

        try {
            url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.connect();
            InputStream in = connection.getInputStream();
            myBitmap = BitmapFactory.decodeStream(in);
            Log.i("Stream:", "" + in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return myBitmap;
    }

}
