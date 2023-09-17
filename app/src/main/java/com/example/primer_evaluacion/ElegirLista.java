package com.example.primer_evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ElegirLista extends AppCompatActivity {
    private RadioButton rbLibroList, rbRevistaList, rbTodos;
    private RadioGroup rgbEleccionList;

    private Button btnContinuarList;
    private Button btnContinuar;

    private Bundle bundle;

    private int idEleccion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_lista);

        btnContinuarList = findViewById(R.id.btnContinuarList);
        rgbEleccionList = findViewById(R.id.rgEleccionList);
        rbLibroList = rgbEleccionList.findViewById(R.id.rgLibroList);
        rbRevistaList = rgbEleccionList.findViewById(R.id.rbRevistaList);
        rbTodos = rgbEleccionList.findViewById(R.id.rbTodos);

        rbLibroList.setOnClickListener(v -> idEleccion = 1); // En caso de que el usuario elija libro
        rbRevistaList.setOnClickListener(v -> idEleccion = 2); // En caso de que el usuario elija revista
        rbTodos.setOnClickListener(v -> idEleccion = 3); // En caso de que el usuario elija mostrar todos

        btnContinuarList.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putInt("tipoEleccion", idEleccion);
            Intent intent = new Intent(this, MostrarLista.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}