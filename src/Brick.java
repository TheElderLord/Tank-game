import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Brick extends Wall {
    private ImageView image;
    public Brick(double x, double y, double width, double height) {
        image=new ImageView(new Image("file:brick-wall.png"));
        image.setX(x);
        image.setY(y);
        image.setFitHeight(height);
        image.setFitWidth(width);
        getChildren().add(image);
        setBreakable(true);
        setThrough(false);


    }
}
