# Protocolo de Aprendizaje Individual - Unidad 1
**Asignatura:** Estructuras de Datos  
**Programa:** Ingeniería de Software (4to Semestre)  
**Institución:** Universidad de Cartagena  
**Estudiante:** Rosary Carmona  
**Tutor:** John Carlos Arrieta Arrieta  
**Actividad:** Actividad 6 - Analizador de Archivos Numéricos y Arreglos/Matrices

---

## 👤 1. Presentación
Hola, mi nombre es Rosary Carmona. Presento a continuación mi desarrollo para la actividad de arreglos y matrices.

---

## 📖 2. Introducción

El presente proyecto documenta el aprendizaje fundamental y práctico de la manipulación de arreglos estáticos, matrices bidimensionales y la lectura de archivos de texto en Java. A través del uso de herramientas de control de versiones y metodologías modernas, se da solución a los ejercicios propuestos en la rúbrica (Ejemplo 1, Matrices y Ejercicio 6), mostrando el control del flujo de ejecución y manejo de índices.

---

## 🎯 3. Objetivos

* **Objetivo General:** Desarrollar habilidades lógicas para el manejo, manipulación y persistencia de información haciendo uso de estructuras de datos estáticas en el lenguaje Java, aplicando buenas prácticas de desarrollo y control de versiones.
* **Objetivos Específicos:**
  * Implementar recorridos y modificaciones sobre arreglos unidimensionales para alterar sus datos usando condicionales.
  * Crear y manipular matrices bidimensionales mediante la impresión en tabla y el intercambio posicional de sus filas.
  * Diseñar un analizador de datos que interactúe con el sistema de archivos del sistema operativo (lectura/escritura) y extraiga estadísticas matemáticas (mínimo, máximo, promedio).
  * Controlar las modificaciones de código bajo el sistema Git, aislando el trabajo en ramas (branches) independientes y fusionándolas de forma segura.

---

## 🛠 4. Justificación

El estudio de las estructuras de datos debe materializarse en la solución de problemas concretos. Dominar los arreglos (arrays) es el paso fundamental antes de entrar en estructuras dinámicas de datos como Listas, Pilas o Árboles, ya que enseñan al desarrollador cómo funciona la memoria indexada y cómo ocurren los errores de desbordamiento (IndexOutOfBoundsException).

Elegir el **Analizador de Archivos Numéricos (Ejercicio 6)** como núcleo central obliga a llevar los arreglos más allá del entorno de la consola; requiriendo leer información externa (txt), parsearla, procesarla algorítmicamente y guardar un reporte. Finalmente, documentar y simular escenarios de vida real con Git ayuda a formar un perfil profesional competente y resiliente en un entorno corporativo.

---

## 💻 5. Desarrollo de la Actividad (Guía Paso a Paso con Código)

Como estudiante de cuarto semestre y siendo aún principiante en el vasto mundo de Java, decidí abordar esta actividad paso a paso. Para mí fue fundamental dividir el problema en partes más pequeñas para entender bien cómo funcionan las estructuras de datos en la memoria. A continuación presento mi proceso lógico y de desarrollo detallado:

### 🎮 Paso 1: Creación del Menú Principal (Control de Flujo)
Al analizar la rúbrica, me di cuenta de que teníamos tres ejercicios totalmente distintos (Arreglos, Matrices y el Analizador de Archivos). Para no tener todo desordenado o tener que modificar el código cada vez que quisiera probar uno, decidí crear un **menú interactivo** en la clase principal ([`Main.java`](src/main/java/com/unicartagena/analizador/Main.java)). 

Para lograrlo, instancié un objeto de la clase `Scanner` que me permite capturar la entrada del teclado, y encerré todo en un ciclo iterativo `while`.

```java
Scanner teclado = new Scanner(System.in);
int opcion = 0;

while (opcion != 4) {
    System.out.println("1. Ejecutar Ejercicio 1 (Arreglos)");
    // ... más opciones (omitidas por brevedad) ...
    
    // Validación para evitar caídas
    if (!teclado.hasNextInt()) {
        System.out.println("Error: Por favor escriba solo números enteros.");
        teclado.next(); 
        continue; 
    }
    opcion = teclado.nextInt();
}
```
**Mi aprendizaje aquí:** El mayor reto fue darme cuenta de que si el usuario escribía una letra (como "a") en vez de un número, el programa colapsaba con un error crítico en consola (`InputMismatchException`). Investigando, aprendí a usar `hasNextInt()` para prevenir el error antes de que ocurra, logrando un programa mucho más profesional y robusto.

### 🧮 Paso 2: Entendiendo los Arreglos (Ejercicio 1)
En la clase [`Arreglos.java`](src/main/java/com/unicartagena/analizador/Arreglos.java), empecé practicando con la estructura de datos más básica: el arreglo unidimensional estático.

