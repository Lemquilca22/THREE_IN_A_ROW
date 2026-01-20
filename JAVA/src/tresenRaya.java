import java.util.Random;
import java.util.Scanner;

public class tresenRaya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        boolean game=true;
        while (game){
            //VALORES DEFAULT
            int defaultLado = 3;
            int partidasNecesarias = 1;
            int victoriasJ1 = 0;
            int victoriasJ2 = 0;
            boolean opciones=true;
            while (opciones) {
                System.out.println("1. JUGAR\n2. CONFIGURACIÓN\n3. SALIR");
                int opcionInterfaz = sc.nextInt();
                switch (opcionInterfaz){
                    case 1:
                        opciones=false;
                        break;
                    case 2:
                        System.out.println("TAMAÑO DEL TABLERO: ");
                        defaultLado=sc.nextInt();
                        System.out.println("CANTIDAD DE PARTIDAS NECESARIAS PARA GANAR: ");
                        partidasNecesarias=sc.nextInt();
                        opciones=false;
                        break;
                    case 3:
                        System.out.println("NOS VEMOS!!");
                        return;
                }

            }

        String [][] tablero = new String[defaultLado][defaultLado];
        //CREACION DEL PERSONAJE ---------------------------------------------------------------------------------
        String [] players = new String[2];
        System.out.println(defaultLado+" EN RAYA");
        System.out.println("JUGADOR:");
        players[0]=sc.next();
        System.out.println("JUGADOR:");
        players[1]=sc.next();
        //---------------------------------------------------------------------------------VICTORIAS NECESARIAS!
        System.out.println("GANADOR AL MEJOR DE "+partidasNecesarias);

        //REGLAS DE JUEGO Y SELECCION DEL JUGADOR QUE COMIENZA----------------------------------------------------
        int jugadoraleatorio= random.nextInt(2);
        System.out.println("EXPLICACIÓN: PARA JUGAR (o) u (x)  DEBES SELECCIONAR UNA CASILLA EN EL TABLERO CON COORDENADAS.");
        System.out.println("EL TABLERO COMIENZA EN 'o' HORIZONTALMENTE Y TERMINA EN '"+(defaultLado-1)+"' Y LO MISMO OCURRE DE FORMA VERTICAL");
        System.out.println("EJEMPLO DE UN TURNO: 0 1, 0 2, 1 1");

        System.out.println();
        System.out.println("COMIENZA: "+players[jugadoraleatorio]);
        boolean reiniciartablero = true;
        boolean juego=true;
        while (reiniciartablero){

            if (victoriasJ1==partidasNecesarias || victoriasJ2==partidasNecesarias){
                juego=false;
                System.out.println("GAME OVER");
                reiniciartablero=false;
            } else {
                juego=true;
                for (int i = 0; i < defaultLado; i++) {
                    for (int j = 0; j < defaultLado; j++) {
                        tablero[i][j]="-";
                    }
                } //ESTA PARTE ES LA ASIGNACIÓN DE VALOR EN EL TABLERO
                System.out.println("VICTORIAS J1: "+victoriasJ1);
                System.out.println("VICTORIAS J2: "+victoriasJ2);
                System.out.println("TABLERO");
                for (int i = 0; i < defaultLado; i++) {
                    for (int j = 0; j < defaultLado; j++) {
                        System.out.print(" "+tablero[i][j]+" ");
                    }
                    System.out.println();
                } //IMPRIMIR EL TABLERO
            }
            //VARIABLES PARA EL JUEGO --------------------------------------------------------------------------------
            int posicionF = 0;
            int posicionC=0;
            //BUCLE JUEGO --------------------------------------------------------------------------------------------
            while (juego) {
                boolean jugador1 = true;
                //------------------------------------------------------------------------------------------ PLAYER 1
                while (jugador1) {
                    System.out.println("ESCOGE LA POSICION DONDE QUIERES PONER (o)");
                    posicionF = sc.nextInt();
                    posicionC = sc.nextInt();
                    //------------------------------------------------------------------------CONDICION OUT OF BOUND !!!
                    if (posicionC>=0 && posicionC<defaultLado && posicionF>=0 && posicionF<defaultLado){
                        //--------------------------------------------------------------------CONDICION ESPACIO OCUPADO
                        if (tablero[posicionF][posicionC]!="o" && tablero[posicionF][posicionC]!="x" ){
                            for (int i = 0; i < defaultLado; i++) {
                                for (int j = 0; j < defaultLado; j++) {
                                    if (i == posicionF && j == posicionC) {
                                        tablero[i][j] = "o";
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
                            //FILAS Y COLUMNAS
                            boolean victoria=false;
                            for (int i = 0; i < defaultLado; i++) {
                                boolean filaCompleta=true; boolean columnaCompleta=true;
                                for (int j = 0; j < defaultLado; j++) {
                                    if (tablero[i][j]!="o"){ filaCompleta=false;}
                                    if (tablero[j][i]!="o"){ columnaCompleta=false;}

                                }
                                if (filaCompleta || columnaCompleta) {
                                    victoria=true;
                                }
                            }
                            //------------------------------------------------COMPROBAR DIAGONALES!!

                                boolean diagonal1=true; boolean diagonal2=true;
                                for (int i = 0; i < defaultLado; i++) {
                                    if (tablero[i][i]!="o"){ diagonal1=false;}
                                    if (tablero[i][defaultLado-1-i]!="o"){ diagonal2=false;}

                                }
                                if (diagonal1 || diagonal2) {
                                    victoria=true;
                                }

                            //------------------------------------------------EL BOOLEAN VICTORIA ES MI CONDICIÓN PARA SALIR DEL BUCLE JUEGO
                            if (victoria) {
                                System.out.println("RONDA TERMINADA\nJUGADOR 1: +1 VICTORIA");
                                victoriasJ1++;
                                juego=false;

                            }
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
                if (!juego) break;

                //-------------------------------------------------------------------------------------------PLAYER 2
                boolean jugador2 = true;
                while (jugador2) {
                    System.out.println("ESCOGE LA POSICION DONDE QUIERES PONER (x)");
                    posicionF = sc.nextInt();
                    posicionC = sc.nextInt();
                    //------------------------------------------------------------------------CONDICION OUT OF BOUND !!!
                    if (posicionC>=0 && posicionC<defaultLado && posicionF>=0 && posicionF<defaultLado){
                        //--------------------------------------------------------------------CONDICION ESPACIO OCUPADO
                        if (tablero[posicionF][posicionC]!="o" && tablero[posicionF][posicionC]!="x" ){
                            for (int i = 0; i < defaultLado; i++) {
                                for (int j = 0; j < defaultLado; j++) {
                                    if (i == posicionF && j == posicionC) {
                                        tablero[i][j] = "x";
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

                            //-------------------------------------------FILAS Y COLUMNAS
                            boolean victoria2=false;
                            for (int i = 0; i < defaultLado; i++) {
                                boolean filaCompleta=true; boolean columnaCompleta=true;
                                for (int j = 0; j < defaultLado; j++) {
                                    if (tablero[i][j]!="x"){ filaCompleta=false;}
                                    if (tablero[j][i]!="x"){columnaCompleta=false;}
                                }
                                if (filaCompleta || columnaCompleta) {
                                    victoria2=true;
                                }
                            }
                            //------------------------------------------------COMPROBAR DIAGONALES!!

                            boolean diagonal1=true; boolean diagonal2=true;
                            for (int i = 0; i < defaultLado; i++) {
                                if (tablero[i][i]!="x"){ diagonal1=false;}
                                if (tablero[i][defaultLado-1-i]!="x"){ diagonal2=false;}

                            }
                            if (diagonal1 || diagonal2) {
                                victoria2=true;
                            }

                            //------------------------------------------------EL BOOLEAN VICTORIA ES MI CONDICIÓN PARA SALIR DEL BUCLE JUEGO
                            if (victoria2) {
                                System.out.println("RONDA TERMINADA\nJUGADOR 2: +1 VICTORIA");
                                victoriasJ2++;
                                juego=false;
                            }
                            break;
                        } else {
                            System.out.println("ESTA CASILLA YA ESTA OCUPADA, INGRESA OTRO VALOR");
                            jugador2=true;
                        }
                    } else {
                        jugador2=true;
                        System.out.println("INGRESA UNA COORDENADA DENTRO DE LOS LIMITES");
                    }

                }
            }
        }
            System.out.println("¿VOLVER A JUGAR?");
        String respuesta=sc.next();
        if (respuesta.equalsIgnoreCase("si")){
            game=true;
        } else {
            System.out.println("GRACIAS POR JUGAR (SI/NO)");
            return;
        }

        }

    }
}
