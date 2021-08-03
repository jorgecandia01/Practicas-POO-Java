package Practica11.Dominio;
import java.awt.Color;
import Practica11.Dominio.Figura;


public class Cuadrado extends Figura
{

	//ATRIBUTOS DE INSTANCIA

	private int Lado;


	//MÉTODOS DE INSTANCIA SE HEREDAN DE FIGURA EXCEPTO LOS DE LADO

	public void setDimension(int L)
	{
		if(L<600 && L>=0)
			this.Lado = L;
		else
			this.Lado = 200;
	}

	int getDimension()
	{
		return Lado;
	}


	@Override
	public String getInfo() //IMPORTANTE HACERLO PUBLIC
	{
		return "Clase: " + this.getClass() + "\n" + super.getInfo() + "\nLado: " + this.getDimension();
	} 

	@Override
	public void pintar(java.awt.Graphics g)
	{
		//g.setColor(this.getColor()); LO HAGO EN LA PADRE
		super.pintar(g);
		if(this.isRelleno())
			g.fillRect(this.getX(), this.getY(), this.getDimension(), this.getDimension()); 
		else
			g.drawRect(this.getX(), this.getY(), this.getDimension(), this.getDimension()); 
	}


	//CONSTRUCTOR

	public Cuadrado(int X, int Y, boolean R, Color C, int L) 
	{
		super(X,Y,R,C,L);
	}
}