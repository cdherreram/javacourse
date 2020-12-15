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

package uniandes.cupi2.sinonimos.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.sinonimos.mundo.Diccionario;
import uniandes.cupi2.sinonimos.mundo.Palabra;

/**
 * Esta clase verifica los métodos de la clase Diccionario
 */
public class DiccionarioTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Diccionario de prueba
     */
    private Diccionario diccionario;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Prepara un escenario de prueba
     */
    private void setupEscenario1( )
    {

        try
        {
            diccionario = new Diccionario( );
            diccionario.cargarDiccionario( "./test/data/sinonimosTest.properties" );
        }
        catch( Exception e )
        {
            fail( "No se pudo cargar el diccionario de sinónimos: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica el método buscarSinónimos para el caso en que la palabra si tiene sinónimos
     */
    public void testBuscarSinonimos1( )
    {
        setupEscenario1( );

        ArrayList sinonimos = diccionario.buscarSinonimos( "llanta" );
        assertEquals( "La lista de sinónimos no es del largo esperado", 2, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );
        Palabra sinonimo1 = ( Palabra )sinonimos.get( 1 );

        assertTrue( "No están los sinónimos esperados", sinonimo0.darPalabra( ).equals( "neumático" ) || sinonimo1.darPalabra( ).equals( "neumático" ) );
        assertTrue( "No están los sinónimos esperados", sinonimo0.darPalabra( ).equals( "rueda" ) || sinonimo1.darPalabra( ).equals( "rueda" ) );
    }

    /**
     * Verifica el método buscarSinonimos para el caso en que la palabra si tiene sinónimos, pero buscando por uno de los sinónimos
     */
    public void testBuscarSinonimos2( )
    {
        setupEscenario1( );

        ArrayList sinonimos = diccionario.buscarSinonimos( "rueda" );
        assertEquals( "La lista de sinónimos no es del largo esperado", 2, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );
        Palabra sinonimo1 = ( Palabra )sinonimos.get( 1 );

        assertTrue( "No están los sinónimos esperados", sinonimo0.darPalabra( ).equals( "neumático" ) || sinonimo1.darPalabra( ).equals( "neumático" ) );
        assertTrue( "No están los sinónimos esperados", sinonimo0.darPalabra( ).equals( "llanta" ) || sinonimo1.darPalabra( ).equals( "llanta" ) );
    }

    /**
     * Verifica el método buscarSinonimos para el caso en que la palabra no existe dentro del diccionario de sinónimos
     */
    public void testBuscarSinonimos3( )
    {
        setupEscenario1( );

        ArrayList sinonimos = diccionario.buscarSinonimos( "perro" );
        assertEquals( "La lista de sinónimos no es del largo esperado: debería estar vacia", 0, sinonimos.size( ) );
    }
}
