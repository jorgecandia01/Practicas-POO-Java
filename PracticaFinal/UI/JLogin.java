package PracticaFinal.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import PracticaFinal.Dominio.Pregunta;
import PracticaFinal.Dominio.Examen;
import PracticaFinal.Dominio.BancoPreguntas;
import PracticaFinal.Dominio.BancoFalladas;
import PracticaFinal.IO.InOut;
import PracticaFinal.UI.JAplicacion;

public class JLogin extends JPanel //En este método importo las preguntas (en caso de que sea necesario), y creo el examen
{
	private JButton btnExamen = new JButton("Hacer Examen");
	private JButton btnImportar = new JButton("Importar preguntas");

	private HashSet<Pregunta> preguntas; 
	private JAplicacion japlicacion;

	private Examen examen;

	public JLogin(JAplicacion japlicacion)
	{
		this.japlicacion = japlicacion;
		this.setLayout(new GridLayout(1,2));
		this.preguntas = InOut.leerPreguntasDelSistema();

		if(this.preguntas.size() < 1)
			JOptionPane.showMessageDialog(JLogin.this, "AVISO: La base de datos de preguntas está vacía.\nDebe importar preguntas antes de iniciar un examen.");


		// (1,1) => HACER EXAMEN
		JPanel pnlExamen = new JPanel(new FlowLayout());
		this.add(pnlExamen);
		pnlExamen.add(btnExamen);

		btnExamen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JLogin.this.setExamen(new BancoPreguntas(JLogin.this.preguntas));
				japlicacion.setExamen(JLogin.this.examen);
				japlicacion.setPnlCentroJExamen();
			}
		});



		// (1,2) => IMPORTAR PREGUNTAS
		JPanel pnlImportar = new JPanel(new FlowLayout());
		this.add(pnlImportar);
		pnlImportar.add(btnImportar);

		btnImportar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) //ACTUALIZO LAS PREGUNTAS GUARDADAS
			{
				int initSize = JLogin.this.preguntas.size();
				//importo las preguntas nuevas y las añado a las antiguas
				HashSet<Pregunta> preguntasNuevas = InOut.importarPreguntas();
				for(Pregunta pregunta:preguntasNuevas)
					JLogin.this.preguntas.add(pregunta);

				//guardo el importe en el sistema
				InOut.guardarPreguntasEnElSistema(preguntas);

				System.out.println("##################################################");
            	System.out.println("Se han añadido "+ (JLogin.this.preguntas.size()-initSize) + " preguntas a la base de datos");
            	System.out.println("##################################################");

            	JOptionPane.showMessageDialog(JLogin.this, "Se han añadido "+ (JLogin.this.preguntas.size()-initSize) + " preguntas a la base de datos");
			}
		});


	}


	public void setExamen(BancoPreguntas banco)
	{
		this.examen = new Examen("Estándar", 10, banco, 0, null); 
	}


}