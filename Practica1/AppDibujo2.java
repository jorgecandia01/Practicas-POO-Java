public class AppDibujo2
{
	public static void main(String args[])
	{
		//PRIMERO INSTANCIO LOS OBJETOS QUE VOY A USAR

		//1.- CUADRADOS
		Cuadrado c1 = new Cuadrado(300,100,200);

		//2.- DIBUJO (LLAMADAS) -> MÉTODO dibujo.pintar(c1) PARA PINTAR LOS CUADRADOS
		Dibujo dibujo = new Dibujo();

		//3.- UTIL (LLAMADAS) -> MÉTODO util.wait(1) PARA ESPERAR 1SEG
		Util util = new Util();


		//AHORA PROGRAMO LO QUE ME PIDEN
		dibujo.pintar(c1);
		util.wait(1);

		c1.SetPosX(500);
		dibujo.pintar(c1);
		util.wait(1);

		c1.SetPosX(100);
		dibujo.pintar(c1);
		util.wait(1);

		c1.SetLado(300);
		dibujo.pintar(c1);
	}
}