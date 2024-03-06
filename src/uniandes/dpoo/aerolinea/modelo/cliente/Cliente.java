package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente 
{
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() 
	{
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete (Tiquete tiquete)
	{
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes()
	{
		int valor = 0;
		for (int i=0; i < tiquetesUsados.size(); i++)
    	{
			Tiquete tiquete = tiquetesUsados.get(i);
			int num = tiquete.getTarifa();
			valor = valor + num;
    	}
		return valor;
	}
	
	public int calcularSaldoPendiente()
	{
		int valor = 0;
		for (int i=0; i < tiquetesSinUsar.size(); i++)
    	{
			Tiquete tiquete = tiquetesSinUsar.get(i);
			int num = tiquete.getTarifa();
			valor = valor + num;
    	}
		return valor;
	}
	
	public void usarTiquetes(Vuelo vuelo)
	{
		for (int i=0; i < tiquetesSinUsar.size(); i++)
    	{
			Tiquete tiquete = tiquetesSinUsar.get(i);
			Vuelo vuel = tiquete.getVuelo();
			if (vuel == vuelo)
			{
				tiquetesUsados.add(tiquete);
				tiquetesSinUsar.remove(i);
				tiquete.marcarComoUsado();
			}
    	}
	}
}
