package com.example.primer_evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.primer_evaluacion.clases.Libro;
import com.example.primer_evaluacion.clases.Publicacion;
import com.example.primer_evaluacion.clases.Revista;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button btnAgregarPublicacion, btnMostrarLista, btnAcercaDe;
    public static ArrayList<Publicacion> lstPublicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPublicaciones = new ArrayList<Publicacion>();


        btnAgregarPublicacion = findViewById(R.id.btnAgregar);
        btnMostrarLista  = findViewById(R.id.btnMostrarLista);
        btnAcercaDe = findViewById(R.id.btnAcercaDe);

        // Configurando evento
        btnAgregarPublicacion.setOnClickListener(this);

        btnMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ElegirLista.class));
            }
        });
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AcercaDeProgramadores.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Agregar publicacion
        if(id == R.id.btnAgregar){
            startActivity(new Intent(this, ElegirTipoPublicacion.class));
        }

    }
}