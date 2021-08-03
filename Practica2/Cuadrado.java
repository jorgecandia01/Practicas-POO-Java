public class Cuadrado
{

	//ATRIBUTOS DE INSTANCIA

	int Lado;
	int PosX;
	int PosY;

	//ATRIBUTOS DE CLASE

	static boolean RELLENO = false;



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



	void SetLado(int L)
	{
		if(L<600 && L>1)
			this.Lado = L;
	}

	int getLado()
	{
		return Lado;
	}



	//MÉTODOS DE CLASE

	static void setRELLENO(boolean relleno)
	{
		RELLENO = relleno;
	}

	static boolean isRELLENO()
	{
		return RELLENO;
	}



	//CONSTRUCTOR

	Cuadrado(int X, int Y, int Lado)  //POR DEFECTO RELLENO ES FALSE
	{
		this.SetPosX(X);
		this.SetPosY(Y);
		this.SetLado(Lado);
	}
}