1. **Declaración y Reserva de Memoria:** En Java, los arreglos tienen un tamaño fijo. Escribí `int[] numeros = new int[10];` para decirle al computador que reserve exactamente 10 bloques de memoria contiguos.
2. **Llenado automático:** Para no escribir 10 números a mano, instancié la clase `Random`. Luego usé un ciclo `for` tradicional para recorrer desde el índice `0` hasta el `9` (`numeros.length - 1`), inyectando números aleatorios del 1 al 100.
3. **Modificación Lógica (El reto de los impares):** La guía me pedía cambiar los números impares a cero. 
```java
for (int i = 0; i < numeros.length; i++) {
    // Si el residuo de dividir entre 2 NO es cero, es impar
    if (numeros[i] % 2 != 0) {
        numeros[i] = 0; 
    }
    // Luego, multiplico el valor por su índice actual
    numeros[i] = numeros[i] * i;
}
```
**Mi aprendizaje aquí:** Comprendí la diferencia abismal entre el *valor* guardado en el cajón (ej. el número 45) y el *índice* o posición de ese cajón (ej. la posición 3). Multiplicar `numeros[i] * i` me obligó a dominar ambos conceptos a la vez.

### 🧩 Paso 3: Dominando las Matrices Bidimensionales (Ejercicio 2)
Una vez dominé el arreglo lineal, pasé a las matrices en [`Matrices.java`](src/main/java/com/unicartagena/analizador/Matrices.java). Para mí, fue súper útil imaginar la matriz como una tabla de Excel (filas y columnas).

- Declaré una matriz de 3x3 así: `int[][] matriz = new int[3][3];`.
- Comprendí que para recorrerla ya no bastaba un ciclo `for`, sino que necesitaba **dos ciclos anidados**. El `for` externo (que usa la variable `i`) maneja las filas, y el `for` interno (con la variable `j`) maneja las columnas.

**El reto del intercambio de filas:**
Se me pidió intercambiar la Fila 0 con la Fila 2. Mi primer instinto fue escribir `matriz[0][j] = matriz[2][j]`, pero al probarlo, me di cuenta de que al hacer eso, ¡los datos originales de la fila 0 se borraban para siempre, y ya no tenía cómo pasarlos a la fila 2!
La solución fue usar una **variable temporal**:
```java
for (int j = 0; j < matriz[0].length; j++) {
    int temporal = matriz[0][j];      // Guardo el dato de la fila 0 en un "vaso vacío"
    matriz[0][j] = matriz[2][j];      // Subo el dato de la fila 2
    matriz[2][j] = temporal;          // Pongo el dato guardado en la fila 2
}
```
Este pequeño algoritmo me pareció fascinante porque me enseñó cómo mover datos en la memoria sin destruirlos.

### 📊 Paso 4: El Reto Principal - Analizador de Archivos (Ejercicio 6)
Este fue el núcleo de la actividad, desarrollado en [`AnalizadorArchivos.java`](src/main/java/com/unicartagena/analizador/AnalizadorArchivos.java). Ya no jugaría solo en la memoria RAM, sino que mi programa interactuaría leyendo archivos reales del disco duro del computador.

1. **Lectura Dinámica e Interactiva:** Quise agregar valor extra a mi entrega. En lugar de "quemar" el nombre del archivo en el código (ej. obligar a que se llame siempre `numeros.txt`), usé el `Scanner` para preguntarle al usuario cómo se llama el archivo que desea analizar.
2. **Uso de BufferedReader:** 
```java
try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        numeros[index] = Integer.parseInt(linea.trim());
        index++;
    }
}
```
Al usar `BufferedReader` junto con un bloque `try-catch`, aseguré que el archivo de texto se leyera rápidamente línea por línea, y que si ocurre un error (por ejemplo, si escriben mal el nombre del archivo y este no existe), el programa no explote sino que capture la excepción `IOException`. Además, descubrí cómo usar `Integer.parseInt()` para convertir texto plano a números matemáticos reales.

3. **Cálculo de Estadísticas en Tiempo Récord:** 
Para calcular el mínimo, el máximo y el promedio, no quise hacer tres recorridos lentos. Lo hice todo en un solo ciclo súper optimizado (complejidad `O(N)`), guardando el primer número como referencia inicial y comparando a medida que avanzaba:
```java
int minimo = numeros[0];
int maximo = numeros[0];
double suma = 0;

for (int num : numeros) {
    if (num < minimo) minimo = num;
    if (num > maximo) maximo = num;
    suma += num;
}
double promedio = suma / numeros.length;
```
4. **Ordenamiento y Reporte Final:** 
Para ordenar los números de menor a mayor, aproveché la magia de la librería nativa de Java `Arrays.sort(numeros)`. Finalmente, usé la clase `FileWriter` para generar automáticamente un archivo de texto nuevo llamado `resultados_...`, donde el programa imprime las estadísticas obtenidas y la lista de números ya organizados.

