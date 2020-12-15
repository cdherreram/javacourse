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

package uniandes.cupi2.sinonimos.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Es el panel donde se indica la palabra que se quiere buscar
 */
public class PanelBuscar extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BUSCAR = "Buscar";

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
     * El bot�n para iniciar la b�squeda
     */
    private JButton botonBuscar;

    /**
     * Campo de texto para la palabra que se debe buscar
     */
    private JTextField txtPalabra;

    /**
     * Etiqueta "Palabra: "
     */
    private JLabel etiquetaPalabra;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     * @param ids - Es una referencia a la clase principal de la interfaz - ids != null
     */
    public PanelBuscar( InterfazDiccionarioSinonimos ids )
    {
        ventanaPrincipal = ids;

        setLayout( new BorderLayout( ) );
        setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
        etiquetaPalabra = new JLabel( "Palabra: " );

        txtPalabra = new JTextField( 20 );

        botonBuscar = new JButton( "Buscar" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );

        add( etiquetaPalabra, BorderLayout.WEST );
        add( txtPalabra, BorderLayout.CENTER );
        add( botonBuscar, BorderLayout.EAST );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acci�n asociada a un bot�n
     * @param evento el evento del click sobre un bot�n - evento != null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( BUSCAR ) )
        {
            ventanaPrincipal.buscarSinonimos( txtPalabra.getText( ) );
        }
    }

    /**
     *  
     */
    public void inicializar( )
    {
        txtPalabra.setText( "" );
    }
}