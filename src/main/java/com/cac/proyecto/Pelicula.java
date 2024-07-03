package com.cac.proyecto;

public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String fechaEstreno;
    private String genero;
    private String duracion;
    private String director;
    private String reparto;
    private String sinopsis;
    private String imagen;

    public Pelicula(){}

    public Pelicula(int idPelicula,String titulo,String fechaEstreno,String genero,String duracion,String director,String reparto,String sinopsis ,String imagen){
        this.idPelicula=idPelicula;
        this.titulo=titulo;
        this.fechaEstreno=fechaEstreno;
        this.genero=genero;
        this.duracion=duracion;
        this.director=director;
        this.reparto=reparto;
        this.sinopsis=sinopsis;
        this.imagen = imagen;
    }

    public int getIdPelicula(){
        return idPelicula;
    }

    public String getTitulo(){
        return titulo;
    }
    public String getFechaEstreno(){
        return fechaEstreno;
    }

    public String getGenero(){
        return genero;
    }
    public String getDuracion(){
        return duracion;
    }

    public String getDirector(){
        return director;
    }
    public String getReparto(){
        return reparto;
    }

    public String getSinopsis(){
        return sinopsis;
    }
    public String getImagen(){
        return imagen;
    }

    public void setTitulo( String titulo){
        this.titulo = titulo;
    }

    public void setFechaEstreno( String fechaEstreno){
        this.fechaEstreno = fechaEstreno;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setDuracion(String duracion){
        this.duracion = duracion;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setReparto(String reparto){
        this.reparto = reparto;
    }

    public void setSinopsis(String sinopsis){
        this.sinopsis = sinopsis;
    }

    public void setImagen(String imagen){
        this.imagen= imagen;
    }

    @Override
    public String toString(){
        return "Pelicula{"+"idPelicula= "+idPelicula+" titulo= "+titulo+" fechaEstreno= "+fechaEstreno+" genero= "+genero+" duracion= "+ duracion +" director= " +director+" reparto "+reparto+" sinopsis= "+sinopsis+"imagen="+imagen+"}";
    }


}
