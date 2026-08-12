# Analizador Archivos Numéricos

## 👤 1. Presentación

**Nombre del Alumno:** Rosary Carmona
**Programa:** Ingeniería de Software
**Asignatura:** Estructuras de Datos
**Actividad:** Actividad 6 - Analizador de Archivos Numéricos y Arreglos/Matrices

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

## 💻 5. Desarrollo de la Actividad

El proyecto se construyó bajo la estructura estándar de **Maven**. 

### 🧮 Parte A: Arreglos y Matrices
Se desarrollaron dos clases que cubren los requisitos de calentamiento:

* 📄 **[`Arreglos.java`](src/main/java/co/edu/udec/estructuras/Arreglos.java)**:
  * Declaración de arreglo unidimensional tamaño 10.
  * Modificación matemática de números impares multiplicándolos por su índice.
  * Recorridos clásicos (`for`) y optimizados (`for-each`).
  * Implementación de una búsqueda secuencial.

* 📄 **[`Matrices.java`](src/main/java/co/edu/udec/estructuras/Matrices.java)**:
  * Generación y formato tabular de una matriz 3x3.
  * Recorridos inversos enfocados en iterar por columnas.
  * Intercambio de posiciones extremas (fila 0 con fila 2) gestionando una variable temporal para no sobreescribir datos accidentalmente.

### 📊 Parte B: Analizador de Archivos Numéricos (Ejercicio 6)
El archivo 📄 **[`AnalizadorArchivos.java`](src/main/java/co/edu/udec/estructuras/AnalizadorArchivos.java)** soluciona el problema de análisis de datos. 
1. Abre el archivo `numeros.txt` y hace una lectura para medir su tamaño.
2. Crea el arreglo con la dimensión exacta.
3. Extrae las estadísticas (mínimo, máximo y un acumulador para el promedio) en un único recorrido optimizado `O(N)`.
4. Utiliza `Arrays.sort` para ordenar los elementos y luego escribe el reporte estructurado en el archivo `resultados.txt`.

---

## 🔗 6. Enlace del Repositorio en GitHub y Control de Versiones

Todo el código fuente y su respectivo historial de evolución se encuentran alojados y preservados en la nube:

[![GitHub](https://img.shields.io/badge/GitHub-Repositorio_del_Proyecto-181717?style=for-the-badge&logo=github)](https://github.com/rcarmonan-commits/Analizador_Archivos_Numericos)

### 🌳 Historial de Desarrollo (Commits y Ramas)
El proyecto se desarrolló de forma progresiva, utilizando ramas (branching) para el desarrollo de módulos individuales y aplicando correcciones lógicas en tiempo real (bugfixes):

1. `iniciando el proyecto maven y configuracion inicial`
2. `creando archivo temporal para la documentacion`
3. `feat(ejemplo1): agregando practicas de arreglos` *(Commit en rama: `rama-ejemplo1`)*
4. `fix: corrigiendo error de indice fuera de limites al recorrer el arreglo` *(Commit en rama: `rama-ejemplo1`)*
5. `Merge branch 'rama-ejemplo1'` *(Fusión de la rama a `main`)*
6. `desarrollando la creacion e impresion basica de matrices 3x3` *(Commit en rama: `rama-matrices`)*
7. `fix: solucionando bug en el intercambio de filas que sobreescribia y borraba los datos originales` *(Commit en rama: `rama-matrices`)*
8. `Merge branch 'rama-matrices'` *(Fusión de la rama a `main`)*
9. `creando el esqueleto del analizador de archivos y lectura de datos` *(Commit en rama: `rama-ejercicio6`)*
10. `fix: solucionando caida critica (FileNotFoundException) al intentar leer un archivo que no existia` *(Commit en rama: `rama-ejercicio6`)*
11. `escribiendo el documento README con la presentacion y justificacion y merge del ejercicio final` *(Merge final a `main`)*

---

## 🎥 7. Enlace del Video de Sustentación

El siguiente recurso audiovisual expone la defensa del proyecto, la compilación del código Java y la revisión en tiempo real de los reportes generados.

> [!IMPORTANT]  
> **Video Explicativo:** [ Insertar URL de YouTube / Google Drive aquí ]
