package com.mycompany.resources;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CompatibilidadPokemon {
    // Carga la compatibilidad desde el archivo JSON
    static JSONObject compatibilidad = cargarCompatibilidad("src/main/java/com/mycompany/resources/compatibilidad.json");

    // Método para cargar la compatibilidad desde un archivo JSON
    public static JSONObject cargarCompatibilidad(String archivo) {
        try {
            // Lee el contenido del archivo JSON como String
            String contenido = new String(Files.readAllBytes(Paths.get(archivo)));
            // Convierte el contenido a un objeto JSONObject
            return new JSONObject(contenido).getJSONObject("tipos");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para calcular la efectividad
    public static double calcularEfectividad(String tipoAtaque, String tipoDefensor, String tipoDefensor2) {
        double v1, v2, total;

        // Si tipoDefensor es null, se considera como efectividad neutral (1.0)
        if (tipoDefensor == null) {
            v1 = 1.0;
        } else if (!compatibilidad.has(tipoDefensor)) {
            // Si el tipo del defensor no está en la lista, también se considera neutral (1.0)
            v1 = 1.0;
        } else {
            // Obtiene la información del tipo defensor desde el JSON
            JSONObject infoDefensor = compatibilidad.getJSONObject(tipoDefensor);

            // Verifica la efectividad del ataque contra el tipo defensor
            if (contiene(infoDefensor, "inmunidad", tipoAtaque)) {
                v1 = 0.0;  // Ataque es inmunizado
            } else if (contiene(infoDefensor, "debilidades", tipoAtaque)) {
                v1 = 2.0;  // Ataque es súper efectivo
            } else if (contiene(infoDefensor, "fortalezas", tipoAtaque)) {
                v1 = 0.5;  // Ataque es poco efectivo
            } else {
                v1 = 1.0;  // Ataque es neutral
            }
        }

        // Si tipoDefensor2 es null, se considera como efectividad neutral (1.0)
        if (tipoDefensor2 == null) {
            v2 = 1.0;
        } else if (!compatibilidad.has(tipoDefensor2)) {
            // Si el tipo del defensor no está en la lista, también se considera neutral (1.0)
            v2 = 1.0;
        } else {
            // Obtiene la información del segundo tipo defensor desde el JSON
            JSONObject infoDefensor2 = compatibilidad.getJSONObject(tipoDefensor2);

            // Verifica la efectividad del ataque contra el segundo tipo defensor
            if (contiene(infoDefensor2, "inmunidad", tipoAtaque)) {
                v2 = 0.0;  // Ataque es inmunizado
            } else if (contiene(infoDefensor2, "debilidades", tipoAtaque)) {
                v2 = 2.0;  // Ataque es súper efectivo
            } else if (contiene(infoDefensor2, "fortalezas", tipoAtaque)) {
                v2 = 0.5;  // Ataque es poco efectivo
            } else {
                v2 = 1.0;  // Ataque es neutral
            }
        }
        // Calcula el valor total de efectividad multiplicando los valores de cada defensor
        total = v1 * v2;
        return total;
    }

    // Método auxiliar para verificar si un tipo de ataque está en una lista específica
    public static boolean contiene(JSONObject info, String key, String tipo) {
        if (!info.has(key)) {
            return false;
        }
        JSONArray lista = info.getJSONArray(key);
        for (int i = 0; i < lista.length(); i++) {
            if (lista.getString(i).equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}