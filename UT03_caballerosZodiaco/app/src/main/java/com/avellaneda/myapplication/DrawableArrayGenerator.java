package com.avellaneda.myapplication;
import java.lang.reflect.Field;

public class DrawableArrayGenerator {
    public static void main(String[] args) {
        Class<?> drawableClass = R.drawable.class;
        Field[] fields = drawableClass.getDeclaredFields();

        int[] drawableIds = new int[fields.length];

        for (int i = 0; i < fields.length; i++) {
            try {
                drawableIds[i] = fields[i].getInt(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Ahora, drawableIds contiene las referencias a todos los recursos en la carpeta drawable
        for (int id : drawableIds) {
            System.out.println("ID de recurso drawable: " + id);
        }
    }
}