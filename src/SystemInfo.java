//Mostrar informació del sistema
//El procés fill ha d’executar una comanda del sistema (systeminfo a Windows o uname -a i uptime a Linux/Mac). El resultat s’ha de mostrar per consola.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInfo {
    public static void main(String[] strings) throws IOException {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "out/artifacts/System_jar/PF1.jar");
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
