package es.studium.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class HiloServidor extends Thread
{
	Socket socket;
	DataOutputStream fsalida;
	DataInputStream fentrada;
	public HiloServidor(Socket s) throws IOException
	{
		this.socket = s;
		// Se crean los flujos de entrada y salida
		fsalida = new DataOutputStream(s.getOutputStream());
		fentrada = new DataInputStream(s.getInputStream());
	}
	public void run()
	{
		String cadena = "";
		String cadena2= "Saludos desde el servidor";
		try
		{
			fsalida.writeUTF(cadena2);
				System.out.println("Comunico con socket " + socket.toString());
				cadena = fentrada.readUTF();// Obtengo la cadena
				System.out.println("Cliente envia: "+cadena);
			
			System.out.println("Fin de comunicación con socket " + socket.toString());
			fsalida.close();
			fentrada.close();
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
