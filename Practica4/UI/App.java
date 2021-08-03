package Practica4.UI;

import Practica4.Dominio.Persona;
import Practica4.Dominio.Agenda;
import Practica4.Dominio.Leer;


public class App
{
	public static void main(String[] args)
	{	
		System.out.println("Elija un nombre para su agenda:");
		String nomAgenda = Leer.porTeclado();
		Agenda agenda = new Agenda(nomAgenda);

		int neleccion = 1000;
		while(neleccion != 9)
		{

			System.out.println("\n\n\n\n##############################");
			System.out.println("########    AGENDA    ########");
			System.out.println("##############################");
			System.out.println("### 1.- Crear persona      ###");
			System.out.println("### 2.- Buscar persona     ###");
			System.out.println("### 3.- Modificar persona  ###");
			System.out.println("### 4.- Eliminar persona   ###");
			System.out.println("### 5.- Mostrar Lista  	   ###");
			System.out.println("##############################");
			System.out.println("### 9.- Salir              ###");
			System.out.println("##############################");
	
			System.out.println("\n\n¿Qué quiere hacer? (elija un número):");
			String eleccion;
			eleccion = Leer.porTeclado();
			neleccion = Integer.parseInt(eleccion);

			//VARIABLES AUXILIARES PARA EL SWITCH
			String dni;
			String nombre;
			int edad;
			String resultado;
			switch(neleccion)
			{
				case 1:

					System.out.println("\nUsted ha elegido crear persona.");
					System.out.println("Introduzca por orden el DNI, el nombre y la edad de la persona.\n");

					System.out.println("DNI: ");
					dni = Leer.porTeclado();

					System.out.println("Nombre: ");
					nombre = Leer.porTeclado();

					System.out.println("Edad: ");
					edad = Integer.parseInt(Leer.porTeclado());  //OJO => EL MÉTODO DEVUELVE UN STRING

					agenda.crearP(dni, nombre, edad);

					break;


				case 2:

					System.out.println("\nUsted ha elegido buscar persona.");
					System.out.println("Introduzca el DNI de la persona que desea buscar:");
					dni = Leer.porTeclado();

					String info = agenda.buscarP(dni);

					System.out.println(info);
					break;


				case 3:

					System.out.println("\nUsted ha elegido modificar persona.");
					System.out.println("Introduzca el DNI de la persona que desea modificar:");	
					dni = Leer.porTeclado();

					System.out.println("\nAhora introduzca los nuevos datos: ");
					//MALL HECHO => LOS DATOS DEBERÍA PEDIRLOS DESDE modificarP()
					System.out.println("DNI: ");
					String nDni = Leer.porTeclado();

					System.out.println("Nombre: ");
					String nNombre = Leer.porTeclado();

					System.out.println("Edad: ");
					int nEdad = Integer.parseInt(Leer.porTeclado());  //OJO => EL MÉTODO DEVUELVE UN STRING

					resultado = agenda.modificarP(dni, nDni, nNombre, nEdad);
					System.out.println(resultado);
					break;


				case 4:

					System.out.println("\nUsted ha elegido eliminar persona.");
					System.out.println("Introduzca el DNI de la persona que desea eliminar.");

					System.out.println("DNI: ");
					dni = Leer.porTeclado();

					resultado = agenda.eliminarP(dni);
					System.out.println(resultado);
					break;


				case 5:

					System.out.println("\nUsted ha elegido mostrar lista.");
					System.out.println(agenda.toString());
					break;


				case 9:
					System.out.println("Adiós!");
					break;		


				default: 
					System.out.println("\nLo sentimos, esa opción no existe, pruebe con otra.");
					break;
			}
		}
	}
}