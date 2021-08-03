package Practica8.Dominio;
import java.awt.Color;
import Practica8.Dominio.Figura;
import java.awt.*;
import javax.swing.JFrame;

public class Circulo extends Figura
{
	private int Radio;

	void setRadio(int Rad)
	{
		if(Rad>1 && Rad<600)
			this.Radio = Rad;
		else
			this.Radio = 100;
	}

	int getRadio()
	{
		return Radio;
	}

	@Override
	public String getInfo() //IMPORTANTE HACERLO PUBLIC
	{
		return "Clase: " + this.getClass() + "\n" + super.getInfo() + "\nRadio: " + this.getRadio();
	} 

	@Override
	public void pintar(java.awt.Graphics g)
	{
		//g.setColor(this.getColor()); LO HAGO EN LA PADRE
		super.pintar(g);
		if(this.isRelleno())
			g.fillOval(this.getX(), this.getY(), this.getRadio(), this.getRadio()); 
		else
			g.drawOval(this.getX(), this.getY(), this.getRadio(), this.getRadio()); 
	}


	public Circulo(int X, int Y, boolean R, Color C, int Rad) 
	{
		super(X,Y,R,C);
		this.setRadio(Rad);
	}
}




