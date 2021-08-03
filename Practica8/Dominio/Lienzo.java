package Practica8.Dominio;
import Practica8.Dominio.Figura;
import Practica8.Dominio.Dibujo;
import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

public class Lienzo extends Canvas //por que no integro el repaint en dibujo y ya?
{
	private JVentanaDibujo ventana;

	public Lienzo(JVentanaDibujo ventana)
	{
		this.ventana = ventana; 
	}

	//@Override seria override de paint, pero le he cambiado el nombre
	public void paint(Graphics g) //porque en verdad esto lo que hace es refrescar no? pintar todo de 0
	{								//NO, REPAINT ES OTRO METODO!!! (QUE TAMBIEN USO)
		Dibujo dibujo = ventana.getDibujo();	//(creo que este paint como tal no lo uso en esta practica)
		Collection<Figura> figuras = dibujo.getTodasFiguras();
		for(Figura figura:figuras)
			figura.pintar(g);
	}
}




