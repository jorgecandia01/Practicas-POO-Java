package Examen.Dominio;

public class Examen
{
	private String nombre;
	private int dificultad; //del 0 al 1, expresa porcentaje de dificultad: 0.0 muy fácil, 1.0 muy difícil

	public Examen(String x, int y)
	{
		nombre = x;
		dificultad = y;
	}

	public Examen()
	{
		this.nombre = "sin nombre";
		this.dificultad = (int) 0.5;

	}

	//NO se puede modificar la definición de este método
	Object calcula()
	{
		int numero = 78;
		char temp = (char) numero;
		//Debe devolver temp 
		return temp;
	}	

	/*
	Método a implementar para que devuelva al abreviatura de una asignatura, siempre 3 caracteres.
	Por ejemplo: de la asignatura programación orientada a objetos, deberá devolver: POO.
	De circuitos Electrónicos: CEL
	De Teoría de la Comunicación: TDL
	De Sistemas Digitales II: SDI
	De estadística: EST
	*/
	String getAbreviatura()
	{
		switch(nombre)
		{
			case "programación orientada a objetos":
			{
				return "POO";
				
			}

			case "circuitos Electrónicos":
			{
				return "CEL";
				
			}

			case "Teoría de la Comunicación":
			{
				return "TDL";
				
			}

			case "Sistemas Digitales II":
			{
				return "SDI";
				
			}

			case "estadística":
			{
				return "EST";
				
			}

			case "Estadística 21":
			{
				return "ES2";
				
			}

			default:
				return "";
		}
	}


	public String toString() //aquí casi me la lias con el public eh jajajaja
	{
		return nombre + "(" + dificultad + ")";
	}
}