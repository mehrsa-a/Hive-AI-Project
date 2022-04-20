import utils.Players;

public class Bee extends Piece{
    public Bee(int x, int y, Players player) {
        super(x, y, player);
        this.name = "B";
    }

    // TODO
    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        return true;
    }

}
