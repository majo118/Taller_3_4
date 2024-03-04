package uniandes.dpoo.aerolinea.modelo.tarifas;


import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas 
{
	public final double IMPUESTO = 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente)
	{
		return -1;
	}
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente)
	{
		return -1;
	}
	
	protected double calcularPorcentajeDescuento(Cliente cliente)
	{
		return -1;
	}
	
	protected int calcularDistanciaVuelo(Ruta rura)
	{
		return -1;
	}
	
	protected int calcularValorImpuestos(int costoBase)
	{
		return -1;
	}
}
