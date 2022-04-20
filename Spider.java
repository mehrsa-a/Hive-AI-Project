import utils.Players;

public class Spider extends Piece{

    public Spider(int x, int y, Players player) {
        super(x, y, player);
        this.name = "s";
    }

    // TODO
    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        return true;
    }


}
