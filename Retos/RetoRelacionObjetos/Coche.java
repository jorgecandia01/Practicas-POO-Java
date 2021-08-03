package Retos.RetoRelacionObjetos;

import java.util.*;

public class Coche
{
	String modelo;
	String matricula;
	String ciudadFabricacion;
	HashMap<String,Integer> ocupantes = new HashMap<String,Integer>(); //nombre -> edad

	public String getModelo()
	{
		return this.modelo;
	}

	public String getMatricula()
	{
		return this.matricula;
	}

	public String getCiudadFabricacion()
	{
		return this.ciudadFabricacion;
	}


}