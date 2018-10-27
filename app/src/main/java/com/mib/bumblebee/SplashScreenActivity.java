package com.mib.bumblebee;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mib.bumblebee.Chat.MainActivity;
import com.mib.bumblebee.api.WebRequest;

import static com.mib.bumblebee.Animations.rgbBackground;
import static com.mib.bumblebee.Constants.Login_URL;

public class SplashScreenActivity extends AppCompatActivity {

    public TextView tv;
    public Button getData;
    public EditText username;
    public EditText password;
    public static String uname;
    public static String pwd;
    public static boolean success = false;
    LinearLayout splashScreenBG;
    public ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        rgbBackground(findViewById(R.id.splash_screen_bg));

        tv = findViewById(R.id.donthaveacc);
        getData = findViewById(R.id.get_data);
        username = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        pb = findViewById(R.id.progressBar1);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString();
                pwd = password.getText().toString();

                loadText ld = new loadText();
                ld.execute();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Signup.class);
                startActivity(in);
                finish();
            }
        });


    }

    class loadText extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            getData.setVisibility(View.INVISIBLE);
            pb.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void... voids) {
            int resCode = WebRequest.login(Login_URL + uname + "/" + pwd);
            if (resCode!=0){
                success = true;
            } else {
                success = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (success){
                tv.setText("Logged In");
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Username or Password Incorrect", Toast.LENGTH_SHORT).show();
                getData.setVisibility(View.VISIBLE);
                pb.setVisibility(View.INVISIBLE);
            }
        }
    }
}
