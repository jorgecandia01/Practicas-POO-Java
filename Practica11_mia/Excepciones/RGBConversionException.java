package Practica11.Excepciones;

public class RGBConversionException extends Exception
{
	private int valor;
	//private String color;

	public RGBConversionException(int valor)
	{
		//this.color = color;
		this.valor = valor;
	}

	@Override
	public String toString()
	{
		return "Los valores RGB deben de estar comprendidos en el intervalo [0-255]\nUsted ha introducido el valor: " + valor; //+ "para el color" + color
	}
}