package model;

public abstract class Poder implements IPower {
    protected int capacidadDanio;

    @Override
    public int obtenerCapacidadDanio() {
        return capacidadDanio;
    }

    @Override
    public void aumentarDanio() {
        if (capacidadDanio < 7) {
            capacidadDanio++;
        }
    }
}