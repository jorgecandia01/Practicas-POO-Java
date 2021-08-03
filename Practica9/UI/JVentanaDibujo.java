package Practica9.UI;

import Practica9.Dominio.Dibujo;
import Practica9.Dominio.Figura;
import Practica9.Dominio.Circulo;
import Practica9.Dominio.Cuadrado;
import Practica9.Dominio.Lienzo;
import Practica9.Dominio.Util;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.*;

public class JVentanaDibujo extends JFrame
{
	private Dibujo dibujo;
	private Lienzo lienzo;

	public static void main(String[] args)
	{
		new JVentanaDibujo();

	}

	public JVentanaDibujo()
	{
		super("Titulo");

		//INICIALIZO VAINAS
		this.dibujo = new Dibujo("Dibujillo");
		this.lienzo = new Lienzo(this);

		JButton btnCuadrado = new JButton("CUADRADO");
		JButton btnCirculo = new JButton("CIRCULO"); 

		JButton btnVT = new JButton("Visualizar todo");
		JButton btnOT = new JButton("Ocultar todo");

		this.setLayout(new BorderLayout());

		//PANEL NORTE
		JPanel pnlNorte = new JPanel(new FlowLayout());
		JTextField txtX = new JTextField(4);
		JTextField txtY = new JTextField(4);
		JTextField txtL_R = new JTextField(4);
		JTextField txtGRP = new JTextField(10);
		pnlNorte.add(new JLabel("Posicion X: "));
		pnlNorte.add(txtX);
		pnlNorte.add(new JLabel("Posicion Y: "));
		pnlNorte.add(txtY);
		pnlNorte.add(new JLabel("Lado/Radio: "));
		pnlNorte.add(txtL_R);
		pnlNorte.add(new JLabel("Grupo: "));
		pnlNorte.add(txtGRP);
		pnlNorte.add(btnCirculo);	//Definido mas abajo
		pnlNorte.add(btnCuadrado);	//Definido mas abajo

		//PANEL CENTRAL
		JPanel pnlCentro = new JPanel(new FlowLayout());
		pnlCentro.add(lienzo);
		lienzo.setSize(800,600); //asi configuro el tamaño neto de pnlNorte no?

		//PANEL SUR
		JPanel pnlSur = new JPanel(new FlowLayout());
		pnlSur.add(btnVT);
		pnlSur.add(btnOT);

		//APPEND DE LOS PANELES
		this.add(pnlNorte, BorderLayout.NORTH);
		this.add(pnlCentro, BorderLayout.CENTER);
		this.add(pnlSur, BorderLayout.SOUTH);

		//METODOS FIN
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		//ADDEO FIGURAS
		dibujo.addFigura("grupo verde", new Circulo(10,10,true,Color.GREEN,80));	//NO OLVIDARSE EL Color. PARA LOS COLORES!!!!!
		dibujo.addFigura("grupo verde", new Circulo(100,10,true,Color.GREEN,50));
		dibujo.addFigura("grupo rojo", new Cuadrado(10,100,false,Color.RED,80));
		dibujo.addFigura("grupo rojo", new Circulo(400,300,true,Color.RED,120));
		dibujo.addFigura("grupo azul", new Cuadrado(600,500,true,Color.BLUE,70));
		lienzo.repaint();


		//ADDEO EVENTOS
		btnCuadrado.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String grupo = "grupo " + txtGRP.getText().toLowerCase().replace(" ","");
				int x = Integer.parseInt(txtX.getText());
				int y = Integer.parseInt(txtY.getText());
				int l_r = Integer.parseInt(txtL_R.getText());

				Figura f = new Cuadrado(x, y, true, Color.BLACK, l_r);
				dibujo.addFigura(grupo,f);
				f.setVisible(true);
				lienzo.repaint();
			}
		});

		btnCirculo.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String grupo = "grupo " + txtGRP.getText().toLowerCase().replace(" ","");
				int x = Integer.parseInt(txtX.getText());
				int y = Integer.parseInt(txtY.getText());
				int l_r = Integer.parseInt(txtL_R.getText());

				Figura f = new Circulo(x, y, true, Color.BLACK, l_r);
				dibujo.addFigura(grupo,f);
				f.setVisible(true);
				lienzo.repaint();
			}
		});

		btnVT.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dibujo.visualizarTodo(true);
				lienzo.repaint();
			}
		});

		btnOT.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dibujo.visualizarTodo(false);
				lienzo.repaint();
			}
		});

	Util.wait(3);
	dibujo.visualizarTodo(false);	//NO VA
	lienzo.repaint();

			
	}


	public Dibujo getDibujo()
	{
		return dibujo;
	}
}