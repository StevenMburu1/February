package com.example.february;

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

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignupTabFragment extends Fragment implements View.OnClickListener {
    EditText email, password, confirmpass,first,last;
    Button signup;
    TextView account,Signup;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.pass);
        confirmpass = root.findViewById(R.id.pass2);
        first = root.findViewById(R.id.first);
        last = root.findViewById(R.id.last);
        signup = root.findViewById(R.id.signup);
        account = root.findViewById(R.id.account);
        Signup=root.findViewById(R.id.signUP);


        email.setTranslationY(800);
        password.setTranslationY(800);
        confirmpass.setTranslationY(800);
        first.setTranslationY(800);
        last.setTranslationY(800);
        signup.setTranslationY(800);
        account.setTranslationY(800);
        Signup.setTranslationY(800);

        email.setAlpha(v);
        password.setAlpha(v);
        confirmpass.setAlpha(v);
        first.setAlpha(v);
        last.setAlpha(v);
        signup.setAlpha(v);
        account.setAlpha(v);
        Signup.setAlpha(v);


        Signup.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        first.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        last.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(400).start();
        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(600).start();
        confirmpass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        account.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(800).start();
        signup.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(1000).start();



        signup.setOnClickListener(view -> {


            String FirstName, LastName, Email, password1, confirmpassword;

            FirstName= String.valueOf(first.getText());
            LastName= String.valueOf(last.getText());
            Email= String.valueOf(email.getText());
            password1= String.valueOf(password.getText());
            confirmpassword= String.valueOf(confirmpass.getText());

            if (!FirstName.equals("") && !LastName.equals("") && !Email.equals("") &&!password1.equals("") &&!confirmpassword.equals("")) {


                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[5];
                        field[0] = "FirstName";
                        field[1] = "LastName";
                        field[2] = "email";
                        field[3] = "password";
                        field[4] = "confirmpassword";

                        //Creating array for data
                        String[] data = new String[5];
                        data[0] =FirstName;
                        data[1] = LastName;
                        data[2] = Email;
                        data[3] = password1;
                        data[4] = confirmpassword;
                        PutData putData = new PutData("http://192.168.0.227/February/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                          //  Toast.makeText(getActivity(),"clicked",Toast.LENGTH_LONG).show();
                            if (putData.onComplete()) {


                                String result = putData.getResult();
                                //End ProgressBar (Set visibility to GONE)
                                Log.i("PutData", result);
                                Toast.makeText(getActivity(),result,Toast.LENGTH_LONG).show();
                                if (result.equals("Sign Up Success")){
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




    @Override
    public void onClick(View view) {


    }
}

