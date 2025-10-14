import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComprimirChild {
    public static void main(String[] args) throws IOException, InterruptedException {
        sonProcess();
    }

    public static void sonProcess() throws IOException, InterruptedException {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String ruta = reader.readLine();
            File file = new File(ruta);

            // Creamos la carpeta compressed
            File compressed = new File("compressed");
            if (!compressed.exists()){
                compressed.mkdir();
            }

            // Crear nombre del archivo de salida
            String originalName = file.getName();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));
            String backupName = originalName + "_" + timestamp + ".tar";
            String dest = "compressed\\" + backupName;

            //Ejecutamos el comando
            String[] command = {"cmd", "/c", "tar", "-cf", dest, ruta};

            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();

            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = output.readLine()) != null){
                System.out.println(linea);
            }

            int isWorking = process.waitFor();
            if (isWorking == 0){
                System.out.println("Se ha comprimido correctamente");
            } else{
                System.out.println("Error: no se ha comprimido correctamente");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
