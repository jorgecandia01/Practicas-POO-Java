package Practica8.Dominio;
import java.awt.Color;

public abstract class Figura
{
	//ATRIBUTOS DE INSTANCIA

	protected int PosX;
	protected int PosY;
	protected Color Col;
	protected boolean Relleno = false;
	protected boolean visible = true;	//Las pintaré si son visibles

	//ATRIBUTOS DE CLASE

	//MÉTODOS DE INSTANCIA

	void SetPosX(int X)
	{
		if(X>0 && X<800)
			this.PosX = X;
	}

	public int getX()
	{
		return PosX;
	}

	void SetPosY(int Y)
	{
		if(Y>0 && Y<600)
			this.PosY = Y;
	}

	public int getY()
	{
		return PosY;
	}

	void setRelleno(boolean relleno)
	{
		this.Relleno = relleno;
	}

	public boolean isRelleno()
	{
		return Relleno;
	}

	void setColor(Color C)
	{
		this.Col = C;
	}

	public Color getColor()
	{
		return Col;
	}


	public String getInfo()
	{
		return "Posicion X: " + this.getX() + "\nPosicion Y: " + this.getY() + "\nColor: " + this.getColor() + "\nRelleno? =>" + this.isRelleno();
	}

	public void pintar(java.awt.Graphics g)
	{
		g.setColor(this.Col);
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	public boolean isVisible() 		
	{
		return visible;
	}


	Figura(int X, int Y, boolean R, Color C)  //POR DEFECTO RELLENO ES FALSE
	{
		this.SetPosX(X);
		this.SetPosY(Y);
		this.setRelleno(R);
		this.setColor(C);
	}
}













