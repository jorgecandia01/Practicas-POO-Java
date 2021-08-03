import java.awt.Color;
public class AppDibujo01
{
	public static void main(String[] args)
	{
		Figura figuras[] = new Figura[10];

		figuras[0] = new Cuadrado(20,50, true, Color.BLUE, 200);
		figuras[1] = new Cuadrado(250,50, false, Color.blue, 150);
		figuras[2] = new Circulo(400,400, true, Color.red, 100);

		for(int i=0;i<figuras.length;i++)
			if(figuras[i] != null)
				System.out.println(figuras[i].getInfo() + "\n\n--------------------\n");
	} 
}