package proyecto_1erbn;
import java.util.Scanner;
public class proyecto {//Por: Agustin Caceres, Ana Lemes, Facundo Garcia
	//Scanner Global
	static Scanner sc = new Scanner(System.in);
	//Variables Globales
	static int alumnosTotales = 40,materias = 10,datos = 4;//Punteros
	static double notas[][] = new double[alumnosTotales][materias];// Las filas son los numeros de alumnos y las columnas son las notas de las materias
	static String alumnos[][] = new String[alumnosTotales][datos];// Las filas como en las notas son los numeros de alumnos y las columnas son los datos de los alumnos
	static int z = 0; // Variable para contar los alumnos ingresados
	
	public static void main(String[] args) {
		menu();
	}
	// Menu y Subs-menus
	public static void menu() {
		int op;
		do {
		textMenu();
		op = sc.nextInt();sc.nextLine();
			switch(op) {
			case 1:
				alumnos();
				break;
			case 2:
				notas();
				break;
			default:
				System.out.println("------------------------------------------");
				System.out.println("\t Error al consultar");
				break;
			case 0:
				System.out.println("\t  ... Saliendo ...");
			}
		}while(op!=0);
	}
	public static void alumnos() {
		int op;
		do{
		alumnosMenu();
		op = sc.nextInt();sc.nextLine();//Solucionar el Error del "Enter" del nextInt seguido de un nextLine;
			switch(op) {
			case 0:
				System.out.println("\t ...Volviendo al Menu...");
				break;
			case 1:
				ingresarAlumnos();
				break;
			case 2:
				eliminarAlumno();
				break;
			case 3:
				cambiarDatosAlumno();
				break;
			case 4:
				mostrarAlumno();
				break;
			case 5:
				listarAlumnos();
				break;
			default:
				System.out.println("Error al consultar");
				break;
			}
		}while(op!=0);
	}
	public static void notas() {	
		int op;
		do{
		notasMenu();
		op = sc.nextInt();sc.nextLine();
			switch(op) {
			case 0:
				System.out.println("\t ...Volviendo al Menu...");
				break;
			case 1:
				ingresarNotas();
				break;
			case 2:
				modificarNotas();
				break;
			case 3:
				mostrarNotas();
				break;
			case 4:
				listarNotasMaterias();
				break;
			default:
				System.out.println("Error al consultar");
				break;
			}
		}while(op!=0);
	}
	// Metodos de Administrar Alumnos
	public static void ingresarAlumnos() {
		int opAl = 0,ciValida;
		String ci;
		do {
			if(z<alumnosTotales-1){
				while(z<alumnosTotales && alumnos[z][0] != null) {
					z++;
				}
				if(z<alumnosTotales) {			
					System.out.println("------------------------------------------");
					System.out.println("\t  --Ingrese el Nombre--");
					alumnos[z][0] = sc.nextLine();
					System.out.println("\t  --Ingrese el Apellido--");
					alumnos[z][1] = sc.nextLine();
					System.out.println("\t  --Ingrese la Edad--");
					alumnos[z][2] = sc.nextLine();
					System.out.println("   --Ingrese la Cedula de Identidad--");
					System.out.println("	-->Sin Puntos ni Guiones<--");
					// De esta Forma podiamos verificar si la edad no fuera numerica
					//String edad = "123"; // reemplaza esto con el string que deseas verificar
					//int num;
					//try {
					//    num = Integer.parseInt(edad);
					//    alumnos[z][2] = num;
					//} catch (NumberFormatException e) { // NumberFormatException "e" es para manejar excepciones.
					//    System.out.println(edad + " no es un número válido.");
					//}

				    // -- Verificamos cedula --
					do {// si la cedula es duplicada vuelve a preguntar 
				    	ciValida = validCi(ci = sc.nextLine());
					}while(ciValida == -1);
				    alumnos[z][3] = ci;
			        System.out.println("------------------------------------------");
			        System.out.println("\t Desea seguir ingresando ?");
			        System.out.println("\t  1) Si");
			        System.out.println("\t  0) No");
			        do {
			            opAl = sc.nextInt();sc.nextLine();
			            switch(opAl) {
			            case 1:
			            	System.out.println("------------------------------------------");
			            	System.out.println("Alumno/a "+alumnos[z][0]+" "+alumnos[z][1]+"\nse ingreso correctamente");
			            	break;
			            case 0:
			            	System.out.println("------------------------------------------");
			            	System.out.println("\t    Alumnos Ingresados");
			            	break;
			            default:
			            	System.out.println("------------------------------------------");
			            	System.out.println("\t Ingrese una opcion correcta");
			            	System.out.println("------------------------------------------");						}
			        }while(opAl!= 1 && opAl != 0);	
				}
				}else {
					System.out.println("--Se ingreso la cantida maxima de Alumnos--");
					opAl = 0;
			}
		}while(opAl!=0);
	}
	public static void eliminarAlumno() {
		int op;
		System.out.println("--Ingrese la Cedula del Alumno a Eliminar--");
		String ci = sc.nextLine();
		int a = numAlumno(ci);
		while(a == -1) {
			System.out.println("\t -Error al encontrar Alumno-");
			System.out.println("\t  -Vuevla a intentarlo-");
			ci = sc.nextLine();
			a = numAlumno(ci);
		}
		do {
			System.out.println("Estas Seguro que Eliminar este el alumno "+ alumnos[a][0]+" "+alumnos[a][1]);
			System.out.println("\t 1-Si");
			System.out.println("\t 0-No");
			op = sc.nextInt();sc.nextLine();
			switch(op){
			case 0:
				System.out.println("\t Abortando Eliminacion");
			break;
			case 1:	
				System.out.println("El Alumno/a :"+ alumnos[a][0]+" "+alumnos[a][1] +" Fue Eliminado");
				for(int c=0; c<datos;c++) {						
					alumnos[a][c]= null;
				}
				op=0;
			break;
			default:
				System.out.println("------------------------------------------");
				System.out.println("\t Ingrese una opcion correcta");
				System.out.println("------------------------------------------");
			}
		}while(op != 0);
		System.out.println("------------------------------------------");
	}
	public static void cambiarDatosAlumno() {
		System.out.println("  --Ingrese la Cedula del Alumno a Modificar--");
		String ci = sc.nextLine();
		int a,d,op,ciValida;
		a = numAlumno(ci);
		while(a == -1) {
			System.out.println("\t Error al encontrar Alumno");
			System.out.println("\t Vuevla a intentarlo");
			ci = sc.nextLine();
			a = numAlumno(ci);
		}
		datosAl();
		d = sc.nextInt();sc.nextLine();
		do {
			switch(d-1) {
			case 0:
				System.out.println("\t -Ingrese el Nombre-");
				alumnos[a][d-1] = sc.nextLine();
				System.out.println("Nombre Modificado");
				System.out.println("------------------------------------------");
				System.out.println("\t Desea seguir Modificando?");
				System.out.println("\t 1)Si");
				System.out.println("\t 0)Salir");
				op = sc.nextInt();sc.nextLine();
				if(op == 1) {
					datosAl();
					d = sc.nextInt();sc.nextLine();
				}else {
					d=0;
				}
				break;
			case 1:
				System.out.println("\t -Ingrese el Apellido-");
				alumnos[a][d-1] = sc.nextLine();
				System.out.println("Apellido Modificado");
				System.out.println("------------------------------------------");
				System.out.println("\t Desea seguir Modificando?");
				System.out.println("\t 1)Si");
				System.out.println("\t 0)Salir");
				op = sc.nextInt();sc.nextLine();
				if(op == 1) {
					datosAl();
					d = sc.nextInt();sc.nextLine();
				}else {
					d=0;
				}
				break;
			case 2:
				System.out.println("\t -Ingrese la Edad-");
				alumnos[a][d-1] = sc.nextLine();
				System.out.println("Edad Modificada");
				System.out.println("------------------------------------------");
				System.out.println("\t Desea seguir Modificando?");
				System.out.println("\t 1)Si");
				System.out.println("\t 0)Salir");
				op = sc.nextInt();sc.nextLine();
				if(op == 1) {
					datosAl();
					d = sc.nextInt();sc.nextLine();
				}else {
					d=0;
				}
				break;
			case 3:
				System.out.println("   -Ingrese el Cedula de Identidad-");
				System.out.println("\t  -Sin Puntos ni Guiones-");
				do {	
			    	ciValida = validCi(ci = sc.nextLine());
				}while(ciValida == -1);
		        alumnos[d][3] = ci;
				System.out.println("Cedula Modificada");
				System.out.println("------------------------------------------");
				System.out.println("\t Desea seguir Modificando?");
				System.out.println("\t 1)Si");
				System.out.println("\t 0)Salir");
				op = sc.nextInt();sc.nextLine();
				if(op == 1) {
					datosAl();
					d = sc.nextInt();sc.nextLine();
				}else {
					d=0;
				}
				break;
			}
		}while(d != 0);
		
		System.out.println("------------------------------------------");
	}
	public static void mostrarAlumno() {
		System.out.println("------------------------------------------");
		System.out.println("\t --Ingrese la Cedula del Alumno--");
		String ci = sc.nextLine();
		int a = numAlumno(ci); // Traemos el numero de la fila del alumno por su cedula
		while(a == -1) {
			System.out.println("\t Error al encontrar Alumno");
			System.out.println("\t Vuelva a intentarlo");
			ci = sc.nextLine();
			a = numAlumno(ci);
		}
			System.out.println("------------------------------------------");
			if(alumnos[a][0]!= ""&&alumnos[a][0]!= null) {//Verificamos si esta vacio o null
				System.out.println("Nombre: "+alumnos[a][0]);
			}
			if(alumnos[a][1]!= ""&&alumnos[a][1]!= null) {
				System.out.println("Apellido: "+alumnos[a][1]);
			}
			if(alumnos[a][2]!= ""&&alumnos[a][2]!= null) {
				System.out.println("Edad: "+alumnos[a][2]);
			}
			if(alumnos[a][3]!= ""&&alumnos[a][3]!= null) {
				System.out.println("Cedula: "+alumnos[a][3]);
				System.out.println("Promedio: "+promedioAlumno(a));
			}
	}
	public static void listarAlumnos() {
		for(int f=0; f<alumnosTotales;f++) {
			if(alumnos[f][0]!= ""&&alumnos[f][0]!= null) {
				System.out.println("");
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.print("\tNombre: "+ alumnos[f][0]+", ");
			}
			if(alumnos[f][1]!= ""&&alumnos[f][1]!= null) {
				System.out.print(" Apellido: "+ alumnos[f][1]+", ");
			}
			if(alumnos[f][2]!= ""&&alumnos[f][2]!= null) {
						System.out.print(" Edad: "+ alumnos[f][2]+", ");
			}
			if(alumnos[f][3]!= ""&&alumnos[f][3]!= null) {
						System.out.print(" Cedula: "+ alumnos[f][3]+", ");
						System.out.println(" Promedio: " + promedioAlumno(f));
			}
		}
	}
	// Metodos de Administrar Notas
	public static void ingresarNotas() {
		System.out.println("------------------------------------------");
		System.out.println("    --Ingrese la Cedula del Alumno--");
		String ci = sc.nextLine();
		int a = numAlumno(ci); // Traemos el numero de la fila del alumno por su cedula
		while(a == -1) {
			System.out.println("\t Error al encontrar Alumno");
			System.out.println("\t Vuevla a intentarlo");
			ci = sc.nextLine();
			a = numAlumno(ci);
		}
		System.out.println("------------------------------------------");
		System.out.println("\t  --Nota de Programacion--");
		notas[a][0] = sc.nextDouble();
		while(notasValida(notas[a][0]) == -1) {
		System.out.println("\t ..Ingrese una nota valida..");
		notas[a][0] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Logica--");
		notas[a][1] = sc.nextDouble();
		while(notasValida(notas[a][1]) == -1) {
		System.out.println("\t ..Ingrese una nota valida..");
		notas[a][1] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de M.Discretos--");
		notas[a][2] = sc.nextDouble();
		while(notasValida(notas[a][2]) == -1) {
		System.out.println("\t ..Ingrese una nota valida..");
		notas[a][2] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Sistemas OP--");
		notas[a][3] = sc.nextDouble();
		while(notasValida(notas[a][3]) == -1) {
		System.out.println("\t ..Ingrese una nota valida..");
		notas[a][3] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Lab.Informatica--");
		notas[a][4] = sc.nextDouble();
		while(notasValida(notas[a][4]) == -1) {
		System.out.println("\t ..Ingrese una nota valida..");
		notas[a][4] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de T.E.A--");
		notas[a][5] = sc.nextDouble();
		while(notasValida(notas[a][5]) == -1) {
			System.out.println("\t ..Ingrese una nota valida..");
			notas[a][5] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Geometria--");
		notas[a][6] = sc.nextDouble();
		while(notasValida(notas[a][6]) == -1) {
			System.out.println("\t ..Ingrese una nota valida..");
			notas[a][6] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Ingles--");
		notas[a][7] = sc.nextDouble();
		while(notasValida(notas[a][7]) == -1) {
			System.out.println("\t ..Ingrese una nota valida..");
			notas[a][7] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Matematicas--");
		notas[a][8] = sc.nextDouble();
		while(notasValida(notas[a][8]) == -1) {
			System.out.println("\t ..Ingrese una nota valida..");
			notas[a][8] = sc.nextDouble();
		}
		System.out.println("\t  --Nota de Historia--");
		notas[a][9] = sc.nextDouble();
		while(notasValida(notas[a][9]) == -1) {
			System.out.println("\t ..Ingrese una nota valida..");
			notas[a][9] = sc.nextDouble();
		}
		System.out.println("------------------------------------------");
		System.out.println("\t Notas Ingresadas");
	}
	public static void modificarNotas() {
		System.out.println("\t --Ingrese Cedula del Alumno--");
		String ci = sc.nextLine();
		int a = numAlumno(ci);
		while(a == -1) {
			System.out.println("\t Error al encontrar Alumno");
			System.out.println("\t Vuevla a intentarlo");
			ci = sc.nextLine();
			a = numAlumno(ci);
		}
		menuMaterias();
		int m = sc.nextInt();
			switch(m) {
			case 0:
				System.out.println("Ingrese Nota de Programacion");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 1:
				System.out.println("Ingrese Nota de Logica");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 2:
				System.out.println("Ingrese Nota de M.Discretos");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 3:
				System.out.println("Ingrese Nota de Sistemas OP");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 4:
				System.out.println("Ingrese Nota de Lab.Informatica");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 5:
				System.out.println("Ingrese Nota de T.E.A");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 6:
				System.out.println("Ingrese Nota de Geometria");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 7:
				System.out.println("Ingrese Nota de Ingles");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 8:
				System.out.println("Ingrese Nota de Matematicas");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			case 9:
				System.out.println("Ingrese Nota de Historia");
				notas[a][m] = sc.nextDouble();
				while(notasValida(notas[a][m]) == -1) {
					System.out.println("\t ..Ingrese una nota valida..");
					notas[a][m] = sc.nextDouble();
				}
				break;
			default:
				System.out.println("Error al Ingresar Materia");
				break;
			}
			System.out.println("Nota Modificada");
			System.out.println("------------------------------------------");
	}
	public static void mostrarNotas() {
		System.out.println("------------------------------------------");
		System.out.println("\t --Ingrese Cedula del Alumno--");
		String ci = sc.nextLine();
		int a = numAlumno(ci); 	
		while(a == -1) {
			System.out.println("\t Error al encontrar Alumno");
			System.out.println("\t Vuevla a intentarlo");
			ci = sc.nextLine();
			a = numAlumno(ci);
		}
		System.out.println("Notas del Alumno :"+alumnos[a][0]+" "+alumnos[a][1]);
		System.out.println("Programacion: "+notas[a][0]);
		System.out.println("Logica: "+notas[a][1]);
		System.out.println("M.Discretos: "+notas[a][2]);
		System.out.println("Sistemas OP: "+notas[a][3]);
		System.out.println("Lab.Informatica: "+notas[a][4]);
		System.out.println("T.E.A: "+notas[a][5]);
		System.out.println("Geometria: "+notas[a][6]);
		System.out.println("Ingles: "+notas[a][7]);
		System.out.println("Matematicas: "+notas[a][8]);
		System.out.println("Historia: "+notas[a][9]);
		System.out.println("Promedio: "+ promedioAlumno(a));
		System.out.println("------------------------------------------");		
	}	
	public static void listarNotasMaterias() {
		menuMaterias();
		int m = sc.nextInt();
		switch(m){
		case 0:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Programacion: "+ notas[f][0]+" ");
				}
			}
			break;
		case 1:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Logica: "+ notas[f][1]+" ");
				}
			}
			break;
		case 2:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", M.Discretos: "+ notas[f][2]+" ");
				}
			}
			break;
		case 3:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Sistemas OP: "+ notas[f][3]+" ");
				}
			}
			break;
		case 4:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Lab.Informatica: "+ notas[f][4]+" ");
				}
			}
			break;
		case 5:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", T.E.A: "+ notas[f][5]+" ");
				}
			}
			break;
		case 6:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					
				}
				System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Geometria: "+ notas[f][6]+" ");
			}
			break;
		case 7:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Ingles: "+ notas[f][7]+" ");
				}
			}
			break;
		case 8:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Matematicas: "+ notas[f][8]+" ");
				}
			}
			break;
		case 9:
			for(int f=0; f<alumnosTotales;f++) {
				if(alumnos[f][0] != null && alumnos[f][0] !="") {
					System.out.println("Nombre: "+alumnos[f][0]+", Apellido: "+alumnos[f][1]+", Cedula: "+alumnos[f][3]+", Historia: "+ notas[f][9]+" ");	
				}
			}
			break;
		}
		System.out.println("------------------------------------------");
	}
	// Metodos de Ayuda
	public static int numAlumno(String ci) {
		int f = 0, res = -1;
		boolean exito = false;
		while(ci.length()!= 8) {
			System.out.println("\t --Ingrese una cedula valida--");
			ci = sc.nextLine();
		}
		
	    do{
	        if(alumnos[f][3] != null && alumnos[f][3].equals(ci)) {
	        	exito = true;
	            }
	        f++;
	    }while(f < alumnosTotales && !exito);
	    if(exito) {
	    	res = f-1;
	    }
	    return res;
	}
	public static int validCi(String ci) {
	    int f = 0, res = 1;
	    boolean isDuplicate = false;
	    while(ci.length() != 8) {
	        System.out.println("\t --Ingrese una cedula valida--");
	        ci = sc.nextLine();
	    }
	        do{
	        	if(alumnos[f][3] != null && alumnos[f][3].equals(ci)) {
	        		System.out.println("\t  --Cedula Duplicada--");
	                System.out.println("\t ..Ingrese nuevamente..");
	                res = -1;
	                isDuplicate = true;
	            }
	            f++;
	        }while(f < alumnosTotales && !isDuplicate);
	        if(!isDuplicate) {
	            res = 1;
	        }
	    
	    return res;
	}
	public static double promedioAlumno(int a) {
		double promedio = 0;
			for(int m=0;m<materias;m++) {
				promedio +=notas[a][m];
			}
			return (promedio/materias);
	}
	public static void menuMaterias() {
		System.out.println("\t --Ingrese la Materia--");
		System.out.println("------------------------------------------");
		System.out.println("\t 0-Programacion");
		System.out.println("\t 1-Logica");
		System.out.println("\t 2-M.Discretos");
		System.out.println("\t 3-Sistemas OP");
		System.out.println("\t 4-Lab.Informatica");
		System.out.println("\t 5-T.E.A");
		System.out.println("\t 6-Geometria");
		System.out.println("\t 7-Ingles");
		System.out.println("\t 8-Matematicas");
		System.out.println("\t 9-Historia");
		System.out.println("------------------------------------------");
	}
	public static double notasValida(double nota) {
		double res = 0;
		if(nota<0||nota>12) {
			res = -1;
		}else {
			res = nota;
		}
		return res;
	}
	public static void alumnosMenu() {
		System.out.println("------------------------------------------");
		System.out.println("\t Que Tipo de Accion desea?");
		System.out.println("\t   1- Ingresar alumnos");
		System.out.println("\t   2- Eliminar alumno");
		System.out.println("\t   3- Modificar alumno");
		System.out.println("\t   4- Mostrar alumno");
		System.out.println("\t   5- Listado de Alumnos");
		System.out.println("\t   0- Volver al Menu");

	}
	public static void textMenu() {
		System.out.println("------------------------------------------");
		System.out.println("\t Que Tipo de Accion desea?");
		System.out.println("\t  1- Administrar Alumnos");
		System.out.println("\t  2- Administrar Notas");
		System.out.println("\t  0- Salir Del Programa");
	}
	public static void notasMenu() {
		System.out.println("--------------------------------------------------");
		System.out.println("\t Que Tipo de Accion desea?");
		System.out.println("\t   1- Ingresar notas");
		System.out.println("\t   2- Modificar notas de Alumno");
		System.out.println("\t   3- Mostrar notas de Alumno");
		System.out.println("\t   4- Listado de Notas por Materia");
		System.out.println("\t   0- Volver a Menu");
		System.out.println("--------------------------------------------------");
	}
	public static void datosAl() {
		System.out.println("\t Que dato desea cambiar?");
		System.out.println("\t 1)Nombre");
		System.out.println("\t 2)Apellido");
		System.out.println("\t 3)Edad");
		System.out.println("\t 4)Cedula");
	}
}