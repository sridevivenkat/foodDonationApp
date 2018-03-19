package com.example.student17.donatefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Option extends AppCompatActivity implements View.OnClickListener{
    Button btnDonor;
    Button btnRecpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        btnDonor = (Button) findViewById(R.id.btnDonor);
        btnDonor.setOnClickListener(this);
        btnRecpt = (Button) findViewById(R.id.btnRecpt);
        btnRecpt.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view == btnDonor) btnDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Option.this, DonorDetail.class));
            }
        });
    }
}
