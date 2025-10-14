import java.io.*;
import java.util.Scanner;

public class LlistarArxius {
    public static void main(String[] strings) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix la ruta del directori: ");
        String ruta = scanner.nextLine();

        File file = new File(ruta);
        if (!file.exists() || !file.isDirectory()){
            System.out.println("Error: este directorio no existe");
            return;
        }
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/List_jar/PF1.jar");
            Process son = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(son.getOutputStream()));
            writer.write(ruta);
            writer.newLine();
            writer.flush();
            writer.close();

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
