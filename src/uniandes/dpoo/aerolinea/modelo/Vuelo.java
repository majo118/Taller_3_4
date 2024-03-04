package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo 
{
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes = new HashMap<String, Tiquete>();
	
	public Vuelo (Ruta ruta, String fecha, Avion avion)
	{
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		
	}
	
	public Ruta getRuta()
	{
		return ruta;
	}
	
	public String getFecha()
	{
		return fecha;
	}
	
	public Avion getAvion()
	{
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes()
	{
		return tiquetes.values();
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
