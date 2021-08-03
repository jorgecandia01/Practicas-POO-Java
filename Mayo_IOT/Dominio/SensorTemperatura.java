package Mayo_IOT.Dominio;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import Mayo_IOT.Dominio.Sensor;

public class SensorTemperatura extends Sensor
{
	private static final String UNIDAD = "ºC";


	public SensorTemperatura(String id, String ubicacion)
	{
		this.id = id;
		this.ubicacion = ubicacion;
	}

	public void addValor(int temperatura)
	{
		mapaHoraValor.put(new Time(1),this.validar(temperatura));
	}

	public int validar(int temperatura)
	{
		Integer vAnterior = 0;
		if(!(mapaHoraValor.isEmpty()))
		{
			vAnterior = (Integer) mapaHoraValor.get(mapaHoraValor.firstKey());
			if((temperatura <= vAnterior*1.1) & (temperatura >= vAnterior*0.9))
				return temperatura;
			else
				return vAnterior;

		}
		else
			return temperatura;

	}
}