import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Player extends Pane {
    private Tank tank;

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Player(Map map) {
        this.tank = map.getTank();
        getChildren().add(tank);
    }

    public void moveTank(KeyCode keyCode) {
        int speed = 2;
        switch (keyCode) {
            case W:
                tank.moveY(-speed);
                break;
            case A:
                tank.moveX(-speed);
                break;
            case S:
                tank.moveY(speed);
                break;
            case D:
                tank.moveX(speed);
                break;
            case SPACE:
                tank.shoot();
                break;
        }
    }
}
