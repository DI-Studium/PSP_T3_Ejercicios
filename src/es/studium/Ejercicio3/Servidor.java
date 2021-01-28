package es.studium.Ejercicio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor
{
	static int CONEXIONES = 0;
	static int nClientes = 3;
	static Socket[] tabla = new Socket[nClientes];
	public static void main(String[] args)
	{
		int puerto = 6000; // Puerto
		while(CONEXIONES+1 < nClientes)
		{
			Socket cliente;
			try
			{
				ServerSocket servidor = new ServerSocket(puerto);
				System.out.println("Servidor iniciado...escuchando por el puerto "+ servidor.getLocalPort());
				while(true)
				{
					cliente = servidor.accept();
					// Esperando a un cliente
					//El socket creado se añade a la tabla,
					//se incrementa el número de conexiones
					//y se lanza el hilo para gestionar los mensajes
					//del cliente que se acaba de conectar
					if (CONEXIONES<nClientes) {
					tabla[CONEXIONES] = cliente;
					}
					else {
						System.out.println("Ha llegado al maximo de conexiones");
					}
					CONEXIONES++;
					HiloServidor hilo = new HiloServidor(cliente);
					hilo.start();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}