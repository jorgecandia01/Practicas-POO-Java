package Practica11.Dominio;

import Practica11.Dominio.Dibujo;
import Practica11.Dominio.Figura;
import Practica11.Dominio.Circulo;
import Practica11.Dominio.Cuadrado;
import Practica11.Dominio.Lienzo;
import Practica11.Dominio.Util;
import Practica11.UI.JVentanaDibujo;
import Practica11.Excepciones.RGBConversionException;

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


public class Lienzo extends javax.swing.JPanel 
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
	public void paint(Graphics g) 
	{								
	//	Dibujo dibujo = ventana.getDibujo();	//esto ya lo hago en el constructor
		Collection<Figura> figuras = dibujo.getTodasFiguras();
		for(Figura figura:figuras)
			figura.pintar(g);
	}


	@Override
	public void paintComponent(Graphics g) //wtf es esto
	{
		super.paintComponent(g); 
		Collection<Figura> figuras = dibujo.getTodasFiguras();
		for(Figura figura:figuras)
			figura.pintar(g);
	}
}














// package practica11.ui;

// import practica11.dominio.Figura;
// import practica11.dominio.Circulo;
// import practica11.dominio.Cuadrado;
// import practica11.dominio.Dibujo;
// import practica11.dominio.FiguraNoValidaException;

// import practica11.util.RGBConversionException;
// import practica11.util.Util;

// import java.awt.Canvas;
// import java.awt.Graphics;
// import java.awt.Cursor;
// import java.awt.Color;
// import java.awt.Point;

// import java.awt.event.MouseEvent;
// import java.awt.event.MouseAdapter;

// import javax.swing.JOptionPane;

// import java.util.Collection;


// public class Lienzo extends javax.swing.JPanel
// {
// 	private JVentanaDibujo ventanaDibujo;
// 	private Dibujo dibujo;

// 	private Point puntoInicial;

// 	public Lienzo(JVentanaDibujo ventanaDibujo)
// 	{
// 		this.ventanaDibujo = ventanaDibujo;
// 		this.dibujo = ventanaDibujo.getDibujo();

// 		this.setBackground(Color.WHITE);
// 		this.setPreferredSize(new java.awt.Dimension(800, 600));
// 		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
// 		this.addMouseListener(new MouseAdapter()
// 			{
// 				public void mouseClicked(MouseEvent me)
// 				{
// 					Lienzo.this.gestionarEventoMouse(me);
// 				}
// 			});		
// 	}

// 	@Override
// 	public void paintComponent(Graphics g)
// 	{
// 		super.paintComponent(g); 
// 		Collection<Figura> figuras = dibujo.getTodasFiguras();
// 		for(Figura figura:figuras)
// 			figura.pintar(g);
// 	}

// 	private void gestionarEventoMouse(MouseEvent me)
// 	{
// 		try
// 		{
// 			Color color = ventanaDibujo.validarColores();
// 			if(puntoInicial == null)
// 			{
// 				puntoInicial = new Point(me.getX(), me.getY());
// 				Lienzo.this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));						
// 			}
// 			else
// 			{
// 				Point puntoFinal = new Point(me.getX(), me.getY());
// 				int dimension = puntoFinal.x - puntoInicial.x;
// 				if(dimension<0)
// 				{
// 					puntoInicial = puntoFinal;
// 					dimension = Math.abs(dimension);
// 				}

// 				Figura figura = null;
// 				if(ventanaDibujo.getTipoFiguraAPintar()==JVentanaDibujo.TipoFiguras.CUADRADO)
// 					figura = new Circulo(puntoInicial.x, puntoInicial.y, true, color, dimension);	
// 				else
// 					figura = new Cuadrado(puntoInicial.x, puntoInicial.y, true, color, dimension);	

// 				dibujo.addFigura("Grupo Global", figura);
// 				Lienzo.this.repaint();
// 				puntoInicial = null;
// 				Lienzo.this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
// 				ventanaDibujo.asignarColoresRandom();
// 			}
// 		}
// 		catch(NumberFormatException exc)
// 		{
// 			JOptionPane.showMessageDialog(Lienzo.this, "El color debe ser un número");
// 		}
// 		catch(RGBConversionException exc)
// 		{
// 			JOptionPane.showMessageDialog(Lienzo.this, exc.toString());	
// 		}
// 	}

// }
