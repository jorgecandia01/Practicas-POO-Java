import java.awt.Color;
public class Cuadrado extends Figura
{

	//ATRIBUTOS DE INSTANCIA

	int Lado;

	//ATRIBUTOS DE CLASE

	//static boolean RELLENO = false; NO ES DE CLASE Y SE HEREDA DE FIGURA



	//MÉTODOS DE INSTANCIA SE HEREDAN DE FIGURA EXCEPTO LOS DE LADO
/*
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

*/

	@Override
	void setLado(int L)
	{
		if(L<600 && L>1)
			this.Lado = L;
		else
			this.Lado = 200;
	}

	@Override
	int getLado()
	{
		return Lado;
	}


	@Override
	String getInfo()
	{
		return "Clase: " + this.getClass() + "\n" + super.getInfo() + "\nLado: " + this.getLado();
	} 

	int getRadio(){return 0;} //CHAPUZA => SI NO PONGO ESTO, LIENZO NO VA (COMO SE HARIA?) 

	void setRadio(int R){}; //CHAPUZA => SI NO PONGO ESTO, LIENZO NO VA (COMO SE HARIA?)
/*

	//MÉTODOS DE CLASE

	static void setRELLENO(boolean relleno)
	{
		RELLENO = relleno;
	}

	static boolean isRELLENO()
	{
		return RELLENO;
	}


*/
	//CONSTRUCTOR

	Cuadrado(int X, int Y, boolean R, Color C, int Lado) 
	{
		super(X,Y,R,C);
		this.setLado(Lado);
	}
}