package Examen.Dominio;

public class Examen
{
	private String nombre;
	private int dificultad; //del 0 al 1, expresa porcentaje de dificultad: 0.0 muy f�cil, 1.0 muy dif�cil

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

	//NO se puede modificar la definici�n de este m�todo
	Object calcula()
	{
		int numero = 78;
		char temp = (char) numero;
		//Debe devolver temp 
		return temp;
	}	

	/*
	M�todo a implementar para que devuelva al abreviatura de una asignatura, siempre 3 caracteres.
	Por ejemplo: de la asignatura programaci�n orientada a objetos, deber� devolver: POO.
	De circuitos Electr�nicos: CEL
	De Teor�a de la Comunicaci�n: TDL
	De Sistemas Digitales II: SDI
	De estad�stica: EST
	*/
	String getAbreviatura()
	{
		switch(nombre)
		{
			case "programaci�n orientada a objetos":
			{
				return "POO";
				
			}

			case "circuitos Electr�nicos":
			{
				return "CEL";
				
			}

			case "Teor�a de la Comunicaci�n":
			{
				return "TDL";
				
			}

			case "Sistemas Digitales II":
			{
				return "SDI";
				
			}

			case "estad�stica":
			{
				return "EST";
				
			}

			case "Estad�stica 21":
			{
				return "ES2";
				
			}

			default:
				return "";
		}
	}


	public String toString() //aqu� casi me la lias con el public eh jajajaja
	{
		return nombre + "(" + dificultad + ")";
	}
}