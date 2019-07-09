package sample;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class wsSwerver extends WebSocketServer {


    public wsSwerver(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        webSocket.send("welcom to the server");
        broadcast("new connection: "+ clientHandshake.getResourceDescriptor());
        System.out.println("new connection to :" + webSocket.getResourceDescriptor());
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("closed " + webSocket.getRemoteSocketAddress() + " with exit code " + i + " additional info: " + s);
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("received message from "	+ webSocket.getRemoteSocketAddress() + ": " + s);
        webSocket.send("you are send this mesage "+s);
    }
    @Override
    public void onMessage( WebSocket conn, ByteBuffer message ) {
        System.out.println("received ByteBuffer from "	+ conn.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.err.println("an error occured on connection " + webSocket.getRemoteSocketAddress()  + ":" + e);
    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }
}
