public interface Player {
    public abstract void setMap(Map m);

    public abstract void moveRight();

    public abstract void moveLeft();

    public abstract void moveDown();

    public abstract void moveUp();

    public abstract Position getPosition();
}
