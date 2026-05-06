import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        boolean modoDios = verificarEasterEgg(nombre);

        do {
            System.out.println("\n===  AHORCADO ===");
            System.out.println("1. Jugar");
            System.out.println("2. Instrucciones");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    juego.jugar(modoDios);
                    break;

                case 2:
                    mostrarInstrucciones();
                    break;

                case 3:
                    System.out.println("Saliendo del juego ");
                    break;

                default:
                    System.out.println("Opción inválida ");
            }

        } while (opcion != 3);

        sc.close();
    }

    public static void mostrarInstrucciones() {
        System.out.println("\n INSTRUCCIONES:");
        System.out.println("- Adivina la palabra letra por letra");
        System.out.println("- Tienes máximo 6 errores");
        System.out.println("- Si completas la palabra, ganas ");
        System.out.println("- Si fallas 6 veces, pierdes ");
    }

    public static boolean verificarEasterEgg(String nombre) {
        if (nombre.equals("XACARANA")) {
            System.out.println(" MODO DIOS ACTIVADO ");
            return true;
        }
        return false;
    }
}