package model;

public class PoderTirarBorbujas extends Poder {

    public PoderTirarBorbujas(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }

    @Override
    public void usarPoder() {
        System.out.println("El mutante lanza burbujas.");
    }
}