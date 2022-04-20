import utils.Players;
import utils.SpaceStates;

public class Spider extends Piece{

    public Spider(int x, int y, Players player) {
        super(x, y, player);
        this.name = "s";
    }


    @Override
    public boolean isCoordinateAvailable(int lastX, int lastY, int x, int y) {
        Coordinate[] firstNeighbors=new Coordinate(lastX, lastY).getNeighborsStates(lastX, lastY);
        for(int i=0; i<6; i++){
            if(firstNeighbors[i].spaceStates==SpaceStates.NULL){
                Coordinate[] secondNeighbors=new Coordinate(lastX, lastY).getNeighborsStates(firstNeighbors[i].x, firstNeighbors[i].y);
                for(int j=0; j<6; j++){
                    if(secondNeighbors[j].spaceStates==SpaceStates.NULL){
                        Coordinate[] thirdNeighbors=new Coordinate(lastX, lastY).getNeighborsStates(secondNeighbors[j].x, secondNeighbors[j].y);
                        for(int k=0; k<6; k++){
                            if(thirdNeighbors[k].spaceStates==SpaceStates.NULL){
                                if(thirdNeighbors[k].x==x && thirdNeighbors[k].y==y){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }


}
