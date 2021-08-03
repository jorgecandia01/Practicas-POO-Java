package Practica9.Dominio;
import Practica9.Dominio.Figura;
import Practica9.Dominio.Dibujo;
import java.awt.*;
import javax.swing.JFrame;
import java.util.*;
import Practica9.UI.JVentanaDibujo;

public class Lienzo extends Canvas //por que no integro el repaint en dibujo y ya?
{
	private JVentanaDibujo ventana;

	public Lienzo(JVentanaDibujo ventana)
	{
		this.ventana = ventana; 
	}

	@Override
	public void paint(Graphics g) //porque en verdad esto lo que hace es refrescar no? pintar todo de 0
	{								//NO, REPAINT ES OTRO METODO!!! (QUE TAMBIEN USO)
		Dibujo dibujo = ventana.getDibujo();	//(creo que este paint como tal no lo uso en esta practica)
		Collection<Figura> figuras = dibujo.getTodasFiguras();
		for(Figura figura:figuras)
			figura.pintar(g);
	}
}




