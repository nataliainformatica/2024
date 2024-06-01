package com.avellaneda.apprepaso;

import java.util.ArrayList;

public class DAO_contactos {

    private static ArrayList<Contacto> contactos;

   // método estático para recuperar la lista de contactos
    public static ArrayList<Contacto> getContactos(){
        if(contactos == null){
            contactos = new ArrayList<>();

    }
        return contactos;
}}
