import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Stack;

public class ClientTank extends TankPlayer {
        private Map map;
        private ImageView tank;
        private Position botPos;
        private int tankHealth = 4;
        private  char direct;
        Stack<Position> positions=new Stack<>();
        private boolean dead;
        public ClientTank(Map map) {
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
            tank = new ImageView(new Image("file:client.png"));
            botPos = positions.pop();
            tank.setX(botPos.getX() * map.getGrid());
            tank.setY(botPos.getY() * map.getGrid());
            tank.setFitWidth(map.getGrid());
            tank.setFitHeight(map.getGrid());
            map.getChildren().add(tank);
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
                if(map.getValueAt(botPos.getY(), botPos.getX()+1)=='0' || map.getValueAt(botPos.getY(), botPos.getX()+1)=='P' ){
                    tank.setImage(new Image("file:client.png"));
                    botPos.setX(botPos.getX()+1);
                    tank.setX(tank.getX() + map.getGrid());

                }
                else if (map.getValueAt(botPos.getY(), botPos.getX()+1)=='T'){
                    botPos.setX(botPos.getX()+1);
                    tank.setX(tank.getX() + map.getGrid());
                    tank.setImage(new Image("file:tree.png"));
                }
            }

        }

        @Override
        public void moveLeft() {
                if (!isDead()){
                    if(map.getValueAt(botPos.getY(), botPos.getX()-1)=='0' ||map.getValueAt(botPos.getY(), botPos.getX()-1)=='P'   ){
                        tank.setImage(new Image("file:client.png"));
                        botPos.setX(botPos.getX()-1);
                        tank.setX(tank.getX() - map.getGrid());


                    }
                    else if (map.getValueAt(botPos.getY(), botPos.getX()-1)=='T'){
                        botPos.setX(botPos.getX()-1);
                        tank.setX(tank.getX() - map.getGrid());
                        tank.setImage(new Image("file:tree.png"));
                    }
                }

        }

        @Override
        public void moveUp() {
               if (!isDead()){
                   if(map.getValueAt(botPos.getY()-1, botPos.getX())=='0' ||  map.getValueAt(botPos.getY()-1, botPos.getX())=='P'){
                       tank.setImage(new Image("file:client.png"));
                       botPos.setY(botPos.getY()-1);
                       tank.setY(tank.getY() - map.getGrid());


                   }

                   else if ( map.getValueAt(botPos.getY()-1, botPos.getX())=='T'){
                       botPos.setY(botPos.getY()-1);
                       tank.setY(tank.getY() - map.getGrid());
                       tank.setImage(new Image("file:tree.png"));
                   }
               }


        }

        @Override
        public void moveDown() {
            if (!isDead()){
                if(map.getValueAt(botPos.getY()+1, botPos.getX())=='0' || map.getValueAt(botPos.getY()+1, botPos.getX())=='P'){
                    tank.setImage(new Image("file:client.png"));
                    botPos.setY(botPos.getY()+1);
                    tank.setY(tank.getY() + map.getGrid());

                }
                else if (map.getValueAt(botPos.getY()+1, botPos.getX())=='T'){
                    botPos.setY(botPos.getY()+1);
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

    @Override
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
