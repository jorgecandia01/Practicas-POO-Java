public class AppDibujo1
{
	public static void main(String args[])
	{
		//PRIMERO INSTANCIO LOS OBJETOS QUE VOY A USAR

		//CUADRADOS
		Cuadrado c1 = new Cuadrado(100,100,50);
		Cuadrado c2 = new Cuadrado(400,300,250);
		Cuadrado c3 = new Cuadrado(100,25,500);

		//DIBUJO (LLAMADAS) -> MÉTODO dibujo.pintar(c1) PARA PINTAR LOS CUADRADOS

		Dibujo dibujo = new Dibujo();


		//UTIL (LLAMADAS) -> MÉTODO util.wait(1) PARA ESPERAR 1SEG

		Util util = new Util();



		//AHORA PROGRAMO LO QUE ME PIDEN

		dibujo.pintar(c1);
		util.wait(1);
		dibujo.pintar(c2);
		util.wait(1);
		dibujo.pintar(c3);
	}
}