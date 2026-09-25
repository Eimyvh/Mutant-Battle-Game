package ui;

import control.ControlBatalla;

public class ControladorInterfaz {

    private ControlBatalla controlBatalla;
    private VistaBatalla vistaBatalla;

    public ControladorInterfaz(ControlBatalla controlBatalla) {
        this.controlBatalla = controlBatalla;
    }

    public void iniciarNuevaBatalla(int tamanoEquipo) {

        controlBatalla.iniciarBatalla(tamanoEquipo);
        vistaBatalla = new VistaBatalla(
        controlBatalla.obtenerCampoBatalla(),
        this
    );
        actualizarVista();
    }

    public void actualizarVista() {
        if (vistaBatalla != null) {
            vistaBatalla.actualizar();
        }
    }

    public void reiniciarBatalla(int tamanoEquipo) {
        controlBatalla.detenerBatalla();
        iniciarNuevaBatalla(tamanoEquipo);
    }
}