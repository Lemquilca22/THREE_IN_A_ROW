import java.util.Scanner;

public class tresenRaya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int defaultLado=3;
        String [][] tablero = new String[defaultLado][defaultLado];
        for (int i = 0; i < defaultLado; i++) {
            for (int j = 0; j < defaultLado; j++) {
                tablero[i][j]="-";
            }
        }
        //Creación de Personaje ---------------------------------------------------------------------------------
        String [] players = new String[2];
        System.out.println("3 EN RAYA");
        System.out.println("JUGADOR 1:");
        players[0]=sc.next();
        System.out.println("JUGADOR 2:");
        players[1]=sc.next();
        //-------------------------------------------------------------------------------------------------------
        System.out.println("TABLERO");
        for (int i = 0; i < defaultLado; i++) {
            for (int j = 0; j < defaultLado; j++) {
                System.out.print(" "+tablero[i][j]+" ");
            }
            System.out.println();
        }

    }
}
