package practica11.io;

import java.util.Iterator;
import java.util.Collection;

import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

import java.util.ArrayList;
import java.util.Collection;

import practica11.dominio.Dibujo;

public class IODibujo
{
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

		return dibujo;
			
	}	


}