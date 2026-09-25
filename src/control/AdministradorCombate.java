//Eimy Vega Hidalgo 2026097911
package control;

import game.CampoBatalla;
import game.Equipo;
import java.util.List;
import model.AccionCombate;
import model.Mutante;

public class AdministradorCombate {
    private CampoBatalla campoBatalla;
    private double radioCombate;

    public AdministradorCombate(CampoBatalla campoBatalla, double radioCombate) {
        this.campoBatalla = campoBatalla;
        this.radioCombate = radioCombate;
    }
    public void buscarEncuentros(Mutante mutante) {

        Equipo equipoUno = campoBatalla.obtenerEquipoUno();
        Equipo equipoDos = campoBatalla.obtenerEquipoDos();
        List<Mutante> enemigos;

        if (mutante.obtenerEquipo() == equipoUno) {
            enemigos = equipoDos.obtenerMutantes();
        } else {
            enemigos = equipoUno.obtenerMutantes();
        }

        for (Mutante enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                double distancia = calcularDistancia(mutante, enemigo);
                if (distancia <= radioCombate &&
                    mutante.obtenerNombre().compareTo(enemigo.obtenerNombre()) < 0) {
                    ejecutarCombate(mutante, enemigo);
                }
            }
        }
    }

    public void ejecutarCombate(Mutante mutanteUno, Mutante mutanteDos) {

        AccionCombate accionUno = mutanteUno.decidirAccion();
        AccionCombate accionDos = mutanteDos.decidirAccion();

        if (accionUno == AccionCombate.ATACAR) {
            double danio = calcularDanio(mutanteUno, mutanteDos);
            if (accionDos == AccionCombate.DEFENDER) {
                danio = danio / mutanteDos.obtenerCapacidadDefensa();
            }

            boolean defensorEstabaVivo = mutanteDos.estaVivo();
            mutanteDos.recibirDanio(danio);

            if (defensorEstabaVivo && danio > 0) {
                mutanteUno.aumentarPoder();
            }
        }
        if (accionDos == AccionCombate.ATACAR &&
            mutanteUno.estaVivo()) {
            double danio = calcularDanio(mutanteDos, mutanteUno);
            if (accionUno == AccionCombate.DEFENDER) {
                danio = danio / mutanteUno.obtenerCapacidadDefensa();
            }

            boolean defensorEstabaVivo = mutanteUno.estaVivo();
            mutanteUno.recibirDanio(danio);
            if (defensorEstabaVivo && danio > 0) {
                mutanteDos.aumentarPoder();
            }
        }
    }

    public double calcularDanio(Mutante atacante, Mutante defensor) {
        return atacante.obtenerPoder().obtenerCapacidadDanio();
    }

    public double calcularDistancia(Mutante mutanteUno, Mutante mutanteDos) { //Usamos la fórmula de distancia entre dos puntos.

        double diferenciaX = mutanteUno.obtenerPosicionX()
            - mutanteDos.obtenerPosicionX();
        double diferenciaY = mutanteUno.obtenerPosicionY()
            - mutanteDos.obtenerPosicionY();
        return Math.sqrt(
            diferenciaX * diferenciaX
            + diferenciaY * diferenciaY
        );
    }
}