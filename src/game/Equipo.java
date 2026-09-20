package game;
import java.util.ArrayList;
import java.util.List;
import model.Mutante;

public class Equipo {
    private List<Mutante> mutantes; //Esto porque puede tener entre 3 y 11 mutantes, y necesitamos guardar todos los que estén en el grupo
    private String color;
    private String simbolo;

    public Equipo(String color, String simbolo) { //Para crear equipos con el color, simbolo y los mutantes
        this.mutantes = new ArrayList<>(); //ArrayList crea la lista.
        this.color = color;
        this.simbolo = simbolo;
    }

    public void agregarMutante(Mutante mutante) {
        mutantes.add(mutante);
    }

    public int obtenerVivos() {  //Recorre todos los mutantes, si hay vivos los suma, si hay muertos no los suma.
        int vivos = 0;
        for (Mutante mutante : mutantes) {
            if (mutante.estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }

    public int obtenerMuertos() {
        int muertos = 0;
        for (Mutante mutante : mutantes) {
            if (!mutante.estaVivo()) {
                muertos++;
            }
        }
        return muertos;
    }
    
    public boolean estaDerrotado() {
        return obtenerVivos() == 0;
    }

}
