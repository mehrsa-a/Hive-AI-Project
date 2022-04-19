import utils.Players;

public abstract class Piece {
    int x;
    int y;
    String ability;
    Players player;
    //0 : north //1 : north-east //2 : south-east //3 : south //4 : south-west //5 : north-west //6 : if beetle covers the piece
    // x-2, y  // x-1, y+1      // x+1, y+1      // x+2, y   // x+1, y-1      // x-1, y-1      // x, y
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
