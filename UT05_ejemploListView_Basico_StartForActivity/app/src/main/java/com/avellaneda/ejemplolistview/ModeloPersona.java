package com.avellaneda.ejemplolistview;

public class ModeloPersona {

    private String nombre;
    private String descripcion;
    private int codigo;
    private int foto;

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre){

        this.nombre=nombre;

    }

    public String getDescripcion() {

        return descripcion;

    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }


    public int getCodigo() {

        return codigo;

    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;

    }

    public int getFoto() {

        return foto;

    }



    public void setFoto(int foto) {

        this.foto = foto;

    }

}