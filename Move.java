public class Move {
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
}
