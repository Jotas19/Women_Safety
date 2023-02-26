package com.jjrp.app_introduccion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Enviar;
    Button btCall;
    final String numero = "018000112137";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCall = findViewById(R.id.btnMarcadorapido);
        Enviar = (Button)findViewById(R.id.txtSOS);

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

    public void Marcado_rapido (View view)
    {
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + numero));
                startActivity(intent);
            }
        });
    }

    public void Mas (View view)
    {
        Intent intent = new Intent(this,MasActivity.class);
        startActivity(intent);
    }

    public void GoMapas (View view)
    {
        Intent intent = new Intent(this,MapasActivity2.class);
        startActivity(intent);
    }



    public void Sugerencias (View view)
    {
        Intent intent = new Intent(MainActivity.this,Sugerencias.class);
        startActivity(intent);
    }


    //Metodos imagenes
    public void contacto0 (View view)
    {
        Intent intent = new Intent(MainActivity.this,contacto0.class);
        startActivity(intent);
    }
    public void contacto1 (View view)
    {
        Intent intent = new Intent(MainActivity.this,contacto1.class);
        startActivity(intent);
    }
    public void contacto2 (View view)
    {
        Intent intent = new Intent(MainActivity.this,contacto2.class);
        startActivity(intent);
    }




}