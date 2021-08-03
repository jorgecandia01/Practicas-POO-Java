package PracticaFinal.Dominio;

import java.util.*;
import java.io.Serializable;

public class Pregunta implements Serializable //NOTA: La mayor parte de los atributos no se usan, se implementan por futura escalabilidad del proyecto
{
	// public static void main(String[] args)
	// {
	// 	Pregunta pregunt = new Pregunta("a","ss","d","f","dg","h","j","k","l","z","x","c","v","b","n","m","q");
	// 	Pregunta pregunt2 = new Pregunta("a","s","dd","f","g","h","j","k","l","z","x","c","v","b","n","m","q");
	// 	Pregunta pregunt3 = new Pregunta("b","sss","dd","f","g","h","j","k","l","z","x","c","v","b","n","m","q");

	// 	System.out.println(pregunt.hashCode());
	// 	System.out.println(pregunt2.hashCode());
	// 	System.out.println(pregunt3.hashCode());

	// 	System.out.println(pregunt.equals(pregunt2));
	// 	System.out.println(pregunt3.equals(pregunt2));
	// 	System.out.println(pregunt3.equals(pregunt));		
	// }
	// DEFINO TODOS LOS ATRIBUTOS COMO STRINGS
	// TODAS LAS PREGUNTAS SE IMPORTAN DESDE FICHEROS

	//ELEMENTOS DE CADA PREGUNTA (VENDRÁN OBLIGATORIAMENTE EN ESTE ORDEN EN EL FICHERO)
	private String idPregunta;
	private String codigoPregunta;
	private String pregunta;
	private String respuesta1; //ES LA RESPUESTA 1 PERO CORRESPONDE A LA OPCIÓN A
	private String respuesta2;
	private String respuesta3;
	private String respuesta4;
	private String respuestaCorrecta;
	private String justificacionTexto;
	private String idOrigen;
	private String idTema;
	private String idSubtema; 
	private String modificadoOrigen;
	private String fechaActualizacion;
	private String revision;
	private String idPara;
	private String idCCAADestino;
	//private String idCCAAOrigen;

	public Pregunta(String idPregunta, String codigoPregunta, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, 
		String respuestaCorrecta, String justificacionTexto, String idOrigen, String idTema, String idSubtema, String modificadoOrigen, String fechaActualizacion,
		String revision, String idPara, String idCCAADestino) //17 atributos
	{
		this.idPregunta = idPregunta;
		this.codigoPregunta = codigoPregunta;
		this.pregunta = pregunta;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuesta4 = respuesta4;
		this.respuestaCorrecta = respuestaCorrecta;
		this.justificacionTexto = justificacionTexto;
		this.idOrigen = idOrigen;
		this.idTema = idTema;
		this.idSubtema = idSubtema;
		this.modificadoOrigen = modificadoOrigen;
		this.fechaActualizacion = fechaActualizacion;
		this.revision = revision;
		this.idPara = idPregunta;
		this.idCCAADestino = idCCAADestino;
	}


	public ArrayList<String> getPregunta()
	{
		ArrayList<String> atributos = new ArrayList<String>();

		atributos.add(this.idPregunta);
		atributos.add(this.codigoPregunta);
		atributos.add(this.pregunta);
		atributos.add(this.respuesta1);
		atributos.add(this.respuesta2);
		atributos.add(this.respuesta3);
		atributos.add(this.respuesta4);
		atributos.add(this.respuestaCorrecta);
		atributos.add(this.justificacionTexto);
		atributos.add(this.idOrigen);
		atributos.add(this.idTema);
		atributos.add(this.idSubtema);
		atributos.add(this.modificadoOrigen);
		atributos.add(this.fechaActualizacion);
		atributos.add(this.revision);
		atributos.add(this.idPara);
		atributos.add(this.idCCAADestino);

		return atributos;
	}


	// GETTER ESPECIFICO CON LA PREGUNTA, LAS 4 RESPUESTAS, LA RESPUESTA CORRECTA Y LA JUSTIFICACIÓN PARA MAYOR COMODIDAD
	public ArrayList<String> getPreguntaLimpia()
	{
		ArrayList<String> atributos = new ArrayList<String>();

		atributos.add(this.pregunta);
		atributos.add(this.respuesta1);
		atributos.add(this.respuesta2);
		atributos.add(this.respuesta3);
		atributos.add(this.respuesta4);
		atributos.add(this.respuestaCorrecta);
		atributos.add(this.justificacionTexto);

		return atributos;		
	}

	@Override // SETTEO EL ID DE LA PREGUNTA COMO HS, LA LÓGICA DE COMPARAR PREGUNTAS Y RESPUESTAS LA IMPLANTO EN EL I/O
	public int hashCode()
	{
		return this.idPregunta.hashCode(); //creo 2 preguntas con el mismo id (pasado como string individual), sus HC coinciden?
	}

	public String getId()
	{
		return this.idPregunta;
	}

	public String getEnunciado()
	{
		return this.pregunta;
	}

	public String[] getRespuestas()
	{
		String[] respuestas = new String[4];
		respuestas[0] = respuesta1;
		respuestas[1] = respuesta2;
		respuestas[2] = respuesta3;
		respuestas[3] = respuesta4;
		return respuestas;
	}

	public String getCorrecta()
	{
		return this.respuestaCorrecta;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Pregunta)
		{
			Pregunta p = (Pregunta) obj;
			if(this.idPregunta == p.getId())
				return true;
			else 
				return false;
		}
		else
			return false;
	}

}


// new Pregunta("a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","q")