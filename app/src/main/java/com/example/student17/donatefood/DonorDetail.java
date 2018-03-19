package com.example.student17.donatefood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DonorDetail extends AppCompatActivity implements View.OnClickListener{
    EditText nameEdit;
    EditText contactEdit;
    EditText cityEdit;
    EditText stateEdit;
    TextView name;
    TextView contact;
    TextView city;
    TextView state;
    RadioGroup radioGroup2;
    RadioButton donor;
    RadioButton recipient;
    Button btnRegister;
    Button btnNext;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_detail);
        name = findViewById(R.id.name);
        nameEdit = findViewById(R.id.nameEdit);
        contact = findViewById(R.id.contact);
        contactEdit = findViewById(R.id.contactEdit);
        city = findViewById(R.id.city);
        cityEdit = findViewById(R.id.cityEdit);
        state = findViewById(R.id.state);
        stateEdit = findViewById(R.id.stateEdit);
        radioGroup2 = findViewById(R.id.radioGroup2);
        donor = findViewById(R.id.donor);
        recipient = findViewById(R.id.recpt);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener( this );
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener( this );
        db=openOrCreateDatabase("DONORDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS DONOR(contact VARCHAR,name VARCHAR)");


    }

    @Override
    public void onClick(View view) {
        if (view == btnRegister) {
            if (nameEdit.getText().toString().trim().length() == 0 || contactEdit.getText().toString().trim().length() == 0
                    || cityEdit.getText().toString().trim().length() == 0 || stateEdit.getText().toString().trim().length() == 0 )
            {
                showMessage( "Error", "Please enter all values" );
                return;
            }
            else{
                db.execSQL("INSERT INTO DONOR(contact,name) VALUES('"+contactEdit.getText()+"','"+nameEdit.getText()+"');");
                clearText();
                startActivity( new Intent( DonorDetail.this, Registered.class ) );
            }

        }







    }

    private void clearText() {
        contactEdit.setText( "" );
        nameEdit.setText( "" );
        cityEdit.setText( "" );
        stateEdit.setText( "" );
        contactEdit.requestFocus();
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setCancelable( true );
        builder.setTitle( title );
        builder.setMessage( message );
        builder.show();
    }

}
