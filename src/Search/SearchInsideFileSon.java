package Search;

import java.io.*;

public class SearchInsideFileSon {
    public static void main(String[] args) throws IOException {
        System.out.println("--- Search Inside File (Child Process) ---");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        if (word == null || word.trim().isEmpty()) {
            System.out.println("0");
            return;
        }
        word = word.trim();

        int contador = 0;
        String linea;

        while ((linea = reader.readLine()) != null) {
            int index = 0;
            while ((index = linea.indexOf(word, index)) != -1) {
                contador++;
                index += word.length();
            }
        }

        System.out.println("La palabra \"" + word + "\" aparece " + contador + " veces.");
    }
}