package com.jjrp.app_introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {


    TextView txtBienvenida;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);


        txtBienvenida=findViewById(R.id.txtBienvenida_SplashScreen);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        txtBienvenida.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                    Intent intent = new Intent(SplashScreen.this, Ingresa.class);
                    startActivity(intent);
                    finish();
            }
        },2000);
    }
}