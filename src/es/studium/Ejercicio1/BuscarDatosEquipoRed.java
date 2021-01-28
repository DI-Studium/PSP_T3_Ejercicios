/**
 * 
 */
package es.studium.Ejercicio1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Alvca
 *
 */
public class BuscarDatosEquipoRed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (String ip: args)
				{
				System.out.println("La direccion IP buscada es :"+ip);
				InetAddress address = InetAddress.getByName(ip);
				pruebaMetodos(address);
				}
		}
		catch(UnknownHostException e){
			System.out.println("Debes estar conectado");
			System.out.println(e);
		}
		
	}
	private static void pruebaMetodos(InetAddress dir)
	{
	System.out.println("\t getHostName:" + dir.getHostName());
	System.out.println("\t getHostAddress:" + dir.getHostAddress());
	System.out.println("\t toString:" + dir.toString());
	System.out.println("\t getCanonicalHostName:"+ dir.getCanonicalHostName());
	}
}
