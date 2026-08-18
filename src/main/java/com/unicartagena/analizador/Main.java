package com.unicartagena.analizador;

import java.util.Scanner;

public class Main {
    
    // =========================================================================
    // MENU INTERACTIVO Y FLUJO DEL PROGRAMA (PARA EL PROFESOR)
    // =========================================================================
    // Profe, aqui centralizamos la ejecucion de todos los puntos de la guia.
    // He diseñado un menu interactivo utilizando un bucle 'while' que iterara
    // indefinidamente hasta que el usuario decida elegir la opcion "Salir".
    
    public static void main(String[] args) {
        // Inicializamos el objeto Scanner para leer las decisiones del teclado
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        
        // Ciclo principal que mantiene viva la aplicacion
        while (opcion != 4) {
            System.out.println("\n=====================================");
            System.out.println("   ANALIZADOR DE ARCHIVOS Y MATRICES ");
            System.out.println("          Por: Rosary Carmona        ");
            System.out.println("=====================================");
            System.out.println("1. Ejecutar Ejercicio 1 (Arreglos)");
            System.out.println("2. Ejecutar Ejercicio 2 (Matrices)");
            System.out.println("3. Ejecutar Ejercicio 6 (Analizador Archivos)");
            System.out.println("4. Salir");
            System.out.print("Escriba el numero de su opcion: ");
            
            // Validacion importante: si el usuario llegase a escribir una letra (ejemplo "A"),
            // el programa normalmente se caeria lanzando un error "InputMismatchException". 
            // Para evitar que eso pase, pregunto si lo que escribio NO es un numero entero (!hasNextInt).
            if (!teclado.hasNextInt()) {
                System.out.println("Error: Por favor escriba solo numeros enteros.");
                teclado.next(); // Limpiamos la letra equivocada de la memoria
                continue; // Volvemos al inicio del bucle
            }
            
            opcion = teclado.nextInt();
            
            // El switch evalua la opcion y llama a la clase correspondiente a cada ejercicio
            switch (opcion) {
                case 1:
                    Arreglos.ejecutar();
                    break;
                case 2:
                    Matrices.ejecutar();
                    break;
                case 3:
                    AnalizadorArchivos.ejecutar(teclado);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Gracias!");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Por favor intente con numeros del 1 al 4.");
            }
        }
        
        // Cerramos el escaner para prevenir perdidas de memoria (Resource Leak)
        teclado.close();
    }
}
