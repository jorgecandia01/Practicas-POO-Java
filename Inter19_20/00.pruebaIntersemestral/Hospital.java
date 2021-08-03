public class Hospital
{
    private Persona personasIngresadas[];
    private String nombre;
    private int capacidadMaxima;
    private int capacidadActual;

    public Hospital(String nombre, int capacidadMaxima)
    {
        this.nombre = nombre;
    	this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = 0;
    	personasIngresadas = new Persona[capacidadMaxima];
    }

    public String getNombre()
    {
    	return nombre;
    }

    public int getCapacidadMaxima()
    {
    	return capacidadMaxima;
    }    

	public int getCapacidadActual()
	{
		return capacidadActual;
	}	    

    public boolean isFull()
    {
    	return capacidadMaxima==capacidadActual;
    }    

	public int getContagiados()
	{
		int numeroContagiados = 0;
 		for(Persona p:personasIngresadas)
	        if(p!=null && p.isContagiado())
	        	numeroContagiados++;

	    return numeroContagiados;
	}

	public float calcularIndicePrecision()
	{
		int numeroContagiados = 0;
		float probabilidad = 0;

 		for(Persona p:personasIngresadas)
	        if(p!=null && p.isContagiado())
	        {
	        	numeroContagiados++;
	        	probabilidad += p.calcularProbabilidad();
	        }
		
		if(numeroContagiados!=0)
	    	return probabilidad/(numeroContagiados*1.0F);
	    else
	    	return 0;
	}

    public boolean ingresar(Persona persona)
    {
    	if(capacidadActual<capacidadMaxima)
    	{
    		personasIngresadas[capacidadActual++] = persona;
    		return true;
    	}
    	else
    		return false;
	}

	public Persona get(int posicion)
    {
    	if(posicion<personasIngresadas.length)
	    	return personasIngresadas[posicion];
	    else
	    	return null;
	}


	public boolean contains(Persona persona)
    {
    	return this.buscar(persona)!=-1;
	}

	public int indexOf(Persona persona)
    {
    	return this.buscar(persona);
	}

	private int buscar(Persona persona)
    {
        int pos = -1;
	    for(int i=0;i<capacidadActual;i++)
	    {
	        if(personasIngresadas[i]!=null)
	        {
	            if(personasIngresadas[i].equals(persona))
	            {
	                pos = i;
	                i = capacidadActual;
	            }
	        }
	    }
	    return pos;
    }    

    public boolean remove(int posicion)
    {
    	if(posicion<capacidadActual)
    	{
    		personasIngresadas[posicion] = null;
    		for(int i=posicion;i<capacidadActual-1;i++)
            	personasIngresadas[i] = personasIngresadas[i+1];
            personasIngresadas[--capacidadActual] = null;
            return true;
	    }
	    else
	    	return false;
    }

    public boolean remove(Persona persona)
    {
    	int posicion = this.indexOf(persona);	
    	return this.remove(posicion);
    }    

	public String toString()
    {
    	StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" (" + capacidadMaxima + ")\n");
        for(int i=0;i<capacidadActual;i++)
            sb.append(personasIngresadas[i] + "\n");
        return sb.toString();
    }    
    
}
