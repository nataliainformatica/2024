package com.avellaneda.myapplication;
import java.util.*;

/**
 * Aries: 21 de marzo - 19 de abril
 * Tauro: 20 de abril - 20 de mayo
 * Géminis: 21 de mayo - 20 de junio
 * Cáncer: 21 de junio - 22 de julio
 * Leo: 23 de julio - 22 de agosto
 * Virgo: 23 de agosto - 22 de septiembre
 * Libra: 23 de septiembre - 22 de octubre
 * Escorpio: 23 de octubre - 21 de noviembre
 * Sagitario: 22 de noviembre - 21 de diciembre
 * Capricornio: 22 de diciembre - 19 de enero
 * Acuario: 20 de enero - 18 de febrero
 * Piscis: 19 de febrero - 20 de marzo
 */
public class SignoZodiaco {
    public static int signo( int mes, int dia) {

        // Determinar el signo del zodiaco
        int signo = determinarSignoZodiacoNumero(dia, mes);

        // Mostrar el resultado
       // System.out.println("El signo del zodiaco es: " + signo);
        return signo;
    }


    public static String descripcionSigno(int miSigno){

        String[] caracteristicas = {

                "Capricornio: Capricornio es un signo de tierra y se destaca por ser ambicioso, responsable y disciplinado.",
                "Acuario: Acuario es un signo de aire y se caracteriza por ser original, independiente y humanitario.",
                "Piscis: Piscis es un signo de agua y se destaca por ser compasivo, soñador y creativo.", "Aries: Aries es un signo de fuego y se caracteriza por ser enérgico, impulsivo y aventurero.",
                "Tauro: Tauro es un signo de tierra y se destaca por ser paciente, confiable y amante del lujo.",
                "Géminis: Géminis es un signo de aire y se caracteriza por ser curioso, comunicativo y versátil.",
                "Cáncer: Cáncer es un signo de agua y se destaca por ser emocional, intuitivo y protector.",
                "Leo: Leo es un signo de fuego y se caracteriza por ser carismático, orgulloso y apasionado.",
                "Virgo: Virgo es un signo de tierra y se destaca por ser analítico, perfeccionista y servicial.",
                "Libra: Libra es un signo de aire y se caracteriza por ser equitativo, sociable y amante de la belleza.",
                "Escorpio: Escorpio es un signo de agua y se destaca por ser intenso, misterioso y apasionado.",
                "Sagitario: Sagitario es un signo de fuego y se caracteriza por ser aventurero, optimista y libre.",
        };
        return caracteristicas[miSigno];
    }
    // Función para determinar el signo del zodiaco
    public static String determinarSignoZodiaco(int dia, int mes) {
        String[] signos = {
                "Capricornio", "Acuario", "Piscis", "Aries", "Tauro", "Géminis",
                "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario"
        };

        int[] limiteFechas = {
                20, 19, 20, 20, 21, 21,
                22, 22, 23, 23, 22, 21
        };

        // Determinar el índice del signo del zodiaco en función del mes y día
        int indice = mes ;
        if (dia >= limiteFechas[mes - 1]) {
            indice = (mes % 12);
        }

        return signos[indice];
    }
    public static int determinarSignoZodiacoNumero(int dia, int mes) {
       /* String[] signos = {
                "Capricornio", "Acuario", "Piscis", "Aries", "Tauro", "Géminis",
                "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario"
        };*/

        int[] limiteFechas = {
                20, 19, 20, 20, 21, 21,
                22, 22, 23, 23, 22, 21
        };

        // Determinar el índice del signo del zodiaco en función del mes y día
        int indice = mes-1;
        if (dia >= limiteFechas[mes-1]) {
            indice = (mes % 12);
        }

        return indice;
    }
}
