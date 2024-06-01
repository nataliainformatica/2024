package com.avellaneda.apprepaso;

public class Contacto {
    private String nombre, apellido, password;
    private int  edad, telefono;

    public Contacto(String nombre, String apellido, String password, int edad, int telefono){
           this.nombre = nombre;
           this.apellido = apellido;
           this.password = password;
           this.edad = edad;
           this.telefono = telefono;
    }

  // constructor por defecto
    public Contacto(){
        this("", "", "", 0, 0);
    }
    // insertar getters y setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", edad=" + edad +
                ", telefono=" + telefono +
                '}';
    }
}
