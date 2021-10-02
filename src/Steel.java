import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Steel extends Wall {
    private ImageView image;
    public Steel(double x, double y, double width, double height) {
        image=new ImageView(new Image("file:steel-wall.png"));
        image.setX(x);
        image.setY(y);
        image.setFitHeight(height);
        image.setFitWidth(width);
        getChildren().add(image);
        setBreakable(false);
        setThrough(false);

    }
}
