package com.example.myapplication.Wraper;

public class Pelicula {
    private String titulo;
    private String descripcion;
    private float valoracion;

    public Pelicula(String titulo, String descripcion, float valoracion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
}
