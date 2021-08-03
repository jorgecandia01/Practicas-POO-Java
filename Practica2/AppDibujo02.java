public class AppDibujo02
{
	public static void main(String[] args)
	{
		//PRIMERO INSTANCIO LOS OBJETOS QUE VOY A USAR

		//CUADRADOS -> Un array de 3 cuadrados (10 para que funcione con Lienzo.java)

		Cuadrado cuadrados[] = new Cuadrado[10];

		cuadrados[0] = new Cuadrado(100,100,50);
		cuadrados[1] = new Cuadrado(400,300,250);
		cuadrados[2] = new Cuadrado(400, 50, 50);


		//DIBUJO (LLAMADAS) -> MÉTODO dibujo.pintar(c1) PARA PINTAR LOS CUADRADOS

		Dibujo dibujo = new Dibujo();


		//UTIL (LLAMADAS) 

		//AHORA UTILIZO EL MÉTODO DE CLASE Util.wait(segundos) (Util con la U mayúscula)
		//=> COMO ES MÉTODO DE CLASE NO NECESITO CREAR UN OBJETO


		// ----------------------


		//AHORA PROGRAMO LO QUE ME PIDEN

		Cuadrado.setRELLENO(true);

		for(int i=0; i<=cuadrados.length; i++)
		{
			if(cuadrados[i] != null)
			{
				dibujo.pintar(cuadrados[i]);
				Util.wait(1);
			}
		}

	}
}