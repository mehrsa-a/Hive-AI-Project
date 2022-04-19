import utils.Players;

public abstract class Piece {
    int x;
    int y;
    String ability;
    Players player;
    int[] spaces=new int[7];
    String name = "";

    public Piece(int x, int y, Players player){
        this.x=x;
        this.y=y;
        for (int i = 0; i < 7; i++) {
            spaces[i] = 0;
        }
        this.player=player;
    }

    public abstract void move(int x, int y);
}
