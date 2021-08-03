package Practica5.Dominio;
import java.awt.Color;


public abstract class Figura
{
	//ATRIBUTOS DE INSTANCIA

	//int Lado; NO TODAS LAS FIGURAS COMPARTEN ESTE PARAMETRO
	int PosX;
	int PosY;
	Color Col;
	boolean Relleno = false;

	//ATRIBUTOS DE CLASE

	//static boolean RELLENO = false; AHORA ESTO ES PROPIO DE CADA CLASE HIJA



	//MÉTODOS DE INSTANCIA

	void SetPosX(int X)
	{
		if(X>0 && X<800)
			this.PosX = X;
	}

	int getX()
	{
		return PosX;
	}



	void SetPosY(int Y)
	{
		if(Y>0 && Y<600)
			this.PosY = Y;
	}

	int getY()
	{
		return PosY;
	}


/*
	void SetLado(int L)
	{
		if(L<600 && L>1)
			this.Lado = L;
	}

	int getLado()
	{
		return Lado;
	}
*/

	//YA NO SON MÉTODOS DE CLASE
	void setRelleno(boolean relleno)
	{
		Relleno = relleno;
	}

	boolean isRelleno()
	{
		return Relleno;
	}


	void setColor(Color C)
	{
		Col = C;
	}

	Color getColor()
	{
		return Col;
	}


	String getInfo()
	{
		return "Posicion X: " + this.getX() + "\nPosicion Y: " + this.getY() + "\nColor: " + this.getColor() + "\nRelleno? =>" + this.isRelleno();
	}

	abstract void setLado(int L);
	abstract int getLado();
	abstract int getRadio();
	abstract void setRadio(int R);

	//MÉTODOS DE CLASE => NO HAY
/*
	static void setRELLENO(boolean relleno)
	{
		RELLENO = relleno;
	}

	static boolean isRELLENO()
	{
		return RELLENO;
	}
*/


	//CONSTRUCTOR => SIGUE HABIENDO PARA HACER EL super(X,Y, R, C) EN EL CONSTRUCTOR DE CADA CLASE HIJA

	Figura(int X, int Y, boolean R, Color C)  //POR DEFECTO RELLENO ES FALSE
	{
		this.SetPosX(X);
		this.SetPosY(Y);
		this.setRelleno(R);
		this.setColor(C);
	}
}
