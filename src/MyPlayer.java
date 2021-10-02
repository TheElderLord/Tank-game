public class MyPlayer implements Player {
    private Map map;
    private Position position;
    public MyPlayer(Map map)  {
        this.map=map;
        for (int i = 0; i <map.getSize() ; i++) {
            for (int j = 0; j <map.getSize() ; j++) {
                if (map.getMap()[i][j]=='P'){
                    position=new Position(j,i);
                }
            }
        }
        map.requestFocus();

    }

    public MyPlayer() {
    }


    @Override
    public void setMap(Map map) {

    }

    @Override
    public void moveRight() {
        if(map.getValueAt(position.getY(),position.getX()+1)!=1 ){

            position.setX(position.getX()+1);

        }
    }

    @Override
    public void moveLeft() {
        if(map.getValueAt(position.getY(),position.getX()-1)!=1){

            position.setX(position.getX()-1);


        }else
            System.out.println("Invalid Position");
    }



    @Override
    public void moveUp() {
        if(map.getValueAt(position.getY()-1,position.getX())!=1){

            position.setY(position.getY() - 1);

        }else
            System.out.println("Invalid Position");
    }




    @Override
    public void moveDown() {
        if(map.getValueAt(position.getY()+1,position.getX())!=1){

            position.setY(position.getY() + 1);

        }else
            System.out.println("Invalid Position");
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
