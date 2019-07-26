package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.InetSocketAddress;

public class Main extends Application {

    private static Main instance;
    private wsSwerver mwWsSwerver;

    public static Main getInstance() {
        return instance;
    }

    public Main() {
        instance = this;
    }

    @Override
    public void init() throws Exception {
        super.init();
        String host = "localhost";
        int port = 8887;
        mwWsSwerver = new wsSwerver(new InetSocketAddress(host, port));
       new Thread(() -> mwWsSwerver.run()).start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 892, 595));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public wsSwerver getMwWsSwerver() {
        return mwWsSwerver;
    }
}
