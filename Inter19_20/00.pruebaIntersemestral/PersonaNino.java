public class PersonaNino extends Persona
{
	public final static int EDAD_MAX = 17;
	public final static int EDAD_MIN = 0;

    private static float PROBABILIDAD_FIJA = 0.02F;

    public PersonaNino(String nombre)
    {
        super(nombre);
    }

    @Override
    public float calcularProbabilidad()
    {
        return PROBABILIDAD_FIJA;
    }

}