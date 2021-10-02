import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {
      Map map;
      Tank tank;
    @Override
    public void start(Stage stage) throws Exception {
        map = new Map("input.txt");
        tank = new Tank(map);
        Scene scene = new Scene(map);
        stage.setScene(scene);
        stage.show();
        map.requestFocus();

    }
}