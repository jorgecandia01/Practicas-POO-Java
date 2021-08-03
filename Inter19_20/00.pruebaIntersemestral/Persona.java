public abstract class Persona
{
    private String nombre;
    private boolean contagiado;
    private Persona personasRelacionadas[] = new Persona[10];

    public Persona(String nombre)
    {
        this.nombre = nombre;
    }

    public void addPersonaRelacionada(Persona persona)
    {
        for(int i=0;i<personasRelacionadas.length;i++)
            if(personasRelacionadas[i]==null)
            {
                personasRelacionadas[i]=persona;
                break;
            }
    }

 	public int getNumeroPersonasRelacionadas()
    {
    	int numero = 0;
        for(Persona p:personasRelacionadas)
            if(p!=null)
            	numero++;
        return numero;
    }    

 	public int getNumeroPersonasRelacionadasContagiadas()
    {
    	int numero = 0;
        for(Persona p:personasRelacionadas)
            if(p!=null && p.isContagiado())
            	numero++;
        return numero;
    }    

	public float calcularIndicePropagacion()
	{
    	return this.getNumeroPersonasRelacionadasContagiadas()/this.getNumeroPersonasRelacionadas();
	}	


    public boolean isContagiado()
    {
        return contagiado;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setContagiado(boolean contagiado)
    {
        this.contagiado = contagiado;       
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append(" Contagiado: ").append(contagiado)
            .append("\nPersonas relacionadas:\n");
        for(Persona persona:personasRelacionadas)
            if(persona!=null)
                sb.append(persona).append("\n");
        return sb.toString();
    }

    public abstract float calcularProbabilidad();

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Persona)
        {
            Persona p = (Persona) obj;
            if (nombre.equals(p.getNombre()))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}