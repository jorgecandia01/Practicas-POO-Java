package Retos.RetoRelacionObjetos;

import java.util.*;

public class Fabrica
{
	String responsable;
	Integer nEmpleados;
	String ciudad;
	Integer nFabricados;
	HashSet<String> modelos;

	public void Fabrica(String responsable, Integer nEmpleados, String ciudad, Integer nFabricados, HashSet<String> modelos)
	{
		this.responsable = responsable;
		this.nEmpleados = nEmpleados;
		this.ciudad = ciudad;	//Se da por hecho que en una ciudad solo puede haber una fabrica
		this.nFabricados = nFabricados;
		this.modelos = modelos;
	}

	public void addModelo(String modelo)
	{
		modelos.add(modelo);
	}


	public String getResponsable()
	{
		return this.responsable;
	}

	public Integer getNEmpleados()
	{
		return this.nEmpleados;
	}

	public HashSet cochesFabricados()
	{
		return this.modelos;
	}

	@Override
	public int hashCode()
	{
		return ciudad.hashCode();
	}


}