
import java.io.IOException;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/game")
public class CustomEndpoint {
	@OnOpen
	public void onOpen(Session session) throws IOException {
		 System.out.println("New session opened: "+session.getId());
	}
	
	@OnMessage
	public String onMessage(String message, Session session) throws IOException {
		System.out.println("Client: " + message);
	
		return "ok";
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("session closed: "+session.getId());
	}
}