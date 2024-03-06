package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
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
	
	public int venderTiquetes( Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException
	{
		int capacidad = avion.getCapacidad();
		
		int tarifa = calculadora.calcularTarifa(this, cliente);
		int tiquetesVendidos = 0;
		if(cantidad > capacidad)
			throw new VueloSobrevendidoException(this);
		for (int i=0; i<=cantidad; i++)
		{	
			if(i > capacidad)
				throw new VueloSobrevendidoException(this);
			else
			{
				Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
				String codigo = tiquete.getCodigo();
				
				tiquetes.put(codigo, tiquete);
				tiquetesVendidos++;
			}
		}
		return tiquetesVendidos;
	}
	
//	public boolean equals(Object obj)
//	{
//		equals(obj);
//		return false;
//	}
	
}
