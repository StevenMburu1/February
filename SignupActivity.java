package com.example.february;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.Arrays;

public class SignupActivity extends AppCompatActivity {

    EditText first, last, email, password, confirmpass;
    Button signup;
    TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_tab_fragment);

        first = findViewById(R.id.first);
        last = findViewById(R.id.last);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        confirmpass = findViewById(R.id.pass2);
        signup = findViewById(R.id.signup);
        forget = findViewById(R.id.account);


    }
}
