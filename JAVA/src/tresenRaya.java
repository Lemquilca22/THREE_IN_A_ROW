import java.util.Random;
import java.util.Scanner;

public class tresenRaya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int defaultLado=3;
        String [][] tablero = new String[defaultLado][defaultLado];
        for (int i = 0; i < defaultLado; i++) {
            for (int j = 0; j < defaultLado; j++) {
                tablero[i][j]="-";
            }
        } //ESTA PARTE ES LA ASIGNACIÓN DE VALOR EN EL TABLERO
        //CREACION DEL PERSONAJE ---------------------------------------------------------------------------------
        String [] players = new String[2];
        System.out.println("3 EN RAYA");
        System.out.println("JUGADOR 1:");
        players[0]=sc.next();
        System.out.println("JUGADOR 2:");
        players[1]=sc.next();
        //REGLAS DE JUEGO Y SELECCION DEL JUGADOR QUE COMIENZA----------------------------------------------------


        int jugadoraleatorio= random.nextInt(2);
        System.out.println("EXPLICACIÓN: PARA JUGAR (O) o (X) EN EL TABLERO DEBES SELECCIONAR SU POSICION CON COORDENADAS.");
        System.out.println("EL TABLERO COMIENZA EN 'O' HORIZONTALMENTE Y TERMINA EN '"+(defaultLado-1)+"' Y LO MISMO OCURRE DE FORMA VERTICAL");
        System.out.println("EJEMPLO DE UN TURNO: 0 1, 0 2, 1 1");
        System.out.println("TABLERO");
        for (int i = 0; i < defaultLado; i++) {
            for (int j = 0; j < defaultLado; j++) {
                System.out.print(" "+tablero[i][j]+" ");
            }
            System.out.println();
        } //IMPRIMIR EL TABLERO
        System.out.println("COMIENZA: "+players[jugadoraleatorio]);
        //VARIABLES PARA EL JUEGO --------------------------------------------------------------------------------
        boolean juego=true;
        int posicionF = 0;
        int posicionC=0;
        //BUCLE JUEGO --------------------------------------------------------------------------------------------
        while (juego) {
            boolean jugador1 = true;
            //------------------------------------------------------------------------------------------ PLAYER 1
            while (jugador1) {
                System.out.println("ESCOGE LA POSICION DONDE QUIERES PONER (O)");
                posicionF = sc.nextInt();
                posicionC = sc.nextInt();
                //------------------------------------------------------------------------CONDICION OUT OF BOUND !!!
                if (posicionC>=0 && posicionC<defaultLado && posicionF>=0 && posicionF<defaultLado){
                    //--------------------------------------------------------------------CONDICION ESPACIO OCUPADO
                    if (tablero[posicionF][posicionC]!="O" && tablero[posicionF][posicionC]!="X" ){
                        for (int i = 0; i < defaultLado; i++) {
                            for (int j = 0; j < defaultLado; j++) {
                                if (i == posicionF && j == posicionC) {
                                    tablero[i][j] = "O";
                                }
                            }
                        }
                        for (int i = 0; i < defaultLado; i++) {
                            for (int j = 0; j < defaultLado; j++) {
                                System.out.print(" " + tablero[i][j] + " ");
                            }
                            System.out.println();
                        } //---------------------------ACTUALIZA EL TABLERO
                        //-------------------------------------------------COMPROBAR SI GANA




                        break;
                    } else {
                        System.out.println("ESTA CASILLA YA ESTA OCUPADA, INGRESA OTRO VALOR");
                        jugador1=true;

                    }
                } else {
                    jugador1=true;
                    System.out.println("INGRESA UNA COORDENADA DENTRO DE LOS LIMITES");
                }
            }

            //-------------------------------------------------------------------------------------------PLAYER 2
            boolean jugador2 = true;
            while (jugador2) {
                System.out.println("ESCOGE LA POSICION DONDE QUIERES PONER (X)");
                posicionF = sc.nextInt();
                posicionC = sc.nextInt();
                //------------------------------------------------------------------------CONDICION OUT OF BOUND !!!
                if (posicionC>=0 && posicionC<defaultLado && posicionF>=0 && posicionF<defaultLado){
                    //--------------------------------------------------------------------CONDICION ESPACIO OCUPADO
                    if (tablero[posicionF][posicionC]!="O" && tablero[posicionF][posicionC]!="X" ){
                        for (int i = 0; i < defaultLado; i++) {
                            for (int j = 0; j < defaultLado; j++) {
                                if (i == posicionF && j == posicionC) {
                                    tablero[i][j] = "X";
                                }
                            }
                        }
                        for (int i = 0; i < defaultLado; i++) {
                            for (int j = 0; j < defaultLado; j++) {
                                System.out.print(" " + tablero[i][j] + " ");
                            }
                            System.out.println();
                        } //---------------------------ACTUALIZA EL TABLERO
                        //-------------------------------------------COMPROBAR SI GANA LA PARTIDA
                        



                        break;
                    } else {
                        jugador2=true;
                        System.out.println("ESTA CASILLA YA ESTA OCUPADA, INGRESA OTRO VALOR");
                    }
                } else {
                    jugador1=true;
                    System.out.println("INGRESA UNA COORDENADA DENTRO DE LOS LIMITES");
                }


            }
        }
    }
}
