package application;


import application.controller.Controller;
import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Client client1=new Client();
        Client client2=new Client();

        Scanner x=new Scanner(System.in);

        System.out.println("请输入玩家1的账号");
        int p= x.nextInt();
        client1.client(p);
        System.out.println("请输入玩家2的账号");
        int q= x.nextInt();
        client2.client(q);

        new Server();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getClassLoader().getResource("mainUI.fxml"));
            Pane root = fxmlLoader.load();
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();

            if(Controller.win()==1)
            { client1.client(p);}
            if(Controller.win()==2)
            { client1.client(q);}
            if(Controller.win()==3)
            { client1.client(q);}
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public static void main(String[] args) {
        launch(args);
    }
}