import java.util.Scanner;

public class ia {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        inicializarTablero(tablero);

        char jugadorActual = 'X';
        boolean juegoTerminado = false;
        Scanner sc = new Scanner(System.in);

        while (!juegoTerminado) {
            mostrarTablero(tablero);
            System.out.println("Jugador " + jugadorActual + ", elige fila y columna (0-2): ");
            int fila = sc.nextInt();
            int col = sc.nextInt();

            // Validar movimiento
            if (fila >= 0 && fila < 3 && col >= 0 && col < 3 && tablero[fila][col] == '-') {
                tablero[fila][col] = jugadorActual;
                juegoTerminado = verificarGanador(tablero, jugadorActual);

                if (juegoTerminado) {
                    mostrarTablero(tablero);
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                } else if (tableroLleno(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡Es un empate!");
                    juegoTerminado = true;
                } else {
                    // Cambiar de turno
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Movimiento no válido. Intenta de nuevo.");
            }
        }
        sc.close();
    }

    // Llena la matriz con guiones iniciales
    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    // Dibuja el tablero en la consola
    public static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Revisa filas, columnas y diagonales
    public static boolean verificarGanador(char[][] tablero, char j) {
        // Filas y Columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == j && tablero[i][1] == j && tablero[i][2] == j) ||
                    (tablero[0][i] == j && tablero[1][i] == j && tablero[2][i] == j)) {
                return true;
            }
        }
        // Diagonales
        if ((tablero[0][0] == j && tablero[1][1] == j && tablero[2][2] == j) ||
                (tablero[0][2] == j && tablero[1][1] == j && tablero[2][0] == j)) {
            return true;
        }
        return false;
    }

    // Revisa si ya no hay espacios vacíos
    public static boolean tableroLleno(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') return false;
            }
        }
        return true;
    }
}
