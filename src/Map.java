import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane {
    private int size;
    private char[][] map;
    private double pixSize =30;
    private Wall wall;
    private ImageView image;
    private Position startPoint;
    public Map(String s) throws FileNotFoundException {
        Scanner input = new Scanner(new File(s));
        size = input.nextInt();
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = input.next().charAt(0);
                }
            }

        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (map[i][j]=='B'){
                    wall = new Brick(j* getPixSize(),i* getPixSize(), getPixSize(), getPixSize());
                    getChildren().add(wall);

                }
                else if (map[i][j]=='S'){
                    wall=new Steel(j* getPixSize(),i* getPixSize(), getPixSize(), getPixSize());

                    getChildren().add(wall);

                }
                else if (map[i][j]=='W'){
                    wall=new Water(j* getPixSize(),i* getPixSize(), getPixSize(), getPixSize());
                    getChildren().add(wall);

                }
                else if (map[i][j]=='T'){
                    wall=new Tree(j* getPixSize(),i* getPixSize(), getPixSize(), getPixSize());
                    getChildren().add(wall);

                }
                else if (map[i][j]=='0'  ){
                    image = new ImageView(new Image("file:way.png"));
                    image.setX(j* getPixSize());
                    image.setY(i* getPixSize());
                    image.setFitHeight(getPixSize());
                    image.setFitWidth(getPixSize());
                    getChildren().add(image);
                }
                else if (map[i][j]=='P'){
                    image = new ImageView(new Image("file:way.png"));
                    image.setX(j* getPixSize());
                    image.setY(i* getPixSize());
                    image.setFitHeight(getPixSize());
                    image.setFitWidth(getPixSize());
                    getChildren().add(image);
                    startPoint=new Position(j,i);
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public double getPixSize() {
        return pixSize;
    }

    public char getValueAt(int i, int j){

        return map[i][j];
    }
    public char[][] getMap() {
        return map;
    }

    public Position getStartPoint() {
        return startPoint;
    }
}
