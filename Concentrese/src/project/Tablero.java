package project;

/**
 *
 * @author Camilo Martínez Hola Mundo :V
 */
import java.util.Random;

public class Tablero {

    private Casilla casilla = new Casilla();
    private String[][] tablero = new String[4][6];
    private String[][] tableroXX = new String[4][6];
    private char[] etiquetas = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'B', 'J', 'Q', 'K'};
    private char[] palos = {'S', 'H', 'D', 'C'};
    private Random random = new Random();
    private int aciertos;
    private int vidasRestantes;
    private boolean marcar[][] = new boolean[4][6];

    public int getAciertos() {
        return aciertos;
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public void generarTablero() {

        llenarTablero();
        llenarTableroXX();
        aciertos = 0;
        vidasRestantes = 15;
        String carta = "";
        int fila = 0;
        int columna = 0;

        for (int i = 0; i < 12; i++) {

            do {

                char palo = palos[random.nextInt(palos.length)];
                char numero = etiquetas[random.nextInt(etiquetas.length)];

                carta = casilla.generarCarta(palo, numero);

            } while (casilla.repetirCarta(carta));

            do {

                fila = random.nextInt(4);
                columna = random.nextInt(6);

            } while (casilla.repetirPosicion(fila, columna));
            tablero[fila][columna] = carta;

            do {

                fila = random.nextInt(4);
                columna = random.nextInt(6);

            } while (casilla.repetirPosicion(fila, columna));
            tablero[fila][columna] = carta;
        }

    }

    public void llenarTablero() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                tableroXX[i][j] = "";
            }
        }
        casilla.setMarcar(false);
        casilla.setCartas("");

    }

    public void llenarTableroXX() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                tableroXX[i][j] = "xx";
            }
        }
    }

    public void mostrarTableroXX() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.print("\t  ");
                }
                if (j != 5) {
                    System.out.print(tableroXX[i][j] + "  |  ");
                } else {
                    System.out.print(tableroXX[i][j]);
                }
            }
            if (i != 3) {
                System.out.println("\n\t------+------+------+------+------+------");
            }
        }
        System.out.println("");
    }

    public void mostrarTablero() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.print("\t  ");
                }
                if (j != 5) {
                    System.out.print(tablero[i][j] + "  |  ");
                } else {
                    System.out.print(tablero[i][j]);
                }
            }
            if (i != 3) {
                System.out.println("\n\t------+------+------+------+------+------");
            }
        }
        System.out.println("");
    }

    public String jugada1(int fila, int columna) {

        if (tableroXX[fila][columna].equals("xx")) {
            tableroXX[fila][columna] = tablero[fila][columna];
            return tableroXX[fila][columna];
        } else {
            return "-1";
        }

    }

    public String jugada2(int fila, int columna, int fila1, int columna1) {

        if (tableroXX[fila][columna].equals("xx")) {

            tableroXX[fila][columna] = tablero[fila][columna];
            return tableroXX[fila][columna];

        } else {
            tableroXX[fila1][columna1] = "xx";
            return "-1";
        }

    }

    public boolean mismaPosicion(int fila, int columna, int fila1, int columna1) {

        return (fila == fila1 && columna == columna1);
    }

    public boolean validarJugada(int fila, int columna, int fila1, int columna1) {

        if (tableroXX[fila][columna].equals(tableroXX[fila1][columna1])) {

            aciertos += 1;
            return true;
        } else {
            vidasRestantes -= 1;
            tableroXX[fila][columna] = "xx";
            tableroXX[fila1][columna1] = "xx";

            return false;
        }

    }

    public String darPaloMasRepetido() {

        int paloMasRepetido = 0;
        String subString = "";
        String palo = "";

        int S = 0, H = 0, D = 0, C = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                subString = "" + tablero[i][j].charAt(0) + tablero[i][j].charAt(1);

                if (subString.equals("10")) {

                    if (tablero[i][j].charAt(2) == 'S') {
                        S++;
                    } else if (tablero[i][j].charAt(2) == 'H') {
                        H++;
                    } else if (tablero[i][j].charAt(2) == 'D') {
                        D++;
                    } else if (tablero[i][j].charAt(2) == 'C') {
                        C++;
                    }

                } else {

                    if (tablero[i][j].charAt(1) == 'S') {
                        S++;
                    } else if (tablero[i][j].charAt(1) == 'H') {
                        H++;
                    } else if (tablero[i][j].charAt(1) == 'D') {
                        D++;
                    } else if (tablero[i][j].charAt(1) == 'C') {
                        C++;
                    }
                }
            }
        }

        if (S > H) {
            paloMasRepetido = S;

        } else {
            paloMasRepetido = H;
        }

        if (paloMasRepetido < D) {
            paloMasRepetido = D;
        }
        if (paloMasRepetido < C) {
            paloMasRepetido = C;
        }

        if (S == paloMasRepetido) {
            palo = "Picas";
        } else if (H == paloMasRepetido) {
            palo = "Corazones";
        } else if (D == paloMasRepetido) {
            palo = "Diamantes";
        } else if (C == paloMasRepetido) {
            palo = "Treboles";
        }

        return palo + "&" + paloMasRepetido;
    }

    public String regalo() {

        String regalo1 = "";
        int fila = 0, fila1 = 0, columna = 0, columna1 = 0;
        boolean condicion = false;

        do {
            fila = random.nextInt(4);
            columna = random.nextInt(6);

        } while (marcar[fila][columna]);

        marcar[fila][columna] = true;
        regalo1 = tablero[fila][columna];


        for (int i = 0; i < tableroXX.length; i++) {
            for (int j = 0; j < tableroXX[i].length; j++) {
                if (marcar[i][j] == false) {
                    if (tablero[i][j].equals(regalo1)) {
                        fila1 = i;
                        columna1 = j;
                    }
                }

            }
        }

        marcar[fila1][columna1] = true;
        tableroXX[fila][columna] = tablero[fila][columna];
        tableroXX[fila1][columna1] = tablero[fila1][columna1];
        aciertos++;
        return regalo1 + "&" + fila + "&" + columna + "&" + fila1 + "&" + columna1;
    }

    public boolean repetirPosicion(int fila, int columna) {

        if (marcar[fila][columna]) {
            return true;
        }

        marcar[fila][columna] = true;
        return false;
    }

}
//hola
