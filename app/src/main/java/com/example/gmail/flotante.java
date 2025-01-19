package com.example.gmail;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class flotante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flotante);
        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar la flecha manualmente
        ImageView ic_back = findViewById(R.id.ic_back);
        ic_back.setOnClickListener(v -> {
            finish(); // Cerrar la actividad actual y regresar a la anterior
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_flotante, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = item.getTitle().toString(); // Obtener el título del elemento seleccionado
                switch (title) { // Manejar otras opciones por nombre
                    case "Adjuntar":
                        Toast.makeText(this, "Adjuntar archivo", Toast.LENGTH_SHORT).show();
                        return true;
                    case "Enviar":
                        Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show();
                        return true;
                    case "Más opciones":
                        Toast.makeText(this, "Más opciones", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return super.onOptionsItemSelected(item);
                }
        }
    }

