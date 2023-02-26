package com.jjrp.app_introduccion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class contacto0 extends AppCompatActivity {
    Button Enviar;
    Button btCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto0);

        btCall = findViewById(R.id.btnMarcadorapido);
        Enviar = (Button)findViewById(R.id.Enviar0);
    }

    public void Marcado_rapido (View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:3168179895"));
        startActivity(intent);
    }

    public void sms (View view)
    {
        if(ActivityCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(
                this,Manifest
                        .permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]
                    { Manifest.permission.SEND_SMS,},1000);
        }
        Enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarMensaje("3007808704","Esto es una prueba");
            }
        });
    }
    private void enviarMensaje (String numero, String mensaje){
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,mensaje,null,null);
            Toast.makeText(getApplicationContext(), "Mensaje Enviado.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, datos incorrectos.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}