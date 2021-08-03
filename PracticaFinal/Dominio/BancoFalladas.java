package PracticaFinal.Dominio;

import java.util.*;
import PracticaFinal.Dominio.Pregunta;

public class BancoFalladas
{
	// EXISTEN 3 NIVELES: 

	//NIVEL 1: LA PREGUNTA HA SIDO FALLADA 1 VEZ
	//NIVEL 2: LA PREGUNTA HA SIDO FALLADA 2 VECES
	//NIVEL 3: LA PREGUNTA HA SIDO FALLADA 3 VECES O MÁS

	private HashSet<Pregunta> banco; //aquí están todas las preguntas falladas
	private String nombreBanco;

	private HashSet<Pregunta> nivel_1 = new HashSet<Pregunta>();
	private HashSet<Pregunta> nivel_2 = new HashSet<Pregunta>();
	private HashSet<Pregunta> nivel_3 = new HashSet<Pregunta>();

	// HASHMAP CON CADA NIVEL COMO INDICE Y EL HASHSET DE PREGUNTAS FALLADAS COMO VALUE
	private HashMap<String,HashSet<Pregunta>> indexPreguntasFalladas = new HashMap<String,HashSet<Pregunta>>();

	// public static void main(String[] args)
	// {
	// 	BancoFalladas banco = new BancoFalladas("asd", new HashSet<Pregunta>());
	// 	banco.addPreguntaFallada(new Pregunta("a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","q"));
	// }

	public BancoFalladas(String nombre, HashSet<Pregunta> bank)
	{
		this.nombreBanco = nombre;
		this.banco = bank;

		indexPreguntasFalladas.put("Nivel 1", nivel_1);
		indexPreguntasFalladas.put("Nivel 2", nivel_2);
		indexPreguntasFalladas.put("Nivel 3", nivel_3);
	}

	public void addPreguntaFallada(Pregunta pregunta)
	{
		banco.add(pregunta);
		this.nivelar(pregunta);
	}

	public void addPreguntasFalladas(HashSet<Pregunta> preguntas)
	{
		for(Pregunta pregunta:preguntas)
		{
			banco.add(pregunta);
			this.nivelar(pregunta);
		}
	}

	public HashSet<Pregunta> getPreguntasFalladas()
	{
		return banco;
	}

	public HashMap<String,HashSet<Pregunta>> getIndexPF()
	{
		return indexPreguntasFalladas;
	}


	public void nivelar(Pregunta pregunta) // Le pasas una pregunta fallada al método y se encarga de gestionarla sobre el hashmap de niveles
	{
		if(!(nivel_1.contains(pregunta)))
			nivel_1.add(pregunta);
		else if(!(nivel_2.contains(pregunta)))
		{
			nivel_2.add(pregunta);
			nivel_1.remove(pregunta);
		}

		else if(!(nivel_3.contains(pregunta)))
		{
			nivel_3.add(pregunta);
			nivel_2.remove(pregunta);
		}
	}


}