/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_diccionarioSinonimos 
 * Autor: Mario Sánchez - 12/07/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sinonimos.interfaz;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import uniandes.cupi2.sinonimos.mundo.*;

/**
 * Es la clase principal de la interfaz
 */
public class InterfazDiccionarioSinonimos extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El diccionario de sinónimos utilizado
     */
    private Diccionario diccionario;

    /**
     * Es el panel donde se realizan las búsquedas
     */
    private PanelBuscar panelBuscar;

    /**
     * Es el panel donde se muestran los sinónimos
     */
    private PanelSinonimos panelSinonimos;

    /**
     * El el panel donde se muestran los botones para las extensiones
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz de la aplicación con el diccionario indicado
     */
    public InterfazDiccionarioSinonimos( )
    {
        setLayout( new BorderLayout( ) );

        panelBuscar = new PanelBuscar( this );
        panelSinonimos = new PanelSinonimos( );
        panelExtension = new PanelExtension( this );

        add( panelBuscar, BorderLayout.NORTH );
        add( panelSinonimos, BorderLayout.CENTER );
        add( panelExtension, BorderLayout.SOUTH );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Diccionario de Sinónimos" );
        setSize( 400, 180 );
        setResizable( false );

        // Carga el diccionario
        try
        {
            diccionario = new Diccionario( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "No se pudo cargar el archivo: " + e.getMessage( ), "Diccionario de Sinónimos", JOptionPane.ERROR_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Busca los sinónimos de una palabra y si existen los muestra
     * @param palabra Corresponde a la palabra que se debe buscar en el diccionario.
     */
    public void buscarSinonimos( String palabra )
    {
        if( diccionario == null )
        {
            JOptionPane.showMessageDialog( this, "No hay sinónimos en el diccionario ", "Diccionario de Sinónimos", JOptionPane.WARNING_MESSAGE );
        }
        else
        {
            ArrayList sinonimos = diccionario.buscarSinonimos( palabra );
            if( sinonimos.size( ) == 0 )
            {
                JOptionPane.showMessageDialog( this, "Palabra inexistente en el diccionario ", "Diccionario de Sinónimos", JOptionPane.WARNING_MESSAGE );
                panelBuscar.inicializar( );
                panelSinonimos.inicializar( );
            }
            else
                panelSinonimos.mostrarSinonimos( sinonimos );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta la opción 1
     */
    public void reqFunc1( )
    {
        String resultado = diccionario.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta la opción 2
     */
    public void reqFunc2( )
    {
        String resultado = diccionario.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Ejecución
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación
     * @param args parámetros de Ejecución
     */
    public static void main( String[] args )
    {
        InterfazDiccionarioSinonimos ids = new InterfazDiccionarioSinonimos( );
        ids.setVisible( true );
    }
}