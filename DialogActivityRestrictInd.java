package com.example.february;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class DialogActivityRestrictInd extends AppCompatDialogFragment {
    EditText num;

    @SuppressLint("UseRequireInsteadOfGet")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {



        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());

        LayoutInflater layoutInflater=getActivity().getLayoutInflater();

        View view=layoutInflater.inflate(R.layout.restrict_dialog, null);

        builder.setView(view)

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        num= view.findViewById(R.id.number);

                        if (num.getText().toString().length() == 0) {
                            num.setText("0");
                        }

                        int num1= Integer.parseInt(num.getText().toString());

                        if (num1>10){
                            Intent intent= new Intent(getActivity(),LoginActivity.class);
                            startActivity(intent);

                            Toast.makeText(getActivity(),"Sign up First for more than 10 trees",Toast.LENGTH_LONG).show();

                        }else if (num1 !=0 ){

                            Intent intent= new Intent(getActivity(),NativeActivity.class);
                            startActivity(intent);
                        }


                    }
                });


        return builder.create();
    }
}