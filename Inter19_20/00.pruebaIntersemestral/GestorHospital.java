public class GestorHospital
{
    private Hospital hospitales[];

    public GestorHospital()
    {
        hospitales=new Hospital[3];
        hospitales[0]=new Hospital("Hospital 1", 1);
        hospitales[1]=new Hospital("Hospital 2", 5);
    }


    public void ingresar(Persona persona)
    {
    	for(Hospital hospital:hospitales)
            if(!hospital.isFull())
            {
                hospital.ingresar(persona);
                break;
            }
    }

    public Hospital buscar(Persona persona)
    {
        for(Hospital hospital:hospitales)
            if(hospital.contains(persona))
                return hospital;
        return null;
    }

    public float indiceContagios()
    {
    	int contagiados = 0;
    	int totalPacientes = 0;

        for(Hospital hospital:hospitales)
        	if(hospital!=null)
        	{
            	contagiados += hospital.getContagiados();
            	totalPacientes += hospital.getCapacidadActual();
            }

        return (float) (contagiados/(totalPacientes*1.0));
    }   

	public float calcularIndicePrecision()
    {
    	int numeroHospitales = 0;
    	float probabilidad = 0;

        for(Hospital hospital:hospitales)
        	if(hospital!=null)
        	{
            	numeroHospitales++;
            	probabilidad += hospital.calcularIndicePrecision();
            }

        return probabilidad/(numeroHospitales*1.0F);
    }       

	public String toString()
    {
    	StringBuilder sb = new StringBuilder();
        for(Hospital hospital:hospitales)
        	if(hospital!=null)
            	sb.append(hospital);
        return sb.toString();
    }    
    
}
