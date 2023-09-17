package com.example.primer_evaluacion;

import static com.example.primer_evaluacion.MainActivity.lstPublicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primer_evaluacion.clases.Libro;
import com.example.primer_evaluacion.clases.Revista;

public class AgregarPublicacion extends AppCompatActivity {

    private EditText edtCodigoPub, edtTituloPub, edtAnioPub, edtNumRev;
    private Button btnProcesar;

    private Bundle bundle;

    private int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_publicacion);

        edtCodigoPub = findViewById(R.id.edtCodigo);
        edtTituloPub = findViewById(R.id.edtTitulo);
        edtAnioPub = findViewById(R.id.edtAnioPublicacion);
        edtNumRev = findViewById(R.id.edtNumeroRevista);
        btnProcesar = findViewById(R.id.btnProcesar);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            // Es libro
            edtNumRev.setVisibility(View.GONE);
        }

        btnProcesar.setOnClickListener(v -> {

            if(edtNumRev.getText().toString().isEmpty()){ // Se valida que el numero de revista contega valor
                // Se trata de un libro, agregar instancia anonima de clase.
                lstPublicaciones.add(
                        new Libro(
                                Integer.valueOf(edtCodigoPub.getText().toString()),
                                edtTituloPub.getText().toString(),
                                Integer.valueOf(edtAnioPub.getText().toString()),
                                        false));
            } else {
                lstPublicaciones.add(
                        new Revista(
                                Integer.valueOf(edtCodigoPub.getText().toString()),
                                edtTituloPub.getText().toString(),
                                Integer.valueOf(edtAnioPub.getText().toString()),
                                Integer.valueOf(edtNumRev.getText().toString())
                        )
                );
            }

            // Una vez insertado el registro, se puede mostrar una alerta y sacar de la pila a la actvidad
            new AlertDialog.Builder(this).setMessage("Insertado con éxito")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();

        });
    }

}