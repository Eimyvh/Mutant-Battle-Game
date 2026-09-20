package control;

import game.CampoBatalla;

public class AdministradorCombate {
    private CampoBatalla campoBatalla;
    private double radioCombate;

    public AdministradorCombate(CampoBatalla campoBatalla, double radioCombate) {
        this.campoBatalla = campoBatalla;
        this.radioCombate = radioCombate;
    }
}