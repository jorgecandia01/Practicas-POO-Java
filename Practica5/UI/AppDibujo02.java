package Practica5.UI;
import Practica5.Dominio.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class AppDibujo02
{
	public static void main(String[] args)
	{
		//Util util = new Util; NO HACE FALTA INSTANCIAR UTIL => Util.wait(s) ES METODO DE CLASE
		Dibujo dibujo = new Dibujo();

		List<Figura> figuras = new ArrayList<Figura>();

		final int dim = 10;
		for(int i=0; i<dim;i++) //Lienzo.dim
		{
			figuras.add(i, new Cuadrado(50+25*i,50+25*i,false,Color.blue,120));
			System.out.println(figuras.get(i));
			System.out.println(figuras.get(i).getClass());
		}


		for(int i=0;i<figuras.size();i++)
			if(figuras.get(i) != null)
			{
				//System.out.println(figuras[i].getInfo() + "\n\n--------------------\n");
				dibujo.pintar(figuras.get(i));
				//Util.wait(1);
			}
	} 
}