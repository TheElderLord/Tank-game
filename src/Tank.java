import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Tank extends MyPlayer {
    private ImageView tank;
    private Map map;
    private Position position;
    private Bullet bullet;
    public Tank(Map map) {
        position=map.getStartPoint();
        this.map=map;
        bullet = new Bullet(map);
        tank= new ImageView(new Image("file:tank.png"));
        tank.setX(position.getX()*map.getPixSize());
        tank.setY(position.getY()*map.getPixSize());
        tank.setFitWidth(map.getPixSize());
        tank.setFitHeight(map.getPixSize());
        map.getChildren().add(bullet);
        map.getChildren().add(tank);
        map.setOnKeyPressed(e->{
            try {
                switch (e.getCode()){
                    case UP:
                    tank.setRotate(90);
                    bullet.setDirection('U');
                    moveUp();break;

                    case DOWN:tank.setRotate(270);
                    bullet.setDirection('D');
                    moveDown();break;

                    case LEFT:
                    tank.setRotate(0);
                    bullet.setDirection('L');
                    moveLeft();break;

                    case RIGHT:
                    tank.setRotate(180);
                    bullet.setDirection('R');
                    moveRight();break;

                    case SPACE:
                    bullet.addbul(position.getX()*map.getPixSize()+map.getPixSize()/2, position.getY()*map.getPixSize()+map.getPixSize()/2,map.getPixSize()/4);
                    bullet.play();break;
                }
            }catch (Exception ex){

            }
        });
    }


    @Override
    public void moveRight() {

        if(map.getValueAt(position.getY(), position.getX()+1)=='0'  ){
            position.setX(position.getX()+1);
            tank.setX(tank.getX() + map.getPixSize());
            tank.setImage(new Image("file:tank.png"));
        }
        else if (map.getValueAt(position.getY(), position.getX()+1)=='T'){
            position.setX(position.getX()+1);
            tank.setX(tank.getX() + map.getPixSize());
            tank.setImage(new Image("file:tree.png"));
        }
        else if (map.getValueAt(position.getY(), position.getX()+1)=='P'){
            position.setX(position.getX()+1);
            tank.setX(tank.getX() + map.getPixSize());
            tank.setImage(new Image("file:tank.png"));
        }

    }

    @Override
    public void moveLeft() {

        if(map.getValueAt(position.getY(), position.getX()-1)=='0' ){
                 position.setX(position.getX()-1);
                tank.setX(tank.getX() - map.getPixSize());
            tank.setImage(new Image("file:tank.png"));

        }
        else if (map.getValueAt(position.getY(), position.getX()-1)=='T'){
            position.setX(position.getX()-1);
            tank.setX(tank.getX() - map.getPixSize());
            tank.setImage(new Image("file:tree.png"));
        }
        else if (map.getValueAt(position.getY(), position.getX()-1)=='P'){
            position.setX(position.getX()-1);
            tank.setX(tank.getX() - map.getPixSize());
            tank.setImage(new Image("file:tank.png"));
        }
    }

    @Override
    public void moveUp() {

        if(map.getValueAt(position.getY()-1, position.getX())=='0' ){
            position.setY(position.getY()-1);
                tank.setY(tank.getY() - map.getPixSize());
            tank.setImage(new Image("file:tank.png"));

        }

        else if ( map.getValueAt(position.getY()-1, position.getX())=='T'){
            position.setY(position.getY()-1);
            tank.setY(tank.getY() - map.getPixSize());
            tank.setImage(new Image("file:tree.png"));
        }
        else if (map.getValueAt(position.getY()-1, position.getX())=='P'){
            position.setY(position.getY()-1);
            tank.setY(tank.getY() - map.getPixSize());
            tank.setImage(new Image("file:tank.png"));
        }

    }

    @Override
    public void moveDown() {

        if(map.getValueAt(position.getY()+1, position.getX())=='0' ){
            position.setY(position.getY()+1);
                tank.setY(tank.getY() + map.getPixSize());
            tank.setImage(new Image("file:tank.png"));
        }
        else if (map.getValueAt(position.getY()+1, position.getX())=='T'){
            position.setY(position.getY()+1);
            tank.setY(tank.getY() + map.getPixSize());
            tank.setImage(new Image("file:tree.png"));
        }
        else if (map.getValueAt(position.getY()+1, position.getX())=='P'){
            position.setY(position.getY()+1);
            tank.setY(tank.getY() + map.getPixSize());
            tank.setImage(new Image("file:tank.png"));
        }
    }
}
