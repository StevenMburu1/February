package com.example.february;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    TextView forgetpass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fab_fragment);

        email= findViewById(R.id.Email);
        password=findViewById(R.id.pass);
        forgetpass=findViewById(R.id.forgetpass);
        login=findViewById(R.id.button);

    }
}