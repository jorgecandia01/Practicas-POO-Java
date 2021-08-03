package miInter.Dominio;

public abstract class Persona
{
	boolean contagiado = false;
	String nif;
	short grupoEdad;
	int edad;

	protected Persona(boolean contagiado, String nif, int edad)
	{
		this.contagiado = contagiado;
		this.edad = edad;
		this.nif = nif;

		if(edad<=17)
			this.grupoEdad = 1;
		else
			if(edad<=65)
				this.grupoEdad = 2;
			else
				this.grupoEdad = 3;
	}


	public boolean isContagiado()
	{
		return this.contagiado;
	}

	public String getNif()
	{
		return this.nif;
	}

	public int getEdad()
	{
		return this.edad;
	}

	public int getGrupo()
	{
		return this.grupoEdad;
	}


	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\nDatos de la persona de NIF ");
		sb.append(getNif());
		sb.append(":");
		sb.append("\nEdad => ");
		sb.append(getEdad());
		sb.append("\nGrupo de edad => ");
		sb.append(getGrupo());
		sb.append("\nInfectado");
		sb.append(isContagiado());

		return sb.toString();
	}


	public boolean equals(Object obj)
	{
		if(obj instanceof Persona)
		{
			Persona p = (Persona) obj;
			if((this.getNif()).equals(p.getNif()))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}