package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete 
{
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente cliente;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComparador, int tarifa)
	{
		
	}
	
	public Cliente getCliente()
	{
		return null;
	}
	
	public Vuelo getVuelo()
	{
		return null;
	}
	
	public String getCodigo()
	{
		return null;
	}
	
	public int getTarifa()
	{
		return -1;
	}
	
	public void marcarComoUsado()
	{
		
	}
	
	public boolean esUsado()
	{
		return false;
	}
}
