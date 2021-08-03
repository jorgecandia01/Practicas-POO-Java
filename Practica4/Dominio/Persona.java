package Practica4.Dominio;

public class Persona
{
    //Atributos de instancia
    private String dni;
    private String nombre; //or defecto null
    private int edad; //por defecto 0

    protected Persona(String dni, String nombre, int edad)
    {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    protected Persona(String dni)
    {
        this.setDni(dni);
    }


    //Métodos
    void setNombre(String nombre)  //LOS TENIA PRIVATE PERO NECESITO MODIFICARLOS DESDE AGENDA EN modificarP()
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }


    void setEdad(int edad) //LOS TENIA PRIVATE PERO NECESITO MODIFICARLOS DESDE AGENDA EN modificarP()
    {
        if (edad > 0 && edad < 130)
        {
            this.edad = edad;
        }
    }

    public int getEdad()
    {
        return edad;
    }


    void setDni(String dni) //LOS TENIA PRIVATE PERO NECESITO MODIFICARLOS DESDE AGENDA EN modificarP()
    {
        this.dni = dni;
    }

    public String getDni()
    {
        return dni;
    }


    @Override
    public String toString()
    {
        return "=>DNI: " + this.getDni() + "\n=>Nombre: " + this.getNombre() + "\n=>Edad: " + this.getEdad();
    }

    @Override
    public boolean equals(Object obj) // GENERALIZO PARA CUALQUIER OBJETO AUNQUE POR AHORA SOLO ME INTERESA COMPARAR EL DNI
    //ACABO DE UPCASTEAR, VEO EL OBJETO COMO CLASE OBJETO (YA NO TENGO EL TOSTRING)
    {
        if(obj instanceof Persona)
        {
            Persona p = (Persona) obj; //DOWNCAST (VUELVO A TENER EL TOSTRING)
            if((this.getDni()).equals(p.getDni()))
                return true;
            else 
                return false;
        }
        else
            return false;
    }
}

