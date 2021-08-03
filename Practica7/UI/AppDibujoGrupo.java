package Practica7.UI;

import Practica7.Dominio.Circulo;
import Practica7.Dominio.Cuadrado;

import Practica7.Dominio.Dibujo;

import Practica7.Dominio.Util;

import java.awt.Color;

public class AppDibujoGrupo
{
	public static void main(String[] args)
	{
		Dibujo dibujo = new Dibujo();	//Inicializo el dibujo

		//con dibujo.pintar(figura) meto directamente la figura en el mapa
		//Circulo(int X, int Y, boolean R, Color C, int Rad) 
		//Cuadrado(int X, int Y, boolean R, Color C, int Lado) 

		dibujo.pintar("grupo verde", new Circulo(10,10,true,Color.GREEN,80));	//NO OLVIDARSE EL Color. PARA LOS COLORES!!!!!
		dibujo.pintar("grupo verde", new Circulo(100,10,true,Color.GREEN,50));
		dibujo.pintar("grupo rojo", new Cuadrado(10,100,false,Color.RED,80));
		dibujo.pintar("grupo rojo", new Circulo(400,300,true,Color.RED,120));
		dibujo.pintar("grupo azul", new Cuadrado(600,500,true,Color.BLUE,70));

		Util.wait(1);
		dibujo.mostrarTodasFiguras();

		Util.wait(1);
		dibujo.ocultarGrupo("grupo verde");

		Util.wait(1);
		dibujo.ocultarGrupo("grupo azul");

		Util.wait(1);
		dibujo.ocultarGrupo("grupo rojo");

		Util.wait(1);
		dibujo.mostrarTodasFiguras();
	}
} 