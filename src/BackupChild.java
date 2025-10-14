import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupChild {
    public static void main(String[] args) throws IOException{
        sonProcess();
    }

    public static void sonProcess() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String ruta = reader.readLine();
            File rutaOriginal = new File(ruta);

            // Validar que existe
            if (!rutaOriginal.exists()) {
                System.out.println("Error: La ruta especificada no existe");
                return;
            }

            // Crear la carpeta /backup
            File backupDir = new File("bakup");
            if (!backupDir.exists()) {
                backupDir.mkdir();
            }

            // Crear nombre con fecha
            String fecha = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
            String backupName = rutaOriginal.getName() + "-" + fecha;
            File destino = new File(backupDir, backupName);

            // Copiar según tipo
            if (rutaOriginal.isDirectory()){
                copyDirectory(rutaOriginal, destino);
            } else {
                copyFile(rutaOriginal, destino);
            }

            System.out.println("Backup completado exitosamente: " + destino.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al realizar el backup: " + e.getMessage());
            throw e;
        }
    }

    public static void copyFile(File source, File dest) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public static void copyDirectory(File sourceDir, File destDir) throws IOException {
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        File[] files = sourceDir.listFiles();
        if (files == null) {
            throw new IOException("No se puede leer el directorio: " + sourceDir);
        }

        for (File file : files) {
            File destFile = new File(destDir, file.getName());
            if (file.isDirectory()) {
                copyDirectory(file, destFile);
            } else {
                copyFile(file, destFile);
            }
        }
    }
}