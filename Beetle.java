public class Beetle extends Piece{


    public Beetle(int x, int y) {
        super(x, y);
        this.name = "b";
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
