package Retos.RetoRelacionObjetos;

import java.util.*;
import Retos.RetoRelacionObjetos.Fabrica;
import Retos.RetoRelacionObjetos.Coche;

public class GestorFabricas
{
	HashSet<Fabrica> fabricas;

	public void addFabrica(Fabrica fabrica)
	{
		fabricas.add(fabrica);
	}

	public Fabrica getFabrica(String ciudad)	//La ciudad que introduzco tiene el mismo hashcode que la ciudad que puse como HC de fabrica?
	{
		Fabrica retorno = new Fabrica(); //Si la ciudad no corresponde a ninguna fabrica, que hago?
		for(Fabrica fabrica:fabricas)	 //Upcasteo a Object en el metodo para asi devolver Boolean false? (devolveria fabricas upcasteadas)
			if(fabrica.hashCode() == ciudad.hashCode())
				retorno = fabrica;

		return retorno;
	}
}