package Practica8.Dominio;
import java.util.*;


public class Dibujo 
{
	private String nombre;
	private HashMap<String,ArrayList<Figura>> grupos = new HashMap<String,ArrayList<Figura>>();

	public Dibujo(String nombre)
	{
		this.nombre = nombre;
	}




	public void visualizarGrupo(String grupo, boolean visible)
	{
		ArrayList<Figura> figuras = grupos.get(grupo); 

		for(Figura figura:figuras)
			figura.setVisible(visible);
	}


	public void visualizarTodo(boolean visible)
	{
		Collection<ArrayList<Figura>> arreglos = grupos.values();	

		for(ArrayList<Figura> arreglo:arreglos)
			for(Figura figura:arreglo)			//Por qué da error si está tipificado como figura???
				figura.setVisible(visible);
	}


	public Collection<Figura> getTodasFiguras()
	{
		Collection<Figura> todasFiguras = new ArrayList<Figura>();
		for(Collection<Figura> figuras:grupos.values())
			for(Figura figura:figuras)
				todasFiguras.add(figura);

		return todasFiguras;
	}


	public void addFigura(String grupo, Figura figura)
	{	
		Set<String> claves = grupos.keySet();	//Los elementos de keySet deben ser Strings no? (Un set de strings)

		if(claves.contains(grupo))
		{
			ArrayList<Figura> lista = grupos.get(grupo);	//Por que no me deja con 	ArrayList<Figura> lista = grupos.get(grupo); ??
			lista.add(figura);
			grupos.put(grupo, lista);
		}
		else
		{
			ArrayList<Figura> lista = new ArrayList<Figura>();
			lista.add(figura);
			grupos.put(grupo, lista);
		}
	}
}



