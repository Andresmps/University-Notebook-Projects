package project;

/**
 *
 * @author Camilo Martínez Hola Mundo :V
 */
import java.util.ArrayList;

public class Casilla {

    private ArrayList<String> cartas = new ArrayList();
    private ArrayList<String> carta1 = new ArrayList();
    private boolean marcar[][] = new boolean[4][6];
    
    public boolean[][] getMarcar() {
        return marcar;
    }
    
    public void setCartas(String carta) {

        for (int i = 0; i < cartas.size(); i++) {
            cartas.set(i, carta);
        }

    }

    public void setMarcar(boolean marcar) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                this.marcar[i][j] = marcar;
            }
        }
    }

    public String generarCarta(char palo, char casilla) {

        String carta = "";

        if (casilla != 'B') {
            carta = "" + casilla + palo;
        } else {
            carta = "10" + palo;
        }

        return carta;
    }

    public boolean repetirCarta(String carta) {

        if (cartas.size() != 0) {

            for (int i = 0; i < cartas.size(); i++) {
                if (cartas.get(i).equals(carta)) {
                    return true;
                }
            }
        }
        cartas.add(carta);
        return false;
    }

    public boolean repetirPosicion(int fila, int columna) {

        if (marcar[fila][columna]) {
            return true;
        }

        marcar[fila][columna] = true;
        return false;
    }

}
