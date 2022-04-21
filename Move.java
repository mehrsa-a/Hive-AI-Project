import utils.Players;

public class Move {
    // check the hive is closed
    public static boolean isClosedHive(Piece piece){
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if (piece.spaces[i] == 1)
                counter += 1;
        }
        return counter >= 5;
    }

    public static boolean isClosedHive(int x,int y,Boarder boarder){
        Piece hypoPiece = new Bee(x,y, Players.WHITE);
        Game game = new Game();
        game.addNewPiece(x,y,hypoPiece);

        boolean flag = isClosedHive(hypoPiece);
        if (flag){
            game.freeSpaces(x, y);
            return true;
        }
        return false;
    }

    // move for Locust
    public boolean locustMove(Boarder boarder, Piece piece, String direction) {
        int new_X = 0;
        int new_y = 0;
        switch (direction) {
            case "w":
                if (boarder.pieces[piece.x - 2][piece.y] == null) {
                    return false;
                } else {
                    new_X = piece.x - 2;
                    new_y = piece.y;
                    while (boarder.pieces[new_X][new_y] == null) {
                        new_X -= 2;
                    }
                    piece.x = new_X;
                    // change space and free space function todo
                }
                break;
            case "e":
                if (boarder.pieces[piece.x + 2][piece.y] == null) {
                    return false;
                } else {
                    new_X = piece.x + 2;
                    new_y = piece.y;
                    while (boarder.pieces[new_X][new_y] == null) {
                        new_X += 2;
                    }
                    piece.x = new_X;
                    // change space and free space function todo
                }
                break;
            case "se":
                if (boarder.pieces[piece.x + 1][piece.y - 1] == null) {
                    return false;
                } else {
                    new_X = piece.x + 1;
                    new_y = piece.y - 1;
                    while (boarder.pieces[new_X][new_y] == null) {
                        new_X += 1;
                        new_y -= 1;
                    }
                    piece.x = new_X;
                    piece.y = new_y;
                    // change space and free space function todo
                }
                break;
            case "ne":
                if (boarder.pieces[piece.x + 1][piece.y + 1] == null) {
                    return false;
                } else {
                    new_X = piece.x + 1;
                    new_y = piece.y + 1;
                    while (boarder.pieces[new_X][new_y] == null) {
                        new_X += 1;
                        new_y += 1;
                    }
                    piece.x = new_X;
                    piece.y = new_y;
                    // change space and free space function todo
                }
                break;
            case "sw":
                if (boarder.pieces[piece.x - 1][piece.y - 1] == null) {
                    return false;
                } else {
                    new_X = piece.x - 1;
                    new_y = piece.y - 1;
                    while (boarder.pieces[new_X][new_y] == null) {
                        new_X -= 1;
                        new_y -= 1;
                    }
                    piece.x = new_X;
                    piece.y = new_y;
                    // change space and free space function todo
                }
                break;
            case "nw":
                if (boarder.pieces[piece.x - 1][piece.y + 1] == null) {
                    return false;
                } else {
                    new_X = piece.x - 1;
                    new_y = piece.y + 1;
                    while (boarder.pieces[new_X][new_y] == null) {
                        new_X -= 1;
                        new_y += 1;
                    }
                    piece.x = new_X;
                    piece.y = new_y;
                    // change space and free space function todo
                }
                break;
        }
        return true;
    }


    public static boolean hiveDestroy(int x, int y,Piece piece){
        // check simple move //
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if (piece.spaces[i] == 1)
                counter += 1;
        }
        if (counter == 1){
            return true;
        }
        if (counter == 2){
            if(piece.spaces[0] == 1 && (piece.spaces[4] == 1 || piece.spaces[5] == 1)){
                return true;
            } else if(piece.spaces[3] == 1 && (piece.spaces[1] == 1 || piece.spaces[2] == 1)){
                return true;
            } else if (piece.spaces[5] == 1 && piece.spaces[1] == 1 ){
                return true;
            } else if(piece.spaces[2] == 1 && piece.spaces[4] == 1){
                return true;
            }

        }
        if (counter == 3){
            if (piece.spaces[0] == 1 && piece.spaces[4] == 1 && piece.spaces[5] == 1){
                return true;
            }
            if (piece.spaces[3] == 1 && piece.spaces[1] == 1 && piece.spaces[2] == 1){
                return true;
            }
            if (piece.spaces[0] == 1 && piece.spaces[4] == 1 && piece.spaces[2] == 1){
                return true;
            }
            if (piece.spaces[2] == 1 && piece.spaces[4] == 1 && piece.spaces[3] == 1){
                return true;
            }
            if (piece.spaces[3] == 1 && piece.spaces[1] == 1 && piece.spaces[5] == 1){
                return true;
            }
            if(piece.spaces[1] == 1 && piece.spaces[5] == 1 && piece.spaces[0] == 1){
                return true;
            }
        }
        if (counter == 4){
            if (piece.spaces[0] == 1 && piece.spaces[4] == 1 && piece.spaces[3] == 1 && piece.spaces[1] == 1){
                return true;
            } if (piece.spaces[0] == 1 && piece.spaces[5] == 1 && piece.spaces[3] == 1 && piece.spaces[2] == 1){
                return true;
            } else if (piece.spaces[0] == 1 && piece.spaces[5] == 1 && piece.spaces[4] == 1 && piece.spaces[3] == 1)
                return true;
            else if (piece.spaces[0] == 1 && piece.spaces[1] == 1 && piece.spaces[2] == 1 && piece.spaces[3] == 1)
                return true;
            return false;
        }
        return counter <= 4;
    }
}
