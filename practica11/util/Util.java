package practica11.util;

import java.awt.Color;

public class Util
{
	/** 
		Detiene el programa el tiempo especificado
		@param segundos número de segundos a esperar 
	*/
	public static void wait(double segundos)
	{
		try
		{
			Thread.sleep((long) (segundos*1000));
		}
		catch(Exception e)
		{

		}
	}

	public static Color rgbToColor(int r, int g, int b) throws RGBConversionException
	{
		if((r < 0 || r > 255))
			throw new RGBConversionException("Rojo", r);
		else if((g < 0 || g > 255))
			throw new RGBConversionException("Verde", g);
		else if((b < 0 || b > 255))
			throw new RGBConversionException("Azul", b);
		else
			return new Color(r, g, b);
	}

	public static int getColorRGBRandom()
	{
		return (int) (Math.random()*255);
	}
}