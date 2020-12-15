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
import uniandes.cupi2.sinonimos.mundo.Palabra;

/**
 * Esta clase sirve para probar la clase Palabra
 */
public class PalabraTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Palabra 1 de prueba
     */
    private Palabra palabra1;
    /**
     * Palabra 2 de prueba
     */
    private Palabra palabra2;
    /**
     * Palabra 3 de prueba
     */
    private Palabra palabra3;
    /**
     * Palabra 4 de prueba
     */
    private Palabra palabra4;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Prepara un escenario de prueba
     */
    private void setupEscenario1( )
    {
        palabra1 = new Palabra( "escuela" );
        palabra2 = new Palabra( "instituto" );
        palabra3 = new Palabra( "plantel" );
        palabra4 = new Palabra( "academia" );

        palabra1.agregarSinonimo( palabra2 );
        palabra1.agregarSinonimo( palabra3 );
        palabra1.agregarSinonimo( palabra4 );
    }

    /**
     * Verifica el m�todo darPalabra
     */
    public void testDarPalabra( )
    {
        setupEscenario1( );

        assertEquals( "La palabra no es la esperada", "escuela", palabra1.darPalabra( ) );
        assertEquals( "La palabra no es la esperada", "instituto", palabra2.darPalabra( ) );
        assertEquals( "La palabra no es la esperada", "plantel", palabra3.darPalabra( ) );
        assertEquals( "La palabra no es la esperada", "academia", palabra4.darPalabra( ) );
    }

    /**
     * Verifica el m�todo darSinonimos para el caso en que la palabra ten�a sin�nimos. <br>
     * Las palabras retornadas deben ser las mismas que las agregadas como sin�nimos porque se quiere que haya solamente un objeto Palabra por cada palabra del diccionario.
     */
    public void testDarSinonimos1( )
    {
        setupEscenario1( );

        ArrayList sinonimos = palabra1.darSinonimos( );
        assertEquals( "La lista de sin�nimos no es del largo esperado", 3, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );
        Palabra sinonimo1 = ( Palabra )sinonimos.get( 1 );
        Palabra sinonimo2 = ( Palabra )sinonimos.get( 2 );

        assertSame( "El sin�nimo retornado no es el mismo objeto que se hab�a almacenado", palabra2, sinonimo0 );
        assertSame( "El sin�nimo retornado no es el mismo objeto que se hab�a almacenado", palabra3, sinonimo1 );
        assertSame( "El sin�nimo retornado no es el mismo objeto que se hab�a almacenado", palabra4, sinonimo2 );
    }

    /**
     * Verifica el m�todo darSinonimos para una palabra que no tiene sin�nimos
     */
    public void testDarSinonimos2( )
    {
        setupEscenario1( );

        ArrayList sinonimos = palabra2.darSinonimos( );
        assertEquals( "La lista de sin�nimos no es del largo esperado: deber�a estar vacia", 0, sinonimos.size( ) );
    }

    /**
     * Verificar el m�todo agregarSinonimo sin problemas
     */
    public void testAgregarSinonimo1( )
    {
        setupEscenario1( );

        palabra2.agregarSinonimo( palabra1 );

        ArrayList sinonimos = palabra2.darSinonimos( );
        assertEquals( "La lista de sin�nimos no es del largo esperado", 1, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );

        assertSame( "El sin�nimo retornado no es el mismo objeto que se hab�a almacenado", palabra1, sinonimo0 );
    }

    /**
     * Verificar el m�todo agregarSinonimo cuando se agrega dos veces la misma palabra
     */
    public void testAgregarSinonimo2( )
    {
        setupEscenario1( );

        palabra2.agregarSinonimo( palabra1 );
        palabra2.agregarSinonimo( palabra1 );

        ArrayList sinonimos = palabra2.darSinonimos( );
        assertEquals( "La lista de sin�nimos no es del largo esperado", 1, sinonimos.size( ) );

        Palabra sinonimo0 = ( Palabra )sinonimos.get( 0 );

        assertSame( "El sin�nimo retornado no es el mismo objeto que se hab�a almacenado", palabra1, sinonimo0 );
    }

    /**
     * Verificar el m�todo agregarSinonimo cuando agregando la misma palabra
     */
    public void testAgregarSinonimo3( )
    {
        setupEscenario1( );

        palabra2.agregarSinonimo( palabra2 );

        ArrayList sinonimos = palabra2.darSinonimos( );
        assertEquals( "La lista de sin�nimos no es del largo esperado", 0, sinonimos.size( ) );
    }

}
