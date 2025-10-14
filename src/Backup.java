import java.io.*;
import java.util.Scanner;
// Todo: Acabar este ejercicio
public class Backup {
    public static void main() throws IOException{
        fatherProcess();
    }

    public static void fatherProcess() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta: ");
        String ruta = scanner.nextLine();

        File file = new File(ruta);

        if (!file.exists()){
            System.out.println("Error: el archivo no existe");
            return;
        }

        try{
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/Backup_jar/PF1.jar");
            Process son = pb.start();

            BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(son.getOutputStream()));
            writer.write(ruta);
            writer.newLine();
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(son.getInputStream()));

            String linea;
            while ((linea = reader.readLine()) != null){
                System.out.println(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
