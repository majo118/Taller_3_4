package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo 
{
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo (Ruta ruta, String fecha, Avion avion)
	{
		
	}
	
	public Ruta getRuta()
	{
		return null;
	}
	
	public String getFecha()
	{
		return null;
	}
	
	public Avion getAvion()
	{
		return null;
	}
	
	public Collection<Tiquete> getTiquetes()
	{
		return null;
	}
	
	public int venderTiquetes( Cliente cliente, CalculadoraTarifas calculadora, int cantidad)
	{
		return -1;
	}
	
	public boolean equals(Object obj)
	{
		return false;
	}
	
}
