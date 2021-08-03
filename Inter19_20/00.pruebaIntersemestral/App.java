public class App
{

    public static void main(String[] args)
    {
    	/*            NO FORMA PARTE DEL EXAMEN: 
    		Ejemplo de creación dinámica de objetos según su edad.
    		Tal y como me proeguntó un compañero. */

    	Persona p = new PersonaFactory(40).createInstance("Manuel de 40");
    	
    	System.out.println(p.getClass().getName());
    	System.out.println(new PersonaFactory(10).createInstance("Luis de 10").getClass().getName());
    	System.out.println(new PersonaFactory(80).createInstance("Javier de 90").getClass().getName());

    	/*               ._/   |-|   \_.                  */

    	System.out.println("\n\n");

        Persona personasEstudio[] = new Persona[10];
        personasEstudio[0] = new PersonaAlta("Persona alta", 4, 3, 1);
        personasEstudio[1] = new PersonaMedia("Persona media", 2, 1);
        personasEstudio[2] = new PersonaNino("Persona niño");

        personasEstudio[2].setContagiado(true);
        personasEstudio[2].addPersonaRelacionada(personasEstudio[0]);

        for(Persona persona:personasEstudio)
            if(persona!=null)
                System.out.println(persona.calcularProbabilidad());

        //Ingreso en un Hospital
        GestorHospital gh = new GestorHospital();
        gh.ingresar(personasEstudio[0]);
        gh.ingresar(personasEstudio[1]);
        gh.ingresar(personasEstudio[2]);

        System.out.println("\n\n" + gh);

		//Búsqueda de un a persona en un Hospital
        System.out.println("\n\nBuscando a Persona alta:");
        System.out.println(gh.buscar(new PersonaAlta("Persona alta")));

        //Contagiados vs Ingresados
		System.out.println("Indice de contagiados en todos los hospitales: " + gh.indiceContagios());

        //Contagiados vs Probabilidad de contagio
		System.out.println("Indice de precisión: " + gh.calcularIndicePrecision());		

		//Contagiados vs Propagación para la persona [2]
		//personasEstudio[0].setContagiado(true);
		System.out.println("Indice de propagación: " + personasEstudio[2].calcularIndicePropagacion());				

    }
}
    
