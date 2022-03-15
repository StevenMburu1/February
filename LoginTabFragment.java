package com.example.february;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class LoginTabFragment  extends Fragment {
    EditText email, password;
    TextView forgetpassword;
    Button login;
    Boolean b;
    float v = 0;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_fab_fragment, container, false);

        email = root.findViewById(R.id.Email);
        password = root.findViewById(R.id.pass);
        forgetpassword = root.findViewById(R.id.forgetpass);
        login = root.findViewById(R.id.login);

        email.setTranslationY(800);
        password.setTranslationY(800);
        forgetpassword.setTranslationY(800);
        login.setTranslationY(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgetpassword.setAlpha(v);
        login.setAlpha(v);


        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpassword.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();



        login.setOnClickListener(view -> {


            String  Email, password1;


            Email= String.valueOf(email.getText());
            password1= String.valueOf(password.getText());


            if ( !Email.equals("") &&!password1.equals("") ) {


                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[2];

                        field[0] = "email";
                        field[1] = "password";


                        //Creating array for data
                        String[] data = new String[2];

                        data[0] = Email;
                        data[1] = password1;

                        PutData putData = new PutData("http://192.168.0.227/February/login.php", "POST", field, data);
                        if (putData.startPut()) {
                            //  Toast.makeText(getActivity(),"clicked",Toast.LENGTH_LONG).show();
                            if (putData.onComplete()) {




                                String result = putData.getResult();
                                //End ProgressBar (Set visibility to GONE)
                                Log.i("PutData", result);
                                Toast.makeText(getActivity(),result,Toast.LENGTH_LONG).show();
                                if (result.equals("Login Success")){
                                    Toast.makeText(getActivity(),result,Toast.LENGTH_SHORT).show();

                                    Intent intent= new Intent(getActivity(),MainActivity.class);
                                    startActivity(intent);



                                }else {
                                    Toast.makeText(getActivity(),result,Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        //End Write and Read data with URL
                    }

                });
            }
            else {
                Toast.makeText(getActivity(),"All Fields Are Required",Toast.LENGTH_SHORT).show();
            }



        });




        return root;


    }


}

