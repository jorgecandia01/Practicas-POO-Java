package Retos.RetoMensajes;

import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.WindowConstants;

public class RetoMensajes
{
	public static void main(String[] args)
	{
		System.out.println(java.awt.event.KeyEvent.VK_ENTER);

        System.out.println(java.awt.event.KeyEvent.VK_ESCAPE);   

		String s1 = BorderLayout.NORTH.toString();
		System.out.println(s1);

		String s2 = String.valueOf(Font.BOLD);
		System.out.println(s2);

		String s3 = String.valueOf(WindowConstants.EXIT_ON_CLOSE);
		System.out.println(s3);
	}
}
