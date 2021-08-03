import java.awt.Color;
public class Circulo extends Figura
{
	int Radio;

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
	String getInfo()
	{
		return "Clase: " + this.getClass() + "\n" + super.getInfo() + "\nRadio: " + this.getRadio();
	} 


	Circulo(int X, int Y, boolean R, Color C, int Rad) 
	{
		super(X,Y,R,C);
		this.setRadio(Rad);
	}
}