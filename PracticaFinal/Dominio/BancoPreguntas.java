package PracticaFinal.Dominio;

import java.util.*;
import PracticaFinal.Dominio.Pregunta;

public class BancoPreguntas
{
	private HashSet<Pregunta> banco;
	private String nombreBanco;

	public BancoPreguntas(String nombre, HashSet<Pregunta> bank)
	{
		this.nombreBanco = nombre;
		this.banco = bank;
	}

	public BancoPreguntas(HashSet<Pregunta> bank)
	{
		this.nombreBanco = "Estándar";
		this.banco = bank;
	}

	public void addPregunta(Pregunta pregunta)
	{
		banco.add(pregunta);
	}

	public void addPreguntas(HashSet<Pregunta> preguntas)
	{
		for(Pregunta pregunta:preguntas)
			banco.add(pregunta);
	}

	public HashSet<Pregunta> getPreguntas()
	{
		return banco;
	}

	public int getSize()
	{
		return banco.size();
	}
}