import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Wall extends Pane {
    private boolean breakable;
    private boolean through;
    public Wall() {
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public boolean isThrough() {
        return through;
    }

    public void setThrough(boolean through) {
        this.through = through;
    }
}
