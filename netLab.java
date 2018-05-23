import java.io.IOException;
import java.net.InetAdress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class createSocket {
	public static void main(string[] args) {
		try {
			InetAdress addr = InetAdress.getByName("Your server's IP adress");
			Socket theSocket = new Socket(addr, 80);
			System.out.println("Connected to "
				+ theSocket.getInetAdress()
				+ " on port " + theSocket.getPort() + " from port "
				+ theSocket.getLocalPort() + " of"
				+ theSocket.getLocalAdress());
		}
		catch(UnknownHostException e){
			System.err.println("I can't find " + e);
		}
		catch(SocketException e){
			System.err.println("Could not connect to " + e);
		}
		catch(IOException e){
			System.err.println(e);
		}
	}
}