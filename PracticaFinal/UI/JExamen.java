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
import PracticaFinal.UI.Treloj;

public class JExamen extends JPanel
{
	private int indice = 0;
	private JAplicacion japlicacion;
	private Examen examen;
	private ArrayList<Pregunta> preguntas;
	private ArrayList<String> correctas = new ArrayList<String>();; //array list con la respuesta correcta de cada pregunta
	private ArrayList<String> correccion = new ArrayList<String>(); //array list con lo respondido en cada pregunta

	//0
	private JLabel lblNPregunta = new JLabel("Pregunta: "+(indice+1));
	private JLabel lblReloj = new JLabel("--:--");

	//1
	private String enunciado;
	private JLabel lblEnunciadoPregunta = new JLabel();

	//2
	private String respuesta1; //hago set text en los radio buttons 
	private String respuesta2;
	private String respuesta3;
	private String respuesta4;

	private ButtonGroup btnGrpRespuestas = new ButtonGroup();
	private JRadioButton btnR1 = new JRadioButton();
	private JRadioButton btnR2 = new JRadioButton();
	private JRadioButton btnR3 = new JRadioButton();
	private JRadioButton btnR4 = new JRadioButton();

	//3 
	private JButton btnSiguiente = new JButton("SIGUIENTE");
	private JButton btnAnterior = new JButton("ANTERIOR");




