package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.java_websocket.server.WebSocketServer;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class Controller extends Thread {
    @FXML
    Label myIp;
    @FXML
    TextField pcIp;

//    String host = pcIp.getText();
//    int port = 8887;
//    WebSocketServer server = new wsSwerver(new InetSocketAddress(host,port));

    @FXML
    public void initialize() throws UnknownHostException, SocketException {
//        InetAddress localHost1= InetAddress.getLocalHost();
//        InetAddress[] localHost= InetAddress.getAllByName(localHost1.getHostName());
//        myIp.setText((localHost1.getHostAddress()).trim() );
//        for (int i = 0; i < localHost.length ;i++){
//            System.out.println("system ip is a :"+(localHost[i].getHostAddress()).trim());
//            System.out.println(localHost[1].getHostName());
//
//        }
    }

    @FXML
    public void starts() {
        Main.getInstance().getMwWsSwerver().broadcast("hello");
//        server.start();
        System.out.println("server is runing");
//        myIp.setText("server address is:"+pcIp.getText());
    }

    @FXML
    public void stops() throws IOException, InterruptedException {
//        server.stop();
        System.out.println("server is stoped");
    }
}
