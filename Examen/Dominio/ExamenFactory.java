package Examen.Dominio;
import Examen.Dominio.ExamenOnline;
import Examen.Dominio.ExamenHibrido;
import Examen.Dominio.ExamenClasico;

public class ExamenFactory
{
	public static ExamenOnline ExamenFactory(String nombre, int dificultad, String herramienta, String seguridad) //factoria de online
	{
		ExamenOnline examen = new ExamenOnline(nombre,herramienta,dificultad,seguridad);
		return examen;
	}


	public static ExamenHibrido ExamenFactory(String nombre, int dificultad, String herramienta) //factoria de hibridos
	{
		ExamenHibrido examen = new ExamenHibrido(nombre,herramienta,dificultad);
		return examen;
	}


	public static ExamenClasico ExamenFactory(String nombre, int dificultad) //factoria de clasicos
	{
		ExamenClasico examen = new ExamenClasico(nombre,dificultad);
		return examen;
	}
}
