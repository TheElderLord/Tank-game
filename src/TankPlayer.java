import javafx.scene.input.KeyCode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Stack;


public class TankPlayer extends MyPlayer {
    private Map map;
    private ImageView tank;
    private Position tankPosition;
    private int tankHealth = 4;
    private  char direct;
    private boolean dead;
    private Position botPos;
    private String name;
    Stack<Position> positions=new Stack<>();
    public TankPlayer(Map map) {
        for (int i = 0; i <map.getSize() ; i++) {
            for (int j = 0; j <map.getSize() ; j++) {
                if (map.getMap()[i][j]=='P'){
                    tankPosition = new Position(j,i);
                }
            }
        }
        this.map = map;
        tank = new ImageView(new Image("file:tank1.png"));
        tank.setX(tankPosition.getX() * map.getGrid());
        tank.setY(tankPosition.getY() * map.getGrid());
        tank.setFitWidth(map.getGrid());
        tank.setFitHeight(map.getGrid());
        map.getChildren().add(tank);

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void  addPlayer(Map map){
        for (int i = 0; i <map.getSize() ; i++) {
            for (int j = 0; j <map.getSize() ; j++) {
                if (map.getMap()[i][j]=='0'){
                    positions.push(new Position(j,i));
                }
            }
        }
        this.map = map;
        tank = new ImageView(new Image("file:client.png"));
        botPos = positions.pop();
        tank.setX(botPos.getX() * map.getGrid());
        tank.setY(botPos.getY() * map.getGrid());
        tank.setFitWidth(map.getGrid());
        tank.setFitHeight(map.getGrid());
        map.getChildren().add(tank);
    }

    public TankPlayer() {
    }

    public void DirRot(double a){
        tank.setRotate(a);
    }

    public char getDirect() {
        return direct;
    }

    public void setDirect(char direct) {
        this.direct = direct;
    }

    public void setX(double x){
        tank.setX(x);
    }
    public void setY(double y){
        tank.setY(y);
    }
    public double getX(){
        return tank.getX();
    }
    public double getY(){
        return tank.getY();
    }
    public int getTankHealth() {
        return tankHealth;
    }

    @Override
    public void moveRight() {
        if (!isDead()){
            if(map.getValueAt(tankPosition.getY(), tankPosition.getX()+1)=='0' || map.getValueAt(tankPosition.getY(), tankPosition.getX()+1)=='P' ){
                tankPosition.setX(tankPosition.getX()+1);
                tank.setX(tank.getX() + map.getGrid());
                tank.setImage(new Image("file:tank1.png"));
            }
            else if (map.getValueAt(tankPosition.getY(), tankPosition.getX()+1)=='T'){
                tankPosition.setX(tankPosition.getX()+1);
                tank.setX(tank.getX() + map.getGrid());
                tank.setImage(new Image("file:tree.png"));
            }
        }


    }

    @Override
    public void moveLeft() {
        if (!isDead()){
            if(map.getValueAt(tankPosition.getY(), tankPosition.getX()-1)=='0' ||map.getValueAt(tankPosition.getY(), tankPosition.getX()-1)=='P'   ){
                tankPosition.setX(tankPosition.getX()-1);
                tank.setX(tank.getX() - map.getGrid());
                tank.setImage(new Image("file:tank1.png"));

            }
            else if (map.getValueAt(tankPosition.getY(), tankPosition.getX()-1)=='T'){
                tankPosition.setX(tankPosition.getX()-1);
                tank.setX(tank.getX() - map.getGrid());
                tank.setImage(new Image("file:tree.png"));
            }
        }


    }

    @Override
    public void moveUp() {
          if (!isDead()){
              if(map.getValueAt(tankPosition.getY()-1, tankPosition.getX())=='0' ||  map.getValueAt(tankPosition.getY()-1, tankPosition.getX())=='P'){
                  tankPosition.setY(tankPosition.getY()-1);
                  tank.setY(tank.getY() - map.getGrid());
                  tank.setImage(new Image("file:tank1.png"));

              }

              else if ( map.getValueAt(tankPosition.getY()-1, tankPosition.getX())=='T'){
                  tankPosition.setY(tankPosition.getY()-1);
                  tank.setY(tank.getY() - map.getGrid());
                  tank.setImage(new Image("file:tree.png"));
              }
          }


    }

    @Override
    public void moveDown() {
         if (!isDead()){
             if(map.getValueAt(tankPosition.getY()+1, tankPosition.getX())=='0' || map.getValueAt(tankPosition.getY()+1, tankPosition.getX())=='P'){
                 tankPosition.setY(tankPosition.getY()+1);
                 tank.setY(tank.getY() + map.getGrid());
                 tank.setImage(new Image("file:tank1.png"));
             }
             else if (map.getValueAt(tankPosition.getY()+1, tankPosition.getX())=='T'){
                 tankPosition.setY(tankPosition.getY()+1);
                 tank.setY(tank.getY() + map.getGrid());
                 tank.setImage(new Image("file:tree.png"));
             }
         }

    }
    public void shoot(){
        if (!isDead()){
            new Gun(map,this);
        }


    }

    public ImageView getTank() {
        return tank;
    }
    public  void  hit(){
        tankHealth--;
    }
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
