package Practica8.Dominio;
import java.awt.Color;
import Practica8.Dominio.Figura;


public class Cuadrado extends Figura
{

	//ATRIBUTOS DE INSTANCIA

	private int Lado;


	//MÉTODOS DE INSTANCIA SE HEREDAN DE FIGURA EXCEPTO LOS DE LADO

	void setLado(int L)
	{
		if(L<600 && L>1)
			this.Lado = L;
		else
			this.Lado = 200;
	}

	int getLado()
	{
		return Lado;
	}


	@Override
	public String getInfo() //IMPORTANTE HACERLO PUBLIC
	{
		return "Clase: " + this.getClass() + "\n" + super.getInfo() + "\nLado: " + this.getLado();
	} 

	@Override
	public void pintar(java.awt.Graphics g)
	{
		//g.setColor(this.getColor()); LO HAGO EN LA PADRE
		super.pintar(g);
		if(this.isRelleno())
			g.fillRect(this.getX(), this.getY(), this.getLado(), this.getLado()); 
		else
			g.drawRect(this.getX(), this.getY(), this.getLado(), this.getLado()); 
	}


	//CONSTRUCTOR

	public Cuadrado(int X, int Y, boolean R, Color C, int Lado) 
	{
		super(X,Y,R,C);
		this.setLado(Lado);
	}
}