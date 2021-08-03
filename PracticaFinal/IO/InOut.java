package PracticaFinal.IO;

import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

import PracticaFinal.Dominio.Pregunta;
import PracticaFinal.Dominio.BancoPreguntas;
import PracticaFinal.Dominio.BancoFalladas;
import PracticaFinal.Dominio.Examen;

public class InOut 
{
	static private int n = 1; //n lleva la cuenta de la línea del fichero en la que nos encontramos


	// public static void main(String[] args) // MÉTODO PARA HACER DEBUGGING
	// {
	// 	HashSet<Pregunta> hs = new HashSet<Pregunta>(); 
	// 	hs = InOut.importarPreguntasPath("C:\\UNIVERSIDAD\\SEGUNDO\\JAVA\\Practicas\\PracticaFinal\\Libro1.csv");
	// 	for(Pregunta pregunta:hs)
	// 	{
	// 		System.out.println(pregunta.getEnunciado());
	// 		System.out.println(pregunta.hashCode()); //POR QUE EL HASHSET ADMITE DOS OBJETOS CON EL MISMO HASHCODE???
	// 		System.out.println(pregunta.getId());
	// 	}
	// }


	public static HashSet<Pregunta> importarPreguntas() // LOS PRINTS EN COMENTARIOS SON PARA DEBUGGING
	{
		HashSet<Pregunta> preguntas = new HashSet<Pregunta>(); 
		HashSet<String> preguntasFallidas = new HashSet<String>(); //Coleccion para debug

		JFileChooser fileChooser = new JFileChooser("."); //Se crea el JFileChooser. Se le indica que la ventana se abra en el directorio actual 

		javax.swing.filechooser.FileFilter filtro = new FileNameExtensionFilter("Archivos CSV (.csv)", "csv"); //El primer parámetro es el mensaje que se muestra, 
		fileChooser.setFileFilter(filtro);												  //el segundo es la extensión de los ficheros que se van a mostrar (por defecto)


		int valor = fileChooser.showOpenDialog(fileChooser); //Muestro la ventana -> devuelve un int que indica el estado de la operación

        if (valor == JFileChooser.APPROVE_OPTION) // int equivale a JFileChooser.APPROVE_OPTION si se ha seleccionado un archivo correctamente
        {
        	String path = fileChooser.getSelectedFile().getAbsolutePath(); // Ya tengo el path del archivo que quiero leer

        	// Empiezo a leer el archivo como tal (como fichero de texto plano)
        	try
        	{
        		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
        		String linea = br.readLine(); //DOY EL PRIMER READLINE AQUÍ PARA QUITAR LA CABECERA

        		while((linea = br.readLine()) != null)
        		{
        			// System.out.println(linea);
        			InOut.addPreg(linea, preguntas, preguntasFallidas);        			
        		}

        		br.close(); //ESTE TEXTO ES EN CONSOLA -> PARA DEBUG
        		System.out.println("\n##########################################################################################");
        		System.out.println("Se han generado " + preguntas.size() + " preguntas exitosamente desde el selector de archivos.");
        		System.out.println("Han habido " + ((n-1)-preguntas.size()) + " preguntas fallidas.");
        		System.out.println("##########################################################################################\n");

                // for(Pregunta p1:preguntas)
                // {
                //     System.out.println(preguntas.contains(p1));
                //     System.out.println(p1.hashCode()+"!");
                    
                // }
                // System.out.println(preguntas.toString());
               
                    

                    // for(Pregunta p2:preguntas)
                    //     System.out.println(p1.getId().equals(p2.getId()));

        		n = 1; //restablezco n
        	}
        	catch(FileNotFoundException fnf)
        	{
        		System.out.println("\nNo se ha podido encontrar el fichero seleccionado\n");
        	}
        	catch(IOException io)
        	{
        		System.out.println("\nError en la lectura del fichero:\n");
        		// System.out.println(io+"\n\n");
        	}
        	catch(Exception e)
        	{
        		System.out.println("\nHa ocurrido un error en la lectura del fichero\n");
        	}
        }

        return preguntas;
	}


