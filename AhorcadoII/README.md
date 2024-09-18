# Juego del Ahorcado en JAVA
He realizado el juego donde se valida la palabra secreta y permite al jugador ver las letras incorrectas que ha ingresado y la cantidad de intentos que le quedan.
Los intento son fijos y se establecieron en 6.

## Qué herramientas se utilizaron?
1. La Clase Scanner
2. Colores disponibles en ANSI para cambiar el color de las letras en la consola
	*			String  ANSI_RESET  =  "\u001B[0m";
				String  ANSI_RED  =  "\u001B[31m";
				String  ANSI_BLUE  =  "\u001B[34m";
				String  ANSI_GREEN  =  "\u001B[32m";
				String  ANSI_YELLOW  =  "\u001B[33m";
3. Se usan los métodos de la clase Scanner para capturar un String y convertirlo en minúscula. 
	*			palabraSecreta  =  scanner.nextLine().toLowerCase();
4. Se usan los métodos de la clase Character para convertir en minúscula y de la clase Scanner next() que provoca que el programa “espere” a que el usuario escriba algo por teclado y charAt(0) filtra y captura solo el primer caracter introducido.
	*			char  correcta  =  Character.toLowerCase(scanner.next().charAt(0));
5. Verificamos si hay alguna entrada restante en el búfer con el método scanner.hasNextLine() y lo borramos llamando a scanner.nextLine()
	*			if (scanner.hasNextLine()) {scanner.nextLine();}
6. Se usa en el for un char casting y se coloca instrucción especial para rellenar el arreglo con los números del 6 5 4 3 2 1 para luego ser suplantados por las letras incorrectas
	*			for (int  i  =  0; i  <  letraIncorrecta.length; i++) {letraIncorrecta[i] = (char) ('0'  +  intentosMaximos  -  i);}
7. Se hace uso del método valueOf de la clase String para tratar el arreglo de tipo char como si de un String se tratara al imprimirlo en pantalla
	*			println("\tAdivina la palabra secreta: "  +  String.valueOf(letraAdivinar));
8. Se utiliza un comando para limpiar la pantalla de la consola y hacer más amigable la interfaz.
	*			System.out.print("\033[H\033[2J"); // Limpia la pantalla
