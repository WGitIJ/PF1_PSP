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
        System.out.print("Selecciona que quieres hacer: ");
        Scanner scanner = new Scanner(System.in);
        int userOption = scanner.nextInt();

        switch (userOption){
            case 1:
                SystemInfo.main();
                break;
            case 2:
                LlistarArxius.main();
                break;
            case 3:
                SearchInsideFile.main();
                break;
            case 4:
                Backup.main();
                break;
            case 5:
                Comprimir.main();
                break;
            case 6:
                MonitorizingProcess.main();
                break;

        }
    }
}
