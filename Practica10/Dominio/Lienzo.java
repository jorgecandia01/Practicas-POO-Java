package Practica10.Dominio;

import Practica10.Dominio.Dibujo;
import Practica10.Dominio.Figura;
import Practica10.Dominio.Circulo;
import Practica10.Dominio.Cuadrado;
import Practica10.Dominio.Lienzo;
import Practica10.Dominio.Util;
import Practica10.UI.JVentanaDibujo;
import Practica10.Excepciones.RGBConversionException;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.*;

import javax.swing.JOptionPane;

import java.util.Collection;


public class Lienzo extends Canvas //por que no integro el repaint en dibujo y ya?
{
	private JVentanaDibujo ventana;
	private Dibujo dibujo;

	private Figura figuraPintando;

	public Lienzo(JVentanaDibujo ventana)
	{


		this.ventana = ventana; 
		this.dibujo = ventana.getDibujo();

		this.setBackground(Color.WHITE);
		this.setPreferredSize(new java.awt.Dimension(800, 600));
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				Color color = ventana.getColor();
				Point puntoInicial = new Point(me.getX(), me.getY()); 
				int dimension = 0; //Esto es el lado/radio
				if(ventana.getTipo() == ventana.CIRCULO)
					figuraPintando = new Circulo(puntoInicial.x, puntoInicial.y, true, color, dimension);
				else
					figuraPintando = new Cuadrado(puntoInicial.x, puntoInicial.y, true, color, dimension);

				Lienzo.this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));	
				dibujo.addFigura("Grupo Global", figuraPintando);
				Lienzo.this.repaint();
			}

			public void mouseReleased(MouseEvent me)
			{
				Lienzo.this.arrastrandoFigura(me);
				Lienzo.this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
				ventana.asignarColoresRandom();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent me)
			{
				Lienzo.this.arrastrandoFigura(me);
			}
		});	
		
	}




	private void arrastrandoFigura(MouseEvent me)
	{
		Point puntoFinal = new Point(me.getX(), me.getY());
		figuraPintando.setPuntoFinal(puntoFinal);
		Lienzo.this.repaint();	
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




