package com.example.gmail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private EmailAdapter emailAdapter;
    private List<Email> emailList; // Variable global


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar lista global
        emailList = getSampleEmails();

        // Barra de búsqueda (EditText)
        EditText searchBar = findViewById(R.id.search_bar);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se necesita implementar
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filtrar la lista en tiempo real
                filterEmails(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No se necesita implementar
            }
            private void filterEmails(String query) {
                String lowerCaseQuery = query.toLowerCase(); // Convertir a minúsculas para búsqueda insensible a mayúsculas
                List<Email> filteredList = new ArrayList<>();

                for (Email email : emailList) { // emailList es la lista original de correos
                    // Filtrar por remitente o asunto
                    if (email.getRemitente().toLowerCase().contains(lowerCaseQuery) ||
                            email.getAsunto().toLowerCase().contains(lowerCaseQuery)) {
                        filteredList.add(email);
                    }
                }
                emailAdapter.updateList(filteredList); // Este método debe estar implementado en el adaptador

            }
        });


        // Inicializar el DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);

        // Configurar el NavigationView
        NavigationView navigationView = findViewById(R.id.navigation_view);


        ImageView menuIcon = findViewById(R.id.menu_icon);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        menuIcon.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        // Botón flotante para componer correo
        FloatingActionButton fabCompose = findViewById(R.id.fab_compose);
        fabCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la actividad de redacción
                Intent intent = new Intent(MainActivity.this, flotante.class);
                startActivity(intent);
            }
        });

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.recycler_emails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Crear datos de prueba
        List<Email> emailList = getSampleEmails();

        // Configurar el adaptador
        emailAdapter = new EmailAdapter(emailList);
        recyclerView.setAdapter(emailAdapter);

        // Configurar el BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            String title = item.getTitle().toString();

            switch (title) {
                case "Correo":
                    Toast.makeText(this, "Bandeja de entrada seleccionada", Toast.LENGTH_SHORT).show();
                    return true;
                case "Videollamada":
                    Toast.makeText(this, "Videollamada seleccionada", Toast.LENGTH_SHORT).show();
                    return true;
                case "Mensaje":
                    Toast.makeText(this, "Mensaje seleccionada", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

        // Configurar acciones del NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();

                switch (title) {
                    case "Todas las bandejas":
                        Toast.makeText(MainActivity.this, "Todas las bandejas seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case "Recibidos":
                        Toast.makeText(MainActivity.this, "Recibidos seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Destacados":
                        Toast.makeText(MainActivity.this, "Destacados seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Pospuestos":
                        Toast.makeText(MainActivity.this, "Pospuestos seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Importantes":
                        Toast.makeText(MainActivity.this, "Importantes seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Enviados":
                        Toast.makeText(MainActivity.this, "Enviados seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Programado":
                        Toast.makeText(MainActivity.this, "Programado seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Bandeja de salida":
                        Toast.makeText(MainActivity.this, "Bandeja de salida seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Borradores":
                        Toast.makeText(MainActivity.this, "Borradores seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Todos":
                        Toast.makeText(MainActivity.this, "Todos seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Spam":
                        Toast.makeText(MainActivity.this, "Spam seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Papelera":
                        Toast.makeText(MainActivity.this, "Papelera seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case "Calendar":
                        Toast.makeText(MainActivity.this, "Calendar seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case "Contactos":
                        Toast.makeText(MainActivity.this, "Contactos seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case "Ajustes":
                        Toast.makeText(MainActivity.this, "Ajustes seleccionados", Toast.LENGTH_SHORT).show();
                        break;
                    case "Ayuda y comentarios":
                        Toast.makeText(MainActivity.this, "Ayuda seleccionada", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Opción no manejada", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Cerrar el Drawer después de la selección
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Método para generar correos de prueba
    private List<Email> getSampleEmails() {
        List<Email> emailList = new ArrayList<>();
        emailList.add(new Email("KEVIN JAVIER ZAMBRANO ENRIQUEZ", "Código GitHub", "10 ene", false, R.drawable.kevin));
        emailList.add(new Email("envios.pw", "INSCRIPCIÓN CIDU 2024", "9 ene", true,R.drawable.ic_email));
        emailList.add(new Email("FRANCISCO JESUS VERA MORAN", "Invitación a Proyecto", "9 ene", false, R.drawable.francisco));
        emailList.add(new Email("WILMER STEVEEN ZAMBRANO LOOR", "Trabajo Grupal", "7 ene", false, R.drawable.wilmer));
        emailList.add(new Email("SGA", "Registro de inasistencia", "7 ene", false, R.drawable.ic_sga));
        emailList.add(new Email("SGA", "Registro de inasistencia", "7 ene", false, R.drawable.ic_sga));
        emailList.add(new Email("SGA", "Registro de inasistencia", "6 ene", false, R.drawable.ic_sga));
        emailList.add(new Email("Soporte SGA", "¡Atención! Protege tu cuenta del SGA y correos institucionales: No compartas tus contraseñas", "2 ene", false, R.drawable.soporte));
        emailList.add(new Email("BOLETIN INFORMATIVO UTEQ RRPP TIC", "¡FELIZ AÑO NUEVO 2025 PARA TODA LA COMUNIDAD UNIVERSITARIA!", "1 ene", true, R.drawable.boletin));

        return emailList;
    }
}
