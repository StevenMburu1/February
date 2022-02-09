package com.example.february;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class LoginTabFragment  extends Fragment {
    EditText email,pass,forgetpass;
    Button login;
    float v=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.login_fab_fragment, container, false);

        email=root.findViewById(R.id.Email);
        pass=root.findViewById(R.id.pass);
        forgetpass=root.findViewById(R.id.forgetpass);
        login=root.findViewById(R.id.button);

        email.setTranslationY(800);
        pass.setTranslationY(800);
        forgetpass.setTranslationY(800);
        login.setTranslationY(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();



        return root;
    }
}
