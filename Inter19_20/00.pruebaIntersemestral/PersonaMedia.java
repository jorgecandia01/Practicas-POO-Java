public class PersonaMedia extends Persona
{
	public final static int EDAD_MAX = 69;
	public final static int EDAD_MIN = 18;

    private static float FACTOR = 0.5F;
    
    private int problemasRespiratorios;
    private int problemasCardiacos;

    public PersonaMedia(String nombre, int problemasRespiratorios, int problemasCardiacos)
    {
        super(nombre);
        this.problemasRespiratorios = problemasRespiratorios;
        this.problemasCardiacos = problemasCardiacos;
    }

    public PersonaMedia(String nombre)
    {
        super(nombre);
    }        

    protected float calcularProbabilidadComun()
    {
        return (problemasRespiratorios/10F + problemasCardiacos/10F);   
    }

    protected float getFactor()
    {
        return FACTOR;
    }

    @Override
    public float calcularProbabilidad()
    {
        return this.calcularProbabilidadComun()*this.getFactor();
    }


    @Override
    public String toString()
    {
        return super.toString() + " Card: " + problemasCardiacos + " Resp: " + problemasRespiratorios;
    }

}