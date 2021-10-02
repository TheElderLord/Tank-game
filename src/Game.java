import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game extends Application {
    Map map;
    TankPlayer tank;
    static ArrayList<TankPlayer>  tanks = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        map = new Map("input3.txt");
        tank = new TankPlayer(map);
        tank.setName("Player");
        tanks.add(tank);
        ClientTank tank1 = new ClientTank(map);
        tank1.setName("Client");
        tank1.addPlayer();
        tanks.add(tank1);
        Text label = new Text(200,200,tank.getTankHealth()+"");
        Bot bot = new Bot(map);
        bot.addPlayer();
        bot.setName("Bot");
        tanks.add(bot);
       Thread thread = new Thread(bot);
       thread.start();


        Thread clientCon = new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(800);
                Socket socket = serverSocket.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                System.out.println(input.readChar());
                while (true){
                    try {
                        switch (input.readChar()){

                            case 'U':tank1.moveUp();
                            tank1.DirRot(90);
                            tank1.setDirect('U');break;
                            case 'D':tank1.moveDown();
                                tank1.DirRot(270);
                                tank1.setDirect('D');break;
                            case 'L':tank1.moveLeft();
                                tank1.DirRot(0);
                                tank1.setDirect('L');break;
                            case 'R':tank1.moveRight();
                                tank1.DirRot(180);
                                tank1.setDirect('R');break;
                            case 'S':Platform.runLater(tank1::shoot);break;
                        }
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        clientCon.start();


        label.setFont(new Font("Italic",24));
        HBox hBox = new HBox(label);
        hBox.setAlignment(Pos.TOP_CENTER);
        map.getChildren().add(hBox);
        Scene scene = new Scene(map);
        stage.setScene(scene);
        stage.show();
        map.print();
        map.requestFocus();
        map.setOnKeyPressed(e->{
            try {
                if (e.getCode() == KeyCode.UP){
                    tank.DirRot(90);
                    tank.setDirect('U');
                    tank.moveUp();

                }
                else if (e.getCode() == KeyCode.DOWN){
                    tank.DirRot(270);
                    tank.setDirect('D');
                    tank.moveDown();
                }
                else if (e.getCode() == KeyCode.LEFT){
                    tank.DirRot(0);
                    tank.setDirect('L');
                    tank.moveLeft();
                }
                else if (e.getCode() == KeyCode.RIGHT){
                    tank.DirRot(180);
                    tank.setDirect('R');
                    tank.moveRight();
                }
                else if (e.getCode()==KeyCode.SPACE){
                    tank.shoot();
                }

            }catch (Exception ex){

            }
        });

    }

    public static ArrayList<TankPlayer> getTanks() {
        return tanks;
    }
}