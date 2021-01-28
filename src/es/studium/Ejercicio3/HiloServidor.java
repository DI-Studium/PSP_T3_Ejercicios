package es.studium.Ejercicio3;

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
		String cadena2= "Eres el cliente numero: "+Servidor.CONEXIONES;
		try
		{
			fsalida.writeUTF(cadena2);
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
