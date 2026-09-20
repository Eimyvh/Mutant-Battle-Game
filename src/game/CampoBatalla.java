package game;

public class CampoBatalla {

    private double ancho;
    private double alto;
    private Equipo equipoUno;
    private Equipo equipoDos;

    public CampoBatalla(double ancho, double alto, Equipo equipoUno, Equipo equipoDos) {
        this.ancho = ancho;
        this.alto = alto;
        this.equipoUno = equipoUno;
        this.equipoDos = equipoDos;
    }

    public double obtenerAncho() {
        return ancho;
    }

    public double obtenerAlto() {
        return alto;
    }

    public Equipo obtenerEquipoUno() {
        return equipoUno;
    }

    public Equipo obtenerEquipoDos() {
        return equipoDos;
    }

    public boolean terminoBatalla() {
        return equipoUno.estaDerrotado() || equipoDos.estaDerrotado();
    }

    public Equipo obtenerGanador() {
        if (equipoUno.estaDerrotado()) {
            return equipoDos;
        }
        if (equipoDos.estaDerrotado()) {
            return equipoUno;
        }
        return null; //aun no habría ganador
    }
}