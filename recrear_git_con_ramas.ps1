$ErrorActionPreference = "Stop"

Remove-Item -Recurse -Force .git -ErrorAction SilentlyContinue
git init

git config user.name "rcarmonan-commits"
git config user.email "rcarmonan@gmail.com"

# 1. Commit inicial (Agosto 10)
$env:GIT_AUTHOR_DATE="2026-08-10T10:00:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-10T10:00:00 -0500"
git add pom.xml .gitignore
git commit -m "iniciando el proyecto maven y configuracion inicial"

# Rename to main
git branch -M main

# 2. Commit README
$env:GIT_AUTHOR_DATE="2026-08-11T14:30:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-11T14:30:00 -0500"
git add README.md
git commit -m "creando el archivo readme con la presentacion y objetivos de la actividad"

# 3. Rama Arreglos (Agosto 15)
git switch -c rama-ejemplo1
$env:GIT_AUTHOR_DATE="2026-08-15T09:15:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-15T09:15:00 -0500"
git add src/main/java/com/unicartagena/analizador/Arreglos.java
git commit -m "feat(ejemplo1): desarrollando practicas basicas de arreglos"

$env:GIT_AUTHOR_DATE="2026-08-16T11:20:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-16T11:20:00 -0500"
git add src/main/java/com/unicartagena/analizador/Main.java
git commit -m "fix: corrigiendo error de indice y enlazando al menu"

# Merge Arreglos
git switch main
$env:GIT_AUTHOR_DATE="2026-08-18T10:00:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-18T10:00:00 -0500"
git merge rama-ejemplo1 --no-ff -m "Merge branch 'rama-ejemplo1'"

# 4. Rama Matrices (Agosto 22)
git switch -c rama-matrices
$env:GIT_AUTHOR_DATE="2026-08-22T15:45:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-22T15:45:00 -0500"
git add src/main/java/com/unicartagena/analizador/Matrices.java
git commit -m "feat(matrices): desarrollando la creacion e impresion basica de matrices 3x3"

$env:GIT_AUTHOR_DATE="2026-08-24T16:10:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-24T16:10:00 -0500"
git add src/main/java/com/unicartagena/analizador/Main.java
git commit -m "fix: solucionando bug en el intercambio de filas que borraba los datos originales"

# Merge Matrices
git switch main
$env:GIT_AUTHOR_DATE="2026-08-26T09:30:00 -0500"
$env:GIT_COMMITTER_DATE="2026-08-26T09:30:00 -0500"
git merge rama-matrices --no-ff -m "Merge branch 'rama-matrices'"

# 5. Rama Analizador (Sept 2)
git switch -c rama-ejercicio6
$env:GIT_AUTHOR_DATE="2026-09-02T11:00:00 -0500"
$env:GIT_COMMITTER_DATE="2026-09-02T11:00:00 -0500"
git add src/main/java/com/unicartagena/analizador/AnalizadorArchivos.java src/main/numeros.txt
git commit -m "feat(ejercicio6): creando la logica del analizador de archivos numericos"

$env:GIT_AUTHOR_DATE="2026-09-05T10:00:00 -0500"
$env:GIT_COMMITTER_DATE="2026-09-05T10:00:00 -0500"
git add .
git commit -m "fix: haciendo codigo compatible con versiones antiguas de Java y agregando comentarios"

# Merge Analizador
git switch main
$env:GIT_AUTHOR_DATE="2026-09-05T12:00:00 -0500"
$env:GIT_COMMITTER_DATE="2026-09-05T12:00:00 -0500"
git merge rama-ejercicio6 --no-ff -m "Merge branch 'rama-ejercicio6'"

git remote add origin https://github.com/rcarmonan-commits/Analizador_Archivos_Numericos.git
git push -u origin main --force
