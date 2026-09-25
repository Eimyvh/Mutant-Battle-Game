//Eimy Vega Hidalgo 20206097911
package ui;

import control.ControlBatalla;
import java.util.ArrayList;
import java.util.List;

public class ControladorInterfaz {

    private final ControlBatalla controlBatalla;
    private VistaBatalla vistaBatalla;
    private List<Observador> observadores;

    public ControladorInterfaz(ControlBatalla controlBatalla) {
        this.controlBatalla = controlBatalla;
        this.observadores = new ArrayList<>();
    }

    public void mostrarPantallaInicio() {
        vistaBatalla = new VistaBatalla(this);
        registrarObservador(vistaBatalla);
    }

    public void iniciarNuevaBatalla(int tamanoEquipo) {

        controlBatalla.iniciarBatalla(tamanoEquipo);

        vistaBatalla.mostrarBatalla(
            controlBatalla.obtenerCampoBatalla()
        );
    }

    public void actualizarVista() {
        notificarObservadores();
    }

    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }
    public void detenerBatalla() {
        controlBatalla.detenerBatalla();
    }

    public void reiniciarBatalla(int tamanoEquipo) {

        controlBatalla.detenerBatalla();

        iniciarNuevaBatalla(tamanoEquipo);
    }
}