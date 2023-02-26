package com.jjrp.app_introduccion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Ingresa extends AppCompatActivity {

    private EditText emailC;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa);

        emailC = findViewById(R.id.emailC);
        password = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
    }
    public void GoRegistro (View view)
    {
        Intent intent = new Intent(this,RegistroActivity.class);
        startActivity(intent);
    }

    public void iniciarsesion (View view) {
        mAuth.signInWithEmailAndPassword(emailC.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Autenticacion correcta", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Autenticacion fallida", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}