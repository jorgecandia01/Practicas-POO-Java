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

public class JLogout extends JPanel
{
	private JAplicacion japlicacion;
	private JButton btnExamen = new JButton("Volver a intentar el mismo Examen");
	private JButton btnInicio = new JButton("Volver a la pantalla de inicio");

	public JLogout(JAplicacion japlicacion)
	{
		this.japlicacion = japlicacion;
		this.setLayout(new GridLayout(1,2));


		// (1,1) => REHACER EXAMEN
		JPanel pnlExamen = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.add(pnlExamen);
		pnlExamen.add(btnExamen);

		btnExamen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				japlicacion.setPnlCentroJExamen();
			}
		});



		// (1,2) => VOLVER AL INICIO
		JPanel pnlInicio = new JPanel(new FlowLayout());
		this.add(pnlInicio);
		pnlInicio.add(btnInicio);

		btnInicio.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) //ACTUALIZO LAS PREGUNTAS GUARDADAS
			{
				japlicacion.setPnlCentroJLogin();
			}
		});
	}
}