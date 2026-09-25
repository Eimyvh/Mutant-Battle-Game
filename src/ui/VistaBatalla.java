//Eimy Vega Hidalgo 20206097911
package ui;

import game.CampoBatalla;
import game.Equipo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import model.Mutante;

public class VistaBatalla extends JPanel implements Observador {

    private CampoBatalla campoBatalla;
    private JFrame ventana;
    private final ControladorInterfaz controlador;

    private JTextField campoTamano;
    private JButton botonIniciar;
    private JPanel panelInicio;

    private Timer temporizador;

    private boolean batallaIniciada;

    public VistaBatalla(ControladorInterfaz controlador) {

        this.controlador = controlador;
        this.batallaIniciada = false;

        crearVentana();
        mostrarPantallaInicio();
    }

    private void crearVentana() {

        ventana = new JFrame("Mutant Battle");
        ventana.setSize(1100, 750);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout());
        ventana.setVisible(true);
    }

    private void mostrarPantallaInicio() {
    panelInicio = crearPanelInicio();

    ventana.add(
        panelInicio,
        BorderLayout.CENTER
    );
    ventana.revalidate();
    ventana.repaint();
}

private JPanel crearPanelInicio() {
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );
            GradientPaint fondo = new GradientPaint(
                0,
                0,
                new Color(25, 10, 40),
                getWidth(),
                getHeight(),
                new Color(5, 35, 35)
            );
            g2.setPaint(fondo);
            g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
            );
            // Árboles sencillos del fondo
            g2.setColor(
                new Color(18, 45, 28)
            );
            for (int i = 0; i < 20; i++) {
                int x = (i * 73) % getWidth();

                g2.fillOval(
                    x - 20,
                    70,
                    65,
                    70
                );
                g2.fillRect(
                    x,
                    120,
                    15,
                    250
                );
            }
            g2.setColor(
                new Color(180, 255, 150)
            );

            g2.setFont(
                new Font(
                    "Arial",
                    Font.BOLD,
                    52
                )
            );
            String titulo = "MUTANT BATTLE";

            int anchoTitulo =
                g2.getFontMetrics()
                    .stringWidth(titulo);
            g2.drawString(
                titulo,
                (getWidth() - anchoTitulo) / 2,
                120
            );
            g2.setColor(Color.WHITE);
            g2.setFont(
                new Font(
                    "Arial",
                    Font.PLAIN,
                    20
                )
            );

            String subtitulo =
                "Prepara a tus mutantes para la batalla";
            int anchoSubtitulo =
                g2.getFontMetrics()
                    .stringWidth(subtitulo);
            g2.drawString(
                subtitulo,
                (getWidth() - anchoSubtitulo) / 2,
                160
            );
        }
    };

    panel.setLayout(null);

    JLabel etiqueta = new JLabel(
        "Tamaño de cada equipo:"
    );
    etiqueta.setForeground(Color.WHITE);
    etiqueta.setFont(
        new Font(
            "Arial",
            Font.BOLD,
            20
        )
    );
    etiqueta.setBounds(
        390,
        280,
        320,
        30
    );

    panel.add(etiqueta);
    campoTamano = new JTextField();
    campoTamano.setFont(
        new Font(
            "Arial",
            Font.BOLD,
            22
        )
    );

    campoTamano.setHorizontalAlignment(
        JTextField.CENTER
    );

    campoTamano.setBounds(
        450,
        325,
        200,
        45
    );

    panel.add(campoTamano);

    JLabel rango = new JLabel(
        "Ingrese un número entre 3 y 11"
    );
    rango.setForeground(
        new Color(210, 210, 210)
    );
    rango.setFont(
        new Font(
            "Arial",
            Font.PLAIN,
            15
        )
    );

    rango.setHorizontalAlignment(
        JLabel.CENTER
    );

    rango.setBounds(
        390,
        375,
        320,
        25
    );

    panel.add(rango);

    botonIniciar = new JButton(
        "INICIAR BATALLA"
    );

    botonIniciar.setFont(
        new Font(
            "Arial",
            Font.BOLD,
            18
        )
    );

    botonIniciar.setBounds(
        425,
        440,
        250,
        55
    );

    botonIniciar.setFocusPainted(false);

    botonIniciar.addActionListener(
        e -> iniciarDesdePantalla()
    );

    panel.add(botonIniciar);

    return panel;
}

    private void iniciarDesdePantalla() {

        String texto = campoTamano.getText().trim();

        int tamanoEquipo;

        try {

            tamanoEquipo = Integer.parseInt(texto);

        } catch (NumberFormatException e) {

            mostrarMensaje(
                "Debe ingresar un número entero."
            );

            return;
        }

        if (tamanoEquipo < 3 || tamanoEquipo > 11) {

            mostrarMensaje(
                "El tamaño debe estar entre 3 y 11."
            );

            return;
        }

        batallaIniciada = true;

        ventana.remove(panelInicio);

        controlador.iniciarNuevaBatalla(
            tamanoEquipo
        );

        ventana.revalidate();
        ventana.repaint();
    }

    private void mostrarMensaje(String mensaje) {

        javax.swing.JOptionPane.showMessageDialog(
            ventana,
            mensaje,
            "Dato inválido",
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
    }

    public void mostrarBatalla(
        CampoBatalla campoBatalla) {

        this.campoBatalla = campoBatalla;

        JPanel contenedor =
            new JPanel(new BorderLayout());

        ventana.setContentPane(contenedor);

        contenedor.add(
            this,
            BorderLayout.CENTER
        );

        JButton botonReiniciar =
            new JButton("REINICIAR BATALLA");

        botonReiniciar.setFont(
            new Font("Arial", Font.BOLD, 15)
        );

        botonReiniciar.addActionListener(
            e -> reiniciar()
        );

        ventana.add(
            botonReiniciar,
            BorderLayout.SOUTH
        );

        if (temporizador != null) {
            temporizador.stop();
        }

        temporizador = new Timer(
            100,
            e -> controlador.actualizarVista()
        );
        temporizador.start();

        ventana.revalidate();
        ventana.repaint();
    }

    private void reiniciar() {

        if (temporizador != null) {
            temporizador.stop();
        }

        controlador.detenerBatalla();

        batallaIniciada = false;
        campoBatalla = null;

        JPanel contenedor =
            new JPanel(new BorderLayout());

        ventana.setContentPane(contenedor);

        panelInicio = crearPanelInicio();

        contenedor.add(
            panelInicio,
            BorderLayout.CENTER
        );

        ventana.revalidate();
        ventana.repaint();
    }

    @Override
    public void actualizar() {

        repaint();
    }

    public void dibujarCampo() {

        repaint();
    }

    public void dibujarMutantes() {

        repaint();
    }

    public void mostrarGanador(Equipo equipo) {

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (!batallaIniciada || campoBatalla == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        dibujarFondo(g2);

        dibujarInformacion(
            g2,
            campoBatalla.obtenerEquipoUno(),
            campoBatalla.obtenerEquipoDos()
        );

        dibujarCampoBatalla(g2);

        dibujarEquipo(
            g2,
            campoBatalla.obtenerEquipoUno()
        );

        dibujarEquipo(
            g2,
            campoBatalla.obtenerEquipoDos()
        );

        if (campoBatalla.terminoBatalla()) {

            Equipo ganador =
                campoBatalla.obtenerGanador();

            if (ganador != null) {

                dibujarGanador(
                    g2,
                    ganador
                );
            }
        }
    }

    private void dibujarFondo(Graphics2D g2) {

    // Fondo oscuro del bosque
    g2.setColor(new Color(10, 25, 18));

    g2.fillRect(
        0,
        0,
        getWidth(),
        getHeight()
    );

    // Troncos de los árboles
    g2.setColor(new Color(35, 45, 32));

    for (int i = 0; i < 18; i++) {

        int x = (i * 73) % getWidth();
        int alto = 100 + (i % 4) * 30;

        g2.fillRect(
            x,
            80,
            18,
            alto
        );
    }

    // Copas de los árboles
    g2.setColor(new Color(18, 45, 28));

    for (int i = 0; i < 18; i++) {

        int x = (i * 73) % getWidth();

        g2.fillOval(
            x - 25,
            55,
            70,
            70
        );
    }

    // Algunas sombras en el suelo
    g2.setColor(new Color(5, 18, 12));

    for (int i = 0; i < 12; i++) {

        int x = (i * 91) % getWidth();
        int y = 250 + (i * 37) % 300;

        g2.fillOval(
            x,
            y,
            80,
            25
        );
    }
}
    private void dibujarInformacion(
        Graphics2D g2,
        Equipo equipoUno,
        Equipo equipoDos) {

        g2.setColor(Color.WHITE);

        g2.setFont(
            new Font("Arial", Font.BOLD, 26)
        );

        g2.drawString(
            "MUTANT BATTLE",
            30,
            40
        );

        g2.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        g2.setColor(
            new Color(255, 90, 90)
        );

        g2.drawString(
            "ROJO",
            30,
            70
        );

        g2.setColor(Color.WHITE);

        g2.drawString(
            "Vivos: " + equipoUno.obtenerVivos()
            + "   Muertos: "
            + equipoUno.obtenerMuertos(),
            90,
            70
        );

        g2.setColor(
            new Color(100, 150, 255)
        );

        g2.drawString(
            "AZUL",
            400,
            70
        );

        g2.setColor(Color.WHITE);

        g2.drawString(
            "Vivos: " + equipoDos.obtenerVivos()
            + "   Muertos: "
            + equipoDos.obtenerMuertos(),
            460,
            70
        );
    }

    private void dibujarCampoBatalla(Graphics2D g2) {

    // No se dibuja un marco de campo.
    // Toda la ventana representa el bosque.

    // Suelo oscuro
    g2.setColor(new Color(12, 28, 18));

    g2.fillRect(
        0,
        100,
        getWidth(),
        getHeight() - 100
    );

    // Pequeñas sombras y vegetación
    g2.setColor(new Color(8, 20, 12));

    for (int i = 0; i < 25; i++) {

        int x = (i * 67) % getWidth();
        int y = 150 + (i * 43) % 450;

        g2.fillOval(
            x,
            y,
            70,
            20
        );
    }
}

    private void dibujarEquipo(
    Graphics2D g2,
    Equipo equipo) {

    for (Mutante mutante :
        equipo.obtenerMutantes()) {

        if (!mutante.estaVivo()) {
            continue;
        }

        int margenIzquierdo = 30;
        int margenDerecho = 30;

        int margenSuperior = 120;
        int margenInferior = 100;

        int ancho = getWidth()
            - margenIzquierdo
            - margenDerecho;

        int alto = getHeight()
            - margenSuperior
            - margenInferior;

        int x = margenIzquierdo
            + (int) (
                mutante.obtenerPosicionX()
                / 100.0 * ancho
            );

        int y = margenSuperior
            + (int) (
                mutante.obtenerPosicionY()
                / 100.0 * alto
            );

        dibujarMutante(
            g2,
            mutante,
            equipo,
            x,
            y
        );
    }
}

    private void dibujarMutante(
    Graphics2D g2,
    Mutante mutante,
    Equipo equipo,
    int x,
    int y) {

    int tamano = 30;

    Color color;

    if (equipo ==
        campoBatalla.obtenerEquipoUno()) {

        color = new Color(190, 60, 60);

    } else {

        color = new Color(70, 110, 200);
    }

    // Cuerpo del mutante
    g2.setColor(color);

    g2.fillOval(
        x,
        y,
        tamano,
        tamano
    );

    // Único ojo
    g2.setColor(Color.WHITE);

    g2.fillOval(
        x + 9,
        y + 6,
        12,
        12
    );

    // Pupila
    g2.setColor(Color.BLACK);

    g2.fillOval(
        x + 13,
        y + 9,
        5,
        5
    );

    // Brazo izquierdo
    g2.setColor(color);

    g2.drawLine(
        x,
        y + 17,
        x - 10,
        y + 22
    );

    // Mano izquierda
    g2.fillOval(
        x - 14,
        y + 19,
        8,
        8
    );

    // Brazo derecho
    g2.drawLine(
        x + tamano,
        y + 17,
        x + tamano + 10,
        y + 22
    );

    // Mano derecha
    g2.fillOval(
        x + tamano + 6,
        y + 19,
        8,
        8
    );

    // Nombre
    g2.setFont(
        new Font(
            "Arial",
            Font.BOLD,
            11
        )
    );

    g2.setColor(Color.WHITE);

    g2.drawString(
        mutante.obtenerNombre(),
        x - 10,
        y + 45
    );

    // Barra de energía
    int energia =
        (int) mutante.obtenerEnergiaActual();

    g2.setColor(Color.DARK_GRAY);

    g2.fillRect(
        x - 5,
        y + 50,
        40,
        6
    );

    g2.setColor(
        new Color(80, 200, 90)
    );

    int anchoEnergia =
        (int) (40 * energia / 100.0);

    g2.fillRect(
        x - 5,
        y + 50,
        anchoEnergia,
        6
    );

    g2.setColor(Color.WHITE);

    g2.setFont(
        new Font(
            "Arial",
            Font.PLAIN,
            10
        )
    );

    g2.drawString(
        "E: " + energia,
        x - 5,
        y + 68
    );
}

    private void dibujarGanador(
        Graphics2D g2,
        Equipo ganador) {

        int ancho = 430;
        int alto = 130;

        int x =
            (getWidth() - ancho) / 2;

        int y =
            (getHeight() - alto) / 2;

        g2.setColor(
            new Color(0, 0, 0, 190)
        );

        g2.fillRoundRect(
            x,
            y,
            ancho,
            alto,
            30,
            30
        );

        g2.setColor(
            new Color(180, 255, 150)
        );

        g2.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                30
            )
        );

        String texto =
            "GANADOR: EQUIPO "
            + ganador.obtenerColor().toUpperCase();

        int anchoTexto =
            g2.getFontMetrics()
                .stringWidth(texto);

        g2.drawString(
            texto,
            x + (ancho - anchoTexto) / 2,
            y + 65
        );

        g2.setColor(Color.WHITE);

        g2.setFont(
            new Font(
                "Arial",
                Font.PLAIN,
                16
            )
        );

        String mensaje =
            "La batalla ha terminado";

        int anchoMensaje =
            g2.getFontMetrics()
                .stringWidth(mensaje);

        g2.drawString(
            mensaje,
            x + (ancho - anchoMensaje) / 2,
            y + 95
        );
    }
}