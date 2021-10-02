import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends Pane {
    int width;
    int height;
    int size;
    private Tank tank;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Map(int size) throws FileNotFoundException {
        this.size = size;

        String PATH = "map.txt";
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);

        ArrayList<String[]> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line.split(" "));
        }

        width = list.get(0).length;
        height = list.size();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (list.get(i)[j].equals("P")) {
                    tank = new Tank(size,j * size, i * size, this);
                } else {
                    getChildren().add(new Block(size, j * size, i * size, list.get(i)[j]));
                }
            }
        }
    }

    public Tank getTank() {
        return tank;
    }

}
