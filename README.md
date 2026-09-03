# Actividad Unidad 1 - Protocolo Individual

**Asignatura:** Estructuras de Datos
**Programa:** Ingeniería de Software
**Institución:** Universidad de Cartagena
**Estudiante:** Rosary Carmona
**Tutor:** John Carlos Arrieta Arrieta

---

## Presentación

Hola, mi nombre es Rosary Carmona. Presento a continuación mi desarrollo para la actividad de arreglos y matrices correspondiente a la Unidad 1.

---

## Introducción

El presente proyecto documenta el aprendizaje fundamental y práctico de la manipulación de arreglos estáticos, matrices bidimensionales y la lectura de archivos de texto en Java. A través del uso de herramientas de control de versiones y metodologías modernas, se da solución a los ejercicios propuestos en la rúbrica (Ejemplo 1, Matrices y Ejercicio 6), mostrando el control del flujo de ejecución y manejo de índices.

---

## Objetivos

**Objetivo General:**
Desarrollar habilidades lógicas para el manejo, manipulación y persistencia de información haciendo uso de estructuras de datos estáticas en el lenguaje Java, aplicando buenas prácticas de desarrollo y control de versiones.

**Objetivos Específicos:**
- Implementar recorridos y modificaciones sobre arreglos unidimensionales para alterar sus datos usando condicionales.
- Crear y manipular matrices bidimensionales mediante la impresión en tabla y el intercambio posicional de sus filas.
- Diseñar un analizador de datos que interactúe con el sistema de archivos del sistema operativo (lectura/escritura) y extraiga estadísticas matemáticas (mínimo, máximo, promedio).
- Controlar las modificaciones de código bajo el sistema Git, aislando el trabajo en ramas (branches) independientes y fusionándolas de forma segura.

---

## Justificación

El estudio de las estructuras de datos debe materializarse en la solución de problemas concretos. Dominar los arreglos (arrays) es el paso fundamental antes de entrar en estructuras dinámicas de datos como Listas, Pilas o Árboles, ya que enseñan al desarrollador cómo funciona la memoria indexada y cómo ocurren los errores de desbordamiento.

Elegir el Analizador de Archivos Numéricos (Ejercicio 6) como núcleo central obliga a llevar los arreglos más allá del entorno de la consola; requiriendo leer información externa (txt), procesarla algorítmicamente y guardar un reporte. Finalmente, documentar y simular escenarios de vida real con Git ayuda a formar un perfil profesional competente y resiliente.

---

## Fundamentos Teóricos

### 1. Arreglos (Arrays)

- **Concepto de arreglo:** Es una estructura de datos estática que permite almacenar múltiples valores bajo un mismo nombre de variable, organizados secuencialmente en la memoria del computador.
- **Tipos de datos que puede almacenar:** Puede almacenar cualquier tipo de dato primitivo (como int, double, char, boolean) o tipos referenciados (objetos como String u objetos de clases personalizadas). Sin embargo, todos los elementos dentro de un mismo arreglo deben ser obligatoriamente del mismo tipo.
- **Diferencia entre tamaño fijo y dinámico según el lenguaje:** En lenguajes de tipado estricto como Java o C, los arreglos convencionales tienen un **tamaño fijo**; una vez declarados (ej. 10 posiciones), su tamaño en memoria no puede expandirse ni encogerse. En lenguajes dinámicos como JavaScript o Python, las estructuras equivalentes (listas) son **dinámicas**, lo que significa que pueden crecer y encogerse en tiempo de ejecución de manera automática.
- **Indexación y posiciones:** Los arreglos utilizan un índice numérico para acceder a sus elementos. En Java, la indexación está basada en cero (0-indexed), es decir, el primer elemento se encuentra en la posición 0 y el último en la posición tamaño - 1.
- **Operaciones básicas:**
  - **Declaración:** Consiste en definir el tipo de arreglo y su nombre (ej. `int[] numeros;`).
  - **Inicialización:** Consiste en instanciar el arreglo en memoria asignándole su tamaño (ej. `numeros = new int[10];`) o sus valores iniciales.
  - **Recorrido:** Visitar cada elemento iterativamente, generalmente usando bucles como for o for-each.
  - **Modificación:** Acceder a un índice específico mediante corchetes para reasignar su valor (ej. `numeros[2] = 15;`).

### 2. Matrices (Arrays bidimensionales)

