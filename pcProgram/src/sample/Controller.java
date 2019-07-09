package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Controller extends Thread {
    @FXML
    Label myIp;

    String host ="localhost";
    int port = 8887;
    WebSocketServer server = new wsSwerver(new InetSocketAddress(host,port));

    @FXML
    public void initialize() throws UnknownHostException {
        InetAddress localHost= InetAddress.getLocalHost();
        System.out.println("system ip is a :"+(localHost.getHostAddress()).trim());
        myIp.setText((localHost.getHostAddress()).trim() );
    }

    @FXML
    public void starts(){

        server.start();
        System.out.println("server is runing");
    }
    @FXML
    public void stops() throws IOException, InterruptedException {
        server.stop();
        System.out.println("server is stoped");
    }
}
