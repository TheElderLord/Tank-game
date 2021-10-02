import javafx.scene.Node;

public class Tank extends Block {
    private Map map;

    public Tank(double size, double x, double y, Map map) {
        super(size, x, y, "P");
        this.map = map;
    }

    public boolean intersectsWithBlock() {
        if (check()) return true;

        for (Node node : map.getChildren()
        ) {
            if (isCollapse(node)) return true;
        }
        return false;
    }

    private boolean isCollapse(Node node) {
        return node instanceof Block && !((Block) node).canIPass() && getBoundsInLocal().intersects(node.getBoundsInLocal());
    }

    private boolean check() {
        return getX() >= map.width * map.size - getFitWidth() || getY() >= map.height * map.size - getFitHeight() || getX() <= 0 || getY() <= 0;
    }

    public void moveX(int amount) {
        setX(getX() + amount);
        if (intersectsWithBlock()) {
            setX(getX() - amount);
        }

        if (amount > 0) {
            setRotate(90);
        } else {
            setRotate(270);
        }
    }

    public void moveY(int amount) {
        setY(getY() + amount);
        if (intersectsWithBlock()) {
            setY(getY() - amount);
        }

        if (amount > 0) {
            setRotate(180);
        } else {
            setRotate(0);
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void shoot() {

        if (getRotate() == 0) {
            Bullet bullet = new Bullet(getX() + 15, getY() - 10, (int) getRotate(), map);
            bullet.setRotate(getRotate() - 90);

        } else if (getRotate() == 180) {
            Bullet bullet = new Bullet(getX() + 15, getY() + 40, (int) getRotate(), map);
            bullet.setRotate(getRotate() - 90);

        } else if (getRotate() == 90) {
            Bullet bullet = new Bullet(getX() + 40, getY() + 15, (int) getRotate(), map);
            bullet.setRotate(getRotate() - 90);

        } else {
            Bullet bullet = new Bullet(getX() - 10, getY() + 15, (int) getRotate(), map);
            bullet.setRotate(getRotate() - 90);

        }


    }
}
