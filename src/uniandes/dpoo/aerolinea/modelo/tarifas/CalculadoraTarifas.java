package uniandes.dpoo.aerolinea.modelo.tarifas;


import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas  
{
	public final double IMPUESTO = 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente)
	{
		int costoBase = calcularCostoBase(vuelo, cliente);
		double descuento = calcularPorcentajeDescuento(cliente);
		
		int tarifa = (int) (costoBase - descuento);
		return tarifa;
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta)
	{
		Aeropuerto aeropuerto1 = ruta.getOrigen();
		Aeropuerto aeropuerto2 = ruta.getDestino();
		
		int distancia = Aeropuerto.calcularDistancia(aeropuerto1, aeropuerto2);
		
		return distancia;
	}
	
	protected int calcularValorImpuestos(int costoBase)
	{
		double impuesto = costoBase*IMPUESTO;
		int nuevoCosto = (int) (costoBase + impuesto);
		
		return nuevoCosto;
	}
}
