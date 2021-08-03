package Mayo2020.Dominio;

public class Asignatura
{	//clave, titulo, asignatura, nota teoría, % práctica, nota práctica
	private String nombre;
	private float notaTeoria;
	private int pPractica;
	private float notaPractica;

	private float nota;

	public Asignatura(String nombre, float notaTeoria, int pPractica, int notaPractica)
	{
		this.nombre = nombre;
		this.notaTeoria = notaTeoria;
		this.pPractica = pPractica;
		this.notaPractica = notaPractica;

		this.nota = this.getNota();
	}

	public Asignatura(String nombre, float notaTeoria)
	{
		this.nombre = nombre;
		this.notaTeoria = notaTeoria;

		this.nota = this.getNota();
	}

	public float getNota()
	{
		float f = (float) 0.0;
		f = (pPractica/100*notaPractica) + (1-(pPractica/100))*notaTeoria;
		return f;
	}

}