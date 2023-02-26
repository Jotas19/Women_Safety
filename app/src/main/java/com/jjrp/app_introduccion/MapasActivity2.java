package com.jjrp.app_introduccion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapasActivity2 extends AppCompatActivity {

    //inicializar variables
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas2);

        //asignar variable
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        //inicializar fused location
        client = LocationServices.getFusedLocationProviderClient(this);

        //revisar permisos
        if(ActivityCompat.checkSelfPermission(MapasActivity2.this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED){
            //con el permiso garantizado llamar al metodo
            getCurrentLocation();
        }else{
            //con los permisos negados, solicitarlos
            ActivityCompat.requestPermissions(MapasActivity2.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
        }

    }
    private void getCurrentLocation(){
        //inicializar tarea de localizacion
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(@NonNull Location location) {
                //Log.e("Informacion", String.valueOf(client));
                //cuando es exitoso
                if (location != null){
                    //sincronizar mapa
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            //inicializar latitud y longitud
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            //crear opciones del marcador
                            MarkerOptions options = new MarkerOptions().position(latLng).title("Te encuentras aquí");
                            //Log.e("Valor de Latlng", String.valueOf(latLng));
                            //Zoom en el mapa
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            //añadir el marcador al mapa
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 44){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //con el permiso dado, llamar al método
                getCurrentLocation();
            }
        }
    }
}