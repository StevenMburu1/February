package com.example.february;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    EditText email,password;
    TextView sign, exotic,indigenous;
    ImageView image1,image2;
    Button button_exotic, button_indigenous;

    LoginTabFragment login1= new LoginTabFragment();
    private Object FragmentTransaction;

    public void openDialog1(View view){

        DialogActivityRestrictExotic dialogActivityRestrictExotic =new DialogActivityRestrictExotic();
        dialogActivityRestrictExotic.show(getSupportFragmentManager(),"Exotic");

    }

    public void openDialog2(View view){

        DialogActivityRestrictInd dialogActivityRestrictInd= new DialogActivityRestrictInd();
        dialogActivityRestrictInd.show(getSupportFragmentManager(),"Indigenous");

    }


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        exotic=findViewById(R.id.exotic_description);
        indigenous=findViewById(R.id.indigenous_description);
        button_exotic=findViewById(R.id.button_exotic);
        button_indigenous=findViewById(R.id.button_indigenous);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.image_slider);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        ViewPager viewPager = (ViewPager) findViewById(R.id.image_slider_2);
        ImageAdapter2 AdapterView = new ImageAdapter2(this);
        viewPager.setAdapter(AdapterView);


        sign= findViewById(R.id.sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                MainActivity.super.onBackPressed();
            }
        });

        button_exotic.setOnClickListener(this::openDialog1);

        button_indigenous.setOnClickListener(this::openDialog2);
    }
        }