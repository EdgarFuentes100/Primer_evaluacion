package com.example.primer_evaluacion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.primer_evaluacion.clases.Publicacion;
import java.util.ArrayList;
public class MostrarLista extends AppCompatActivity {
    private ListView lsvPublicacion;
    private Bundle bundle;
    private int idEleccion;
    private ArrayAdapter<Publicacion> arrayAdapter;
    private ArrayList<Publicacion> libros = new ArrayList<>();
    private ArrayList<Publicacion> revistas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        lsvPublicacion = findViewById(R.id.lsvPublicacion);

        if (idEleccion == 1) {
            libros.clear(); // Limpia la lista de libros antes de llenarla nuevamente
            for (Publicacion publicacion : MainActivity.lstPublicaciones) {
                if (publicacion.getTipoPublicacion() == 1) {
                    libros.add(publicacion);
                }
            }
            arrayAdapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, libros);
            lsvPublicacion.setAdapter(arrayAdapter);

        } else if (idEleccion == 2) {
            revistas.clear(); // Limpia la lista de revistas antes de llenarla nuevamente
            for (Publicacion publicacion : MainActivity.lstPublicaciones) {
                if (publicacion.getTipoPublicacion() == 2) {
                    revistas.add(publicacion);
                }
            }
            arrayAdapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, revistas);
            lsvPublicacion.setAdapter(arrayAdapter);

        } else if (idEleccion == 3) {
            arrayAdapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, MainActivity.lstPublicaciones);
            lsvPublicacion.setAdapter(arrayAdapter);
        } else {
            Toast.makeText(this, "Debe seleccionar una opción", Toast.LENGTH_SHORT).show();
        }

        lsvPublicacion.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Publicacion publicacionSelect = arrayAdapter.getItem(i);

                if (publicacionSelect != null) {
                    boolean eliminacionExitosa = MainActivity.lstPublicaciones.remove(publicacionSelect);

                    if (eliminacionExitosa) {
                        String mensaje = "Eliminada con éxito";
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();

                        // Actualiza la lista de libros o revistas si es necesario
                        if (publicacionSelect.getTipoPublicacion() == 1) {
                            libros.remove(publicacionSelect);
                        } else if (publicacionSelect.getTipoPublicacion() == 2) {
                            revistas.remove(publicacionSelect);
                        }

                        arrayAdapter.notifyDataSetChanged();
                    } else {
                        String mensaje = "No se pudo eliminar la publicación";
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    }
                }

                return true;
            }
        });
    }
}
