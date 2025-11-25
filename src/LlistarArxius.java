import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LlistarArxius {
    public static void main(String[] args) {
        System.out.println("--- Llistar Arxius d'un Directori ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la ruta del directori: ");
        String ruta = scanner.nextLine();
        String[] command = {"cmd", "/c","dir ", ruta};

        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            Process son = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(son.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