	static public void addPreg(String linea, HashSet<Pregunta> preguntas, HashSet<String> preguntasFallidas) //Método que evalua la pregunta
	{								// Si es válida, la mete en 'preguntas'. Si no es válida, la mete en preguntasFallidas
					linea = linea.trim();
        			// if(linea.equals("")) //Si hay una línea que es un string vacio, se pasa a la siguiente
        			// 	continue;		//CON LOS TRY CATCH NUEVOS ESTO NO HACE FALTA

        			String s[] = linea.split("\t");//////////////////OJO AL SEPARADOR///////////////////
        			//System.out.println(s.length);
        			int i = 0;
        			for(String atributo:s)
        			{
        				atributo.trim();
        				atributo.toLowerCase();
        				s[i] = atributo;
        				//System.out.println(s[i]);
        				i++;
        			}
        			//System.out.println("PRINTEO: "+s.toString());
        			try
        			{
                        Pregunta addingPreg = new Pregunta(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10],s[11],s[12],s[13],s[14],s[15],s[16]);
                        // System.out.println(addingPreg.hashCode());
                        // System.out.println(addingPreg.getId());
                        // System.out.println(preguntas.contains(addingPreg));
        				preguntas.add(addingPreg); 
        			}
        			catch(IllegalArgumentException ia)
        			{
        				System.out.println("\nUna de las preguntas del fichero ya existe en la base de datos. Excepción: 'IllegalArgumentException'.");
        				System.out.println("Dicha pregunta se encuentra en la línea: " + InOut.n);
        				try
        				{
        					preguntasFallidas.add(linea);
        				}
        				catch(Exception e)
        				{
        					System.out.println("\nError al gestionar una pregunta no válida. Línea " + InOut.n);
        				}
        			}
        			catch(ArrayIndexOutOfBoundsException aioob)
        			{
        				System.out.println("\nLa estructura de la pregunta introducida no coincide con la del resto de preguntas de la base de datos ('ArrayIndexOutOfBoundsException')");
        				System.out.println("Dicha pregunta se encuentra en la línea: " + InOut.n);
        				try
        				{
        					preguntasFallidas.add(linea);
        				}
        				catch(Exception e)
        				{
        					System.out.println("\nError al gestionar una pregunta no válida. Línea " + InOut.n);
        				}
        			}
        			catch(Exception e0)
        			{
        				System.out.println("\nHa ocurrido un error al importar la pregunta.");
        				System.out.println("Dicha pregunta se encuentra en la línea: " + InOut.n);
        				try
        				{
        					preguntasFallidas.add(linea);
        				}
        				catch(Exception e1)
        				{
        					System.out.println("\nError al gestionar una pregunta no válida. Línea " + InOut.n);
        				}
        			}
        			finally
        			{
        				InOut.n = n+1; //independientemente de lo que pase, saltamos a la siguiente línea del fichero
        			}
   	}










   	public static HashSet<Pregunta> importarPreguntasPath(String path) // LOS PRINTS EN COMENTARIOS SON PARA DEBUGGING
	{                                                              //MÉTODO PARA IMPORTAR PREGUNTAS VÍA PATH EN VEZ DE FILECHOOSER
		HashSet<Pregunta> preguntas = new HashSet<Pregunta>(); 
		HashSet<String> preguntasFallidas = new HashSet<String>(); 

		
        	try
        	{
        		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));
        		String linea = br.readLine(); //DOY EL PRIMER READLINE AQUÍ PARA QUITAR LA CABECERA

        		while((linea = br.readLine()) != null)
        		{
        			// System.out.println(linea);
        			InOut.addPreg(linea, preguntas, preguntasFallidas);        			
        		}

        		br.close();
        		System.out.println("\n#################################################");
        		System.out.println("Se han importado " + preguntas.size() + " preguntas exitosamente.");
        		System.out.println("Han habido " + preguntasFallidas.size() + " preguntas fallidas.");
        		System.out.println("#################################################\n");

        		n = 1; //restablezco n
        	}
        	catch(FileNotFoundException fnf)
        	{
        		System.out.println("\nNo se ha podido encontrar el fichero seleccionado\n");
        	}
        	catch(IOException io)
        	{
        		System.out.println("\nError en la lectura del fichero:\n");
        		// System.out.println(io+"\n\n");
        	}
        	catch(Exception e)
        	{
        		System.out.println("\nHa ocurrido un error en la lectura del fichero\n");
        	}

		return preguntas;
	}



    public static HashSet<Pregunta> agrandarBateriaPreguntas(HashSet<Pregunta> preguntasAntiguas, HashSet<Pregunta> preguntasNuevas)
    {
        HashSet<Pregunta> preguntasARetornar = preguntasAntiguas;

        for(Pregunta pregunta:preguntasNuevas)
        {
            preguntasARetornar.add(pregunta);
            //si la pregunta ya esta dentro, no se añade (HashSet no lanza excepcion)
        }

        return preguntasARetornar;
    }



    public static void guardarPreguntasEnElSistema(HashSet<Pregunta> preguntas)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Preguntas.obj"));

            for(Pregunta pregunta:preguntas)
                oos.writeObject(pregunta);
        }
        catch(Exception e)
        {
            System.out.println("Error en la escritura");
        }
    }


    public static HashSet<Pregunta> leerPreguntasDelSistema() //Método que lee las preguntas guardadas en ProyectoFinal
    {
        HashSet<Pregunta> preguntas = new HashSet<Pregunta>();
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Preguntas.obj"));     
            Object objeto;  
            
            while((objeto = ois.readObject()) != null)
                preguntas.add((Pregunta)objeto);

        }
        catch(NullPointerException npe)
        {
            System.out.println("No hay archivo de preguntas en la base de datos");
        }
        catch(EOFException eof)
        {
            System.out.println("Lectura de la base de datos terminada");
        }
        catch(Exception e)
        {
            System.out.println("Error en la lectura\n" + e);
        }


        return preguntas;
    }
}
