/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resources;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author exosh
 */
public class Pokemon {
    String nombre;
    String especie;
    Color colorType;
    String tipo1;
    String tipo2;
    String idTrainer;
    int hp;
    int atq;
    int def;
    int eat;
    int edf;
    int vel;
    String habilidad;
    String objeto;
    ImageIcon imagen;
    int nivel = 50;
    Movimiento[] movimientos = new Movimiento[4];
    public Pokemon(String idTrainer, String nombre, String especie,String tipo1, String tipo2,
                   String habilidad, String objeto,int hp, int atq, int def, int eat, int edf, int vel) {
        this.idTrainer = idTrainer;
        this.nombre = nombre;
        this.especie = especie;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.habilidad = habilidad;
        this.objeto = objeto;
        this.atq = atq;
        this.def = def;
        this.eat = eat;
        this.edf = edf;
        this.vel = vel;
        this.hp = hp;
        setColorType(tipo1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(String idTrainer) {
        this.idTrainer = idTrainer;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public int getEdf() {
        return edf;
    }

    public void setEdf(int edf) {
        this.edf = edf;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
