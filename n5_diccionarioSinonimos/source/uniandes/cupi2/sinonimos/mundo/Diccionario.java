/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_diccionarioSinonimos 
 * Autor: Mario S�nchez - 12/07/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sinonimos.mundo;

import java.io.*;
import java.util.*;

/**
 * Esta clase representa un diccionario de sin�nimos.
 */
public class Diccionario
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Esta es la lista de palabras que hay en el diccionario de sin�nimos
     */
    private ArrayList palabras;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo diccionario de sin�nimos cargado con todas las palabras. <br>
     * Las palabras del diccionario las toma del archivo data/sinonimos.txt <br>
     * <b>post: </b> el diccionario se crea con las definiciones de sin�nimos del archivo data/sinonimos.properties
     * @throws Exception si ocurre un error al cargar el archivo data/sinonimos.txt
     */
    public Diccionario( ) throws Exception
    {
        palabras = new ArrayList( );
        cargarDiccionario( "./data/sinonimos.properties" );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Carga un diccionario de sin�nimos a partir de un archivo de propiedades. <br>
     * <b>post: </b>Se cargaron los sin�nimos que se encontraban dentro del archivo
     * @param archivo nombre y ruta del archivo que contiene los sin�nimos que se deben cargar - archivo!=null
     * @throws Exception si hay problemas leyendo el archivo indicado
     */
    public void cargarDiccionario( String archivo ) throws Exception
    {
        Properties datos = new Properties( );

        FileInputStream in = new FileInputStream( archivo );
        datos.load( in );
        in.close( );

        // Limpia las palabras anteriores si las hay
        palabras.clear( );

        int numeroPalabras = Integer.parseInt( datos.getProperty( "sinonimos.numeroPalabras" ) );

        // Crear los objetos de tipo palabra y enlazarlos
        for( int i = 1; i <= numeroPalabras; i++ )
        {
            String prefijo = "sinonimos.palabra" + i + ".";
            String nombrePalabra = datos.getProperty( prefijo + "palabra" );
            Palabra nuevaPalabra = new Palabra( nombrePalabra );
            palabras.add( nuevaPalabra );

            ArrayList sinonimos = new ArrayList( );

            // La palabra base tambi�n se incluye a la lista de sin�nimos
            sinonimos.add( nuevaPalabra );

            int numeroSinonimos = Integer.parseInt( datos.getProperty( prefijo + "numeroSinonimos" ) );
            for( int j = 1; j <= numeroSinonimos; j++ )
            {
                String nombreSinonimo = datos.getProperty( prefijo + "sinonimo" + j );
                nuevaPalabra = new Palabra( nombreSinonimo );
                palabras.add( nuevaPalabra );
                sinonimos.add( nuevaPalabra );
            }

            // Enlazar los sin�nimos. Cada palabra sin�nimo de otra tambi�n va en el diccionario
            // y tambi�n tiene sus sin�nimos.
            int cuantosSinonimos = sinonimos.size( );
            for( int j = 0; j < cuantosSinonimos; j++ )
            {
                Palabra pal = ( Palabra )sinonimos.get( j );
                for( int k = 0; k < cuantosSinonimos; k++ )
                {
                    Palabra sinonimo = ( Palabra )sinonimos.get( k );
                    // En agregarSinonimo no se toma en cuenta el sin�nimo que es igual a
                    // la palabra
                    pal.agregarSinonimo( sinonimo );
                }
            }
        }
    }

    /**
     * Busca los sin�nimos de una palabra
     * @param palabra la palabra que se est� buscando - palabra!=null
     * @return lista con los sin�nimos conocidos de esta palabra. Si no hay ninguno entonces la lista est� vac�a.
     */
    public ArrayList buscarSinonimos( String palabra )
    {
        ArrayList sinonimosEncontrados = null;

        boolean encontre = false;
        int cuantos = palabras.size( );
        for( int i = 0; i < cuantos && !encontre; i++ )
        {
            Palabra pal = ( Palabra )palabras.get( i );
            if( pal.darPalabra( ).equals( palabra ) )
            {
                encontre = true;
                sinonimosEncontrados = pal.darSinonimos( );
            }
        }
        if( !encontre )
            sinonimosEncontrados = new ArrayList( );

        return sinonimosEncontrados;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * El m�todo para el punto de extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * El m�todo para el punto de extensi�n 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
