import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LlistarArxiusChild {
    public static void main(String[] args) {
        childProcess();
    }

    public static void childProcess(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String ruta = reader.readLine();
            String[] command = {"cmd", "/c","dir", ruta};

            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();


            BufferedReader processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String linea;
            while ((linea = processReader.readLine()) != null){
                System.out.println(linea);
            }
            processReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
