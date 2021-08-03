package Examen.Dominio;
import Examen.Dominio.ExamenOnline;
import Examen.Dominio.ExamenHibrido;
import Examen.Dominio.ExamenClasico;

public class Bateria
{
	int capacidad;
	int numeroExamenes;
	String nombre;
	Examen bateria[] = new Examen[capacidad];

	public Bateria(String nombre, int capacidad)
	{
		this.nombre = nombre;
		this.capacidad = capacidad;
		//Examen bateria[] = new Examen[capacidad];
	}

	public int getNumero()
	{
		return numeroExamenes;
	}


	public void indexar(Examen examen)
	{
		for(int i=0; i<bateria.length;i++)
			if(bateria[i]!=null)
				bateria[i] = examen;
	}


	public void addExamen(String nombre, int dificultad, String herramienta, String seguridad) //factoria de online
	{
		ExamenOnline examen = new ExamenOnline(nombre,herramienta,dificultad,seguridad);
		Examen ex = new Examen();
		ex = examen;
		bateria.indexar(ex);
	}


	public void addExamen(String nombre, int dificultad, String herramienta) //factoria de hibridos
	{
		ExamenHibrido examen = new ExamenHibrido(nombre,herramienta,dificultad);
		Examen ex = new Examen();
		ex = examen;
		bateria.indexar(ex);
	}


	public void addExamen(String nombre, int dificultad) //factoria de clasicos
	{
		ExamenClasico examen = new ExamenClasico(nombre,dificultad);
		Examen ex = new Examen();
		ex = examen;
		bateria.indexar(ex);
	}


	







	@Override
	public String toString()
	{

	}

}