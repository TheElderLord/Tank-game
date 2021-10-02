public class Position{
    private int x;
    private int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Position p){
        if(p.getX() == getX() && p.getY() == getY())
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
}













