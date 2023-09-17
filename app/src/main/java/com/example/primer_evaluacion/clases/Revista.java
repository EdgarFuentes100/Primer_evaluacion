package com.example.primer_evaluacion.clases;

import com.example.primer_evaluacion.interfaces.IPrestable;

public class Revista extends Publicacion {
    private int numeroRevista;

    public Revista() {}

    public Revista(int codigoPublicacion,
                   String tituloPublicacion,
                   int anioPublicacion,
                   int numeroRevista) {
        super(codigoPublicacion,
                tituloPublicacion,
                anioPublicacion);
        this.numeroRevista = numeroRevista;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    @Override
    public int getTipoPublicacion() {
        return 2;
    }

    @Override
    public String toString() {
        return "Revista [Código: " + getCodigoPublicacion() + ", Título: " + getTituloPublicacion() +
                ", Año: " + getAnioPublicacion() + ", Numero de revista: " + getNumeroRevista() + "]";
    }
}
