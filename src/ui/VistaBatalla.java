package ui;

import game.CampoBatalla;
import game.Equipo;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Mutante;

public class VistaBatalla extends JPanel implements Observador {

    private CampoBatalla campoBatalla;
    private JFrame ventana;

    public VistaBatalla(CampoBatalla campoBatalla) {
        this.campoBatalla = campoBatalla;

        ventana = new JFrame("Mutant Battle");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(this);
        ventana.setVisible(true);
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
        repaint();
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
                mutante.obtenerNombre(),
                x,
                y - 5
            );

            g.drawString(
                "E: " + (int) mutante.obtenerEnergiaActual(),
                x,
                y + 35
            );
        }
    }
}