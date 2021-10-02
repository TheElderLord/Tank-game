import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Water extends Wall {
    ImageView image;
    public Water(double x, double y,double width, double height) {
        image=new ImageView(new Image("file:water.png"));
        image.setX(x);
        image.setY(y);
        image.setFitHeight(height);
        image.setFitWidth(width);
        getChildren().add(image);
        setBreakable(false);
        setThrough(false);

    }
}
