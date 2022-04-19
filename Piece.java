import utils.Players;

public abstract class Piece {
    int x;
    int y;
    String ability;
    Players player;
    int[] spaces=new int[7];
    String name = "";

    public Piece(int x, int y){
        this.x=x;
        this.y=y;
        for (int i = 0; i < 7; i++) {
            spaces[i] = 0;
        }
    }

    public abstract void move(int x, int y);
}
