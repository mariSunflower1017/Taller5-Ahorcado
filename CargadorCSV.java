import java.io.*;
import java.util.*;

public class CargadorCSV {

    public static List<String[]> cargarPalabras() {

        List<String[]> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("palabras.csv"));
            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                if (partes.length == 3) {
                    lista.add(partes);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo palabras.csv");
        }

        return lista;
    }
}