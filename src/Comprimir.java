import java.io.*;
import java.util.Scanner;

public class Comprimir {
    public static void main(String[] strings) throws IOException {
        fatherPorcess();
    }

    public static void fatherPorcess() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserta la ruta del fichero: ");
        String path = scanner.nextLine();

        // Lo convertimos en file, para poder trabajar con el como fichero
        File file = new File(path);

        //Comprobamos si el fichero existe
        if (!file.exists()){
            System.out.println("Error: la ruta no existe");
            return;
        }

        try{
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/comprimir_jar/PF1.jar");
            Process son = pb.start();

            // Enviamos la ruta al proceso hijo
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(son.getOutputStream()));
            writer.write(path);
            writer.newLine();
            writer.flush();
            writer.close();

            // Leemos lo que nos ha enviado el hijo
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
