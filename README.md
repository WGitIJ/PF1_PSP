# PF1 – PSP Project

Aplicación de consola escrita en Java que centraliza varios ejercicios de Procesos y Servicios: consulta de información del sistema, listado de directorios, búsqueda de texto en archivos, copias de seguridad, compresión y monitorización de procesos. El punto de entrada es `Menu`, que invoca a cada ejercicio y coordina los procesos padre‑hijo mediante `ProcessBuilder` y los *artifacts* generados en `out/artifacts/**`.

## Requisitos
- JDK y JRE de la **misma versión** (recomendado JDK 21 o superior). Comprueba ambas con `java -version` y `javac -version`.
- Sistema operativo Windows (los comandos delegan en `cmd /c ...`).

> Si ves `UnsupportedClassVersionError`, significa que compilaste con un JDK más nuevo que el runtime que usas para ejecutar. Alinea ambas versiones o recompila con `javac --release 8 ...` si necesitas compatibilidad con Java 8.

## Estructura principal
- `src/Menu.java`: menú principal con las 7 opciones del proyecto.
- `src/SystemInfo.SystemInfo*.java`: muestra información del sistema ejecutando `systeminfo` dentro de un proceso hijo.
- `src/Listar.LlistarArxius*.java`: lista archivos de un directorio usando `dir`.
- `src/Search.SearchInsideFile*.java`: busca una palabra clave dentro de un fichero, enviando el contenido al proceso hijo.
- `src/Bakup.Backup*.java`: crea una copia del archivo indicado.
- `src/Comprimir.Comprimir*.java`: comprime un fichero o carpeta.
- `src/Monitor.MonitorizingProcess*.java`: comprueba si un proceso está activo.

Cada módulo tiene una versión “padre” que interactúa con el usuario y lanza un `.jar` hijo ubicado en `out/artifacts/<Modulo>_jar/PF1.jar`.

## Compilación
```powershell
cd C:\Users\Wisdom\OneDrive\Documentos\FP\CIFP_Inca\DAM_25-26\PSP\PF1_PSP
javac -d out/production/PF1 src\*.java
# O fuerza la versión del bytecode:
# javac --release 21 -d out/production/PF1 src\*.java
```

## Ejecución
```powershell
java -cp out/production/PF1 Menu
```

El menú mostrará:
1. Información del sistema  
2. Listado de archivos  
3. Búsqueda en fichero  
4. Copia de seguridad  
5. Compresión  
6. Monitorización de procesos  
7. Salir

Selecciona una opción y sigue las instrucciones por consola. Algunos módulos requieren rutas absolutas o nombres de proceso válidos.

## Artefactos hijos
Asegúrate de tener generados los `.jar` en `out/artifacts/**` (por ejemplo `out/artifacts/SystemInfo_jar/PF1.jar`). Si usas IntelliJ, ejecuta **Build ➜ Build Artifacts ➜ Build** para cada uno. El padre se comunica con el hijo mediante la entrada/salida estándar, así que estos `.jar` son imprescindibles.

## Resolución de problemas
- **Rutas no válidas**: verifica que el archivo/directorio exista y que tengas permisos.
- **Procesos que no responden**: algunos comandos del sistema pueden tardar; espera a que terminen antes de cerrar la consola.
- **Errores de encoding**: utiliza rutas sin caracteres especiales o ejecuta la consola en UTF‑8 (`chcp 65001`).

Con esto deberías poder compilar, ejecutar y entender rápidamente cada módulo del proyecto.

