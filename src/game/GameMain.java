package game;
//Main de prueba para los avances hasta el momento.
public class GameMain {

    public static void main(String[] args) {
        Equipo equipoUno = new Equipo("Rojo", "R");
        Equipo equipoDos = new Equipo("Azul", "A");

        CampoBatalla campo = new CampoBatalla(
            100,
            100,
            equipoUno,
            equipoDos
        );

        System.out.println("Ancho del campo: " + campo.obtenerAncho());
        System.out.println("Alto del campo: " + campo.obtenerAlto());

        System.out.println("Vivos equipo 1: " + equipoUno.obtenerVivos());
        System.out.println("Vivos equipo 2: " + equipoDos.obtenerVivos());

        System.out.println("¿Terminó la batalla? " + campo.terminoBatalla());
        System.out.println("Ganador: " + campo.obtenerGanador());
    }
}
