package com.unicartagena.analizador;

import java.util.Random;

public class Matrices {
    
    // =========================================================================
    // EXPLICACION DE MATRICES PARA EL PROFESOR Y SUSTENTACION
    // =========================================================================
    // Profe, aqui abordamos las matrices bidimensionales (arreglos de arreglos).
    // Usamos dos indices: 'i' para las filas y 'j' para las columnas.

    public static void ejecutar() {
        System.out.println("\n=== DESARROLLO DEL PUNTO 2 DE LA GUIA: MATRICES ===");

        // ==========================================
        // DECLARACION DE LA MATRIZ Y LLENADO
        // ==========================================
        // Se declara una matriz de 3 filas x 3 columnas
        int[][] matriz = new int[3][3];
        Random aleatorio = new Random();

        // Llenado mediante for anidado
        for (int i = 0; i < matriz.length; i++) { // recorre las filas
            for (int j = 0; j < matriz[i].length; j++) { // recorre las columnas
                matriz[i][j] = aleatorio.nextInt(90) + 10; // Numeros de dos digitos (10 a 99)
            }
        }

        // ==========================================
        // IMPRESION TABULAR
        // ==========================================
        System.out.println("\n-- Matriz Original (3x3) --");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println(); // Salto de linea al cambiar de fila
        }

        // ==========================================
        // RECORRIDO VERTICAL (POR COLUMNAS)
        // ==========================================
        // Invertimos los for: el externo controla las columnas 'j' y el interno las filas 'i'
        System.out.println("\n-- Imprimiendo de arriba hacia abajo (Vertical) --");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print("Columna " + j + ": ");
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // ==========================================
        // SUMATORIA TOTAL DE LOS ELEMENTOS
        // ==========================================
        int sumatoria = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumatoria += matriz[i][j]; // Acumulador
            }
        }
        System.out.println("\nSumatoria de todos los elementos: " + sumatoria);

        // ==========================================
        // INTERCAMBIO DE FILAS (ALGORITMO)
        // ==========================================
        // Profe, aqui esta la logica del intercambio. Para no perder la fila 0 al
        // ser reemplazada por la fila 2, usamos una variable temporal.
        System.out.println("\n-- Intercambiando la Fila 0 con la Fila 2 --");
        
        for (int j = 0; j < matriz[0].length; j++) {
            int temporal = matriz[0][j];      // guardamos el dato de arriba
            matriz[0][j] = matriz[2][j];      // subimos el de abajo
            matriz[2][j] = temporal;          // bajamos el dato guardado
        }

        // Imprimimos la matriz modificada
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
    }
}
