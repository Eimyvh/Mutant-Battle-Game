package model;

public class ModelMain {

    public static void main(String[] args) {

        PoderTirarFuego poder = new PoderTirarFuego(2);

        Mutante mutante = new Mutante(
    "Mutante 1",
    100,
    2,
    1,
    1,
    0,
    10,
    10,
    poder,
    null
);

        System.out.println("¿Está vivo? " + mutante.estaVivo());

        mutante.recibirDanio(25);

        System.out.println("¿Está vivo después del daño? "
                + mutante.estaVivo());

        System.out.println("Daño del poder: "
                + poder.obtenerCapacidadDanio());

        mutante.aumentarPoder();

        System.out.println("Daño del poder después de aumentar: "
                + poder.obtenerCapacidadDanio());

        poder.usarPoder();
    }
}
