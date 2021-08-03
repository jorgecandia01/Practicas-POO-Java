package Practica7.Dominio;
import Practica7.Dominio.Figura;
import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

public class Lienzo extends Canvas
{
	HashMap<String,ArrayList<Figura>> grupos = new HashMap<String,ArrayList<Figura>>(); //<Color,Colection> => Todos los values se upcastean a object??

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

/*
	public void visualizarTodo(boolean visible)
	{
		Iterator it = grupos.values().iterator();
		while(it.hasNext())
		{
			Iterator itFigurasGrupo = ((Collection) it.next()).iterator();
			while(itFigurasGrupo.hasNext())
				((Figura) itFigurasGrupo.next()).setVisible(visible);
		}
	}*/


	public void paint(Graphics g)
	{
		Collection<ArrayList<Figura>> arreglos = grupos.values();	

		for(ArrayList<Figura> arreglo:arreglos)
			for(Figura figura:arreglo)			
				if(figura.isVisible())
					figura.pintar(g);
	}

/*
	public void paint(Graphics g)
	{
		Iterator it = grupos.values().iterator();
		while(it.hasNext())
		{
			Iterator itFigurasGrupo = ((Collection) it.next()).iterator();
			while(itFigurasGrupo.hasNext())
			{
				Figura figura = (Figura) itFigurasGrupo.next();
				if(figura.isVisible())
					figura.pintar(g);
			}
		}
	}
*/

}


//System.out.println("Asd");//Por que no puedo tipificar????? Estaba tipificando mal!! los values son arraylists no figuras!!