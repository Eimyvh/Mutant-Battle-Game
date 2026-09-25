package control;

import game.CampoBatalla;
import model.Mutante;

public class HiloMutante extends Thread {
    private Mutante mutante;
    private CampoBatalla campoBatalla;
    private AdministradorCombate administradorCombate;

    public HiloMutante(Mutante mutante, CampoBatalla campoBatalla, AdministradorCombate administradorCombate) {
        this.mutante = mutante;
        this.campoBatalla = campoBatalla;
        this.administradorCombate = administradorCombate;
    }


@Override
public void run() { 

    while (mutante.estaVivo() && !campoBatalla.terminoBatalla()) {
        mutante.mover();

        double y = mutante.obtenerPosicionY();

        if (Math.random() < 0.1) {
            y += (Math.random() < 0.5 ? -1 : 1) * mutante.obtenerEnergiaActual() * 0.02;
        }

        mutante.establecerPosicion(
            mutante.obtenerPosicionX(),
            y
        );

        controlarLimites();
        administradorCombate.buscarEncuentros(mutante);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            break;
        }
    }
}
private void controlarLimites() {

        double x = mutante.obtenerPosicionX();
        double y = mutante.obtenerPosicionY();

        if (x >= campoBatalla.obtenerAncho() || x <= 0) {
            mutante.invertirDireccionX();
        }

        if (y >= campoBatalla.obtenerAlto() || y <= 0) {
            mutante.invertirDireccionY();
        }
        mutante.establecerPosicion(x, y);
    }
}