package Mayo2020.UI;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

//------------------------------------------------------------------------
// ToDo: compilar y ejecutar el programa
//------------------------------------------------------------------------

	//compilación... (borrar esta línea)    

	//ejecución... (borrar esta línea)    

//----------------------------------------------------
// FIN de los comandos de compilación y ejecución
//----------------------------------------------------


public class JVentana extends JFrame
{

    //---------------------------------------------
    // ToDo: si debes definir algún atributo, aquí:
    //---------------------------------------------

    HashSet<Alumno> alumnos = IO.leer("Alumnos.csv");
	   
    //---------------------
    // FIN de los atributos
    //---------------------

	public static void main(String[] args)
    {
        new JVentana();
    }

	public JVentana()
	{
        super("JAlumnos - Examen mayo 2020");

        JPanel pnlNorte = new JPanel(new FlowLayout());
        JPanel pnlCentro = new JPanel(new BorderLayout());
        JPanel pnlCentroArriba = new JPanel(new FlowLayout());
        JPanel pnlSur = new JPanel(new GridLayout(1, 2));

        JPanel pnlCentroCentro = new JPanel(FlowLayout());
        pnlCentro.add(pnlCentroCentro, BorderLayout.CENTER);

        JLabel lblAplicacion = new JLabel("Notas de alumnos");
        lblAplicacion.setFont(new Font("Arial", Font.BOLD, 16));
        lblAplicacion.setForeground(new Color(112, 146, 190));
        pnlNorte.add(lblAplicacion);

        JButton btnMostrar = new JButton("Mostrar");
        JLabel lblClave = new JLabel("Clave de alumno: ");
        JTextField txtClave = new JTextField("20180001");
        JLabel lblTitulo = new JLabel("Título: ");
        JTextField txtTitulo = new JTextField("GITT");

        pnlCentroArriba.add(lblClave);
        pnlCentroArriba.add(txtClave);
        pnlCentroArriba.add(lblTitulo);
        pnlCentroArriba.add(txtTitulo);
        pnlCentroArriba.add(btnMostrar);

        pnlCentro.add(pnlCentroArriba, BorderLayout.NORTH);

        pnlSur.add(new JLabel("Examen de mayo 2020"));
        JLabel lblBy = new JLabel("by Nombre del alumno");
        lblBy.setHorizontalAlignment(JLabel.RIGHT);
        pnlSur.add(lblBy);

        //---------------------------------------------------------------------------
        // ToDo: escribir aquí el código del EVENTO BOTÓN MOSTRAR mediante Clases Anónimas
        //---------------------------------------------------------------------------

       	btnMostrar.addActionListener(new ActionAdapter()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int clave = Integer.parseInt(txtClave.getText());
                String titulo = txtTitulo.getText();

                

                Alumno alumno = //pillo el alumno

                pnlCentro.add(new JLabel())


            }
        })   

        //---------------------------------------------------------------------------
        // FIN del código del EVENTO BOTÓN MOSTRAR mediante Clases Anónimas
        //---------------------------------------------------------------------------





		//------------------------------------------------------------------------
        // ToDo: escribir aquí el código del EVENTO CERRAR VENTANA mediante Clases Anónimas
        //------------------------------------------------------------------------
       
       		this.addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(ActionEvent e)
                {
                    IO.escribirCSV(alumnos);
                    System.out.println()
                }
            })

		//----------------------------------------------------
        // FIN del código del EVENTO CERRAR VENTANA
        //----------------------------------------------------


        this.setLayout(new BorderLayout(10, 10));
        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH);
        
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}

}