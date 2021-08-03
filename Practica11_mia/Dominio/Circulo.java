package Practica11.Dominio;
import java.awt.Color;
import Practica11.Dominio.Figura;
import java.awt.*;
import javax.swing.JFrame;

public class Circulo extends Figura
{
	private int Radio;

	@Override
	public void setDimension(int Rad)
	{
		if(Rad>=1 && Rad<600)
			this.Radio = Rad;
		else
			this.Radio = 100;
	}

	int getDimension()
	{
		return Radio;
	}

	@Override
	public String getInfo() //IMPORTANTE HACERLO PUBLIC
	{
		return "Clase: " + this.getClass() + "\n" + super.getInfo() + "\nRadio: " + this.getDimension();
	} 

	@Override
	public void pintar(java.awt.Graphics g)
	{
		//g.setColor(this.getColor()); LO HAGO EN LA PADRE
		super.pintar(g);
		if(this.isRelleno())
			g.fillOval(this.getX(), this.getY(), this.getDimension(), this.getDimension()); 
		else
			g.drawOval(this.getX(), this.getY(), this.getDimension(), this.getDimension()); 
	}


	public Circulo(int X, int Y, boolean R, Color C, int Rad) 
	{
		super(X,Y,R,C,Rad);
	}
}




