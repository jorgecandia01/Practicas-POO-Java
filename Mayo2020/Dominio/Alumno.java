package Mayo2020.Dominio;

import java.util.*;

public class Alumno
{
	//clave, titulo, asignatura, nota teoría, % práctica, nota práctica
	private Integer clave;
	private String titulo;
	private HashSet<Asignatura> asignaturas;

	private float notaMedia;

	public Alumno(int clave, String titulo, HashSet<Asignatura> asignaturas)
	{
		this.clave = clave;
		this.titulo = titulo;
		this.asignaturas = asignaturas;

		this.notaMedia = this.getMedia();
	}

	public float getMedia()
	{
		float bigNota = (float) 0.0;

		for(Asignatura asignatura:asignaturas)
		{
			bigNota = bigNota + asignatura.getNota();
		}

		return bigNota/asignaturas.size();
	}

	public HashSet<Asignatura> getAsignaturas()
	{
		return asignaturas;
	}

	@Override
	public int hashCode()
	{
		return this.clave.hashCode();
	}

}