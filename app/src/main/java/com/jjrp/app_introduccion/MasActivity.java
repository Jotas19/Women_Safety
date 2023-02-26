package com.jjrp.app_introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas);

    }

    public void GoTime (View view)
    {
        Intent intent = new Intent(this,TimeActivity.class);
        startActivity(intent);
    }
}