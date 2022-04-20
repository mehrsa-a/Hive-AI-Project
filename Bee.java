import utils.Players;

public class Bee extends Piece{
    public Bee(int x, int y, Players player) {
        super(x, y, player);
        this.name = "B";
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
