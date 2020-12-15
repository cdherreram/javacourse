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

package uniandes.cupi2.sinonimos.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Es el panel donde se muestran los botones para las extensiones
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String OPCION_1 = "Opción 1";
    private static final String OPCION_2 = "Opción 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazDiccionarioSinonimos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * El botón para la opción 1
     */
    private JButton botonOpcion1;

    /**
     * El botón para la opción 2
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     * @param ids - Es una referencia a la clase principal de la interfaz - ids != null
     */
    public PanelExtension( InterfazDiccionarioSinonimos ids )
    {
        ventanaPrincipal = ids;

        setLayout( new GridLayout( 1, 2 ) );
        setBorder( BorderFactory.createEmptyBorder( 5, 50, 5, 50 ) );
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );

        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );

        add( botonOpcion1 );
        add( botonOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acción asociada a un botón
     * @param evento el evento del click sobre un botón - evento != null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( OPCION_1 ) )
        {
            ventanaPrincipal.reqFunc1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            ventanaPrincipal.reqFunc2( );
        }
    }
}