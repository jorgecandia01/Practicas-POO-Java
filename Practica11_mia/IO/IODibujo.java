package Practica11.IO;

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

import Practica11.Dominio.Dibujo;

// public class IODibujo
// {

// 	public static Dibujo leer()
// 	{
// 		Dibujo dibujo = null;
// 		try
// 		{
// 			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dibujo.obj"));
// 			dibujo = (Dibujo) ois.readObject();
// 			ois.close();
// 		}
// 		catch(FileNotFoundException fnf)
// 		{
// 			System.out.println(">>No se encuentra el fichero");
// 		}
// 		catch(ClassNotFoundException cnf)
// 		{
// 			System.out.println(">>No se encuentra la clase");
// 		}
// 		catch(IOException io)
// 		{
// 			System.out.println(">>Error en la lectura del fichero");
// 		}

// 		return dibujo;
// 	}


// 	public static void guardar(Dibujo dibujo)
// 	{
//  		try
// 		{
// 			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dibujo.obj"));
// 			oos.writeObject(dibujo);
// 			oos.close();
// 		}
// 		catch(IOException io)
// 		{
// 			System.out.println(">>Error de guardo");
// 		}

// 	}

// }



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