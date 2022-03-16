package com.example.february;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogActivity extends AppCompatDialogFragment {
    double volume;
    int diameter,heights;
    EditText dbh,height;

    private void openDialog3() {
        DialogActivityVolume dialogActivityVolume =new DialogActivityVolume();
        dialogActivityVolume.show(requireFragmentManager(),"Volume");

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());

        LayoutInflater layoutInflater= requireActivity().getLayoutInflater();

        View view=layoutInflater.inflate(R.layout.calculate_dialog, null);

        builder.setView(view)

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("calculate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbh = view.findViewById(R.id.dbh);
                        height = view.findViewById(R.id.height);

                        if (dbh.getText().toString().length()==0){
                            dbh.setText("0");
                        }
                        if (height.getText().toString().length()==0){
                            height.setText("0");
                        }


                        diameter=Integer.parseInt(dbh.getText().toString());
                         heights=Integer.parseInt(dbh.getText().toString());
                        volume=((0.013152-(0.00005069*(diameter)*2))+(0.0001769*(diameter*heights))+(0.00002895*diameter*2*heights));
                        openDialog3();


                    }
                });





        return builder.create();
    }


}