import java.io.*;
import java.util.Scanner;

public class SearchInsideFile {
    public static void main() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserta el URL del fichero: ");
        String filePath = scanner.nextLine();
        System.out.println("Inserta la palabra clave");
        String word = scanner.nextLine();

        //Comprobamos que el fichero exista
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()){
            System.out.println("Error: This file don't exist");
            return;
        }

        //Comprobamos que la palabra no este vacía
        if (word.isEmpty()){
            System.out.println("Error: Word can't be empty");
            return;
        }
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/SearchInsideFile_jar/PF1.jar");
        Process fill = pb.start();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fill.getOutputStream()));

            //Le enviamos primero la palabra clave
            writer.write(word);
            writer.newLine();

            //Le enviamos el contenido del txt al hijo
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }

            //Finalizamos el envío
            writer.flush();
            writer.close();

            //Padre lee lo que le envía el hijo
            BufferedReader sonReader = new BufferedReader(new InputStreamReader(fill.getInputStream()));
            String linea;
            while ((linea = sonReader.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
