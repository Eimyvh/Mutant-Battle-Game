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
}