- **Concepto de matriz:** Es un arreglo de arreglos, formando una estructura de datos cuadriculada que permite almacenar información en dos dimensiones (bidimensional).
- **Representación en memoria (fila-columna):** Las matrices se organizan lógicamente en un plano cartesiano de filas y columnas, donde el primer índice siempre representa la Fila y el segundo índice representa la Columna (ej. `matriz[fila][columna]`).
- **Declaración e inicialización:** Se declaran añadiendo un par de corchetes adicional (ej. `int[][] matriz;`) y se inicializan asignando tamaño a ambas dimensiones (ej. `matriz = new int[3][3];`).
- **Recorridos por filas y columnas:** Requieren obligatoriamente estructuras iterativas anidadas (un ciclo dentro de otro). El ciclo externo comúnmente itera sobre las filas y el ciclo interno sobre las columnas.
- **Matrices irregulares:** Son matrices donde no todas las filas tienen la misma cantidad de columnas. En Java son totalmente viables porque las matrices son arreglos de arreglos independientes.

---

## Desarrollo

A continuación presento mi proceso lógico y de desarrollo detallado para dar respuesta a los requerimientos:

### Paso 1: Creación del Proyecto Java (Maven) y Menú Principal

Al analizar la rúbrica, decidí inicializar el repositorio utilizando la estructura estándar de **Maven** y apoyándome en mi IDE de preferencia (Visual Studio Code) para estructurar el proyecto en Java. Luego, procedí a crear un menú interactivo en la clase principal (`Main.java`) para los tres ejercicios solicitados. Para lograrlo, instancié un objeto de la clase `Scanner` que permite capturar la entrada del teclado, y encerré todo en un ciclo iterativo `while`. Validé la entrada de datos (usando `hasNextInt`) para evitar caídas del programa si el usuario ingresaba letras en vez de números.

```
C:\Analizador_Archivos_Numericos> java Main

--- MENU PRINCIPAL ---
1. Arreglos
2. Matrices
3. Analizador de Archivos Numericos
4. Salir
Ingrese una opcion:
```

### Paso 2: Entendiendo los Arreglos (Ejercicio 1)

En la clase [`Arreglos.java`](src/main/java/com/unicartagena/analizador/Arreglos.java) desarrollé punto a punto los requerimientos:

1. **Declaración e Inicialización:** Escribí `int[] numeros = new int[10];` para crear el arreglo de 10 enteros. Lo inicialicé usando la clase `Random` para inyectar valores aleatorios.
2. **Recorrido y Visualización:**
   - Utilicé un **bucle for clásico** iterando desde `i = 0` hasta `numeros.length - 1` para imprimir las posiciones e índices.
   - Utilicé un **bucle for-each** (`for (int num : numeros)`) para recorrer e imprimir el arreglo de manera más limpia extrayendo únicamente sus valores.
3. **Modificación:** Recorrí el arreglo con un condicional para cambiar todos los valores impares por cero (`if (numeros[i] % 2 != 0) numeros[i] = 0;`). Posteriormente, multipliqué todos los valores por su propio índice (`numeros[i] = numeros[i] * i;`).
4. **Búsqueda Lineal:** Implementé un algoritmo de búsqueda lineal (secuencial) iterando todo el arreglo con un for y una bandera boolean para encontrar si se almacenó algún valor igual a cero en el paso anterior.

```
--- EJERCICIO 1 - ARREGLOS UNIDIMENSIONALES ---
--- 1. Declaracion y creacion ---
Arreglo creado con 10 posiciones e inicializado aleatoriamente.
--- 2. Recorrido clasico (for) ---
Posicion [0] = 45
Posicion [1] = 12 ...
--- 3. Modificacion ---
Valores impares cambiados a cero y multiplicados por su indice.
Posicion [0] = 0
Posicion [1] = 0 ...
--- 4. Busqueda Lineal ---
Se encontraron 6 valores en cero.
```

### Paso 3: Dominando las Matrices Bidimensionales (Ejercicio 2)

En la clase [`Matrices.java`](src/main/java/com/unicartagena/analizador/Matrices.java) desarrollé las siguientes actividades requeridas:

1. **Declaración e Inicialización:** Creé una matriz de 3x3 (`int[][] matriz = new int[3][3];`) y la llené automáticamente con valores aleatorios del 1 al 9 usando la clase `Random`.
2. **Recorridos:**
   - Imprimí la matriz original iterando sus filas y columnas para lograr una salida en forma de tabla (tabular).
   - Realicé un recorrido vertical por columnas invirtiendo el orden de los ciclos for (iterando el ciclo externo por columnas y el interno por filas).
3. **Operaciones:**
   - Sumé todos los elementos utilizando un acumulador (`sumatoria += matriz[i][j]`) dentro del ciclo.
   - Intercambié posicionalmente la primera fila (0) con la última fila (2), utilizando una variable temporal auxiliar para no perder los datos del array durante el reemplazo en memoria.

```
--- EJERCICIO 2 - MATRICES BIDIMENSIONALES ---
--- 1. Declaracion e inicializacion ---
Matriz de 3x3 inicializada aleatoriamente:
4  7  1
9  3  8
2  6  5
--- 3. Operaciones ---
Sumatoria total: 45
Intercambio de primera y ultima fila exitoso.
```

