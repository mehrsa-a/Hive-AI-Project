public class Boarder {
    Piece[][] pieces=new Piece[22][22];
    static int col = 10;
    static int row = 11;
    Piece currentPiece = null;
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
                    currentPiece = new Bee(i*2, j);
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
                    currentPiece = new Bee(i*2+1, j);
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
                } else {
                    currentPiece = new Bee(i*2, j*2);
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
                if(pieces[i*2+1][j*2+1]!=null){
                    currentPiece =  boarder.pieces [i*2+1][j*2+1];
                } else {
                    currentPiece = new Bee(i*2, j*2);
                    currentPiece.name=" ";
                }
                System.out.printf(" %s |", currentPiece.name);
            }
            System.out.println();
        }
    }
}
