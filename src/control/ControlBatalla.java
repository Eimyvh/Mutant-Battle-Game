package control;

import constants.ConstantesJuego;
import game.CampoBatalla;
import game.Equipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.IPower;
import model.Mutante;
import model.PoderTirarBorbujas;
import model.PoderTirarCablesElectrocutantes;
import model.PoderTirarFlechas;
import model.PoderTirarFuego;
import model.PoderTirarNieve;

public class ControlBatalla {
    private CampoBatalla campoBatalla;
    private AdministradorCombate administradorCombate;
    private List<HiloMutante> hilosMutantes;

    public ControlBatalla() {
        this.hilosMutantes = new ArrayList<>();
    }

    public void crearEquipos(int tamanoEquipo) {
        if (tamanoEquipo < ConstantesJuego.MIN_MUTANTES_EQUIPO ||
            tamanoEquipo > ConstantesJuego.MAX_MUTANTES_EQUIPO) {

            throw new IllegalArgumentException(
                "El tamaño del equipo debe estar entre "
                + ConstantesJuego.MIN_MUTANTES_EQUIPO
                + " y "
                + ConstantesJuego.MAX_MUTANTES_EQUIPO
                + " mutantes."
            );
        }

        Equipo equipoUno = new Equipo("Rojo", "R");
        Equipo equipoDos = new Equipo("Azul", "A");
        campoBatalla = new CampoBatalla(
            100, //Temporalmente usaremos esta config. donde el campo es 100x100
            100,
            equipoUno,
            equipoDos
        );
        administradorCombate = new AdministradorCombate(
            campoBatalla,
            ConstantesJuego.RADIO_COMBATE
        );
        Random random = new Random();
        for (int i = 1; i <= tamanoEquipo; i++) {
            int danioUno = random.nextInt(
                ConstantesJuego.MAX_CAPACIDAD_DANIO_INICIAL
                - ConstantesJuego.MIN_CAPACIDAD_DANIO + 1
            ) + ConstantesJuego.MIN_CAPACIDAD_DANIO;

            int numeroPoder = random.nextInt(5);

            IPower poderUno;

            switch (numeroPoder) {
                case 0:
                    poderUno = new PoderTirarBorbujas(danioUno);
                    break;

                case 1:
                    poderUno = new PoderTirarCablesElectrocutantes(danioUno);
                    break;

                case 2:
                    poderUno = new PoderTirarFlechas(danioUno);
                    break;

                case 3:
                    poderUno = new PoderTirarFuego(danioUno);
                    break;

                default:
                    poderUno = new PoderTirarNieve(danioUno);
                    break;
            }

            int defensaUno = random.nextInt(
                ConstantesJuego.MAX_CAPACIDAD_DEFENSA
                - ConstantesJuego.MIN_CAPACIDAD_DEFENSA + 1
            ) + ConstantesJuego.MIN_CAPACIDAD_DEFENSA;

            double velocidadUno = ConstantesJuego.VELOCIDAD_MINIMA
                + random.nextDouble() * (
                    ConstantesJuego.VELOCIDAD_MAXIMA
                    - ConstantesJuego.VELOCIDAD_MINIMA
                );

            double posicionXUno = random.nextDouble()
                * ConstantesJuego.ANCHO_CAMPO;

            double posicionYUno = random.nextDouble()
                * ConstantesJuego.ALTO_CAMPO;

            Mutante mutanteUno = new Mutante(
                "Mutante Rojo " + i,
                ConstantesJuego.ENERGIA_INICIAL,
                defensaUno,
                velocidadUno,
                posicionXUno,
                posicionYUno,
                poderUno,
                equipoUno
            );

            equipoUno.agregarMutante(mutanteUno);

            int danioDos = random.nextInt(
                ConstantesJuego.MAX_CAPACIDAD_DANIO_INICIAL
                - ConstantesJuego.MIN_CAPACIDAD_DANIO + 1
            ) + ConstantesJuego.MIN_CAPACIDAD_DANIO;

            int numeroPoderDos = random.nextInt(5);

            IPower poderDos;

            switch (numeroPoderDos) {
                case 0:
                    poderDos = new PoderTirarBorbujas(danioDos);
                    break;

                case 1:
                    poderDos = new PoderTirarCablesElectrocutantes(danioDos);
                    break;

                case 2:
                    poderDos = new PoderTirarFlechas(danioDos);
                    break;

                case 3:
                    poderDos = new PoderTirarFuego(danioDos);
                    break;

                default:
                    poderDos = new PoderTirarNieve(danioDos);
                    break;
            }

            int defensaDos = random.nextInt(
                ConstantesJuego.MAX_CAPACIDAD_DEFENSA
                - ConstantesJuego.MIN_CAPACIDAD_DEFENSA + 1
            ) + ConstantesJuego.MIN_CAPACIDAD_DEFENSA;

            double velocidadDos = ConstantesJuego.VELOCIDAD_MINIMA
                + random.nextDouble() * (
                    ConstantesJuego.VELOCIDAD_MAXIMA
                    - ConstantesJuego.VELOCIDAD_MINIMA
                );

            double posicionXDos = random.nextDouble()
                * ConstantesJuego.ANCHO_CAMPO;

            double posicionYDos = random.nextDouble()
                * ConstantesJuego.ALTO_CAMPO;

            Mutante mutanteDos = new Mutante(
                "Mutante Azul " + i,
                ConstantesJuego.ENERGIA_INICIAL,
                defensaDos,
                velocidadDos,
                posicionXDos,
                posicionYDos,
                poderDos,
                equipoDos
            );

            equipoDos.agregarMutante(mutanteDos);
        }
    }
    public void iniciarBatalla(int tamanoEquipo) {
        crearEquipos(tamanoEquipo);
        iniciarHilos();
    }
    public void iniciarHilos() {
        hilosMutantes.clear();

        for (Mutante mutante : campoBatalla.obtenerEquipoUno().obtenerMutantes()) {
            HiloMutante hilo = new HiloMutante(
                mutante,
                campoBatalla,
                administradorCombate
            );
            hilosMutantes.add(hilo);
            hilo.start();
        }

        for (Mutante mutante : campoBatalla.obtenerEquipoDos().obtenerMutantes()) {
            HiloMutante hilo = new HiloMutante(
                mutante,
                campoBatalla,
                administradorCombate
            );
            hilosMutantes.add(hilo);
            hilo.start();
        }
    }
    public void detenerBatalla() {
        for (HiloMutante hilo : hilosMutantes) {
            hilo.interrupt();
        }
    }
    public boolean terminoBatalla() {
        return campoBatalla != null && campoBatalla.terminoBatalla();
    }
}
