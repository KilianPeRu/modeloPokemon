package com.mycompany.resources;

import java.util.Random;

public class Batalla {
    static Random rand = new Random();
    static Pokemon p1;
    static Pokemon p2;
    static CompatibilidadPokemon cp = new CompatibilidadPokemon();

    public Batalla(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Pokemon getP1() {
        return p1;
    }

    public void setP1(Pokemon p1) {
        this.p1 = p1;
    }

    public Pokemon getP2() {
        return p2;
    }

    public void setP2(Pokemon p2) {
        this.p2 = p2;
    }

    public static int calculoDano(Movimiento m1, Pokemon p1, Pokemon p2) {
        int acierto = rand.nextInt(100)+1;
        if(acierto <= m1.getPrecision()){
            double bonificacion = calculoBonificacion(m1.getTipo(), p1);
            double efectividad = cp.calcularEfectividad(m1.getTipo(), p2.getTipo1().toLowerCase(), p2.getTipo2().toLowerCase());
            double rolls = 80 + rand.nextInt(21);
            int nivel = p1.getNivel();
            int ataque;
            int defensa;
            if(m1.getClase().equals("Fisico")){
                ataque = p1.getAtq();
                defensa = p2.getDef();
            }else{
                ataque = p1.getEat();
                defensa = p2.getEdf();
            }
            int poder = m1.getPoder();
            if (poder == 0){
                return 0;
            }
            double danio = 0.01 * bonificacion * efectividad * rolls * ((((0.2 * nivel + 1) * ataque * poder) / (25 * defensa)) + 2);
            return (int) danio;
        }else{
            return 0;
        }
    }

    public static double calculoBonificacion(String tipoAtaque, Pokemon p1) {
        if (p1.getTipo1().toLowerCase().equals(tipoAtaque.toLowerCase()) || p1.getTipo2().toLowerCase().equals(tipoAtaque.toLowerCase())) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    public static int ordenAtaques(Movimiento m1, Movimiento m2) {
        Random rand = new Random();
        int aleatorio = rand.nextInt(100) + 1;
        int prioridadMovimiento1 = m1.getPrioridad();
        int prioridadMovimiento2 = m2.getPrioridad();

        if (prioridadMovimiento1 > prioridadMovimiento2) {
            return 1;
        }
        if (prioridadMovimiento1 < prioridadMovimiento2) {
            return 2;
        }
        if (p1.getVel() > p2.getVel()) {
            return 1;
        }
        if (p2.getVel() > p1.getVel()) {
            return 2;
        }
        if (aleatorio > 50) {
            return 1;
        } else {
            return 2;
        }
    }
    public static Movimiento calcularMejorOpcion(Movimiento[] moves){
        int[] danoMovimientos = new int[moves.length];

        for (int i = 0; i < moves.length; i++) {
            danoMovimientos[i] = calculoDano(moves[i], p2,p1);
        }

        int maximo = danoMovimientos[0];  // Inicializamos con el primer elemento
        Movimiento opcionOptima = moves[0];
        for (int i = 1; i < danoMovimientos.length; i++) {
            if (danoMovimientos[i] > maximo) {
                opcionOptima = moves[i];
                maximo = danoMovimientos[i];  // Actualizamos si encontramos un valor mayor
            }
        }
        return opcionOptima;
    }
}
