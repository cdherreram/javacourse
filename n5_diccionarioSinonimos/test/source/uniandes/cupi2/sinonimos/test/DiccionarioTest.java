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

package uniandes.cupi2.sinonimos.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.sinonimos.mundo.Diccionario;
import uniandes.cupi2.sinonimos.mundo.Palabra;

/**
 * Esta clase verifica los m�todos de la clase Diccionario
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
    // M�todos
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
            fail( "No se pudo cargar el diccionario de sin�nimos: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica el m�todo buscarSin�nimos para el caso en que la palabra si tiene sin�nimos
     */
    public void testBuscarSinonimos1( )
    {
        setupEscenario1( );

        ArrayList sinonimos = diccionario.buscarSinonimos( "llanta" );
        assertEquals( "La lista de sin�nimos no es del largo esperado", 2, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );
        Palabra sinonimo1 = ( Palabra )sinonimos.get( 1 );

        assertTrue( "No est�n los sin�nimos esperados", sinonimo0.darPalabra( ).equals( "neum�tico" ) || sinonimo1.darPalabra( ).equals( "neum�tico" ) );
        assertTrue( "No est�n los sin�nimos esperados", sinonimo0.darPalabra( ).equals( "rueda" ) || sinonimo1.darPalabra( ).equals( "rueda" ) );
    }

    /**
     * Verifica el m�todo buscarSinonimos para el caso en que la palabra si tiene sin�nimos, pero buscando por uno de los sin�nimos
     */
    public void testBuscarSinonimos2( )
    {
        setupEscenario1( );

        ArrayList sinonimos = diccionario.buscarSinonimos( "rueda" );
        assertEquals( "La lista de sin�nimos no es del largo esperado", 2, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );
        Palabra sinonimo1 = ( Palabra )sinonimos.get( 1 );

        assertTrue( "No est�n los sin�nimos esperados", sinonimo0.darPalabra( ).equals( "neum�tico" ) || sinonimo1.darPalabra( ).equals( "neum�tico" ) );
        assertTrue( "No est�n los sin�nimos esperados", sinonimo0.darPalabra( ).equals( "llanta" ) || sinonimo1.darPalabra( ).equals( "llanta" ) );
    }

    /**
     * Verifica el m�todo buscarSinonimos para el caso en que la palabra no existe dentro del diccionario de sin�nimos
     */
    public void testBuscarSinonimos3( )
    {
        setupEscenario1( );

        ArrayList sinonimos = diccionario.buscarSinonimos( "perro" );
        assertEquals( "La lista de sin�nimos no es del largo esperado: deber�a estar vacia", 0, sinonimos.size( ) );
    }
}
