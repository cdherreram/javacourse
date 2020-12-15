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
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.sinonimos.mundo.*;

/**
 * Es el panel donde se muestran los sin�nimos de las palabras buscadas
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
     * Es la lista de palabras que son sin�nimos de la palabra buscada
     */
    private ArrayList sinonimos;

    /**
     * Es la posici�n del sin�nimo que esta siendo mostrado
     */
    private int actual;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta "N�mero de Sin�nimos: X"
     */
    private JLabel etiquetaNumeroSinonimos;

    /**
     * Bot�n para pasar al siguiente sin�nimo
     */
    private JButton botonSiguiente;

    /**
     * Bot�n para volver al sin�nimo anterior
     */
    private JButton botonAnterior;

    /**
     * Campo de texto donde se muestra el sin�nimo
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
        setBorder( new TitledBorder( "Sin�nimos" ) );

        botonAnterior = new JButton( "<<" );
        botonAnterior.setActionCommand( ANTERIOR );
        botonAnterior.addActionListener( this );

        txtSinonimo = new JTextField( 20 );
        txtSinonimo.setEditable( false );

        botonSiguiente = new JButton( ">>" );
        botonSiguiente.setActionCommand( SIGUIENTE );
        botonSiguiente.addActionListener( this );

        etiquetaNumeroSinonimos = new JLabel( "N�mero de Sin�nimos: " );

        add( botonAnterior, BorderLayout.WEST );
        add( txtSinonimo, BorderLayout.CENTER );
        add( botonSiguiente, BorderLayout.EAST );
        add( etiquetaNumeroSinonimos, BorderLayout.SOUTH );

        sinonimos = null;
        actual = -1;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Muestra el siguiente sin�nimo <br>
     * <b>post: </b> se muestra al usuario el sin�nimo inmediatamente posterior en la lista
     */
    private void siguiente( )
    {
        actual++;
        if( actual == sinonimos.size( ) )
        {
            actual--;
            JOptionPane.showMessageDialog( this, "Ultimo sin�nimo de la palabra", "Advertencia", JOptionPane.WARNING_MESSAGE );
        }
        else
        {
            Palabra pal = ( Palabra )sinonimos.get( actual );
            txtSinonimo.setText( pal.darPalabra( ) );
        }
    }

    /**
     * Muestra el sin�nimo anterior <br>
     * <b>post: </b> se muestra al usuario el sin�nimo inmediatamente anterior en la lista
     */
    private void anterior( )
    {
        actual--;
        if( actual == -1 )
        {
            actual++;
            JOptionPane.showMessageDialog( this, "Primer sin�nimo de la palabra", "Advertencia", JOptionPane.WARNING_MESSAGE );
        }
        else
        {
            Palabra pal = ( Palabra )sinonimos.get( actual );
            txtSinonimo.setText( pal.darPalabra( ) );
        }
    }

    /**
     * Cambia la lista de sin�nimos mostrados y muestra el primero <br>
     * <b>pre: </b>La lista de sin�nimos no es null ni vac�a. <b>post: </b>Se est� mostrando el primer sin�nimo de la lista y el tama�o de esta lista
     * @param listaSinonimos la lista de sin�nimos que debe mostrarse - listaSinonimos != null
     */
    public void mostrarSinonimos( ArrayList listaSinonimos )
    {
        actual = 0;
        sinonimos = listaSinonimos;
        etiquetaNumeroSinonimos.setText( "N�mero de Sin�nimos: " + sinonimos.size( ) );

        Palabra pal = ( Palabra )listaSinonimos.get( 0 );
        txtSinonimo.setText( pal.darPalabra( ) );

        botonAnterior.setEnabled( true );
        botonSiguiente.setEnabled( true );
    }

    /**
     * Ejecuta la acci�n asociada a un bot�n
     * @param evento el evento del click sobre un bot�n - evento!=null
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