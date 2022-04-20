import utils.Players;

public class Locust extends Piece {

    public Locust(int x, int y, Players player) {
        super(x, y, player);
        this.name = "l";
    }

    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        while (Game.boarder.pieces[lastX-2][lastY]!=null){
            lastX-=2;
        }
        if(lastX-2==x && lastY==y){
            return true;
        }

        while (Game.boarder.pieces[lastX-1][lastY+1]!=null){
            lastX--;
            lastY++;
        }
        if(lastX-1==x && lastY+1==y){
            return true;
        }

        while (Game.boarder.pieces[lastX+1][lastY+1]!=null){
            lastX++;
            lastY++;
        }
        if(lastX+1==x && lastY+1==y){
            return true;
        }

        while (Game.boarder.pieces[lastX+2][lastY]!=null){
            lastX+=2;
        }
        if(lastX+2==x && lastY==y){
            return true;
        }

        while (Game.boarder.pieces[lastX+1][lastY-1]!=null){
            lastX++;
            lastY--;
        }
        if(lastX+1==x && lastY-1==y){
            return true;
        }

        while (Game.boarder.pieces[lastX-1][lastY-1]!=null){
            lastX--;
            lastY--;
        }
        if(lastX-1==x && lastY-1==y){
            return true;
        }
        return false;
    }

}
