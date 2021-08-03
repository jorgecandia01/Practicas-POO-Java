package Practica11.Dominio;

import java.awt.Color;
import javax.swing.JTextField;


public class Util
{
	/** 
		Detiene el programa el tiempo especificado
		@param segundos número de segundos a esperar 
	*/
	public static void wait(int segundos)  
	{										
		try
		{
			Thread.sleep(segundos*1000);
		}
		catch(Exception e)
		{

		}
	}

	public static int getColorRGBRandom()
	{
		return (int) (Math.random()*255);
	}

	// public static void coloresRandom(JTextField r,JTextField g,JTextField b)
	// {
	// 	r.setText(String.valueOf(Util.getColorRGBRandom())); //Lo convierto todo a string porque es lo que asigno a las cajas de texto
	// 	g.setText(String.valueOf(Util.getColorRGBRandom()));
	// 	b.setText(String.valueOf(Util.getColorRGBRandom()));
	// }

	public static Color asignarColor(int r, int g, int b)
	{
		return new Color(r,g,b);
	}
}