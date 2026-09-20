package model;

public class PoderTirarFlechas extends Poder {

    public PoderTirarFlechas(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }

    @Override
    public void usarPoder() {
        System.out.println("El mutante lanza flechas.");
    }
}