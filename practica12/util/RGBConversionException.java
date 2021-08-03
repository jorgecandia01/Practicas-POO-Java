package practica12.util;

public class RGBConversionException extends Exception
{
	private String color;
	private int valor;

	public RGBConversionException(String color, int valor)
	{
		this.color = color;
		this.valor = valor;
	}

	@Override
	public String toString()
	{
		return "El color " + color + " no puede tener el valor " + valor + ". Valores válidos: [0-255]";
	}

}