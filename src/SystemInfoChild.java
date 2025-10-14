import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInfoChild {
    public static void main(String[] args) throws IOException {
        sonProcess();
    }
    public static void sonProcess() throws IOException {
        try {
            String[] command = {"cmd", "/c", "systeminfo"};

            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
