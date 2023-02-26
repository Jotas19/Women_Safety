package com.jjrp.app_introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Buscar extends AppCompatActivity {
    private List<String> Lista = new ArrayList<>();
    private ArrayAdapter Adapter;
    private ListView ListView;
    private EditText EditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        EditText=findViewById(R.id.txtBuscar);
        ListView=findViewById(R.id.Lista);
        Lista.add("Alicia");
        Lista.add("Marta");
        Lista.add("Aura");
        Lista.add("Marcela");
        Lista.add("Liseth");
        Lista.add("Marly");
        Lista.add("Karen");
        Lista.add("Paula");

        Adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,Lista);
        ListView.setAdapter(Adapter);


        EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

















}