import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;


public class Map extends Pane {
    private char[][] map;
    private int size;
    private double grid = 50;
    private ImageView image;
    private Wall wall;
    static ArrayList<Brick> bricks= new ArrayList<>();
    public Map(String s) throws InvalidMapException, FileNotFoundException {
        Scanner scan = new Scanner(new File(s));
        size = scan.nextInt();

        if(size == 0){
            throw new InvalidMapException("Map size can not be zero");
        }
        map = new char[size][size];

        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = scan.next().charAt(0);
                }
            }
        }
        catch (Exception e){
            throw new InvalidMapException("Invalid map");
        }
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j <size ; j++) {
                Rectangle rectangle =new Rectangle(j * getGrid(),i * getGrid(), getGrid(), getGrid());
                getChildren().addAll(rectangle);
                if (getValueAt(i, j) == 'B'){
                    Brick wall = new Brick(j * getGrid(),i * getGrid(), getGrid(), getGrid(),this);
                    bricks.add(wall);

                }

                else if (getValueAt(i, j)  =='W'){
                    wall = new Water(j * getGrid(),i * getGrid(),"file:water.png", getGrid(), getGrid());
                    wall.setBreakable(false);
                    getChildren().add(wall);

                }

                else if (getValueAt(i, j)  == 'S'){
                    wall = new Steel(j * getGrid(),i * getGrid(),"file:steel.png", getGrid(), getGrid());
                    wall.setBreakable(false);
                    getChildren().add(wall);

                }

                else if (getValueAt(i, j)  == 'T'){
                    wall = new Tree(j * getGrid(),i * getGrid(),"file:tree.png", getGrid(), getGrid());
                    wall.setBreakable(false);
                    getChildren().add(wall);

                }
                else if (getValueAt(i, j)  =='0'  || getValueAt(i, j) =='P'){
                    image = new ImageView(new Image("file:way.png"));
                    image.setX(j * getGrid());
                    image.setY(i * getGrid());
                    image.setFitHeight(getGrid());
                    image.setFitWidth(getGrid());
                    getChildren().add(image);
                }


            }
        }
    }

    public int getSize() {
        return size;
    }

    public double getGrid() {
        return grid;
    }

    public char getValueAt(int i, int j){

        return map[i][j];
    }

    public void print(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Brick> getBricks() {
        return bricks;
    }

    public char[][] getMap() {
        return map;
    }
    public void setValue(int i, int j){
        map[i][j] = 0;
    }
    public void delBrick(int x,int y){
        map[x][y]='0';
    }
}


