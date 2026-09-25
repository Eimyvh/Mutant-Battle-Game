//Eimy Vega Hidalgo 20206097911
package model;

public class PoderTirarFlechas extends Poder {

    public PoderTirarFlechas(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }
    @Override
    public void usarPoder() {
        System.out.println(">>>>>  -->  -->  -->  -->  -->");
    }
}