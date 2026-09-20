package model;

import game.Equipo;

public class Mutante {

    private String nombre;
    private double energiaActual;
    private int capacidadDefensa;
    private double velocidad;
    private double posicionX;
    private double posicionY;
    private IPower poder;
    private Equipo equipo;

    public Mutante(String nombre, double energiaActual, int capacidadDefensa,
               double velocidad, double posicionX, double posicionY,
               IPower poder, Equipo equipo) {

    this.nombre = nombre;
    this.energiaActual = energiaActual;
    this.capacidadDefensa = capacidadDefensa;
    this.velocidad = velocidad;
    this.posicionX = posicionX;
    this.posicionY = posicionY;
    this.poder = poder;
    this.equipo = equipo;
    }
    public void mover() {
        posicionX += velocidad;
        posicionY += velocidad;
    }
    public void recibirDanio(double danio) {
        energiaActual -= danio;
        if (energiaActual < 0) { //para que la energía no quede negativa sino en 0.
            energiaActual = 0;
        }
    }
    public boolean estaVivo() { //boolean que nos va a permitir saber si el mutante está vivo o no
        return energiaActual > 0;
    }
    public AccionCombate decidirAccion() { //Para que el mutante pueda decidir de manera aleatoria una de las dos opciones: atacar o defender.
    if (Math.random() < 0.5) {
        return AccionCombate.ATACAR;
    }
    return AccionCombate.DEFENDER;
    }
    public void aumentarPoder() {
    poder.aumentarDanio();
    }
}