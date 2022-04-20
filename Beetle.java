import utils.Players;

public class Beetle extends Piece{


    public Beetle(int x, int y, Players player) {
        super(x, y, player);
        this.name = "b";
    }

    // TODO
    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        return true;
    }
}
