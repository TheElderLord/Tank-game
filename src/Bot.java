import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;


public class Bot extends TankPlayer implements Player,Runnable {
    private Map map;
    private ImageView tank;
    private Position botPos;
    private int tankHealth = 4;
    private  char direct;
    private boolean dead=false;
    Stack<Position> positions=new Stack<>();
    private String name;
    public Bot(Map map) {
        for (int i = 0; i <map.getSize() ; i++) {
            for (int j = 0; j <map.getSize() ; j++) {
                if (map.getMap()[i][j]=='0'){
                    positions.push(new Position(j,i));
                }
            }
        }
        this.map = map;
    }
    public  void  addPlayer(){
        tank = new ImageView(new Image("file:bot.png"));
        botPos = positions.pop();
        tank.setX(botPos.getX() * map.getGrid());
        tank.setY(botPos.getY() * map.getGrid());
        tank.setFitWidth(map.getGrid());
        tank.setFitHeight(map.getGrid());
        map.getChildren().add(tank);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public  char getDirect() {
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

        if(map.getValueAt(botPos.getY(), botPos.getX()+1)=='0' || map.getValueAt(botPos.getY(), botPos.getX()+1)=='P' ){
            botPos.setX(botPos.getX()+1);
            tank.setX(tank.getX() + map.getGrid());
            tank.setImage(new Image("file:bot.png"));
        }
        else if (map.getValueAt(botPos.getY(), botPos.getX()+1)=='T'){
            botPos.setX(botPos.getX()+1);
            tank.setX(tank.getX() + map.getGrid());
            tank.setImage(new Image("file:tree.png"));
        }
    }

    @Override
    public void moveLeft() {

        if(map.getValueAt(botPos.getY(), botPos.getX()-1)=='0' ||map.getValueAt(botPos.getY(), botPos.getX()-1)=='P'   ){
            botPos.setX(botPos.getX()-1);
            tank.setX(tank.getX() - map.getGrid());
            tank.setImage(new Image("file:bot.png"));

        }
        else if (map.getValueAt(botPos.getY(), botPos.getX()-1)=='T'){
            botPos.setX(botPos.getX()-1);
            tank.setX(tank.getX() - map.getGrid());
            tank.setImage(new Image("file:tree.png"));
        }
    }

    @Override
    public void moveUp() {

        if(map.getValueAt(botPos.getY()-1, botPos.getX())=='0' ||  map.getValueAt(botPos.getY()-1, botPos.getX())=='P'){
            botPos.setY(botPos.getY()-1);
            tank.setY(tank.getY() - map.getGrid());
            tank.setImage(new Image("file:bot.png"));

        }

        else if ( map.getValueAt(botPos.getY()-1, botPos.getX())=='T'){
            botPos.setY(botPos.getY()-1);
            tank.setY(tank.getY() - map.getGrid());
            tank.setImage(new Image("file:tree.png"));
        }

    }

    @Override
    public void moveDown() {

        if(map.getValueAt(botPos.getY()+1, botPos.getX())=='0' || map.getValueAt(botPos.getY()+1, botPos.getX())=='P'){
            botPos.setY(botPos.getY()+1);
            tank.setY(tank.getY() + map.getGrid());
            tank.setImage(new Image("file:bot.png"));
        }
        else if (map.getValueAt(botPos.getY()+1, botPos.getX())=='T'){
            botPos.setY(botPos.getY()+1);
            tank.setY(tank.getY() + map.getGrid());
            tank.setImage(new Image("file:tree.png"));
        }
    }
    public void shoot(){
        new Gun(map,this);

    }

    @Override
    public void run() {
        ArrayList<Character> moves = new ArrayList<>();
        moves.add('L');
        moves.add('R');
        moves.add('D');
        moves.add('U');
        moves.add('S');
try {


        while (!isDead()){
            Collections.shuffle(moves);

        Platform.runLater(()->{
            switch (moves.get(0)){
                case 'L':try {
                    setDirect('L');
                    tank.setRotate(0);
                    moveLeft();
                }catch (Exception e){

                } break;
                case 'R':
                    try {
                        setDirect('R');
                        tank.setRotate(180);
                        moveRight();
                    }catch (Exception e){

                    }
                    break;
                case 'U':
                    try {
                        setDirect('U');
                        tank.setRotate(90);
                        moveUp();

                    }catch (Exception e){

                    }break;
                case 'D':
                    try {
                        setDirect('D');
                        tank.setRotate(270);
                        moveDown();


                    }catch (Exception e){

                    }break;
                case 'S':
                   shoot();


            }
        });
        Thread.sleep(300);

        }}catch (Exception e){
           e.printStackTrace();
        }
    }
    public  void  hit(){
        tankHealth--;
    }

    @Override
    public ImageView getTank() {
        return tank;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
