package com.mib.bumblebee.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by MUHAMMAD IQBAL on 3/26/2017.
 */

public class ImageProcess {

    public String encodeImage(String path, int width, int height){
        File imageFile = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(imageFile);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Bitmap bmp = BitmapFactory.decodeStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String engImage = Base64.encodeToString(b, Base64.DEFAULT);

        byte[] c = Base64.decode(engImage.getBytes(), Base64.DEFAULT);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        Bitmap image = BitmapFactory.decodeByteArray(c, 0, c.length, options);

        if(image.getHeight() <= 400 && image.getWidth() <= 400){
            return  engImage;
        }
        image = Bitmap.createScaledBitmap(image, width, height, false);

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, bs);

        byte[] d = bs.toByteArray();
        String  base64String= Base64.encodeToString(d, Base64.NO_WRAP);
        return base64String;
    }

}
