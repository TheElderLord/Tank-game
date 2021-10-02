import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Bullet extends Pane {
    private Timeline motion;
    private int speed=60;
    private char direction;
    private Map map;
    public Bullet(Map map) {
        this.map=map;
        motion = new Timeline(
                new KeyFrame(Duration.millis(speed), e -> shootBullet()));
        motion.setCycleCount(Timeline.INDEFINITE);
    }
    public void addbul(double x, double y, double radius){
        getChildren().add(new BulletCircle(x,y,radius));
    }
    public void play() {
        motion.play();
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    protected void shootBullet(){
        for (Node node:this.getChildren()) {
            BulletCircle ball = (BulletCircle) node;
            switch (getDirection()){
                case 'U':
                    if (ball.getCenterY() - map.getPixSize() < 0) {
                            getChildren().remove(ball);
                        }

                        else {
                            ball.setCenterY(ball.getCenterY() - map.getPixSize());
                        }
                        break;

                case 'D':
                if (ball.getCenterY() + map.getPixSize() > map.getHeight())
                    getChildren().remove(ball);
                else {
                    ball.setCenterY(ball.getCenterY() + map.getPixSize());

                }
                    break;
                case 'L':
                if (ball.getCenterX() - map.getPixSize() < 0)
                    getChildren().remove(ball);
                else {
                    ball.setCenterX(ball.getCenterX() - map.getPixSize());
                } break;
                case 'R':
                    if (ball.getCenterX() + map.getPixSize() > map.getWidth())

                           getChildren().remove(ball);
                   else {
                       ball.setCenterX(ball.getCenterX() + map.getPixSize());
                   }break;

            }
        }
    }
}
class BulletCircle extends Circle{


    public BulletCircle(double v, double v1, double v2) {
        super(v, v1, v2);
    }


}
