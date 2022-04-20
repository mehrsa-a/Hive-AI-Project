import utils.Players;

public class Boarder {
    Piece[][] pieces=new Piece[28][48];
    static int col = 12;
    static int row = 24;
    Piece currentPiece = null;
    static String s="";
    //white pieces have a * beside their name
    /*if there were an extra beetle in one coordinate, if that was white we add a + before the piece name
    and if that was black we add a - before the piece name*/
    public Boarder() {
        for (int i = 0; i < col; i++) {
            System.out.print(" ");
            for (int j = 0; j < row; j++) {
                System.out.print("/ \\ ");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < row; j++) {
                if(pieces[i*2][j]!=null){
                    currentPiece =  pieces [i*2][j];
                } else {
                    currentPiece = new Bee(i*2, j, Players.WHITE);
                    currentPiece.name=" ";
                }
                System.out.printf(" %s |", currentPiece.name);
            }
            System.out.println();
            System.out.print(" ");
            for (int j = 0; j < row; j++) {
                System.out.print("\\ / ");
            }
            System.out.println();
            System.out.print("  |");

            for(int j = 0; j < row-1; j++){
                if(pieces[i*2+1][j]!=null){
                    currentPiece =  pieces [i*2+1][j];
                } else {
                    currentPiece = new Bee(i*2+1, j, Players.WHITE);
                    currentPiece.name=" ";
                }
                System.out.printf(" %s |", currentPiece.name);
            }
            System.out.println();
        }
    }

    public void printBorder(Boarder boarder){
        for (int i = 0; i < col; i++) {
            System.out.print(" ");
            for (int j = 0; j < row; j++) {
                System.out.print("/ \\ ");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < row; j++) {
                if(boarder.pieces[i*2][j*2]!=null){
                    currentPiece =  boarder.pieces [i*2][j*2];
                    if(currentPiece.isExtraBeetleHere){
                        if(currentPiece.extraBeetle.player==Players.WHITE){
                            s+="+";
                        } else {
                            s+="-";
                        }
                    } else {
                        s+=" ";
                    }
                    s+= currentPiece.name;
                    if(currentPiece.player==Players.WHITE){
                        s+="*";
                    } else {
                        s+=" ";
                    }
                } else {
                    currentPiece = new Bee(i*2, j*2, Players.WHITE);
                    currentPiece.name=" ";
                    s+="   ";
                }
                System.out.printf("%s|", s);
                s="";
            }
            System.out.println();
            System.out.print(" ");
            for (int j = 0; j < row; j++) {
                System.out.print("\\ / ");
            }
            System.out.println();
            System.out.print("  |");

            for(int j = 0; j < row-1; j++){
                if(pieces[i*2+1][j*2+1]!=null){
                    currentPiece =  boarder.pieces [i*2+1][j*2+1];
                    if(currentPiece.isExtraBeetleHere){
                        if(currentPiece.extraBeetle.player==Players.WHITE){
                            s+="+";
                        } else {
                            s+="-";
                        }
                    } else {
                        s+=" ";
                    }
                    s+= currentPiece.name;
                    if(currentPiece.player==Players.WHITE){
                        s+="*";
                    } else {
                        s+=" ";
                    }
                } else {
                    currentPiece = new Bee(i*2, j*2, Players.WHITE);
                    currentPiece.name=" ";
                    s+="   ";
                }
                System.out.printf("%s|", s);
                s="";
            }
            System.out.println();
        }
    }
}
