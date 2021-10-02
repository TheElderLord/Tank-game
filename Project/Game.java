import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game {
    private Map map;
    private Player player;
    private Pane gamePane = new Pane();
    private Scene gameScene;

    public Game() {
    }

    public void init(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    public void play() {
        gamePane.setStyle("-fx-background-color: black");

        gameScene = new Scene(gamePane, map.size * map.width, map.size * map.height);

        gamePane.getChildren().addAll(player, map);

        gameScene.setOnKeyPressed(event -> {
            player.moveTank(event.getCode());
        });

    }

    public Pane getPane() {
        return gamePane;
    }

    public Scene getScene() {
        return gameScene;
    }
}
