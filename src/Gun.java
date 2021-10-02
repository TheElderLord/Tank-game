import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

public class Gun  {
    private Timeline motion;
    private int x,y;
    private Map map;
    private TankPlayer tank;
    private ImageView bullet;
    public Gun(Map map,TankPlayer tank) {
        this.map=map;
        this.tank = tank;
        this.x = (int)(tank.getX()/map.getGrid());
        this.y= (int) (tank.getY()/map.getGrid());
        bullet=new ImageView("file:bullet.png");
        bullet.setFitWidth(map.getGrid()/4);
        bullet.setFitHeight(map.getGrid()/4);
        bullet.setX(tank.getX()+20 );
        bullet.setY(tank.getY() + 20);
        motion = new Timeline(new KeyFrame(Duration.millis(100), e -> fire()));
        motion.setCycleCount(Timeline.INDEFINITE);

        motion.play();
        map.getChildren().add(bullet);


    }

    public void disapear(){
        motion.jumpTo(Duration.ZERO);
        motion.stop();
        bullet.setVisible(false);
    }
    public void play() {
        motion.play();
    }



    protected synchronized void fire(){
        if (tank.getDirect() == 'U') {
            bullet.setRotate(90);

            if(!(y == 0) && !(map.getValueAt(y-1, x) == 'S'
                    || map.getValueAt(y-1, x) == 'B')){
                bullet.setY(bullet.getY() - map.getGrid());
                y--;
                for (TankPlayer tank: Game.getTanks()) {
                    if (tank.getX()/map.getGrid()==x && tank.getY()/map.getGrid()==y){
                        tank.hit();
                        if (tank.getName().equals("Client")){
                            System.out.println("Client HP:"+tank.getTankHealth());
                        }
                         else if (tank.getName().equals("Bot")){
                            System.out.println("Bot HP:"+tank.getTankHealth());
                        }
                        else
                            System.out.println("Player HP:"+tank.getTankHealth());
                        if (tank.getTankHealth()==0){
                            tank.getTank().setVisible(false);
                            tank.setDead(true);
                            map.getChildren().remove(tank);
                        }
                        disapear();
                    }
                }
            }
            else if (!(y == 0)   &&map.getValueAt(y-1, x) == 'B' ){
                ArrayList<Brick> bricks = Map.getBricks();
                for (int i = 0; i <bricks.size() ; i++) {
                    if (x==(int)(bricks.get(i).getX()/map.getGrid()) &&y-1==(int)(bricks.get(i).getY()/map.getGrid()) ){
                        bricks.get(i).decrase();
                        if (bricks.get(i).getHp()==0){
                            bricks.get(i).getBrick().setVisible(false);
                            map.delBrick(y-1,x);
                        }
                        disapear();
                    }
                }
            }

            else {
                disapear();
            }

        } else if (tank.getDirect() == 'D') {
            bullet.setRotate(270);
            if(y + 1 < map.getSize() && !(map.getValueAt(y+1, x) == 'S'
                    || map.getValueAt(y+1, x) == 'B')){
                bullet.setY(bullet.getY() + map.getGrid());
                ++y;
                for (TankPlayer tank: Game.getTanks()) {
                    if (tank.getX()/map.getGrid()==x && tank.getY()/map.getGrid()==y){
                       tank.hit();
                       if (tank.getName().equals("Client")){
                           System.out.println("Client HP:"+tank.getTankHealth());
                       }
                         else if (tank.getName().equals("Bot")){
                           System.out.println("Bot HP:"+tank.getTankHealth());
                       }
                       else
                           System.out.println("Player HP:"+tank.getTankHealth());
                        if (tank.getTankHealth()==0){
                            tank.getTank().setVisible(false);
                            tank.setDead(true);
                            map.getChildren().remove(tank);
                        }
                        disapear();
                    }
                }
            }

            else if (y+1  < map.getSize() &&map.getValueAt(y+1, x) == 'B' ){
                ArrayList<Brick> bricks = Map.getBricks();
                for (int i = 0; i <bricks.size() ; i++) {
                    if (x==(int)(bricks.get(i).getX()/map.getGrid()) &&y+1==(int)(bricks.get(i).getY()/map.getGrid()) ){
                        bricks.get(i).decrase();
                        if (bricks.get(i).getHp()==0){
                            bricks.get(i).getBrick().setVisible(false);
                            map.delBrick(y+1,x);
                        }
                        disapear();
                    }
                }
            }
            else {
                disapear();
            }


        } else if (tank.getDirect() == 'L') {
            bullet.setRotate(0);
            if(!(x == 0)  && !(map.getValueAt(y, x-1) == 'S'
                    || map.getValueAt(y, x-1) == 'B')){
                bullet.setX(bullet.getX() - map.getGrid());
                x--;
                for (TankPlayer tank: Game.getTanks()) {
                    if (tank.getX()/map.getGrid()==x && tank.getY()/map.getGrid()==y){
                        tank.hit();
                        if (tank.getName().equals("Client")){
                            System.out.println("Client HP:"+tank.getTankHealth());
                        }
                         else if (tank.getName().equals("Bot")){
                            System.out.println("Bot HP:"+tank.getTankHealth());
                        }
                        else
                            System.out.println("Player HP:"+tank.getTankHealth());
                        if (tank.getTankHealth()==0){
                            tank.getTank().setVisible(false);
                            tank.setDead(true);
                            map.getChildren().remove(tank);
                        }
                        disapear();
                    }
                }
            }
            else if (!(x == 0)   &&map.getValueAt(y, x-1) == 'B' ){
                ArrayList<Brick> bricks = Map.getBricks();
                for (int i = 0; i <bricks.size() ; i++) {
                    if (x-1==(int)(bricks.get(i).getX()/map.getGrid()) &&y==(int)(bricks.get(i).getY()/map.getGrid()) ){
                        bricks.get(i).decrase();
                        if (bricks.get(i).getHp()==0){
                            bricks.get(i).getBrick().setVisible(false);
                            map.delBrick(y,x-1);
                        }
                        disapear();
                    }
                }
            }

            else{
                disapear();
            }

        } else if (tank.getDirect() == 'R') {
            bullet.setRotate(180);
            if(x + 1 < map.getSize() && !(map.getValueAt(y, x+1) == 'S'
                    || map.getValueAt(y, x+1) == 'B')){
                bullet.setX(bullet.getX() + map.getGrid());
                ++x;
                for (TankPlayer tank: Game.getTanks()) {
                    if (tank.getX()/map.getGrid()==x && tank.getY()/map.getGrid()==y){
                       tank.hit();
                        if (tank.getName().equals("Client")){
                            System.out.println("Client HP:"+tank.getTankHealth());
                        }
                        else if (tank.getName().equals("Bot")){
                            System.out.println("Bot HP:"+tank.getTankHealth());
                        }
                        else
                            System.out.println("Player HP:"+tank.getTankHealth());
                       if (tank.getTankHealth()==0){
                           tank.getTank().setVisible(false);
                           tank.setDead(true);
                           map.getChildren().remove(tank);
                       }
                       disapear();
                    }
                }
            }
            else if (x+1  < map.getSize() &&map.getValueAt(y, x+1) == 'B' ){
                ArrayList<Brick> bricks = Map.getBricks();
                for (int i = 0; i <bricks.size() ; i++) {
                    if (x+1==(int)(bricks.get(i).getX()/map.getGrid()) &&y==(int)(bricks.get(i).getY()/map.getGrid()) ){
                        bricks.get(i).decrase();
                        if (bricks.get(i).getHp()==0){
                            bricks.get(i).getBrick().setVisible(false);
                            map.delBrick(y,x+1);
                        }
                        disapear();
                    }
                }
            }


            else{
                disapear();
            }

        }
    }


}
