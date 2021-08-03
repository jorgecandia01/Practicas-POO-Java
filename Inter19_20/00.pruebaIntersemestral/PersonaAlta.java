public class PersonaAlta extends PersonaMedia
{
	public final static int EDAD_MAX = 111;
	public final static int EDAD_MIN = 70;

    private static float FACTOR_ALTA = 0.75F;
    private int otrosRiesgos;

    public PersonaAlta(String nombre, int problemasRespiratorios, int problemasCardiacos, int otrosRiesgos)
    {
        super(nombre, problemasRespiratorios, problemasCardiacos);
        this.otrosRiesgos = otrosRiesgos;
    }

    public PersonaAlta(String nombre)
    {
        super(nombre);
    }    

    @Override
    protected float getFactor()
    {
        return FACTOR_ALTA;
    }

    @Override
    public float calcularProbabilidad()
    {
        return super.calcularProbabilidadComun()*otrosRiesgos;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Otros: " + otrosRiesgos;
    }

}