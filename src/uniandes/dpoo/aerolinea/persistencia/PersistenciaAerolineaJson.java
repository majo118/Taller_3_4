package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea 
{
	private static final String AVION_NOMBRE = "avion";
	private static final String AVION_CAPACIDAD = "capacidad";
	
	private static final String HORA_SALIDA = "horaSalida";
	private static final String HORA_LLEGADA = "horaLlegada";
	private static final String CODIGO_RUTA = "codigo";
	private static final String ORIGEN = "origen";
	private static final String DESTINO = "destino";
	
	private static final String FECHA = "fecha";
	private static final String AVION = "avion";
	private static final String RUTA = "ruta";
	
	
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException
	{
		String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
        JSONObject raiz = new JSONObject( jsonCompleto );
        
        cargarAviones(aerolinea, raiz.getJSONArray( "aviones" ));
        cargarRutas(aerolinea, raiz.getJSONArray( "clientes" ));
        cargarVuelos(aerolinea, raiz.getJSONArray( "clientes" ));
	}
	
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException
	{
		JSONObject jAerolinea = new JSONObject();
		
		salvarAviones(aerolinea, jAerolinea);
		salvarRutas(aerolinea, jAerolinea);
		salvarVuelos(aerolinea, jAerolinea);
			
		PrintWriter pw = new PrintWriter( archivo );
		jAerolinea.write( pw, 2, 0 );
        pw.close( );
		
	}
	
	private void salvarAviones( Aerolinea aerolinea, JSONObject jobject )
    {
		JSONArray jAviones = new JSONArray( );
		for( Avion avion : aerolinea.getAviones( ) )
        {
			JSONObject jAvion = new JSONObject( );
			jAvion.put(AVION_NOMBRE, avion.getNombre());
			jAvion.put(AVION_CAPACIDAD, avion.getCapacidad());
			
			jAviones.put(jAvion);
			
        }
		jobject.put( "aviones", jAviones );
    }
	
	private void salvarRutas( Aerolinea aerolinea, JSONObject jobject )
	{
		JSONArray jRutas = new JSONArray( );
		for( Ruta ruta : aerolinea.getRutas( ) )
        {
			JSONObject jRuta = new JSONObject( );
			jRuta.put(HORA_SALIDA, ruta.getHotaSalida());
			jRuta.put(HORA_LLEGADA, ruta.getHoraLlegada());
			jRuta.put(CODIGO_RUTA, ruta.getCodigoRuta());
			jRuta.put(ORIGEN, ruta.getOrigen());
			jRuta.put(DESTINO, ruta.getDestino());
			
			jRutas.put(jRuta);
			
        }
		jobject.put( "rutas", jRutas );
	}
	
	private void salvarVuelos( Aerolinea aerolinea, JSONObject jobject )
	{
		JSONArray jVuelos = new JSONArray( );
		for( Vuelo vuelo : aerolinea.getVuelos( ) )
        {
			JSONObject jvuelo = new JSONObject( );
			jvuelo.put(FECHA, vuelo.getFecha());
			jvuelo.put(AVION, vuelo.getAvion());
			jvuelo.put(RUTA, vuelo.getRuta());

			
			jVuelos.put(jvuelo);
			
        }
		jobject.put( "vuelos", jVuelos );
	}
	
	private void cargarAviones( Aerolinea aerolinea, JSONArray jAviones )
    {
		int numAviones = jAviones.length( );
		for( int i = 0; i < numAviones; i++ )
        {
			JSONObject avion = jAviones.getJSONObject( i );
			
			String avionNombre = avion.getString(AVION_NOMBRE);
			int avionCapacidad = avion.getInt(AVION_CAPACIDAD);
			
			Avion nuevoAvion = new Avion (avionNombre, avionCapacidad);
			
			aerolinea.agregarAvion(nuevoAvion);
			
        }
    }
	
	private void cargarRutas( Aerolinea aerolinea, JSONArray jRutas )
	{
		int numRutas = jRutas.length( );
		for( int i = 0; i < numRutas; i++ )
        {
			JSONObject ruta = jRutas.getJSONObject( i );

			
			String rutaHoraS = ruta.getString(HORA_SALIDA);
			String rutaHoraL = ruta.getString(HORA_LLEGADA);
			String rutaCodigo = ruta.getString(CODIGO_RUTA);
			String rutaOrigen = ruta.getString(ORIGEN);
			String rutaDestino = ruta.getString(DESTINO);
			
			Ruta nuevaRuta = new Ruta (rutaOrigen, rutaDestino, rutaHoraS, rutaHoraL, rutaCodigo);
			
			aerolinea.agregarRuta(nuevaRuta);
        }
			
        
	}
	
	private void cargarVuelos( Aerolinea aerolinea, JSONArray jVuelos )
	{
//		int numVuelos = jVuelos.length( );
//		for( int i = 0; i < numVuelos; i++ )
//        {
//			JSONObject vuelo = jVuelos.getJSONObject( i );
//
//			
//			String fecha = vuelo.getString(FECHA);
//			String avion = vuelo.getString(AVION);
//			String ruta = vuelo.getString(RUTA);
//
//			
//			Vuelo nuevoVuelo = new Vuelo (fecha, avion, ruta);
//			
//			aerolinea.agregarVuelo(nuevoVuelo);
//        }

	}
}
