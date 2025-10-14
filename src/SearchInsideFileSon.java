import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SearchInsideFileSon {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        int contador = 0;

        String linea;

        // region respuesta incompleta
//        while ((linea = reader.readLine()) != null){
//            if (linea.contains(word)){
//                contador++;
//            }
//        }

        //endregion

        while ((linea = reader.readLine()) != null){
            int index = 0;
            while ((index = linea.indexOf(word, index)) != -1){
                contador++;
                index = index + word.length();
            }
        }

        System.out.println(contador);
    }
}
