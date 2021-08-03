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
import PracticaFinal.UI.JExamen;
import PracticaFinal.UI.JLogin;

public class JAplicacion extends JFrame
{
	//PANEL NORTE
	private JLabel lblNPregunta = new JLabel("Pregunta: "+"30");
	private JLabel lblAConocimiento = new JLabel("Oposición");
	private Examen examen;

	private JPanel pnlCentro;


	public static void main(String[] args)
	{
		JAplicacion japlicacion = new JAplicacion();


	}

	public JAplicacion() //Examen examen
	{
		super("Aplicación Examen");
		//this.examen = examen;

		this.setLayout(new BorderLayout());

		//PANEL SUR => SPAM
		JPanel pnlSur = new JPanel(new FlowLayout());
		this.add(pnlSur,BorderLayout.SOUTH);
		pnlSur.add(new JLabel("Formantia.es"));
		pnlSur.setBackground(Color.WHITE);



		////// LOG IN //////

		//PANEL CENTRO 

		this.setPnlCentroJLogin();
		//A partir de aquí todo va encadenado a partir de JLogin


		



		//MÉTODOS FINALES
		this.setPreferredSize(new java.awt.Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); //Ajusta el tamaño de la ventana al tamaño de sus componentes.
        // this.setLocation(500, 10); //Posiciona la ventana en X, Y
        this.setLocationRelativeTo(null); //Posiciona la ventana en el centro de la pantalla
        
        this.setVisible(true); //Último método
	}



	public void setExamen(Examen examen)
	{
		this.examen = examen;
	}

	public Examen getExamen()
	{
		return this.examen;
	}


	public void setPnlCentroJExamen() //Método que se llama desde JLogin, cuando se elige la opción de hacer un examen
	{
		// this.removeLayoutComponent(pnlCentro);

		// System.out.println(this.examen.getSize());

		this.remove(pnlCentro);
		this.pnlCentro = null;
		this.pnlCentro = new JExamen(this); 
		this.add(pnlCentro, BorderLayout.CENTER);
		this.pnlCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlCentro.revalidate();
	}

	public void setPnlCentroJLogin()
	{
		// System.out.println("R");
		this.pnlCentro = null;
		this.pnlCentro = new JLogin(this);
		this.add(pnlCentro, BorderLayout.CENTER);
		this.revalidate();
	}

	// public void setPnlCentroJLogout()
	// {
	//	this.remove(pnlCentro);
	// 	this.pnlCentro = null;
	// 	this.pnlCentro = new JLogout(this);
	// 	this.add(pnlCentro, BorderLayout.CENTER);
	// 	this.revalidate();
	// }
}