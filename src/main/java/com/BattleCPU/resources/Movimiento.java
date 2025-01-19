package com.BattleCPU.resources;

public class Movimiento {
    String Nombre;
    int Prioridad;
    int Poder;
    int Precision;
    String Tipo;
    int PP;
    String Clase;

    public Movimiento(String Nombre, int Prioridad, int Poder, int Precision, String Tipo, int PP, String Clase) {
        this.Nombre = Nombre;
        this.Prioridad = Prioridad;
        this.Poder = Poder;
        this.Precision = Precision;
        this.Tipo = Tipo;
        this.PP = PP;
        this.Clase = Clase;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getPrecision() {
        return Precision;
    }

    public void setPrecision(int precision) {
        Precision = precision;
    }

    public int getPoder() {
        return Poder;
    }

    public void setPoder(int poder) {
        Poder = poder;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(int prioridad) {
        Prioridad = prioridad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getClase() {
        return Clase;
    }

    public void setClase(String clase) {
        Clase = clase;
    }
}
