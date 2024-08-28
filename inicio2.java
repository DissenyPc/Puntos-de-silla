package controlador2;

import java.util.Scanner;

public class inicio2 {

    

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        while (true) {

            // ---------------------PEDIMOS FILA Y COLUMNA---------------------

            Fila = entrada.nextInt();

            Columna = entrada.nextInt();

            if (Fila == 0 && Columna == 0) {

                break; // SI 0 0 SALIMOS DEL BUCLE Y DESPUES YA NO HAY NADA Y SE ACABA EL PROGRAMA

            }

            valores = new int[Fila][Columna];

//----------------------PEDIMOS LOS VALORES DEL ARRAY-----------------------------------

            for (int f = 0; f < Fila; f++) {

                for (int c = 0; c < Columna; c++) {

                    valores[f][c] = entrada.nextInt();

                }

            }

            boolean PSilla = false;

            //--------------RECORREMOS ARRAY LLAMANDO A COMPROBAR--------------------

            for (int f = 0; f < Fila; f++) {

                for (int c = 0; c < Columna; c++) {

                    if (comprobar(f, c)) { //----------SI VERDADERO SALIMOS DEL BUCLE Y pSILLA TRUE

                        PSilla = true;

                        break;
                    }

                }

                if (PSilla) { //----------SI VERDADERO SALIMOS DEL BUCLE

                    break;

                }

            }

            if (PSilla) {

                System.out.println("SI"); // IS PSILLA VERDADERO IMPRIMIMOS SI

            } else {

                System.out.println("NO"); // SI FALSO IMPRIMIMOS NO

            }
        }
    }

//---------------ENTRAMOS EN COMPROBAR----------------------------

    public static boolean comprobar(int fila, int columna) {

        boolean comprobacion = false;

        // MIENTRAS EL VALOR A COMPROBAR SEA MENOR PONEMOS EN COMRPBACION TRUE SI NO SALIMOS DEL BUCLE

        for (int i = 0; i < Columna; i++) {

            comprobacion = valores[fila][columna] <= valores[fila][i];

            if(!comprobacion) break;

        }

// SI AL SALIR DEL BUCLE POR FINAL O POR BREAK COMPROBACION ES TRUE COMPROBAMOS COLUMNA MAYOR

        if (comprobacion) { 

            for (int i = 0; i < Fila; i++) {

                comprobacion = valores[fila][columna] >= valores[i][columna]; // PONEMOS EN COMPROBACION SI VERDAD O FALSO SEGUN MAYOR O NO

                if(!comprobacion) break; // SI NO ES MAYOR SALIMOS DEL BUCLE

            }

            if (comprobacion) return true; // SI AL SALIR DEL BUCLE ES TRUE SALIMOS DEL METODO DEVOLVIENDO TRUE

        }
        
// SI NO HEMOS SALIDO DEL METODO COMPROBAMOS SI FILA ES MAYOR

        for (int i = 0; i < Columna; i++) {

            comprobacion = valores[fila][columna] >= valores[fila][i];

            if(!comprobacion) break; // SI NO SALIMOS DEL BUCLE

        }

        if (comprobacion) { // SI SI COMPROBAMOS SI COLUMNA ES MENOR

            for (int i = 0; i < Fila; i++) {

                comprobacion = valores[fila][columna] <= valores[i][columna]; // PONEMOS EN COMPROBACION SI TRUE O FALSE

                if(!comprobacion) break; //SI NO SALIMOS DEL BUCLE

            }

            if (comprobacion) return true; //SI SI SALIMOS DEL METODO DEVOLVIENDO TRUE
            
        }

        return false; // SI AUN NO HEOS SALIDO DEL METODO ENTONCES SALIMOS DEVOLVIENDO FALSE
    }

    static int[][] valores;
    static int Fila, Columna;

}
