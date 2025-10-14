import java.io.*;
import java.util.Scanner;

public class Comprimir {
    public static void main(String[] args) throws IOException {
        fatherPorcess();
    }

    public static void fatherPorcess() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserta la ruta del fichero: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (!file.exists()){
            System.out.println("Error: la ruta no existe");
            return;
        }

        try{
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/ComprimirChild_jar/PF1.jar");
            Process son = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(son.getOutputStream()));
            writer.write(path);
            writer.newLine();
            writer.flush();
            writer.close();

            BufferedReader readerSon = new BufferedReader(new InputStreamReader(son.getInputStream()));
            String linea;
            while ((linea = readerSon.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
