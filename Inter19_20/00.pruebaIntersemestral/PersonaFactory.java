import java.lang.reflect.Field;

/*
Esta clase no forma parte del examen. 
Solo responde a la pregunta de un compañero.
*/

public class PersonaFactory
{
	private static Class tipoPersona[] = {PersonaNino.class, PersonaMedia.class, PersonaAlta.class};

	private int edad; 

	public PersonaFactory(int edad)
	{
		this.edad = edad;
	}

	public Persona createInstance(String nombre)
	{
		Persona p=null;
		try
		{
			for(Class tipo:tipoPersona)
			{
				Field fMax = tipo.getField("EDAD_MAX");
				int valorMax = fMax.getInt(tipo);
				Field fMin = tipo.getField("EDAD_MIN");
				int valorInt = fMin.getInt(tipo);
				if(edad >= valorInt && edad <= valorMax)
				{
					p = (Persona) tipo.getConstructor(String.class).newInstance(nombre);
					break;
				}
			}
		}
		catch(Exception e)
		{}
		return p;
	}
}