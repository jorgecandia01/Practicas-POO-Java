package Practica8.Dominio;

import Practica8.Dominio.Dibujo;
import Practica8.Dominio.Figura;
import Practica8.Dominio.Circulo;
import Practica8.Dominio.Cuadrado;

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

		this.setLayout(new BorderLayout());

		//PANEL NORTE
		JPanel pnlNorte = new JPanel(new FlowLayout());
		JTextField txtX = new JTextField(4);
		JTextField txtY = new JTextField(4);
		JTextField l_r = new JTextField(4);
		pnlNorte.add(new JLabel("Posicion X: "));
		pnlNorte.add(txtX);
		pnlNorte.add(new JLabel("Posicion Y: "));
		pnlNorte.add(txtY);
		pnlNorte.add(new JLabel("Lado/Radio: "));
		pnlNorte.add(l_r);
		pnlNorte.add(btnCirculo);	//Definido mas abajo
		pnlNorte.add(btnCuadrado);	//Definido mas abajo

		//PANEL CENTRAL
		JPanel pnlCentro = new JPanel(new FlowLayout());
		pnlCentro.add(lienzo);
		lienzo.setSize(800,600); //asi configuro el tamaño neto de pnlNorte no?

		//PANEL SUR
		JPanel pnlSur = new JPanel(new FlowLayout());
		pnlSur.add(new JLabel("By Jorge Candia"));

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
		dibujo.visualizarTodo(true);
		lienzo.repaint();
	}


	public Dibujo getDibujo()
	{
		return dibujo;
	}
}