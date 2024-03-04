package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    
	private String horaSalida;
	private String horaLlegada;
	private String codigoRuta;
	private Aeropuerto destino;
	private Aeropuerto origen;

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
	public Ruta (Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta)
	{
		this.origen = origen;
		this.destino= destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.codigoRuta = codigoRuta;
	}
	
	public String getCodigoRuta()
	{
		return codigoRuta;
	}
	
	public Aeropuerto getOrigen()
	{
		return origen;
	}
	
	public Aeropuerto getDestino()
	{
		return destino;
	}
	
	public String getHotaSalida()
	{
		return horaSalida;
	}
	
	public String getHoraLlegada()
	{
		return horaLlegada;
	}
	
	public int getDuracion()
	{
		int horaSalidaN = getHoras(horaSalida);
		int horaLlegadaN = getHoras(horaLlegada);
		
		int minutoSalida = getMinutos(horaSalida);
		int minutoLlegada = getMinutos(horaLlegada);
		
		int horaSalidaM = horaSalidaN*60;
		int horaLlegadaM = horaLlegadaN*60;
		
		minutoSalida = minutoSalida + horaSalidaM;
		minutoLlegada = minutoLlegada + horaLlegadaM;
		
		int Duracion = minutoLlegada - minutoSalida;
		
		if (Duracion < 0)
		{
		    minutoLlegada = (minutoSalida-minutoLlegada - 60);
		    horaSalidaN = getHoras("2300");
		    minutoSalida = getMinutos("2300");
		    horaSalidaM = horaSalidaN*60;
		    minutoSalida = minutoSalida + horaSalidaM;
		    
		    Duracion = (minutoLlegada - minutoSalida)*-1;
		}
		
		return Duracion;
	}
	
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }

    
}
