import utils.Players;

public class Beetle extends Piece{


    public Beetle(int x, int y, Players player) {
        super(x, y, player);
        this.name = "b";
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
