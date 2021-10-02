import javafx.application.Application;

import javafx.stage.Stage;

public class PlayGameFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Map map = new Map(50);
        Player player = new Player(map);

        Game game = new Game();
        game.init(map, player);

        game.play();
        primaryStage.setScene(game.getScene());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