	public JExamen(JAplicacion japlicacion)//le paso la aplicación, que contiene el examen
	{
		this.japlicacion = japlicacion;
		this.setLayout(new GridLayout(3,1));

		this.examen = japlicacion.getExamen();
		preguntas = examen.getPreguntasExamen();
		// System.out.println(this.preguntas.size());
		// System.out.println(this.examen.getSize());
		correctas = examen.getCorrectas();

		this.hacerEspacio();

		//otra opcion habria sido hacer un border layout dentro del border layout
		JPanel pnlEnunciado = new JPanel(new GridLayout(2,1)); //PANEL DE ENUNCIADO
		JPanel pnlRespuestas = new JPanel(new GridLayout(4,1));	//PANEL DE RESPUESTAS
		JPanel pnlBotones = new JPanel(new GridLayout(2,1)); //PANEL DE BOTONES 		new FlowLayout(FlowLayout.CENTER, 100, 0)

		this.add(pnlEnunciado);
		this.add(pnlRespuestas);
		this.add(pnlBotones);

		//0 ÍNDICE
		JPanel pnlIndice = new JPanel(new FlowLayout(FlowLayout.CENTER,300,0)); //PANEL CON INFO SOBRE EL EXAMEN
		pnlEnunciado.add(pnlIndice);
		pnlIndice.add(lblNPregunta);

		pnlIndice.add(lblReloj);
		Treloj tReloj = new Treloj(this);
		tReloj.start();

		//1 ENUNCIADO
		pnlEnunciado.add(lblEnunciadoPregunta);
		lblEnunciadoPregunta.setFont(new Font("Calibri", Font.BOLD, 18));
		pnlEnunciado.setSize(new java.awt.Dimension(600, 100));
		lblEnunciadoPregunta.setVerticalAlignment(SwingConstants.CENTER);

		
		//2 PREGUNTAS
		pnlRespuestas.add(btnR1);
		pnlRespuestas.add(btnR2);
		pnlRespuestas.add(btnR3);
		pnlRespuestas.add(btnR4);
		btnGrpRespuestas.add(btnR1);
		btnGrpRespuestas.add(btnR2);
		btnGrpRespuestas.add(btnR3);
		btnGrpRespuestas.add(btnR4);

		//REFRESCO PARA LA PRIMERA PREGUNTA:
		this.actualizarPregunta();

		//3 BOTONES
		JPanel pnlBotonesBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 360, 0));
		pnlBotones.add(new JPanel(new FlowLayout()));
		pnlBotones.add(pnlBotonesBotones);
		pnlBotonesBotones.add(btnAnterior);
		pnlBotonesBotones.add(btnSiguiente);
		
		
		

		//EVENTOS
		btnSiguiente.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JExamen.this.guardarSeleccion(indice);
				// System.out.println(indice); //DEBUG
				// System.out.println(preguntas.size());

				if(indice<(preguntas.size()-1))
					{
						indice++;
						lblNPregunta.setText("Pregunta: "+(indice+1));
						JExamen.this.actualizarPregunta();
					}
				else
				{
					StringBuilder sb = new StringBuilder();
					sb.append("Ha sacado un ");
					sb.append(JExamen.this.getAciertos());
					sb.append(" sobre ");
					sb.append(preguntas.size());
					sb.append("\n\nHa fallado en las siguientes preguntas:     \n");
					sb.append(JExamen.this.getFallos().toString());
					sb.append("\n\nHa tardado:  ");
					sb.append(lblReloj.getText());
					sb.append(" minutos");
					// sb.append();
					tReloj.setI(100);			//El thread no se detiene, he leido en internet que es por movidas de los frames (tampoco va con interrupt)
					pnlIndice.remove(lblReloj);	//quitando el lbl, se detiene (no se borra, no se por que, pero se detiene, aunque el tiempo sigue contando por dentro)
					pnlIndice.revalidate();
					JOptionPane.showMessageDialog(JExamen.this, sb.toString());
					// System.exit(-1);

				}

				JExamen.this.revalidate();
			}
		});


		btnAnterior.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				JExamen.this.guardarSeleccion(indice);
				// System.out.println(indice);
				// System.out.println(correccion.get(indice));

				if(indice>0)
					indice = indice - 1;

				lblNPregunta.setText("Pregunta: "+(indice+1));
				JExamen.this.actualizarPregunta();
				JExamen.this.revalidate();
			}
		});



	}

	public void actualizarPregunta()
	{
		String pEnunciado = preguntas.get(indice).getEnunciado();
		String[] pRespuestas = preguntas.get(indice).getRespuestas();

		enunciado = pEnunciado;
		respuesta1 = pRespuestas[0];
		respuesta2 = pRespuestas[1];
		respuesta3 = pRespuestas[2];
		respuesta4 = pRespuestas[3];

		lblEnunciadoPregunta.setText("<html><p style=\"width:700px\">"+enunciado+"</p></html>");
		btnR1.setText("<html><p style=\"width:700px\">"+respuesta1+"</p></html>"); 
		btnR2.setText("<html><p style=\"width:700px\">"+respuesta2+"</p></html>"); //en width cambio la longitud con la que se muestra la pregunta antes del salto de linea
		btnR3.setText("<html><p style=\"width:700px\">"+respuesta3+"</p></html>"); //todo esto es para que haga un salto de linea si llega al final de la ventana
		btnR4.setText("<html><p style=\"width:700px\">"+respuesta4+"</p></html>"); 

		//metodo checkfinal para comprobar con el indice si he acabado e ir a la pantalla final
	}


	public void guardarSeleccion(int ind)
	{
		String seleccion = "";
		
		if(btnR1.isSelected())
			seleccion = "A";

		if(btnR2.isSelected())
			seleccion = "B";

		if(btnR3.isSelected())
			seleccion = "C";

		if(btnR4.isSelected())
			seleccion = "D";


		//si no hay ninguno seleccionado, sale del bucle y se guarda un string vacio, que por ende no es la respuesta correcta

		correccion.set(indice,seleccion);
		btnGrpRespuestas.clearSelection();
	}


	public void hacerEspacio() //lleno correccion de strings vacíos para poder hacer (ArrayList).set => por si vuelvo atras en una pregunta
	{
		for(int i=0;i<preguntas.size();i++)
		{
			correccion.add("");
		}
	}

	public ArrayList<String> getCorreccion()
	{
		return correccion;
	}


	public int getAciertos()
	{
		int aciertos = 0;
		for(int i = 0; i<preguntas.size(); i++)
		{
			if((correccion.get(i)).equals(correctas.get(i)))
				aciertos++;

			// System.out.println(correccion.get(i) + " -> " + correctas.get(i));
		}
		// System.out.println(aciertos);

		return aciertos;
	}

	public String getFallos()
	{
		ArrayList<Integer> fallos = new ArrayList<Integer>();

		for(int i = 0; i<preguntas.size(); i++)
		{
			if(!(correccion.get(i)).equals(correctas.get(i)))
			{
				fallos.add(i+1);
			}

			// System.out.println(correccion.get(i) + " -> " + correctas.get(i));
		}
		// System.out.println(aciertos);

		StringBuilder sb = new StringBuilder();
		sb.append(" | ");

		if(fallos.get(0)!=null)
			for(Integer fallo:fallos)
			{
				sb.append(fallo.toString());
				sb.append(" | ");
			}

		else
			sb.append("No hay fallos");

		return sb.toString();
	}


	public void setReloj(String rel)
	{
		lblReloj.setText(rel);
	}

}