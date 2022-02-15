package com.example.february;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignupActivity extends AppCompatActivity {

    EditText first, last, email, password, confirmpass;
    Button signup;
    TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_tab_fragment);

        first= findViewById(R.id.first);
        last= findViewById(R.id.last);
        email= findViewById(R.id.email);
        password= findViewById(R.id.pass);
        confirmpass= findViewById(R.id.pass2);
        signup= findViewById(R.id.signup);
        forget= findViewById(R.id.forgetpass);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FirstName, LastName, Email,password1, confirmpassword;

                FirstName= String.valueOf(first.getText());
                LastName= String.valueOf(last.getText());
                Email= String.valueOf(email.getText());
                password1= String.valueOf(password.getText());
                confirmpassword= String.valueOf(confirmpass.getText());

                if (!FirstName.equals("") && !LastName.equals("") && !Email.equals("") &&!password1.equals("") &&!confirmpassword.equals("")) {

                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];
                            field[0] = "FirstName";
                            field[1] = "LastName";
                            field[2] = "Email";
                            field[3] = "password1";
                            field[4] = "confirmpassword";

                            //Creating array for data
                            String[] data = new String[5];
                            data[0] =FirstName;
                            data[1] = LastName;
                            data[2] = Email;
                            data[3] = password1;
                            data[4] = confirmpassword;
                            PutData putData = new PutData("http://192.168.137.230/February/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                                        startActivity(intent);
                                        finish();


                                    }else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }

                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"All Fields Are Required",Toast.LENGTH_SHORT).show();
                }



            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),LoginTabFragment.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
