import java.io.*;
import java.util.Scanner;

public class MonitorizingProcess {
    public static void main(String[] strings) throws IOException {
        fatherProcess();
    }

    public static void fatherProcess() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del proceso: ");
        String procesName = scanner.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/Monitor_jar/PF1.jar");
        Process son = pb.start();

        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(son.getOutputStream()));
            writer.write(procesName);
            writer.newLine();
            writer.flush();

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
