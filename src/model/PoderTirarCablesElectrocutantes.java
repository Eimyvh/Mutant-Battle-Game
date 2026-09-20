package model;

public class PoderTirarCablesElectrocutantes extends Poder {

    public PoderTirarCablesElectrocutantes(int capacidadDanio) {
        this.capacidadDanio = capacidadDanio;
    }

    @Override
    public void usarPoder() {
        System.out.println(">>>>>  --{  --{  --{  --{  --{");
    }
}