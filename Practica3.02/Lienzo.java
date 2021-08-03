import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	Figura figuras[] = new Figura[10];
	static int NUM = 0;

	void addFigura(Figura fig)
	{
		for(int i=0;i<figuras.length;i++)
			if(figuras[i]==null)
			{
				figuras[i] = fig;
				i=figuras.length; // ESTO FUNCIONA A MODO DE BREAK
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