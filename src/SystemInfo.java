import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInfo {
    public static void main(String[] args) {
        String[] command = {"systeminfo"};

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
