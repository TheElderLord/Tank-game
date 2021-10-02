import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Wall extends Pane {
    private boolean isBreakable;
    private ImageView image;
    private int life;
    public Wall(double x,double y,String s,double width,double height) {

        image=new ImageView(new Image(s));
        image.setX(x);
        image.setY(y);
        image.setFitHeight(height);
        image.setFitWidth(width);
        getChildren().add(image);
    }



    public void setBreakable(boolean breakable) {
        isBreakable = breakable;
    }
}
