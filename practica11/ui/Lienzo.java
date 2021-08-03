package practica11.ui;

import practica11.dominio.Figura;
import practica11.dominio.Circulo;
import practica11.dominio.Cuadrado;
import practica11.dominio.Dibujo;
import practica11.dominio.FiguraNoValidaException;

import practica11.util.RGBConversionException;
import practica11.util.Util;

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
	private JVentanaDibujo ventanaDibujo;
	private Dibujo dibujo;

	private Figura figuraPintando;

	public Lienzo(JVentanaDibujo ventanaDibujo)
	{
		this.ventanaDibujo = ventanaDibujo;
		this.dibujo = ventanaDibujo.getDibujo();

		this.setBackground(Color.WHITE);
		this.setPreferredSize(new java.awt.Dimension(800, 600));
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent me)
				{
					try
					{
						Color color = ventanaDibujo.validarColores();
						Point puntoInicial = new Point(me.getX(), me.getY());
						int dimension = 0;

						if(ventanaDibujo.getTipoFiguraAPintar()==JVentanaDibujo.TipoFiguras.CIRCULO)
							figuraPintando = new Circulo(puntoInicial.x, puntoInicial.y, true, color, dimension);	
						else
							figuraPintando = new Cuadrado(puntoInicial.x, puntoInicial.y, true, color, dimension);

						Lienzo.this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));	
						dibujo.addFigura("Grupo Global", figuraPintando);
						Lienzo.this.repaint();	
					}
					catch(NumberFormatException exc)
					{
						JOptionPane.showMessageDialog(Lienzo.this, "El color debe ser un número");
					}
					catch(RGBConversionException exc)
					{
						JOptionPane.showMessageDialog(Lienzo.this, exc.toString());	
					}					
				}

				public void mouseReleased(MouseEvent me)
				{
					Lienzo.this.arrastrandoFigura(me);
					Lienzo.this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					ventanaDibujo.asignarColoresRandom();	
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

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		Collection<Figura> figuras = dibujo.getTodasFiguras();
		for(Figura figura:figuras)
			figura.pintar(g);
	}

	private void arrastrandoFigura(MouseEvent me)
	{
		Point puntoFinal = new Point(me.getX(), me.getY());
		figuraPintando.setPuntoFinal(puntoFinal);
		Lienzo.this.repaint();	
	}
}