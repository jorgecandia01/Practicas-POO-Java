package practica12.dominio;

public abstract class Figura implements java.io.Serializable
{
	protected int x;
	protected int y;
	protected boolean relleno;
	private java.awt.Color color;

	protected boolean visible = true;

	/** 
		Inicializa todos los atributos del objeto 
		@param x Posición x de la ventana en pixels
		@param y Posición x de la ventana en pixels
		@param relleno Lo pinta transparente u opaco
		@param color Color de la figura
		
	*/
	public Figura(int x, int y, boolean relleno, java.awt.Color color)
	{
		this.setX(x);
		this.setY(y);
		this.relleno = relleno;
		this.color = color;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void setX(int x)
	{
		if(x>0 && x<800)
			this.x = x;
	}

	public void setY(int y)
	{
		if(y>0 && y<600)
			this.y = y;
	}

	public void setPuntoFinal(java.awt.Point punto)
	{
		int ladoX = Math.abs(punto.x-x);
		int ladoY = Math.abs(punto.y-y);
		this.setDimension(Math.min(ladoX, ladoY));
	}

	/** Aplica la dimensión final del objeto expresado en radio, lado, etc... */
	public abstract void setDimension(int dimension);

	public void setRelleno(boolean relleno)
	{
		this.relleno = relleno;
	}

	public boolean getRelleno()
	{
		return relleno;
	}

	public void setColor(java.awt.Color color)
	{
		this.color = color;
	}

	public java.awt.Color getColor()
	{
		return color;
	}	

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	public boolean isVisible()
	{
		return visible;
	}

	public void pintar(java.awt.Graphics g)
	{
		g.setColor(color);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		sb.append(", ");
		sb.append(y);
		sb.append(", ");
		sb.append(relleno);
		sb.append(", ");
		sb.append(color.getRGB());
		return sb.toString();
	}
}