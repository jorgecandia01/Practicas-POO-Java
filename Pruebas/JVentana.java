package Pruebas; 

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class JVentana extends JFrame
{
    public static void main(String args[])
    {
        new JVentana();
    }

    public JVentana()
    {
        super("Mi titulo");
        this.setLayout(new BorderLayout());

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridLayout(2,2));
    
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblEdad = new JLabel("Edad:");
        JTextField txtNombre = new JTextField(10);
        JTextField txtEdad = new JTextField(2);

        pnlCentro.add(lblNombre);
        pnlCentro.add(txtNombre);
        pnlCentro.add(lblEdad);
        pnlCentro.add(txtEdad);
        
        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new FlowLayout());

        JButton btnGuardar = new JButton("Guardar");
        pnlSur.add(btnGuardar);

        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH);
        
        //this.setTitle("Un titulo");
        //this.setSize(400, 200);
        this.pack(); //Ajusta el tamaño de la ventana al tamaño de sus componentes.
        this.setLocation(500, 10);
        
        this.setVisible(true); //Último método
    }


}