Esta experiencia fue vital para mi formación, porque por primera vez logré conectar la lógica pura (arreglos y cálculos) con la persistencia real (archivos de texto en mi disco duro), una habilidad que entiendo que es esencial para cualquier futuro ingeniero de software.

---

## 🔗 6. Enlace del Repositorio en GitHub y Control de Versiones

Todo el código fuente y su respectivo historial de evolución (commits) se encuentran alojados y preservados en la nube:

- **Enlace del repositorio público de GitHub:** [https://github.com/rcarmonan-commits/Analizador_Archivos_Numericos](https://github.com/rcarmonan-commits/Analizador_Archivos_Numericos)

### 🌳 Historial de Desarrollo (Commits y Ramas)
El proyecto se desarrolló de forma progresiva, utilizando ramas (branching) para el desarrollo de módulos individuales y aplicando correcciones lógicas en tiempo real (bugfixes):

1. `iniciando el proyecto maven y configuracion inicial` *(Commit en rama: `main`)*
2. `creando el archivo readme con la presentacion y objetivos de la actividad` *(Commit en rama: `main`)*
3. `feat(ejemplo1): desarrollando practicas basicas de arreglos y creacion del menu` *(Commit en rama: `rama-ejemplo1`)*
4. `fix: corrigiendo error de indice fuera de limites al recorrer el arreglo` *(Commit en rama: `rama-ejemplo1`)*
5. `Merge branch 'rama-ejemplo1'` *(Fusión de la rama a `main`)*
6. `desarrollando la creacion e impresion basica de matrices 3x3` *(Commit en rama: `rama-matrices`)*
7. `fix: solucionando bug en el intercambio de filas que sobreescribia y borraba los datos originales` *(Commit en rama: `rama-matrices`)*
8. `Merge branch 'rama-matrices'` *(Fusión de la rama a `main`)*
9. `creando la logica del analizador de archivos numericos con lectura dinamica` *(Commit en rama: `rama-ejercicio6`)*
10. `fix: solucionando caida critica (FileNotFoundException) al intentar leer un archivo que no existia` *(Commit en rama: `rama-ejercicio6`)*
11. `refactor: agregando ultimos comentarios de sustentacion para el profesor y merge final` *(Merge final a `main`)*

---

## 🎥 7. Enlace del Video de Sustentación

El siguiente recurso audiovisual expone la defensa del proyecto, la compilación del código Java y la revisión en tiempo real de los reportes generados.

> [!IMPORTANT]  
> **Video Explicativo:** [ Insertar URL de YouTube / Google Drive aquí ]

---

## ⚖️ 8. Comparativa de Lenguajes (Java vs Lenguajes Dinámicos)

Como parte de la investigación requerida en la actividad, realicé una comparativa para entender por qué en Java declaramos los arreglos y las variables de forma tan estricta, en contraste con otros lenguajes modernos como Python o JavaScript que he visto por encima.

1. **Lenguajes Estáticos vs Dinámicos:**
   - **Java es Estático:** Cuando escribí `int[] numeros = new int[10];`, tuve que decirle al computador explícitamente desde el principio que iban a ser `int` (enteros) y que el tamaño era `10`. Si el programa está corriendo y quiero guardar una palabra o agrandarlo a 11, Java me detiene y arroja un error en tiempo de compilación. La ventaja de esto es que previene muchísimos errores antes de siquiera probar el programa.
   - **Python es Dinámico:** En un lenguaje dinámico, simplemente diría `numeros = []` y el computador asume el tipo en tiempo de ejecución. Puede crecer infinitamente y mezclar letras con números. Aunque es más fácil para novatos, es más propenso a errores silenciosos si uno no tiene cuidado.

2. **Tipado Fuerte vs Tipado Débil:**
   - **Java es de Tipado Fuerte:** Si intento sumar un número con un texto sin convertirlo explícitamente (como me tocó hacer con `Integer.parseInt(linea)` en el analizador de archivos), Java me rechaza la operación. No asume cosas a mis espaldas.
   - **Tipado Débil (Ej. JavaScript):** En JavaScript, si sumo `5 + "5"`, el lenguaje no explota, sino que asume que quiero concatenar y me devuelve `"55"`, lo cual puede ser un dolor de cabeza enorme si yo realmente quería que la respuesta fuera `10`.

**Conclusión:** Aprender Estructuras de Datos en un lenguaje *Estático y Fuerte* como Java es mucho mejor para nosotros los estudiantes, porque nos obliga a entender cómo funciona realmente la memoria del computador y nos entrena para escribir código disciplinado, seguro y predecible.