### Paso 4: El Reto Principal — Analizador de Archivos (Ejercicio 6)

Desarrollado en [`AnalizadorArchivos.java`](src/main/java/com/unicartagena/analizador/AnalizadorArchivos.java). El programa interactúa leyendo archivos reales del disco duro:

1. **Lectura Dinámica:** Pedí al usuario que ingresara el nombre del archivo de texto.
2. **Uso de BufferedReader:** Usé un bloque try-catch con `BufferedReader` y `FileReader` para leer línea por línea, convirtiendo el texto a números con `Integer.parseInt()`.
3. **Cálculo de Estadísticas:** En un solo ciclo optimizado guardé el mínimo, máximo y la sumatoria acumulada. Al final dividí por la longitud para hallar el promedio.
4. **Ordenamiento y Reporte Final:** Ordené el arreglo con `Arrays.sort()` y generé un reporte en un nuevo archivo txt usando `FileWriter`.

```
--- EJERCICIO 6 - ANALIZADOR DE ARCHIVOS NUMERICOS ---
Ingrese la ruta completa o el nombre (ej. numeros.txt): prueba.txt
Atencion: El archivo o ruta 'prueba.txt' no existe.
Desea que lo creemos automaticamente con numeros de prueba? (s/n): s
Archivo creado exitosamente con 20 numeros!

Estadisticas calculadas con exito:
- Minimo: 3
- Maximo: 98
- Promedio: 45.2
-> Los resultados han sido guardados en 'resultados_prueba.txt'.
```

### Paso 5: Implementación de Control de Versiones con Git

Para cumplir con las exigencias metodológicas de la actividad, todo el desarrollo se versionó utilizando Git y alojando el código en un repositorio local y remoto en GitHub. Se respetó un flujo de trabajo estricto basado en ramas (branching) para aislar cada ejercicio antes de integrarlo a la rama principal.

A continuación, se evidencian los comandos exactos ejecutados en la terminal para cada una de las funcionalidades:

**1. Para el Ejercicio de Arreglos (Paso 2 del desarrollo):**
```bash
git switch main
git pull
git switch -c rama-ejemplo1
git status
git add .
git commit -m "feat(ejemplo1): desarrollando practicas basicas de arreglos"
git push origin rama-ejemplo1
git switch main
git pull
git merge rama-ejemplo1
git push origin main
```

**2. Para el Ejercicio de Matrices (Paso 3 del desarrollo):**
```bash
git switch main
git pull
git switch -c rama-matrices
git status
git add .
git commit -m "feat(matrices): desarrollando la creacion e impresion basica de matrices 3x3"
git push origin rama-matrices
git switch main
git pull
git merge rama-matrices
git push origin main
```

**3. Para el Reto Principal (Paso 4 del desarrollo):**
```bash
git switch main
git pull
git switch -c rama-ejercicio6
git status
git add .
git commit -m "feat(ejercicio6): creando la logica del analizador de archivos numericos"
git push origin rama-ejercicio6
git switch main
git pull
git merge rama-ejercicio6
git push origin main
```

Al aplicar este ciclo de manera rigurosa, se garantizó un historial limpio, trazable y estructurado, evitando conflictos y evidenciando el uso correcto de Git como herramienta profesional.

### Comparativa de Lenguajes (Java vs Lenguajes Dinámicos)

1. **Lenguajes Estáticos vs Dinámicos:** Java es estático. Al declarar un arreglo, definimos explícitamente el tipo de dato y su tamaño fijo. Lenguajes dinámicos permiten arreglos flexibles, pero Java previene errores de desbordamiento y tipos en tiempo de compilación.
2. **Tipado Fuerte vs Tipado Débil:** Java es de tipado fuerte. No permite sumar un texto y un entero sin conversión explícita, a diferencia de lenguajes de tipado débil que concatenan valores inesperadamente. Esto educa al programador a escribir código seguro y estructurado.

---

## Enlace del repositorio público de GitHub

https://github.com/rcarmonan-commits/Analizador_Archivos_Numericos

### 🌳 Árbol de commits (git log --oneline --graph)

```text
*   220dc66 Merge branch 'rama-ejercicio6'
|\  
| * 2094288 feat(ejercicio6): creando la logica del analizador de archivos numericos
|/  
*   057fe05 Merge branch 'rama-matrices'
|\  
| * 10c4399 feat(matrices): desarrollando la creacion e impresion basica de matrices 3x3
|/  
*   2762001 Merge branch 'rama-ejemplo1'
|\  
| * e5b7f09 feat(ejemplo1): desarrollando practicas basicas de arreglos
|/  
* 29134cc feat: iniciando el proyecto maven y configuracion inicial
```

---

## Enlace del video de sustentación

[ Inserte aquí el enlace de YouTube / Google Drive con el video explicando el código, probando la ejecución y mostrando el rostro y voz del alumno ]
