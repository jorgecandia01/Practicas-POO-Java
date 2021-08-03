import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Util 
{
    public static HashMap<Integer,Integer> encontrarPareja(int[] numeros, int sum) 
    {
    /* Código a desarrollar
    *
    *
    *
    * */
        return null;
    }

    public static HashMap<Integer, Integer> escribirParejasSimetricas(HashMap<Integer,Integer> hm) 
    {
    /* Código a desarrollar
    *
    *
    *
    * */
        return null;
    }


    public static boolean tieneTodosNumConsecutivos(int[] b) 
    {
        boolean retorno = false;
        for(int i = 0; i<b.length; i++)
        {
            if(i+1 < b.length)
            {
                if(b[i] == (b[i + 1] - 1))
                {
                    retorno = true;
                }
                else
                {
                    retorno = false;
                    i = b.length; //break
                }
            }
        }




        return retorno;
    }
}