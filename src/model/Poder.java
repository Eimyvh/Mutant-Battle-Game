//Eimy Vega Hidalgo 20206097911
package model;

import constants.ConstantesJuego;

public abstract class Poder implements IPower {
    protected int capacidadDanio;

    @Override
    public int obtenerCapacidadDanio() {
        return capacidadDanio;
    }
    @Override
    public void aumentarDanio() {
        if (capacidadDanio < ConstantesJuego.MAX_CAPACIDAD_DANIO) {
            capacidadDanio++;
        }
    }
}