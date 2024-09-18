import java.util.Scanner;

public class AhorcadoII {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Colores disponibles en ANSI para cambiar el color de las letras en la consola
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";

        String palabraSecreta = "";
        boolean palabraCorrecta = false;
        boolean palabraAdivinada = false;
        int intentosMaximos = 6;
        int intentos = 0;
        char[] letraIncorrecta = new char[intentosMaximos];

        // Estructura de control iterativa para validar la palabra secreta
        while (!palabraCorrecta) {
            System.out.print("\033[H\033[2J"); // Limpia la pantalla
            System.out.println(ANSI_BLUE + "**** BIENVENIDO AL JUEGO DEL AHORCADO ****\nEs el turno del " + ANSI_RESET
                    + ANSI_GREEN + "JUGADOR #1." + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Debe elegir la palabra secreta.");
            System.out.print("Escríbala: " + ANSI_RESET);

            // Se usan los métodos de la clase Scanner para capturar un String y convertirlo
            // en minúscula.
            palabraSecreta = scanner.nextLine().toLowerCase();
            System.out.print("Está de acuerdo que esta sea la palabra secreta (Y/N): ");

            // Se usan los métodos de la clase Character para convertir en minúscula y de la
            // clase Scanner next() que provoca que el programa “espere” a que el usuario
            // escriba algo por teclado y charAt(0) filtra y captura solo el primer caracter
            // introducido.
            char correcta = Character.toLowerCase(scanner.next().charAt(0));

            // Verificamos si hay alguna entrada restante en el búfer con el método
            // scanner.hasNextLine() y lo borramos llamando a scanner.nextLine()
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            if (correcta == 'y') {
                palabraCorrecta = true;
            }
        }

        char[] letraAdivinar = new char[palabraSecreta.length()];

        for (int i = 0; i < letraAdivinar.length; i++) {
            letraAdivinar[i] = '_';
        }

        //Se usa en el for un char casting y se coloca instrucción especial para rellenar el arreglo con los números del 6 al 1
        for (int i = 0; i < letraIncorrecta.length; i++) {
            letraIncorrecta[i] = (char) ('0' + intentosMaximos - i);
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            boolean letraCorrecta = false;

            System.out.print("\033[H\033[2J"); // Limpia la pantalla
            System.out.println(ANSI_BLUE + "**** BIENVENIDO AL JUEGO DEL AHORCADO ****\nEs el turno del " + ANSI_RESET
                    + ANSI_GREEN + "JUGADOR #2." + ANSI_RESET);
            System.out
                    .println("\tAdivina la palabra secreta: " + ANSI_BLUE + String.valueOf(letraAdivinar) + ANSI_RESET);
            System.out.println(
                    "\tOportunidades y letras incorrectas: " + ANSI_RED + String.valueOf(letraIncorrecta) + ANSI_RESET);
            System.out.print(ANSI_YELLOW + "\nTienes " + (intentosMaximos - intentos) + " Intentos.");
            System.out.print(" PULSA UNA LETRA: " + ANSI_RESET);

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letraAdivinar[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                letraIncorrecta[intentos] = letra;
                intentos++;
                System.out.print("\033[H\033[2J"); // Limpia la pantalla
                System.out.println("Letra incorrecta. Te quedan " + (intentosMaximos - intentos) + " intentos.\n");
            }

            if (String.valueOf(letraAdivinar).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.print("\033[H\033[2J"); // Limpia la pantalla
                System.out.println(ANSI_GREEN +
                        "ENHORA BUENA!! Haz logrado adivinar la palabra secreta.\n\n\t\t" + ANSI_RESET + ANSI_BLUE
                        + palabraSecreta.toUpperCase()
                        + "\n" + ANSI_RESET);
            }
        }

        if (!palabraAdivinada) {
            System.out.print("\033[H\033[2J"); // Limpia la pantalla
            System.out
                    .println(ANSI_YELLOW + "GAME OVER!! No lograste descubrir la palabra secreta.\n\n\t\t" + ANSI_RESET
                            + ANSI_RED + palabraSecreta.toUpperCase() + "\n" + ANSI_RESET);
        }

        scanner.close();
    }
}
