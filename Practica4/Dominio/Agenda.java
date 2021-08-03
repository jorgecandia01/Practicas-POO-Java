package Practica4.Dominio;

import Practica4.Dominio.Persona;

public class Agenda
{
	//ATRIBUTOS

	public static final int MAX_PERSONAS = 10;
	private Persona personas[];
	private String nombre;
	private int size;


	//CONSTRUCTOR DE AGENDA
	public Agenda(String nom)
	{
		this.nombre = nom;
		size = 0;
		personas = new Persona[MAX_PERSONAS];
	}


	//METODOS DE INSTANCIA

	public String getNombre()
	{
		return nombre;
	}

	public int getSize()
	{
		return size;
	}


	//1.- CREAR PERSONA => LO HAGO EN LA PROPIA APP

	public void crearP(String dni, String nombre, int edad)
	{
		for(int i = 0; i<personas.length; i++)
		{
			System.out.println("iteración");
			if(personas[i] == null)
			{
				personas[i] = new Persona(dni, nombre, edad);
				System.out.println("persona añadida");
				size++;
				i = personas.length;  //NO OLVIDARSE O ME LLENA LA LISTA CON LA MISMA PERSONA!!!!
			}
		}
	}


	//2.- BUSCAR PERSONA

	public String buscarP(String dni) 
	{
		Persona pComp = new Persona(dni);
		String retorno = "";

		for(int i = 0; i<personas.length; i++)
		{
			System.out.println("iteración");
			if(personas[i].equals(pComp) && personas[i]!=null) //DELEGO A PERSONA
			{
				retorno = "\nDatos de la persona con DNI " + dni + ":\n" + personas[i].toString();
				i = personas.length; //BREAK
			}
			else
				if(i==personas.length)
					retorno = "\nLo sentimos, el DNI que ha introducido no coincide con ninguno de la agenda.";
				else
					retorno = "";
		}
		return retorno;
	}


	//3.- MODIFICAR PERSONA

	public String modificarP(String dni, String nDni, String nNombre, int nEdad) 
	{
		Persona pComp = new Persona(dni);
		String retorno = "";

		for(int i = 0; i<personas.length; i++)
		{
			if(personas[i].equals(pComp) && personas[i]!=null) //DELEGO A PERSONA
			{
				personas[i].setDni(nDni); 
				personas[i].setNombre(nNombre); 
				personas[i].setEdad(nEdad); 
				retorno = "\nPersona modificada exitosamente.";
				i = personas.length; //BREAK
			}
			else
				if(i==personas.length)
					retorno = "\nLo sentimos, el DNI que ha introducido no coincide con ninguno de la agenda.";
		}
		return retorno;
	}



	//4.- ELIMINAR PERSONA

	public String eliminarP(String dni)
	{
		Persona pComp = new Persona(dni);
		String retorno = "";

		for(int i = 0; i<personas.length; i++)
		{
			if(personas[i].equals(pComp) && personas[i]!=null) //DELEGO A PERSONA
			{
				personas[i] = null; 
				retorno = "\nPersona eliminada exitosamente.";
				size--;
				i = personas.length;
			}
			else
				if(i==personas.length)
					retorno = "\nLo sentimos, el DNI que ha introducido no coincide con ninguno de la agenda.";
		}
		return retorno;
	}



	//5.- LISTAR TODAS LAS PERSONAS

	@Override
	public String toString()
	{
		StringBuilder info = new StringBuilder();
		info.append("\n\n------------------------------------");

		for(int i=0 ; i<personas.length ; i++)
			if(personas[i] != null)
			{
				info.append("\nInformación de la persona número " + i +":\n");
				info.append(personas[i].toString());
				info.append("\n------------------------------------");
			}

		return info.toString();
	}

};