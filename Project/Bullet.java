import javafx.animation.AnimationTimer;
import javafx.scene.Node;

public class Bullet extends Block {
    private int rotation;
    private AnimationTimer animationTimer;
    private Map map;

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public AnimationTimer getAnimationTimer() {
        return animationTimer;
    }

    public void setAnimationTimer(AnimationTimer animationTimer) {
        this.animationTimer = animationTimer;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Bullet(double x, double y, int direction, Map map) {
        super(10, x, y, "F");
        this.rotation = direction;
        this.map = map;

        map.getChildren().add(this);

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                animateBullet();
            }
        };
        animationTimer.start();
    }

    public void collapse() {
        if (check()) {
            map.getChildren().remove(this);
            animationTimer.stop();
        }

        for (Node node : map.getChildren()
        ) {
            if (node instanceof Block && !((Block) node).canBulletPass() && getBoundsInLocal().intersects(node.getBoundsInLocal())) {
                Block block = (Block) node;
                block.fire();
                if (!block.isOnMap()) {
                    map.getChildren().remove(node);
                }

                if (map.getChildren().contains(this)) {
                    map.getChildren().remove(this);
                    animationTimer.stop();
                    return;
                }
            }
        }
    }

    private boolean check() {
        return getX() >= map.width * map.size - getFitWidth() || getY() >= map.height * map.size - getFitHeight() || getX() <= 0 || getY() <= 0;
    }

    public void animateBullet() {
        int speed = 10;
        switch (rotation) {
            case 0:
                setY(getY() - speed);
                break;
            case 180:
                setY(getY() + speed);
                break;
            case 270:
                setX(getX() - speed);
                break;
            case 90:
                setX(getX() + speed);
                break;
        }

        collapse();
    }

}
