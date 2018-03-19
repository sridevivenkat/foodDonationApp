package com.example.student17.donatefood;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {
    EditText aadhaarNo;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        aadhaarNo = findViewById( R.id.aadharNo );
        btnLogin = findViewById( R.id.btnLogin );
        btnLogin.setOnClickListener( this );
    }

    @Override
    public void onClick(android.view.View view) {
        if (view == btnLogin) {
            if (aadhaarNo.getText().toString().trim().length() == 0) {
                showMessage( "Error", " Field cannot be blank please enter the value" );
                return;
            }
            String pass=aadhaarNo.getText().toString();
            if (pass.equals( "1" ))
            {
                btnLogin.setOnClickListener( new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        showMessage( "ok", "login success" );
                        startActivity( new Intent(  MainActivity.this, Option.class) );
                    }
                } );
            }
            else
            {
                showMessage( "Error", " Wrong password .Please try again!!!" );
            }
        }

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setCancelable( true );
        builder.setTitle( title );
        builder.setMessage( message );
        builder.show();
    }
}
