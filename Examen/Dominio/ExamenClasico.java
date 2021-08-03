package Examen.Dominio;
import Examen.Dominio.Examen;

public class ExamenClasico extends Examen
{
	private String nombre;
	private int dificultad; //del 0 al 1, expresa porcentaje de dificultad: 0.0 muy fácil, 1.0 muy difícil

	public ExamenClasico(String nombre, int dificultad)
	{
		super(nombre, dificultad);
	}

	public ExamenClasico()
	{
		super();
	}

	//NO se puede modificar la definición de este método
	Object calcula()
	{
		int numero = 78;
		char temp = (char) numero;
		temp = (char) (temp + 1);
		//Debe devolver temp 
		return temp;
	}	

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());

		return  sb.toString();
	}
}