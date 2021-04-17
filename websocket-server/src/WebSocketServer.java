import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.glassfish.tyrus.server.Server;

public class WebSocketServer {

	public static void main(String[] args) {
		runServer();
	}

	public static void runServer() {
		Server server = new Server("localhost", 8080, "/websockets", CustomEndpoint.class);
		String input=null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please press 's' to stop the server.");
		try {
			server.start();
			do {
			input = reader.readLine();
			System.out.println(input);
			}while(input!="s");
				server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}