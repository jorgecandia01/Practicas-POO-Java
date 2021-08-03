package Practica5.Dominio;

public class Util
{
	/** 
		Detiene el programa el tiempo especificado
		@param segundos número de segundos a esperar 
	*/
	public static void wait(int segundos)  //static y ya? no public static? quién puede acceder a métodos de clase con el modificador por defecto?
	{										//SI!!!! PARA JUGAR CON PAQUETES TIENE QUE SER PUBLIC O DA ERROR!!!
		try
		{
			Thread.sleep(segundos*1000);
		}
		catch(Exception e)
		{

		}
	}
}