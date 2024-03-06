package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas
{
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente)
	{
		Ruta ruta = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo(ruta);
		
		int costo = 0;
		String tipoCliente = cliente.getTipoCliente();
		
		if (tipoCliente.equals("Corporativo"))
			costo = COSTO_POR_KM_CORPORATIVO * distancia;
		
		else if (tipoCliente.equals("Natural"))
			costo = COSTO_POR_KM_NATURAL * distancia;
		
		return costo;
	}
	
	protected double calcularPorcentajeDescuento(Cliente cliente)
	{
		double descuento = 0.0;
		
		String tipoCliente = cliente.getTipoCliente();
		
		if (tipoCliente.equals("Corporativo"))
		{
			ClienteCorporativo clienteC = (ClienteCorporativo) cliente;
			int tamanio = clienteC.getTamanoEmpresa();
			
			if (tamanio == 1)
				descuento = DESCUENTO_GRANDES;
			
			else if (tamanio == 2)
				descuento = DESCUENTO_MEDIAS;
			
			else if (tamanio == 3)
				descuento = DESCUENTO_PEQ;
		}
		return descuento;
	}
}
