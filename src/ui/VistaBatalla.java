package ui;

import game.CampoBatalla;
import game.Equipo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Mutante;

public class VistaBatalla extends JPanel implements Observador {

    private CampoBatalla campoBatalla;
    private JFrame ventana;

    public VistaBatalla(
    CampoBatalla campoBatalla,
    ControladorInterfaz controlador) {
        this.campoBatalla = campoBatalla;

        ventana = new JFrame("Mutant Battle");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        JButton botonReiniciar = new JButton("Reiniciar batalla");

        botonReiniciar.addActionListener(e -> {
            ventana.dispose();
            int tamanoEquipo =
                campoBatalla.obtenerEquipoUno().obtenerMutantes().size();

            controlador.reiniciarBatalla(tamanoEquipo);
        });

        ventana.add(this, BorderLayout.CENTER);
        ventana.add(botonReiniciar, BorderLayout.SOUTH);

        ventana.setVisible(true);

        Timer temporizador = new Timer(100, e -> actualizar());
        temporizador.start();
    }

    public void dibujarCampo() {
        repaint();
    }

    public void dibujarMutantes() {
        repaint();
    }

    @Override
    public void actualizar() {
        repaint();
    }

    public void mostrarGanador(Equipo equipo) {
        // El ganador se muestra desde paintComponent().
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawString("MUTANT BATTLE", 20, 30);

        dibujarEquipo(g, campoBatalla.obtenerEquipoUno());
        dibujarEquipo(g, campoBatalla.obtenerEquipoDos());

        g.setColor(Color.BLACK);

        g.drawString(
            "Rojo - Vivos: "
            + campoBatalla.obtenerEquipoUno().obtenerVivos()
            + " Muertos: "
            + campoBatalla.obtenerEquipoUno().obtenerMuertos(),
            20,
            50
        );

        g.drawString(
            "Azul - Vivos: "
            + campoBatalla.obtenerEquipoDos().obtenerVivos()
            + " Muertos: "
            + campoBatalla.obtenerEquipoDos().obtenerMuertos(),
            20,
            70
        );

        if (campoBatalla.terminoBatalla()) {

            Equipo ganador = campoBatalla.obtenerGanador();

            if (ganador != null) {
                g.setColor(Color.BLACK);

                g.drawString(
                    "GANADOR: Equipo "
                    + ganador.obtenerColor(),
                    20,
                    100
                );
            }
        }
    }

    private void dibujarEquipo(Graphics g, Equipo equipo) {

        for (Mutante mutante : equipo.obtenerMutantes()) {

            if (!mutante.estaVivo()) {
                continue;
            }

            int x = (int) (mutante.obtenerPosicionX() * 6);
            int y = (int) (mutante.obtenerPosicionY() * 5);

            if (equipo == campoBatalla.obtenerEquipoUno()) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }

            g.fillOval(x, y, 20, 20);

            g.setColor(Color.BLACK);

            g.drawString(
                equipo.obtenerSimbolo(),
                x + 7,
                y - 8
            );

            g.drawString(
                mutante.obtenerNombre(),
                x,
                y + 35
            );

            g.drawString(
                "E: "
                + (int) mutante.obtenerEnergiaActual(),
                x,
                y + 50
            );
        }
    }
}