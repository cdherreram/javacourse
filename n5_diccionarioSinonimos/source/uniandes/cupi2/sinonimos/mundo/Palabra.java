/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_diccionarioSinonimos 
 * Autor: Mario Sánchez - 14/07/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sinonimos.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa a una palabra de la cual se conocen sinónimos
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
     * Es la lista de las otras palabras que son sinónimos de esta palabra.
     */
    private ArrayList sinonimos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva palabra sin sinónimos. <br>
     * <b>post: </b> La lista de sinónimos de la palabra queda vacía.
     * @param pal Es la palabra que va a representar el objeto - pal!=null
     */
    public Palabra( String pal )
    {
        palabraBusqueda = pal;
        sinonimos = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // Métodos
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
     * Retorna una lista con los sinónimos de la palabra
     * @return lista de sinónimos de la palabra
     */
    public ArrayList darSinonimos( )
    {
        // Se construye una nueva lista con los mismos sinónimos para no exponer el estado interno de esta clase
        ArrayList lista = new ArrayList( sinonimos );
        return lista;
    }

    /**
     * Agrega un nuevo sinónimo a la palabra. <br>
     * Si el sinónimo ya se conocía o es igual a esta palabra entonces no se agrega. <br>
     * <b>post: </b>Se agregó la palabra a la lista de sinónimos
     * @param sinonimo - Es el nuevo sinónimo que se quiere agregar
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
