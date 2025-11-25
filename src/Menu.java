// java
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        System.out.println("Bienvenidos al Primer Proyecto de PSP");
        System.out.println("------------------------------------------------------");
        System.out.println("1. Mostrar información del Sistema");
        System.out.println("2. Listar archivos de un directorio");
        System.out.println("3. Buscar dentro de un fichero");
        System.out.println("4. Crear una copia de fichero");
        System.out.println("5. Comprimir un fichero o una carpeta");
        System.out.println("6. Monitorizar procesos activos");
        System.out.println("7. Salir");
        menu();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Selecciona que quieres hacer: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Opción no válida. Introduce un número.");
                    scanner.next(); // consumir entrada inválida
                    continue;
                }

                int userOption = scanner.nextInt();

                switch (userOption) {
                    case 1:
                        SystemInfo.main(new String[0]);
                        break;
                    case 2:
                        LlistarArxius.main(new String[0]);
                        break;
                    case 3:
                        SearchInsideFile.main(new String[0]);
                        break;
                    case 4:
                        Backup.main(new String[0]);
                        break;
                    case 5:
                        Comprimir.main(new String[0]);
                        break;
                    case 6:
                        MonitorizingProcess.main(new String[0]);
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no reconocida. Intenta otra vez.");
                        break;
                }

                System.out.println("------------------------------------------------------");
            }
        } finally {
            scanner.close();
        }
    }
}