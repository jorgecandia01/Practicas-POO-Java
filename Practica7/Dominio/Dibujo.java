package Practica7.Dominio;
import Practica7.Dominio.Figura;
import Practica7.Dominio.Lienzo;
import java.awt.*;
import javax.swing.JFrame;

public class Dibujo extends JFrame
{
	Lienzo lienzo;

	public Dibujo()
	{
		super("Dibujo");
		lienzo = new Lienzo();
		lienzo.setSize(800,600);
		this.add(lienzo);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}




	/** 
		Pinta el figura recibido por el App y actualiza el lienzo (canvas) 
		@param figura figura a pintar
	*/
	public void pintar(String grupo, Figura figura)
	{
		lienzo.addFigura(grupo, figura);
		lienzo.repaint();
	}


	public void ocultarGrupo(String grupo)
	{
		lienzo.visualizarGrupo(grupo, false);
		lienzo.repaint();
	}

	public void mostrarGrupo(String grupo)
	{
		lienzo.visualizarGrupo(grupo, true);
		lienzo.repaint();
	}	

	public void ocultarTodasFiguras()
	{
		lienzo.visualizarTodo(false);
		lienzo.repaint();
	}

	public void mostrarTodasFiguras()
	{
		lienzo.visualizarTodo(true);
		lienzo.repaint();
	}		
	

}












