import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    DataOutputStream toServer =null;
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Socket socket = new Socket("localhost",800);
            toServer = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e){

        }
        StackPane stackPane = new StackPane();
        Label label = new Label(" ");
        stackPane.getChildren().add(label);
        stage.setScene(new Scene(stackPane,400,400));
        stage.show();
        stackPane.requestFocus();

            stackPane.setOnKeyPressed(e->{
                new Thread(()->{
                try {
                    Platform.runLater(()->{
                        switch (e.getCode()){
                            case LEFT: label.setText("LEFT");
                                try {
                                    toServer.writeChar('L');
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case RIGHT:label.setText("RIGHT");
                                try {
                                    toServer.writeChar('R');
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case UP:label.setText("UP");
                                try {
                                    toServer.writeChar('U');
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case DOWN:
                                label.setText("DOWN");
                                try {
                                    toServer.writeChar('D');
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case SPACE:  label.setText("Shoot");
                                try {
                                    toServer.writeChar('S');
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            default:
                                try {
                                    toServer.flush();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                        }
                    });


                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }).start();
        });
    }
}
