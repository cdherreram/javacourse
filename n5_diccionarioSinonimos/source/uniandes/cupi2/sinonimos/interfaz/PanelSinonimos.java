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
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.sinonimos.mundo.*;

/**
 * Es el panel donde se muestran los sinónimos de las palabras buscadas
 */
public class PanelSinonimos extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String SIGUIENTE = "SIGUIENTE";
    private static final String ANTERIOR = "ANTERIOR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista de palabras que son sinónimos de la palabra buscada
     */
    private ArrayList sinonimos;

    /**
     * Es la posición del sinónimo que esta siendo mostrado
     */
    private int actual;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta "Número de Sinónimos: X"
     */
    private JLabel etiquetaNumeroSinonimos;

    /**
     * Botón para pasar al siguiente sinónimo
     */
    private JButton botonSiguiente;

    /**
     * Botón para volver al sinónimo anterior
     */
    private JButton botonAnterior;

    /**
     * Campo de texto donde se muestra el sinónimo
     */
    private JTextField txtSinonimo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     */
    public PanelSinonimos( )
    {
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Sinónimos" ) );

        botonAnterior = new JButton( "<<" );
        botonAnterior.setActionCommand( ANTERIOR );
        botonAnterior.addActionListener( this );

        txtSinonimo = new JTextField( 20 );
        txtSinonimo.setEditable( false );

        botonSiguiente = new JButton( ">>" );
        botonSiguiente.setActionCommand( SIGUIENTE );
        botonSiguiente.addActionListener( this );

        etiquetaNumeroSinonimos = new JLabel( "Número de Sinónimos: " );

        add( botonAnterior, BorderLayout.WEST );
        add( txtSinonimo, BorderLayout.CENTER );
        add( botonSiguiente, BorderLayout.EAST );
        add( etiquetaNumeroSinonimos, BorderLayout.SOUTH );

        sinonimos = null;
        actual = -1;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra el siguiente sinónimo <br>
     * <b>post: </b> se muestra al usuario el sinónimo inmediatamente posterior en la lista
     */
    private void siguiente( )
    {
        actual++;
        if( actual == sinonimos.size( ) )
        {
            actual--;
            JOptionPane.showMessageDialog( this, "Ultimo sinónimo de la palabra", "Advertencia", JOptionPane.WARNING_MESSAGE );
        }
        else
        {
            Palabra pal = ( Palabra )sinonimos.get( actual );
            txtSinonimo.setText( pal.darPalabra( ) );
        }
    }

    /**
     * Muestra el sinónimo anterior <br>
     * <b>post: </b> se muestra al usuario el sinónimo inmediatamente anterior en la lista
     */
    private void anterior( )
    {
        actual--;
        if( actual == -1 )
        {
            actual++;
            JOptionPane.showMessageDialog( this, "Primer sinónimo de la palabra", "Advertencia", JOptionPane.WARNING_MESSAGE );
        }
        else
        {
            Palabra pal = ( Palabra )sinonimos.get( actual );
            txtSinonimo.setText( pal.darPalabra( ) );
        }
    }

    /**
     * Cambia la lista de sinónimos mostrados y muestra el primero <br>
     * <b>pre: </b>La lista de sinónimos no es null ni vacía. <b>post: </b>Se está mostrando el primer sinónimo de la lista y el tamaño de esta lista
     * @param listaSinonimos la lista de sinónimos que debe mostrarse - listaSinonimos != null
     */
    public void mostrarSinonimos( ArrayList listaSinonimos )
    {
        actual = 0;
        sinonimos = listaSinonimos;
        etiquetaNumeroSinonimos.setText( "Número de Sinónimos: " + sinonimos.size( ) );

        Palabra pal = ( Palabra )listaSinonimos.get( 0 );
        txtSinonimo.setText( pal.darPalabra( ) );

        botonAnterior.setEnabled( true );
        botonSiguiente.setEnabled( true );
    }

    /**
     * Ejecuta la acción asociada a un botón
     * @param evento el evento del click sobre un botón - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( SIGUIENTE ) )
        {
            siguiente( );
        }
        else if( comando.equals( ANTERIOR ) )
        {
            anterior( );
        }
    }

    /**
     *  
     */
    public void inicializar( )
    {
        txtSinonimo.setText( "" );
        botonAnterior.setEnabled( false );
        botonSiguiente.setEnabled( false );
    }
}