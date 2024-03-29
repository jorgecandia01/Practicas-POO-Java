import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	Cuadrado cuadrados[] = new Cuadrado[10];
	static int NUM = 0;

	void addCuadrado(Cuadrado c)
	{
		for(int i=0;i<cuadrados.length;i++)
			if(cuadrados[i]==null)
			{
				cuadrados[i] = c;
				i=cuadrados.length;
			}
	}

	public void paint(Graphics g)
	{
		int i = 0;	
		NUM++;
		g.setColor(Color.RED);			
		for(Cuadrado cuadrado:cuadrados)
		{
			if(cuadrado!=null)
			{
				System.out.println("N: " + NUM + "-" + ++i);
				if(Cuadrado.isRELLENO())
					g.fillRect(cuadrado.getX(), cuadrado.getY(), cuadrado.getLado(), cuadrado.getLado()); 
				else
					g.drawRect(cuadrado.getX(), cuadrado.getY(), cuadrado.getLado(), cuadrado.getLado()); 

			}
		}
	}
}