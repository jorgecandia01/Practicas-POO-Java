package Mayo2020.IO;

import java.io.*;
import java.util.*;
import Mayo2020.Dominio.*;

public class IO
{


	public static HashSet<Alumno> leerCSV(String p)
	{
		String path = p;
		HashSet<Alumno> alumnos = new HashSet<Alumno>();

		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			String linea = "";
			while((linea = br.readLine()) != null)
			{
				String valores[] = linea.split(",");

				for(String valor:valores)
					valor = valor.trim();

				if(!(alumnos.contains(Integer.valueOf(valor[0]))))
				{	//el alumno aun no esta en la base de datos
					if(valores.length>4) //asigantura con practica

				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}




		return alumnos;
	}



	public void writeAlumnos(HashSet<Alumno> alumnos, String path)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

			for(Alumno alumno:alumnos)
				oos.writeObject(alumno);

			oos.close();
		}
		catch()
		{

		}
	}
}