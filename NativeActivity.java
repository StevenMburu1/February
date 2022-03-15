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

import com.google.android.material.imageview.ShapeableImageView;

public class NativeActivity extends AppCompatActivity {

    TextView yellowwood,yellowwoodtext,waterpear,waterpeatext,fountain,fountaintext,lead,leadtext,moringa,moringatext;
    ScrollView scrollView;
    ShapeableImageView moringa_image,waterpear_image,fountain_image,lead_image,yellowwood_image;

    public void openDialog(View view){

        DialogActivity dialogActivity=new DialogActivity();
        dialogActivity.show(getSupportFragmentManager(),"test");

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.native_trees);
        scrollView = findViewById(R.id.scrollView2);

        yellowwoodtext = findViewById(R.id.yellowwood_text);
        waterpeatext = findViewById(R.id.waterpear_text);
        fountaintext = findViewById(R.id.fountain_tree_text);
        leadtext = findViewById(R.id.lead_tree_text);
        moringatext = findViewById(R.id.moringa_text);

        yellowwood = findViewById(R.id.yellowwood);
        waterpear = findViewById(R.id.waterpear);
        fountain = findViewById(R.id.fountain_tree);
        lead = findViewById(R.id.lead_tree);
        moringa = findViewById(R.id.moringa);

        moringa_image = findViewById(R.id.moringa_image);
        waterpear_image = findViewById(R.id.waterpear_image);
        yellowwood_image = findViewById(R.id.yellowwood_image);
        fountain_image = findViewById(R.id.fountain_image);
        lead_image = findViewById(R.id.lead_image);

        yellowwoodtext.setMovementMethod(new ScrollingMovementMethod());
        waterpeatext.setMovementMethod(new ScrollingMovementMethod());
        fountaintext.setMovementMethod(new ScrollingMovementMethod());
        leadtext.setMovementMethod(new ScrollingMovementMethod());
        moringatext.setMovementMethod(new ScrollingMovementMethod());

        scrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                yellowwoodtext.getParent().requestDisallowInterceptTouchEvent(false);

                return false;
            }
        });

        yellowwoodtext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                yellowwoodtext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        waterpeatext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                waterpeatext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        fountaintext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                fountaintext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        leadtext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                leadtext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        moringatext.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                moringatext.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

        moringa_image.setOnClickListener(this::openDialog);
        waterpear_image.setOnClickListener(this::openDialog);
        yellowwood_image.setOnClickListener(this::openDialog);
        lead_image.setOnClickListener(this::openDialog);
        fountain_image.setOnClickListener(this::openDialog);
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
        Intent intent= new Intent(NativeActivity.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
