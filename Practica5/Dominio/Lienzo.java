package Practica5.Dominio;
import Practica5.Dominio.Figura;
import java.awt.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Lienzo extends Canvas
{
	ArrayList<Figura> figuras = new ArrayList<Figura>();
	static int NUM = 0;
	//public final int dim = 10;

	void addFigura(Figura fig)
	{
		final int dim = 10;  //CÓMO SERIA PARA PILLAR EL DIM DE APPDIBUJO?? O QUE APPDIBUJO PILLE ESTE DIM
		for(int i=0;i<dim;i++)
			if(figuras.get(i)==null)
			{
				figuras.add(i,fig);
				i=dim; // ESTO FUNCIONA A MODO DE BREAK
			}
	}

	public void paint(Graphics g)
	{
		int i = 0;	
		NUM++;
		//g.setColor(Color.RED);	=> AHORA SE ELIGE EN LA INSTANCIA			
		for(Figura figura:figuras)
		{
			if(figura!=null)
			{
				System.out.println("N: " + NUM + "-" + ++i);
				g.setColor(figura.getColor());


				if(figura instanceof Cuadrado)
				{
					if(figura.isRelleno())
						g.fillRect(figura.getX(), figura.getY(), figura.getLado(), figura.getLado()); 
					else
						g.drawRect(figura.getX(), figura.getY(), figura.getLado(), figura.getLado()); 
				}

				if(figura instanceof Circulo)
				{
					if(figura.isRelleno())
						g.fillOval(figura.getX(), figura.getY(), figura.getRadio(), figura.getRadio()); 
					else
						g.drawOval(figura.getX(), figura.getY(), figura.getRadio(), figura.getRadio()); 
				}
			}
		}
	}
}