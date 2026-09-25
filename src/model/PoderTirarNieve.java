//Eimy Vega Hidalgo 20206097911
package model;

public class PoderTirarNieve extends Poder {

    public PoderTirarNieve(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }
    @Override
    public void usarPoder() {
        System.out.println(">>>>>  *  *  *  *  *  ");
    }
}