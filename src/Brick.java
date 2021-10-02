import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Brick  {
    private int hp=4;
    private double x,y;
    ImageView brick=new ImageView(new Image("file:brick.png"));
    public Brick(double x, double y, double width, double height,Map map) {
        this.x=x;
        this.y=y;
        brick.setX(x);
        brick.setY(y);
        brick.setFitWidth(height);
        brick.setFitHeight(width);
        map.getChildren().add(brick);
    }

    public void decrase(){
        --hp;
    }

    public int getHp() {
        return hp;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ImageView getBrick() {
        return brick;
    }

    public void setBrick(ImageView brick) {
        this.brick = brick;
    }
}
