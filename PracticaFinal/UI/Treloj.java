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

public class Treloj extends Thread
{
	private int i = 0;

	private String ssegundero = "00";
	private String sminutero = "00";
	private String reloj = "00:00";

	JExamen jexamen;

	public Treloj(JExamen jexamen)
	{
		this.jexamen = jexamen;
	}

	public void run()
	{
		while(i == 0)
		{
			for(int minutero = 0; minutero<60; minutero++)
			{
				for(int segundero = 0; segundero<60; segundero++)
				{

					if(segundero<10)
						ssegundero = "0" + segundero;
					else
						ssegundero = "" + segundero;

					if(minutero<10)
						sminutero = "0" + minutero;
					else
						sminutero = "" + minutero;

					reloj = (sminutero + ":" + ssegundero);

					jexamen.setReloj(reloj);

					try
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException e){}


				}
			}
		}
	}

	public void setI(int indice)
	{
		this.i = indice;
	}
}