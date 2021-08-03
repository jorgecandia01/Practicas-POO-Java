import java.awt.Color;
public class AppDibujo02
{
	public static void main(String[] args)
	{
		//Util util = new Util; NO HACE FALTA INSTANCIAR UTIL => Util.wait(s) ES METODO DE CLASE
		Dibujo dibujo = new Dibujo();

		Figura figuras[] = new Figura[10];

		for(int i=0; i<figuras.length;i++)
		{
			figuras[i] = new Cuadrado(50+25*i,50+25*i,false,Color.blue,120);
			System.out.println(figuras[i]);
		}


		for(int i=0;i<figuras.length;i++)
			if(figuras[i] != null)
			{
				//System.out.println(figuras[i].getInfo() + "\n\n--------------------\n");
				dibujo.pintar(figuras[i]);
				Util.wait(1);
			}
	} 
}