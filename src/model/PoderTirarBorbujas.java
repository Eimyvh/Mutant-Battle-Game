//Eimy Vega Hidalgo 20206097911
package model;

public class PoderTirarBorbujas extends Poder {
    public PoderTirarBorbujas(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }

    @Override
    public void usarPoder() {
        System.out.println(">>>>> (°)  (°)  (°)  (°)  (°) ");
    }
}