import java.awt.Color;
public class AppDibujo01
{
	public static void main(String[] args)
	{
		//Util util = new Util; NO HACE FALTA INSTANCIAR UTIL => Util.wait(s) ES METODO DE CLASE
		Dibujo dibujo = new Dibujo();

		Figura figuras[] = new Figura[10];

		figuras[0] = new Circulo(150,150, true, Color.blue, 100);
		figuras[1] = new Cuadrado(350,100, true, Color.red, 150);
		figuras[2] = new Cuadrado(50,400, false, Color.red, 150);
		figuras[3] = new Circulo(500,400, true, Color.green, 100);

		for(int i=0;i<figuras.length;i++)
			if(figuras[i] != null)
			{
				//System.out.println(figuras[i].getInfo() + "\n\n--------------------\n");
				dibujo.pintar(figuras[i]);
			}
	} 
}