/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_diccionarioSinonimos 
 * Autor: Mario S�nchez - 14/07/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sinonimos.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa a una palabra de la cual se conocen sin�nimos
 */
public class Palabra
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la palabra que representa este objeto
     */
    private String palabraBusqueda;

    /**
     * Es la lista de las otras palabras que son sin�nimos de esta palabra.
     */
    private ArrayList sinonimos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva palabra sin sin�nimos. <br>
     * <b>post: </b> La lista de sin�nimos de la palabra queda vac�a.
     * @param pal Es la palabra que va a representar el objeto - pal!=null
     */
    public Palabra( String pal )
    {
        palabraBusqueda = pal;
        sinonimos = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la palabra
     * @return palabra
     */
    public String darPalabra( )
    {
        return palabraBusqueda;
    }

    /**
     * Retorna una lista con los sin�nimos de la palabra
     * @return lista de sin�nimos de la palabra
     */
    public ArrayList darSinonimos( )
    {
        // Se construye una nueva lista con los mismos sin�nimos para no exponer el estado interno de esta clase
        ArrayList lista = new ArrayList( sinonimos );
        return lista;
    }

    /**
     * Agrega un nuevo sin�nimo a la palabra. <br>
     * Si el sin�nimo ya se conoc�a o es igual a esta palabra entonces no se agrega. <br>
     * <b>post: </b>Se agreg� la palabra a la lista de sin�nimos
     * @param sinonimo - Es el nuevo sin�nimo que se quiere agregar
     */
    public void agregarSinonimo( Palabra sinonimo )
    {
        if( !palabraBusqueda.equals( sinonimo.darPalabra( ) ) )
        {
            boolean encontreSinonimo = false;
            int cuantos = sinonimos.size( );

            for( int i = 0; i < cuantos && !encontreSinonimo; i++ )
            {
                Palabra pal = ( Palabra )sinonimos.get( i );
                if( pal.darPalabra( ).equals( sinonimo.darPalabra( ) ) )
                {
                    encontreSinonimo = true;
                }
            }

            if( !encontreSinonimo )
            {
                sinonimos.add( sinonimo );
            }
        }
    }
}
