import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class JVentanaTuneada extends JFrame
{
    public static void main(String args[])
    {
        new JVentanaTuneada();
    }

    public JVentanaTuneada()
    {
        super("JAgenda");
        this.setLayout(new BorderLayout(5,5)); //Gaps entre zonas

        JLabel lblTitulo = new JLabel("Agenda", new ImageIcon("java.png"), JLabel.CENTER); //Centra el componente en el área
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        //lblTitulo.setForeground(Color.BLUE);
        lblTitulo.setForeground(new Color(50, 90, 168));

        //Se utiliza el constructor que recibe un LayoutManager
        //Se incluyen GAPs entre celdas del Grid
        JPanel pnlCentro = new JPanel(new GridLayout(2,2,5,5)); 
    
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

        this.add(lblTitulo, BorderLayout.NORTH); //Si una zona del Layout solo tiene un componente, puede agregarse sin Panel
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH); //Al tener solo un componente, se podría agregar sin Panel. Se deja así para agregar más botones en el futuro.
        
        //this.setTitle("Un titulo");
        //this.setSize(400, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); //Ajusta el tamaño de la ventana al tamaño de sus componentes.
        //this.setLocation(500, 10); //Posiciona la ventana en X, Y
        this.setLocationRelativeTo(null); //Posiciona la ventana en el centro de la pantalla
        
        this.setVisible(true); //Último método
    }


}















