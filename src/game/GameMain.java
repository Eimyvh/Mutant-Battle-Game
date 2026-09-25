//Eimy Vega Hidalgo 20206097911
package game;

import control.ControlBatalla;
import ui.ControladorInterfaz;

public class GameMain {
    public static void main(String[] args) {
        ControlBatalla controlBatalla = new ControlBatalla();
        ControladorInterfaz controlador =
            new ControladorInterfaz(controlBatalla);
        controlador.mostrarPantallaInicio();
    }
}