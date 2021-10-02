import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Block extends ImageView {
    private boolean walkable = false;
    private boolean flyable = false;
    private boolean unbreakable = true;
    private int health = 4;
    public Block(double size, double x, double y, String type) {
        setFitHeight(size);
        setFitWidth(size);
        setX(x);
        setY(y);

        setImage(type);
    }

    private void setImage(String type) {
        switch (type) {
            case "S":
                setImage(new Image(new File("Battle_City_wall.png").toURI().toString()));
                break;
            case "W":
                flyable = true;
                setImage(new Image(new File("Battle_City_water.png").toURI().toString()));
                break;
            case "B":
                unbreakable = false;
                setImage(new Image(new File("bricks_new.png").toURI().toString()));
                break;
            case "T":
                walkable = true;
                flyable = true;
                setImage(new Image(new File("trees.png").toURI().toString()));
                break;
            case "P":
                setImage(new Image(new File("tank.png").toURI().toString()));
                setFitHeight(40);
                setFitWidth(40);
                break;
            case "F":
                setImage(new Image(new File("bullet.png").toURI().toString()));
                flyable = true;
                break;
            default:
                walkable = true;
                flyable = true;
        }
    }

    public void fire() {
        if (!flyable && !unbreakable) {
            health--;
        }
    }

    public boolean isOnMap() {
        return health > 0;
    }

    public boolean canIPass() {
        return walkable;
    }

    public boolean canBulletPass() {
        return flyable;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public boolean isFlyable() {
        return flyable;
    }

    public void setFlyable(boolean flyable) {
        this.flyable = flyable;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public void setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
