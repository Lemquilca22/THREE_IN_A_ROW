# THREE IN A ROW 🗿
## DESCRIPCIÓN
El "Three in a row" también conocido como "3 en raya" en español o "michi" en latinoamerica es un juego clásico para 2 personas en un tablero de 3x3, donde cada jugador se turna para colocar una 'X' o una 'O', buscando ser el primero en alinear tres de sus símbolos en una línea horizontal, vertical o diagonal, ganando por estrategia y anticipación.
## INTERFAZ DEL JUEGO
Para acceder a uno de estos apartados debes ingresar el número, que corresponda (1, 2 o 3).

1. JUGAR:
   
   Al seleccionar esta opción comenzarás a jugar (La mecánica se explicará en "COMO JUGAR").
2. CONFIGURACIÓN:
   
   Al entrar en configuración primero puedes modificar el tamaño del lado del tablero, es decir (4x4, 5x5, 6x6, etc). Al hacerlo también modificas las condiciones para ganar, por ejemplo si seleccionaste 4, entonces tendrás que formar 4 en raya para poder Ganar.

   Luego de configurar el tamaño del tablero, se asigna la cantidad de partidas necesarias para poder ganar (2, 3, 4, o 5... etc.). 
3. SALIR

   Al seleccionar Salir, se cierra el programa. (Esto se realiza con un return, que hace que acabe todo el programa) 
   
## COMO JUGAR 

   ### JUGADORES
   Primero ingresamos los nombre que queremos tener en la partida, no importa mucho el orden de quien lo haga primero o segundo.
   
   La razón por la cual no importa el orden en ese momento es porque al iniciar el Juego la maquina elige quien empieza el juego de manera aleatoria , siendo "o" la ficha con la que ha de jugar el J1. 

   ### MOVERSE EN EL TABLERO

   A diferencia del tres en raya clasico donde dibujamos nuestras fichas con papel y boli o un marcador, en esta versión debemos hacerlo por coordenadas ¿Qué quiere decir eso?
   
   Si tenemos un tablero de 3x3 entonces tendremos 9 espacios para colocar "o" u "x". ¿Entonces es tan facil como poner 1 y 3 si quiero poner mi ficha en la primera fila y 3 columna? 

   No, las coordenas de este tablero 3x3 van del (0-2) siendo 0 el primer valor y 2 el último, esto se aplica a Filas y columnas.

   EJEMPLO: Si quiero colocar el "o" en el centro del tablero debo ingresar 1, dejo un espacio, y nuevamente 1, algo así (1 1), el primer valor es la fila y el segundo la columna.

   ### GAME OVER Y RESUMEN

   Entonces el juego comienza; cada jugador ingresa la posición donde quiere poner su ficha (ojo, si la posición esta ocupada debes ingresar nuevamente el valor), a continuación según las condiciones para poder ganar:

   Si la cantidad de Victorias necesarias es solo 1, entonces el primer jugador que forme 3 en raya gana, se acaba la partida.. (PUEDES VOLVER A JUGAR SI TIENES SED DE REVANCHA).
   
   Si la cantidad de Victorias es superior a 1, entonces en cada ronda sumas victorias(+1) y se reiniciará el tablero para volver a jugar después de cada victoria, esto hasta que se cumpla la condición de partidas necesarias para ganar, cuando eso sucede GAME OVER!
   
   Casi me olvido, ¿Y si ninguno consigue hacer 3 en raya? Pues... se reinicia el tablero y volvemos a Jugar hasta que alguien consiga 3 en raya, "en el empate no se suman puntos".

   

   
   

   

   
