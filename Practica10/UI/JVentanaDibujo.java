package Practica10.UI;

import Practica10.Dominio.Dibujo;
import Practica10.Dominio.Figura;
import Practica10.Dominio.Circulo;
import Practica10.Dominio.Cuadrado;
import Practica10.Dominio.Lienzo;
import Practica10.Dominio.Util;
import Practica10.Excepciones.RGBConversionException;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

import java.util.*;

public class JVentanaDibujo extends JFrame
{
	private Dibujo dibujo;
	private Lienzo lienzo;

	private String tipo; 
	private int r;
	private int g;
	private int b;
	private Color color;

	public final static String CIRCULO  = "CIRCULO";
	public final static String CUADRADO = "CUADRADO";

	JTextField txtR = new JTextField(3); //wtf pero me deja escribir mas de 3 caracteres
	JTextField txtG = new JTextField(3);
	JTextField txtB = new JTextField(3);


	public static void main(String[] args)
	{
		new JVentanaDibujo();

	}

	public JVentanaDibujo() //puedo definir atributos en el constructor? si no? como funciona eso de que sean locales en el constructor? como accedo a ellos?
	{
		super("Titulo");

		//INICIALIZO VAINAS
		this.dibujo = new Dibujo("Dibujillo");
		this.lienzo = new Lienzo(this);

		JButton btnVT = new JButton("Visualizar todo");
		JButton btnOT = new JButton("Ocultar todo");

		this.setLayout(new BorderLayout());

		//BOTONES TOGGLE
		ButtonGroup btnGrpFiguras = new ButtonGroup();
		JToggleButton btnCuadrado = new JToggleButton("CUADRADO");
		JToggleButton btnCirculo = new JToggleButton("CÍRCULO"); 
		btnCirculo.setSelected(true);
		btnGrpFiguras.add(btnCirculo);
		btnGrpFiguras.add(btnCuadrado);


		//PANEL NORTE
		JPanel pnlNorte = new JPanel(new FlowLayout());

		pnlNorte.add(new JLabel("Red: "));
		pnlNorte.add(txtR);
		pnlNorte.add(new JLabel("Green: "));
		pnlNorte.add(txtG);
		pnlNorte.add(new JLabel("Blue: "));
		pnlNorte.add(txtB);
		pnlNorte.add(btnCirculo);	//Definida mas abajo su funcionalidad
		pnlNorte.add(btnCuadrado);	//Definida mas abajo su funcionalidad

		//PANEL CENTRAL
		JPanel pnlCentro = new JPanel(new FlowLayout());
		pnlCentro.add(lienzo);
		lienzo.setSize(800,600); //asi configuro el tamaño neto de pnlNorte no?
		pnlCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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
		this.initDibujo();


		//EVENTOS DE BOTON CIRCULO/CUADRADO
		btnCuadrado.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JVentanaDibujo.this.tipo = CUADRADO;
				JVentanaDibujo.this.asignarInt(txtR,txtG,txtB);
				JVentanaDibujo.this.color = asignarColor(r,g,b); //si no pongo JVentanaDibujo, a que hace referencia this? a los atributos locales del constructor?
			}
		});

		btnCirculo.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JVentanaDibujo.this.tipo = CIRCULO;
				JVentanaDibujo.this.asignarInt(txtR,txtG,txtB); //asigno los colores de las textbox a los atributos
				JVentanaDibujo.this.color = asignarColor(r,g,b);
			}
		});
			
	}






	//MÉTODOS UTILIZADOS

	private void initDibujo()
	{
		dibujo.addFigura("grupo verde", new Circulo(10,10,true,Color.GREEN,80));	//NO OLVIDARSE EL Color. PARA LOS COLORES!!!!!
		dibujo.addFigura("grupo verde", new Circulo(100,10,true,Color.GREEN,50));
		dibujo.addFigura("grupo rojo", new Cuadrado(10,100,false,Color.RED,80));
		dibujo.addFigura("grupo rojo", new Circulo(400,300,true,Color.RED,120));
		dibujo.addFigura("grupo azul", new Cuadrado(600,500,true,Color.BLUE,70));
		lienzo.repaint();
	}


	public int validarRGB(String valor) throws RGBConversionException
	{
		int vfinal = 0;

		try
		{
			vfinal = Integer.parseInt(valor);
		}
		catch(NumberFormatException numb)
		{
			System.out.println("Los valores RGB han de ser números y deben estar comprendidos en el intervalo [0-255]\nUsted ha introducido el valor: " + vfinal);
			//aqui despliego un dialog

		}
		finally
		{
			if(vfinal>= 0 && vfinal<=255)
				return vfinal;
			else
				throw new RGBConversionException(vfinal);
		}
	}


	public void asignarInt(JTextField r,JTextField g,JTextField b)
	{
		try
		{
			JVentanaDibujo.this.r = JVentanaDibujo.this.validarRGB(r.getText());
			JVentanaDibujo.this.g = JVentanaDibujo.this.validarRGB(g.getText());
			JVentanaDibujo.this.b = JVentanaDibujo.this.validarRGB(b.getText());
		}
		catch(RGBConversionException conv)
		{
			System.out.println(conv);
			//aqui despliego el dialog
		}
	}


	public Color asignarColor(int r, int g, int b)
	{
		// this.asignarInt(txtR,txtG,txtB); //Actualizo el color antes de asignarlo
		return new Color(r,g,b);
	}

	public void asignarColoresRandom()
	{
		txtR.setText(String.valueOf(Util.getColorRGBRandom()));
		txtG.setText(String.valueOf(Util.getColorRGBRandom()));
		txtB.setText(String.valueOf(Util.getColorRGBRandom()));
	}

	//GETTERS

	public Dibujo getDibujo()
	{
		return dibujo;
	}

	public String getTipo()
	{
		return tipo;
	}

	public Color getColor()
	{
		return color;
	}



}

		



























// btnCirculo.addActionListener(new ActionListener()
// 		{
// 			@Override
// 			public void actionPerformed(ActionEvent e)
// 			{
// 				JVentanaDibujo.this.tipo = "circulo";

// 				try
// 				{
// 					JVentanaDibujo.this.r = JVentanaDibujo.this.asignarRGB(txtR.getText());
// 					JVentanaDibujo.this.g = JVentanaDibujo.this.asignarRGB(txtG.getText());
// 					JVentanaDibujo.this.b = JVentanaDibujo.this.asignarRGB(txtB.getText());
// 				}//CÓMO INDICO SI EL ERROR ES EN R, G Ó B???
// 				catch(RGBConversionException conv)
// 				{
// 					System.out.println(conv);
// 					//aqui despliego el dialog


// 				}

// 			}
// 		});








	// public void coloresRandom(JTextField r,JTextField g,JTextField b)
	// {
	// 	r.setText(String.valueOf(Util.getColorRGBRandom())); //Lo convierto todo a string porque es lo que asigno a las cajas de texto
	// 	g.setText(String.valueOf(Util.getColorRGBRandom()));
	// 	b.setText(String.valueOf(Util.getColorRGBRandom()));
	// }

	
