import utils.Players;

public class Ant extends Piece{

    public Ant(int x, int y, Players player) {
        super(x, y, player);
        this.name = "a";
    }

    // TODO
    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        return true;
    }


}
