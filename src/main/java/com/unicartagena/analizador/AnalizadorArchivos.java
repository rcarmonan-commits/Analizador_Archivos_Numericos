package com.unicartagena.analizador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AnalizadorArchivos {

    // =========================================================================
    // EXPLICACION DE LECTURA DE ARCHIVOS PARA EL PROFESOR Y SUSTENTACION
    // =========================================================================
    // Profe, este es el nucleo del Ejercicio 6. En lugar de usar un nombre fijo (quemado)
    // en el codigo, solicitamos al usuario que ingrese el nombre del archivo.
    // Usamos FileReader y BufferedReader porque leen el archivo de texto directamente
    // desde el disco duro hacia la memoria, linea por linea.

    public static void ejecutar(Scanner teclado) {
        System.out.println("\n--- EJERCICIO 6 - ANALIZADOR DE ARCHIVOS NUMERICOS ---");
        
        System.out.print("Ingrese el nombre del archivo a analizar (ej. numeros.txt): ");
        String archivoEntrada = teclado.next();
        String archivoSalida = "resultados_" + archivoEntrada;
        
        // ==========================================
        // 1. MEDIR EL TAMAÑO Y CREAR EL ARREGLO
        // ==========================================
        // Contamos cuantas lineas tiene el archivo primero para instanciar el arreglo
        // con el tamaño matematico correcto, ya que en Java el tamaño es estatico.
        int cantidadLineas = contarLineas(archivoEntrada);
        
        if (cantidadLineas == 0) {
            System.out.println("Error: El archivo '" + archivoEntrada + "' esta vacio o no existe.");
            return; // Detiene la ejecucion de este metodo para no romper el programa
        }
        
        int[] numeros = new int[cantidadLineas];
        
        // ==========================================
        // 2. LEER Y ALMACENAR LOS NUMEROS
        // ==========================================
        // El bloque try-with-resources garantiza que el archivo se cierre automaticamente
        // al terminar, evitando perdidas de memoria (resource leaks).
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            int index = 0;
            
            // Leemos linea por linea hasta llegar al final (null)
            while ((linea = br.readLine()) != null) {
                // Parseamos (convertimos) el texto leido a numero entero
                numeros[index] = Integer.parseInt(linea.trim());
                index++;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return;
        }
        
        // ==========================================
        // 3. CALCULAR ESTADISTICAS EN UN SOLO RECORRIDO O(N)
        // ==========================================
        // Asumimos inicialmente que el primer numero es tanto el menor como el mayor
        int minimo = numeros[0];
        int maximo = numeros[0];
        double suma = 0;
        
        // Usamos el for-each para hacer una inspeccion rapida de todos los numeros
        for (int num : numeros) {
            if (num < minimo) {
                minimo = num;
            }
            if (num > maximo) {
                maximo = num;
            }
            suma += num; // Acumulador para el promedio
        }
        
        double promedio = suma / numeros.length;
        
        System.out.println("\nEstadisticas calculadas con exito:");
        System.out.println("- Minimo: " + minimo);
        System.out.println("- Maximo: " + maximo);
        System.out.println("- Promedio: " + promedio);
        
        // ==========================================
        // 4. ORDENAR Y GUARDAR RESULTADOS
        // ==========================================
        // Usamos la libreria Arrays de Java para ordenar el arreglo de menor a mayor
        Arrays.sort(numeros);
        
        // Usamos FileWriter para crear o sobreescribir el archivo de salida
        try (FileWriter fw = new FileWriter(archivoSalida)) {
            fw.write("=== REPORTE ESTADISTICO ===\n");
            fw.write("Archivo origen: " + archivoEntrada + "\n");
            fw.write("Cantidad de datos leidos: " + numeros.length + "\n\n");
            
            fw.write("Minimo: " + minimo + "\n");
            fw.write("Maximo: " + maximo + "\n");
            fw.write("Promedio: " + promedio + "\n\n");
            
            fw.write("=== DATOS ORDENADOS ===\n");
            for (int num : numeros) {
                fw.write(num + "\n");
            }
            
            System.out.println("-> Los resultados han sido guardados en '" + archivoSalida + "'.");
        } catch (IOException e) {
            System.out.println("Error critico al intentar escribir el reporte: " + e.getMessage());
        }
    }
    
    // Metodo auxiliar encapsulado (private) que solo sirve de apoyo a esta clase
    private static int contarLineas(String archivo) {
        int lineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.readLine() != null) {
                lineas++;
            }
        } catch (IOException e) {
            // Se maneja la excepcion devolviendo 0 de forma segura
        }
        return lineas;
    }
}
// Bugfix: Excepcion controlada al no encontrar archivo
