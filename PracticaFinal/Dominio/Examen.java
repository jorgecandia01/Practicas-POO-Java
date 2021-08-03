package PracticaFinal.Dominio;

import java.util.*;
import PracticaFinal.Dominio.Pregunta;
import PracticaFinal.Dominio.BancoPreguntas;
import PracticaFinal.Dominio.BancoFalladas;
import PracticaFinal.IO.InOut;

public class Examen //Contiene atributos y métodos para futura escalabilidad como realizar un examen teniendo en cuenta preguntas falladas anteriormente
{
	private String nombre; //puede server a modo de ID, lo pongo porque puede ser útil en un futuro
	private int nPreguntas;
	private BancoPreguntas supply;
	private ArrayList<Pregunta> banco; //pila de TODAS las preguntas disponibles, falladas o no
	private int rateFalladas; // rate de preguntas en este examen que han sido respondidas mal con anterioridad en otros
	private BancoFalladas bancoFalladas;

	private HashSet<Pregunta> preguntasHS;
	
	private ArrayList<Pregunta> preguntasExamen;


	// public static void main(String[] args)
	// {
	// 	Examen examen = new Examen();
	// 	HashSet<Pregunta> pregsHS = examen.getPreguntasExamenHS();
	// 	// System.out.println(pregsHS.size());

	// 	Examen examen2 = new Examen("Estándar", 20, new BancoPreguntas("Estandar", pregsHS), 0, null);
	// 	System.out.println(examen2.getSize());		
	// }

	public Examen() //constructor para hacer debug
	{
		this.nombre = "Examen prueba";
		this.nPreguntas = 20;
		this.supply = new BancoPreguntas("Prueba banco", InOut.importarPreguntasPath("C:\\UNIVERSIDAD\\SEGUNDO\\JAVA\\Practicas\\PracticaFinal\\Libro1.csv"));
		this.banco = new ArrayList<Pregunta>(supply.getPreguntas());
		this.rateFalladas = 0;
		this.bancoFalladas = new BancoFalladas("asd", new HashSet<Pregunta>());
		bancoFalladas.addPreguntaFallada(banco.get(0));

		this.preguntasExamen = this.generarExamen(nPreguntas, rateFalladas);

		this.preguntasHS = new HashSet<Pregunta>(supply.getPreguntas());
	}

	public HashSet<Pregunta> getPreguntasExamenHS()
	{
		return preguntasHS;
	}


	public Examen(String nombre, int npreguntas, BancoPreguntas supply, int ratefalladas, BancoFalladas bancofalladas) //si quiero un examen sin preguntas falladas,
	{																									// pongo ratefalladas a 0 y bancofalladas null
		this.nombre = nombre;

		if(9<npreguntas & npreguntas<=30)
			this.nPreguntas = npreguntas;
		else
			this.nPreguntas = 20;

		this.supply = supply;
		this.banco = new ArrayList<Pregunta>(supply.getPreguntas());

		if(bancofalladas != null)
			this.bancoFalladas = bancofalladas;
		else
			this.bancoFalladas = new BancoFalladas("Estándar", new HashSet<Pregunta>());

		this.rateFalladas = this.getRate(ratefalladas, npreguntas); //no siempre va a coincidir, puede que no haya tantas preguntas falladas o que se meta un % inválido

		//CREO EL EXAMEN

		this.preguntasExamen = this.generarExamen(npreguntas, rateFalladas); //IMP, METO EL RATE ATRIBUTO DEL OBJETO, NO EL DE ENTRADA DEL CONSTRUCTOR!!
	}


	public ArrayList<Pregunta> getPreguntasExamen()
	{
		return preguntasExamen;
	}


	public int getRate(int falladas, int npreguntas)
	{
		int rate;
		if(falladas>= 0 && falladas <= 100)
			rate = falladas;
		else
			rate = 0;

		//Verifico si hay suficientes preguntas falladas
		int nFalladasBanco = bancoFalladas.getPreguntasFalladas().size();
		int nFalladasExamen = (int) npreguntas*(rate/100);

		if(nFalladasExamen > nFalladasBanco)
			rate = 0;

		return rate;
	}





	public ArrayList<Pregunta> generarExamen(int npreguntas, int ratefalladas)
	{
		// System.out.println("asdada"+npreguntas);
		// HashSet<Pregunta> preguntasFalladas = bancoFalladas.getPreguntasFalladas();
		// int rate = ratefalladas/100;

		int sizeBanco = banco.size();
		// int sizeBancoF = preguntasFalladas.size();

		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>(); //preguntas del examen (lo que retorna el método)

		// int pfalladas = (int) npreguntas*rate;
		int pnuevas = npreguntas;//-pfalladas;
		

		for(int i = 0; i<pnuevas; i++) //añado las preguntas nuevas
		{
			// System.out.println("asdada"+pnuevas);
			int j = 0;
			while(j < supply.getSize()) //para evitar un bucle infinito en caso de que no haya suficientes preguntas o whatever
			{							//damos por hecho que en el banco hay muchas más preguntas que las elegidas en el examen (el random no va a dar el mismo nº tantisimas veces)
				// System.out.println(i);
				double d = Math.random()*sizeBanco;
				int nPregunta = (int) d;	//INDICE CON EL QUE VOY A HACER EL GET SOBRE EL BANCO
				Pregunta addingPregunta = banco.get(nPregunta);
				j++; 
			
				if(!(preguntas.contains(addingPregunta)))
				{
					preguntas.add(addingPregunta);	
					j = 5000000; //breakeo el while
				}
			}
		}

		//BANCO DE PREGUNTAS FALLADAS NO DISPONIBLE EN ESTA VERSIÓN DEL PROGRAMA

		// for(int i = 0; i<pfalladas; i++) //añado las preguntas falladas
		// {
		// 	int j = 0;
		// 	while(j < 30)
		// 	{
		// 		double d = Math.random()*sizeBancoF;
		// 		int nPregunta = (int) d;	//INDICE CON EL QUE VOY A HACER EL GET SOBRE EL BANCO
		// 		Pregunta addingPregunta = this.bancoFalladas.get(nPregunta); 
		// 		j++;
			
		// 		if(!(preguntas.contains(addingPregunta)))
		// 		{
		// 			preguntas.add(addingPregunta);
		// 			i++;
		// 			j = 50;
		// 		}
		// 	}
		// }


		return preguntas;
	}


	public int getSize()
	{
		return nPreguntas;
	}

	public ArrayList<String> getCorrectas()
	{
		ArrayList<String> correctas = new ArrayList<String>(); 
		for(Pregunta p:preguntasExamen)
			correctas.add(p.getCorrecta());
		return correctas;
	}
}