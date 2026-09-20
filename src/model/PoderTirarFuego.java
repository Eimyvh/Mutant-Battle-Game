package model;

public class PoderTirarFuego extends Poder {

    public PoderTirarFuego(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }

    @Override
    public void usarPoder() {
        System.out.println(">>>>> ~  ~  ~  ~  ~ ");
    }
}