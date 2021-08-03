package practica12.io;

import java.util.Iterator;
import java.util.Collection;

import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.*;

import java.util.ArrayList;
import java.util.Collection;

import practica12.dominio.Dibujo;
import practica12.dominio.Figura;
import practica12.dominio.Cuadrado;
import practica12.dominio.Circulo;
import java.awt.Color;

public class IODibujo
{
	public static void main(String[] args)
	{

		ArrayList<Figura> figuras = (ArrayList<Figura>) IODibujo.leerCSV();
		for(Figura figura:figuras)
			System.out.println(figura.getClass());
	}

	public static void guardar(Dibujo dibujo)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("dibujo.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dibujo);
			oos.close();
			fos.close();
		}
		catch(IOException e)
		{
			System.out.println("Se produjo un error en la escritura del archivo");
		}
	}	

	public static Dibujo leer() 
	{
		Dibujo dibujo = null;
		try
		{
			FileInputStream fis = new FileInputStream("dibujo.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			dibujo = (Dibujo) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Clases no encontradas");
		}
		catch(FileNotFoundException e)
		{
			//Desarrollo: e.printStackTrace();
			//Solo en Producción:
			System.out.println("No se encontró el fichero");
		}
		catch(IOException e)
		{
			//Desarrollo: e.printStackTrace();
			//Solo en Producción:
			System.out.println("Se produjo un error en la lectura del archivo");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return dibujo;
	}	


	// ESTRUCTURA: Tipo Objeto, x, y, relleno, color.getRGB(), lado/radio

	public static Collection<Figura> leerCSV() //poner el pasar como atributo un string si quiero leer un csv en específico
	{
		Collection<Figura> figuras = new ArrayList<Figura>();
		final String CUADRADO = "cuadrado";
		final String CIRCULO  = "circulo"; 
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("ejemploCSV.csv"));
			String linea = null;

			while((linea = br.readLine()) != null)
			{
				String atributos[] = linea.split(",");

				String tipo = atributos[0].trim().toLowerCase();
				int x = Integer.parseInt(atributos[1].trim());
				int y = Integer.parseInt(atributos[2].trim());
				boolean relleno = Boolean.parseBoolean(atributos[3].trim());
				Color color = new Color(Integer.parseInt(atributos[4].trim()));
				int dimension = Integer.parseInt(atributos[5].trim()); 

				if(tipo.equals(CUADRADO)) // OJO => .EQUALS!!!! NO ==
					figuras.add(new Cuadrado(x, y, relleno, color, dimension));
				if(tipo.equals(CIRCULO))
					figuras.add(new Circulo(x, y, relleno, color, dimension));
			}
		}
		catch(FileNotFoundException e)
		{
			//Desarrollo: e.printStackTrace();
			//Solo en Producción:
			System.out.println("No se encontró el fichero");
		}
		catch(IOException e)
		{
			//Desarrollo: e.printStackTrace();
			//Solo en Producción:
			System.out.println("Se produjo un error en la lectura del archivo");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return figuras;
	}

	public static void guardarCSV(ArrayList<Figura> figuras_a_guardar)
	{
		ArrayList<Figura> figuras = figuras_a_guardar;

		try
		{
			PrintWriter pw = new PrintWriter(new FileWriter("ejemploGCSV.csv"));

			for(Figura figura:figuras)
				pw.println(figura.toString());

			pw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}



}