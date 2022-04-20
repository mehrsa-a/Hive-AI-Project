import utils.Players;

public class Beetle extends Piece{


    public Beetle(int x, int y, Players player) {
        super(x, y, player);
        this.name = "b";
    }

    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        if(lastX-2==x && lastY==y){
            return true;
        }

        if(lastX-1==x && lastY+1==y){
            return true;
        }

        if(lastX+1==x && lastY+1==y){
            return true;
        }

        if(lastX+2==x && lastY==y){
            return true;
        }

        if(lastX+1==x && lastY-1==y){
            return true;
        }

        if(lastX-1==x && lastY-1==y){
            return true;
        }

        return false;
    }
}
