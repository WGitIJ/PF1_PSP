import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonitorizingProcessChild {
    public static void main(String[] args) throws IOException{
        sonProcess();
    }

    public static void sonProcess() throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String processName = reader.readLine();

            String[] command = {"cmd", "/c", "tasklist"};

            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();

            BufferedReader pReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String linea;
            while ((linea = pReader.readLine()) != null){
                if (processName == null || processName.isEmpty()){
                    System.out.println(linea);
                }else{
                    if (linea.toLowerCase().contains(processName.toLowerCase())){
                        System.out.println(linea);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
