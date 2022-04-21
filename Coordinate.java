import utils.SpaceStates;

import java.util.Objects;

public class Coordinate {
    int x;
    int y;
    SpaceStates spaceStates;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(){

    }

    public Coordinate[] getNeighborsStates(int x, int y){
        Coordinate[] coordinates=new Coordinate[6];

        for(int i=0; i<6; i++){
            coordinates[i]=new Coordinate();
        }

        if(Game.boarder.pieces[x-2][y]==null){
            coordinates[0].x=x-2;
            coordinates[0].y=y;
            coordinates[0].spaceStates=SpaceStates.NULL;
        } else {
            coordinates[0].x=x-2;
            coordinates[0].y=y;
            coordinates[0].spaceStates=SpaceStates.NOTNULL;
        }

        if(Game.boarder.pieces[x+2][y]==null){
            coordinates[1].x=x+2;
            coordinates[1].y=y;
            coordinates[1].spaceStates=SpaceStates.NULL;
        } else {
            coordinates[1].x=x+2;
            coordinates[1].y=y;
            coordinates[1].spaceStates=SpaceStates.NOTNULL;
        }

        if(Game.boarder.pieces[x+1][y+1]==null){
            coordinates[2].x=x+1;
            coordinates[2].y=y+1;
            coordinates[2].spaceStates=SpaceStates.NULL;
        } else {
            coordinates[2].x=x+1;
            coordinates[2].y=y+1;
            coordinates[2].spaceStates=SpaceStates.NOTNULL;
        }

        if(Game.boarder.pieces[x-1][y+1]==null){
            coordinates[3].x=x-1;
            coordinates[3].y=y+1;
            coordinates[3].spaceStates=SpaceStates.NULL;
        } else {
            coordinates[3].x=x-1;
            coordinates[3].y=y+1;
            coordinates[3].spaceStates=SpaceStates.NOTNULL;
        }

        if(Game.boarder.pieces[x-1][y-1]==null){
            coordinates[4].x=x-1;
            coordinates[4].y=y-1;
            coordinates[4].spaceStates=SpaceStates.NULL;
        } else {
            coordinates[4].x=x-1;
            coordinates[4].y=y-1;
            coordinates[4].spaceStates=SpaceStates.NOTNULL;
        }

        if(Game.boarder.pieces[x+1][y-1]==null){
            coordinates[5].x=x+1;
            coordinates[5].y=y-1;
            coordinates[5].spaceStates=SpaceStates.NULL;
        } else {
            coordinates[5].x=x+1;
            coordinates[5].y=y-1;
            coordinates[5].spaceStates=SpaceStates.NULL;
        }

        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        Coordinate c= (Coordinate) o;
        if(this.x==c.x && this.y==c.y){
            return true;
        }
        return false;
    }

}
