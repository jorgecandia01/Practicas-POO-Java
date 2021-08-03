package practica11.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Dibujo implements java.io.Serializable
{
	private String nombre;
	private java.util.HashMap<String, Collection<Figura>> figuras = new java.util.HashMap<String, Collection<Figura>>();

	public Dibujo(String nombre)
	{
		this.nombre = nombre;
	}

	public void addFigura(String grupo, Figura figura)
	{
		Collection<Figura> figurasGrupo = figuras.get(grupo);
		if(figurasGrupo==null)
			figurasGrupo = new ArrayList<Figura>();

		figurasGrupo.add(figura);
		figuras.put(grupo, figurasGrupo);
	}

	public void setVisibleGrupo(String grupo, boolean visible)
	{
		Collection<Figura> figurasGrupo = figuras.get(grupo);
		if(figurasGrupo!=null)
		{
			for(Figura figura:figurasGrupo)
				figura.setVisible(visible);
		}
	}	

	public void setVisibleTodasFiguras(boolean visible)
	{
		for(Collection<Figura> figuras:figuras.values())
			for(Figura figura:figuras)
				figura.setVisible(visible);
	}	

	public Collection<Figura> getTodasFiguras()
	{
		Collection<Figura> todasFiguras = new ArrayList<Figura>();
		for(Collection<Figura> figuras:figuras.values())
			for(Figura figura:figuras)
				todasFiguras.add(figura);

		return todasFiguras;
	}

}