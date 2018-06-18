package com.example.edson0710.cine_ceti.model;

public class Peliculas {

    private String titulo;
    private String duracion;
    private String f_estreno;
    private String clasificacion;
    private String imagen;

    public Peliculas() {
    }

    public Peliculas(String titulo, String duracion, String f_estreno, String clasificacion, String imagen) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.f_estreno = f_estreno;
        this.clasificacion = clasificacion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getF_estreno() {
        return f_estreno;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setF_estreno(String f_estreno) {
        this.f_estreno = f_estreno;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

