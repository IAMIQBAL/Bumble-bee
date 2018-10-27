//package com.mib.bumblebee.api;
//
//import com.mib.bumblebee.Constants;
//
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// * Created by MUHAMMAD IQBAL on 2/23/2017.
// */
//
//public class UploadImage {
//
//
//    public static void uploadFile(String sourceFileUri, String username, String pictype) throws IOException {
//
////
//            HttpURLConnection conn = null;
//            DataOutputStream dos = null;
//            String lineEnd = "\r\n";
//            String twoHyphens = "--";
//            String boundary = "*****";
//            int bytesRead, bytesAvailable, bufferSize;
//            byte[] buffer;
//            int maxBufferSize = 1024 * 1024;
//            File sourceFile = new File(sourceFileUri);
//
////            if (sourceFile.isFile()) {
////
//                String upLoadServerUri = Constants.IMAGE_URL;
//
//                // open a URL connection to the Servlet
//                FileInputStream fileInputStream = new FileInputStream(
//                        sourceFile);
//                URL url = new URL(upLoadServerUri);
//
//                // Open a HTTP connection to the URL
//                conn = (HttpURLConnection) url.openConnection();
//                conn.setDoInput(true); // Allow Inputs
//                conn.setDoOutput(true); // Allow Outputs
//                conn.setUseCaches(false); // Don't use a Cached Copy
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Connection", "Keep-Alive");
//                conn.setRequestProperty("ENCTYPE",
//                        "multipart/form-data");
//                conn.setRequestProperty("Content-Type",
//                        "multipart/form-data;boundary=" + boundary);
//                conn.setRequestProperty("bill", sourceFileUri);
//
//        // custom headers
//        conn.setRequestProperty("Username", username);
//        conn.setRequestProperty("pictype", pictype);
//        //-----------------------------------------//
//
//        dos = new DataOutputStream(conn.getOutputStream());
//
//                dos.writeBytes(twoHyphens + boundary + lineEnd);
//                dos.writeBytes("Content-Disposition: form-data; name=\"bill\";filename=\""
//                        + sourceFileUri + "\"" + lineEnd);
//
//                dos.writeBytes(lineEnd);
//
//                // create a buffer of maximum size
//                bytesAvailable = fileInputStream.available();
//
//                bufferSize = Math.min(bytesAvailable, maxBufferSize);
//                buffer = new byte[bufferSize];
//
//                // read file and write it into form...
//                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
//
//                while (bytesRead > 0) {
//
//                    dos.write(buffer, 0, bufferSize);
//                    bytesAvailable = fileInputStream.available();
//                    bufferSize = Math
//                            .min(bytesAvailable, maxBufferSize);
//                    bytesRead = fileInputStream.read(buffer, 0,
//                            bufferSize);
//
//                }
//
//                // send multipart form data necesssary after file
//                // data...
//                dos.writeBytes(lineEnd);
//                dos.writeBytes(twoHyphens + boundary + twoHyphens
//                        + lineEnd);
//
//                // Responses from the server (code and message)
//                int serverResponseCode = conn.getResponseCode();
//                String serverResponseMessage = conn
//                        .getResponseMessage();
//
//                if (serverResponseCode == 200) {
//
//                    // messageText.setText(msg);
//                    //Toast.makeText(ctx, "File Upload Complete.",
//                    //      Toast.LENGTH_SHORT).show();
//
//                    // recursiveDelete(mDirectory1);
//
//                }
//
//                // close the streams //
//                fileInputStream.close();
//                dos.flush();
//                dos.close();
//
////            }
//        }
//}