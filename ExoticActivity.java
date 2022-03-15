package com.example.february;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.imageview.ShapeableImageView;

public class ExoticActivity extends AppCompatActivity {

    TextView cypress,cypresstext,eucalyptus,eucalyptustext,pine,pinetext,wattle,wattletext,jacaranda,jacarandatext;
    ScrollView scrollView;
    ShapeableImageView cypress_image;

    public void openDialog(View view){

        DialogActivity dialogActivity=new DialogActivity();
        dialogActivity.show(getSupportFragmentManager(),"test");

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exotic_trees);
        scrollView = findViewById(R.id.scrollView1);

        cypresstext = findViewById(R.id.cypress_text);
        eucalyptustext = findViewById(R.id.eucalyptus_text);
        pinetext = findViewById(R.id.pine_text);
        wattletext = findViewById(R.id.Wattle_text);
        jacarandatext = findViewById(R.id.Jacaranda_text);

        cypress = findViewById(R.id.cypress);
        eucalyptus = findViewById(R.id.eucalyptus);
        pine = findViewById(R.id.pine);
        wattle = findViewById(R.id.Wattle);
        jacaranda = findViewById(R.id.Jacaranda);

        cypress_image = findViewById(R.id.cypress_image);

        cypresstext.setMovementMethod(new ScrollingMovementMethod());
        pinetext.setMovementMethod(new ScrollingMovementMethod());
        wattletext.setMovementMethod(new ScrollingMovementMethod());
        eucalyptustext.setMovementMethod(new ScrollingMovementMethod());
        jacarandatext.setMovementMethod(new ScrollingMovementMethod());

        scrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                cypresstext.getParent().requestDisallowInterceptTouchEvent(false);

                return false;
            }
        });

        cypresstext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                cypresstext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        eucalyptustext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                eucalyptustext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        wattletext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                wattletext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        jacarandatext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                jacarandatext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        pinetext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                pinetext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        cypress_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(view);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_bar, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//        public boolean onQueryTextSubmit(String query) {
//            searchView.clearFocus();
//             /*   if(list.contains(query)){
//                    adapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
//                }*/
//            return false;
//
//        }
//
//        @Override
//        public boolean onQueryTextChange(String newText) {
//            adapter.getFilter().filter(newText);
//            return false;
//        }
//    });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(ExoticActivity.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
