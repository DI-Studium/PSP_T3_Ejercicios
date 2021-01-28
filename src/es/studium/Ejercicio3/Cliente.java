package es.studium.Ejercicio3;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente
{
	//static final String HOST = "192.168.0.20";
	static final String HOST = "localhost";
	static final int PUERTO = 6000;
	public static void main(String[] arg)
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Iniciando programa cliente..");
			Socket cliente = new Socket(HOST, PUERTO);
			if(cliente!=null) {
			// Creo el flujo de salida al servidor
			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			// Creo el flujo de entrada desde servidor
			InputStream entrada = cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			
				String eco=flujoEntrada.readUTF();
				System.out.println("=>Mi número es el : "+eco);
			System.out.println("Fin programa cliente..");
			do {
				System.out.println("Dame una cadena (* para FIN): ");
				eco=sc.nextLine();
				flujoSalida.writeUTF(eco);
			}while(!eco.equals("*"));
			
			// Cerramos streams y sockets
			entrada.close();
			flujoEntrada.close();
			salida.close();
			flujoSalida.close();
			cliente.close();
			sc.close();
		}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}