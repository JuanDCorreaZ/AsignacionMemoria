package asignacionmemoria;

import java.util.Arrays;
import java.util.Scanner;

public class AsignacionMemoria {

    public static void main(String[] args) {

        int Vector[] = new int[20];

        llenarVector(Vector);
        System.out.println(Arrays.toString(Vector));
        Asignar(Vector);

    }
    /*Este procedimient llena el vector con numeros random*/

    private static void llenarVector(int[] Vector) {

        for (int i = 0; i < Vector.length; i++) {

            Vector[i] = (int) (Math.random() * 50 + 1); //Este es el metodo para llenar el vector con numeros random

        }

    }

    private static void Asignar(int[] Vector) {

        Scanner read = new Scanner(System.in);

        int proceso; //Este es el que va a pedir memoria
        int resp; //Aqui se guarda la respuesta para continuar con la asignación
        int posicion; //Esta variable guarda la posición en donde se asignó memoria
        boolean booleano;
        int fragInterna;
        int VectorRespaldo[] = new int[20];
        System.arraycopy(Vector, 0, VectorRespaldo, 0, 20);

        System.out.println(" ");

        System.out.println("Quiere agregar un proceso? 1.Si/ 2.No");
        resp = read.nextInt();

        while (resp == 1) {

            System.out.println("Ingrese el tamaño en memoria");
            proceso = read.nextInt();

            posicion = 0; //Cero porque se debe iterar el vector desde el inicio
            boolean Comprobar = ComprobacionVector(Vector);

            //i es igual posicion porque es necesario empezar a contar desde donde se asignó memoria.
            for (int i = posicion; i < Vector.length; i++) {

                if (Vector[i] >= proceso && Comprobar == false) {

                    System.out.println("La memoria solicitada fue: " + proceso); //Se muestra la memoria solicitada
                    System.out.println(" ");
                    System.out.println("La memoria que se asignó fue: " + Vector[i]); //Muestra memoria asignada
                    System.out.println(" ");
                    fragInterna = Vector[i] - proceso;
                    System.out.println("La fragmentación interna es: " + fragInterna);//Se muestra la fragmentación interna

                    System.out.println(" ");
                    posicion = i; //Se guarda la posición o índice
                    System.out.println("La posición en donde se asignó la memoria: " + posicion); //Muestra la posición en el vector.

                    VectorRespaldo[i] = fragInterna;
//                    imprimirVectorRespaldo(VectorRespaldo);
                    System.out.println(Arrays.toString(VectorRespaldo));
                    Vector[i] = 0; //Se vuelve 0
                    break;
                } else{

                    compactacionVector(Comprobar, VectorRespaldo, Vector, posicion, proceso);

                }

            }
            System.out.println(" ");
            System.out.println(Arrays.toString(Vector));
            System.out.println(" ");
            System.out.println("Quiere agregar otro proceso? 1.Si / 2. No");
            resp = read.nextInt();
            System.out.println("");
        }

    }

    private static void compactacionVector(boolean Comprobar, int[] VectorRespaldo, int[] Vector, int posicion, int proceso) {

        int suma = 0;
        
        if (Comprobar == false) {
            for (int i = posicion; i < Vector.length; i++) {
                
                do{
                    suma += Vector[i];
                    if (suma > proceso) {
                        
                        
                        
                    }
                    
                    if (i > Vector.length) {
                        i=0;
                        compactacionVectorRes(i, VectorRespaldo);
                    }
                    
                    
                    
                }while(suma < proceso);                
            }
            
            
        }

    }

    private static boolean ComprobacionVector(int[] Vector) {
        boolean resultado = false;
        int contador = 0;
        for (int i = 0; i < Vector.length; i++) {
            if (Vector[i] == 0) {
                contador = contador + 1;
            }
        }

        if (contador == 20) {
            resultado = true;
        }

        return resultado;
    }

    private static void compactacionVectorRes(int i, int[] VectorRespaldo) {
        
        
        
        
    }

}
