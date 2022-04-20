import utils.Players;

public class Locust extends Piece {

    public Locust(int x, int y, Players player) {
        super(x, y, player);
        this.name = "l";
    }

    // TODO
    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        return true;
    }

}
