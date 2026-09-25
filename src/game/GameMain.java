package game;

import control.ControlBatalla;
import java.util.Scanner;
import ui.ControladorInterfaz;

public class GameMain {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int tamanoEquipo;

        do {
            System.out.print("Ingrese el tamaño de los equipos (3-11): ");
            tamanoEquipo = entrada.nextInt();

            if (tamanoEquipo < 3 || tamanoEquipo > 11) {
                System.out.println("El tamaño debe estar entre 3 y 11.");
            }

        } while (tamanoEquipo < 3 || tamanoEquipo > 11);

        ControlBatalla controlBatalla = new ControlBatalla();

        ControladorInterfaz controlador =
            new ControladorInterfaz(controlBatalla);

        controlador.iniciarNuevaBatalla(tamanoEquipo);

        entrada.close();
    }
}
