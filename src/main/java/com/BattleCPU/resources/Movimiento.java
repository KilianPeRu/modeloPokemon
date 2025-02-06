package com.BattleCPU.resources;

import java.awt.*;

public class Movimiento {
    String Nombre;
    int Prioridad;
    int Poder;
    int Precision;
    String Tipo;
    int PP;
    String Clase;
    public Color colorType;

    public Movimiento(String Nombre, int Prioridad, int Poder, int Precision, String Tipo, int PP, String Clase) {
        this.Nombre = Nombre;
        this.Prioridad = Prioridad;
        this.Poder = Poder;
        this.Precision = Precision;
        this.Tipo = Tipo;
        this.PP = PP;
        this.Clase = Clase;
        setColorType(Tipo);
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
    public void setColorType(String colores){
        switch (colores){
            case "Normal":
                this.colorType = new Color(209, 209, 209);
                break;
            case "Fuego":
                this.colorType = new Color(255, 63, 63);
                break;
            case "Agua":
                this.colorType = new Color(84, 84, 255);
                break;
            case "Planta":
                this.colorType = new Color(69, 163, 47);
                break;
            case "Electrico":
                this.colorType = new Color(255, 255, 0);
                break;
            case "Acero":
                this.colorType = new Color(126, 131, 131);
                break;
            case "Bicho":
                this.colorType = new Color(115, 163, 83);
                break;
            case "Dragon":
                this.colorType = new Color(9, 33, 165);
                break;
            case "Fantasma":
                this.colorType = new Color(99, 52, 143);
                break;
            case "Hada":
                this.colorType = new Color(250, 110, 255);
                break;
            case "Hielo":
                this.colorType = new Color(123, 242, 255);
                break;
            case "Lucha":
                this.colorType = new Color(255, 112, 112);
                break;
            case "Psiquico":
                this.colorType = new Color(240, 165, 255);
                break;
            case "Roca":
                this.colorType = new Color(117, 72, 41);
                break;
            case "Siniestro":
                this.colorType = new Color(25, 25, 25);
                break;
            case "Tierra":
                this.colorType = new Color(223, 138, 81);
                break;
            case "Veneno":
                this.colorType = new Color(101, 5, 136);
                break;
            case "Volador":
                this.colorType = new Color(226, 255, 252);
                break;
            default:
                this.colorType = new Color(255, 255, 255);
                break;
        }
    }
    public Color getColorType() {
        return colorType;
    }

}
