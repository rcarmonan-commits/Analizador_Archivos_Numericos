package com.unicartagena.analizador;

import java.util.Random;

public class Arreglos {

    // =========================================================================
    // EXPLICACION DE ARREGLOS PARA EL PROFESOR Y SUSTENTACION
    // =========================================================================
    // Profe, en esta clase resuelvo los puntos iniciales sobre arreglos estaticos.
    // Un arreglo es una estructura en memoria contigua que permite agrupar varios
    // elementos bajo un solo identificador.

    public static void ejecutar() {
        System.out.println("\n=== DESARROLLO DEL PUNTO 1 DE LA GUIA: ARREGLOS ===");

        // ==========================================
        // DECLARACION E INICIALIZACION
        // ==========================================
        // Declaramos un arreglo de 10 enteros exactamente como pide la guia
        int[] numeros = new int[10];
        Random aleatorio = new Random();

        System.out.println("\n-- Llenando el arreglo con numeros aleatorios --");
        // Utilizamos un bucle for tradicional, desde 0 hasta length-1, para llenar los campos
        for (int i = 0; i < numeros.length; i++) {
            // El nextInt(100) da del 0 al 99. Sumando 1 garantizamos de 1 a 100.
            numeros[i] = aleatorio.nextInt(100) + 1;
        }

        // ==========================================
        // RECORRIDOS (FOR CLASICO Y FOR-EACH)
        // ==========================================
        System.out.println("\n-- Recorrido con FOR normal (mostrando indices) --");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posicion [" + i + "] = " + numeros[i]);
        }

        System.out.println("\n-- Recorrido con FOR-EACH (solo valores) --");
        // El for-each es mas rapido de escribir, extrae cada elemento iterativamente
        for (int num : numeros) {
            System.out.print(num + "  ");
        }
        System.out.println("\n");

        // ==========================================
        // MODIFICACION LOGICA Y ARITMETICA
        // ==========================================
        // Regla pedida: Cambiar los impares a cero y luego multiplicarlos por su indice
        System.out.println("-- Aplicando reglas matematicas de modificacion... --");
        for (int i = 0; i < numeros.length; i++) {
            // Evaluamos si el residuo de dividir por 2 es diferente de cero (numero impar)
            if (numeros[i] % 2 != 0) {
                numeros[i] = 0; // Se modifica la posicion original en la memoria
            }
            // Multiplicamos por la variable 'i' (el indice actual)
            numeros[i] = numeros[i] * i;
        }

        System.out.println("\nArreglo resultante tras modificaciones:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Pos [" + i + "] = " + numeros[i]);
        }

        // ==========================================
        // BUSQUEDA LINEAL BÁSICA
        // ==========================================
        // La busqueda lineal implica recorrer paso por paso buscando una coincidencia
        System.out.println("\n-- Búsqueda lineal buscando un 0 --");
        boolean encontrado = false;
        
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 0) {
                System.out.println("¡Cero encontrado en la posicion " + i + "!");
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontro el numero buscado.");
        }
    }
}
