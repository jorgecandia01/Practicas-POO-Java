package Mayo_IOT.Dominio;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public abstract class Sensor implements Serializable
{
	protected String id;
	protected String ubicacion;
	protected TreeMap<Time,Object> mapaHoraValor = new TreeMap<Time,Object>(); //tree para que las keys estén ordenadas
	protected static String UNIDAD;

	//voy implementando un toString, que será lo que escriba en el fichero
	// @Override
	public String ultimoValor()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(id);
		sb.append(", Ubicación: ");
		sb.append(ubicacion);
		sb.append(", Hora: ");
		sb.append(mapaHoraValor.firstKey().toString());
		sb.append("Valor: ");
		sb.append(mapaHoraValor.get(mapaHoraValor.firstKey()));
		sb.append(UNIDAD);

		return sb.toString();
	}

	public String getTodosValores()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(id);
		sb.append(", Ubicación: ");
		sb.append(ubicacion);
		sb.append("HORA -> VALOR MEDIDO: ");

		for(int i = 0; i<mapaHoraValor.size(); i++)
		{
			
		}











		Set keys = mapaHoraValor.keySet();
		Collection values = mapaHoraValor.values();



	}
}