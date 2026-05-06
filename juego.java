import java.util.*;

public class juego {

    public static void jugar(boolean modoDios) {

        Scanner sc = new Scanner(System.in);
        List<String[]> palabras = CargadorCSV.cargarPalabras();

        Random random = new Random();
        String[] seleccion = palabras.get(random.nextInt(palabras.size()));

        String palabra = seleccion[1].toLowerCase();
        String pista = seleccion[2];

        char[] estado = new char[palabra.length()];
        Arrays.fill(estado, '_');

        int errores = 0;
        int maxErrores = 6;

        if (modoDios) {
            estado[0] = palabra.charAt(0);
            System.out.println("BONUS: Primera letra revelada");
        }

        System.out.println("--- ¡QUE COMIENCE EL JUEGO! ---");

        while (errores < maxErrores && !estaCompleta(estado)) {

            mostrarPalabra(estado);
            mostrarAhorcado(errores);
            System.out.println("Vidas agotadas: " + errores + " / " + maxErrores);

            System.out.print("Ingresa una letra (o '?' para una pista - COBRA 1 VIDA): ");
            String entrada = sc.next().toLowerCase();
            char letra = entrada.charAt(0);

            if (letra == '?') {
                errores++;

                System.out.println("\nPISTA: " + pista);
                System.out.println("Te ha costado 1 vida. Llevas " + errores + " errores.");

                if (errores >= maxErrores) {
                    break;
                }
                continue;
            }

            boolean acierto = validarLetra(letra, palabra, estado);

            if (!acierto) {
                errores++;
                System.out.println("La letra '" + letra + "' no está. Error #" + errores);
            } else {
                System.out.println("¡Buen acierto!");
            }
        }

        if (errores >= maxErrores) {
            mostrarAhorcado(errores);
            System.out.println("\n¡GAME OVER! Te has quedado sin intentos.");
            System.out.println("La palabra era: " + palabra);
        } else {
            System.out.println("\n¡VICTORIA! Has adivinado la palabra: " + palabra);
        }
    }

    public static void mostrarPalabra(char[] estado) {
        System.out.print("Palabra: ");
        for (char c : estado) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean validarLetra(char letra, String palabra, char[] estado) {
        boolean acierto = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                estado[i] = letra;
                acierto = true;
            }
        }

        return acierto;
    }

    public static boolean estaCompleta(char[] estado) {
        for (char c : estado) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void mostrarAhorcado(int errores) {

        switch (errores) {
            case 0:
                System.out.println(" ");
                break;
            case 1:
                System.out.println(" O ");
                break;
            case 2:
                System.out.println(" O \n | ");
                break;
            case 3:
                System.out.println(" O \n/| ");
                break;
            case 4:
                System.out.println(" O \n/|\\");
                break;
            case 5:
                System.out.println(" O \n/|\\\n/ ");
                break;
            case 6:
                System.out.println(" O \n/|\\\n/ \\");
                break;
        }
    }
}