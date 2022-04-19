import utils.Players;

import java.util.Scanner;

public class Game {
    static Boarder boarder=new Boarder();

    public static boolean firstMove(Piece piece){
        /*if(i%2==0 && j%2==1){
            Boarder.currentPiece = null;
            return false;
        } else if(i%2==1 && j%2==0){
            Boarder.currentPiece = null;
            return false;
        }*/
        boarder.currentPiece=piece;
        boarder.pieces[10][10]=piece;
        return true;
    }

    public static void main(String[] args) {
        Player w_player = new Player();
        Player b_player = new Player();
        Scanner input = new Scanner(System.in);

        String piece = "";
        System.out.println("please choose your piece: ");
        System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider  6.Move");
        if(w_player.Total_piece ==8){
            if (w_player.beeCounter == 0) {
                 piece = input.next();
            } else {
                piece = "B";
            }
        } else {
             piece = input.next();
        }

        int x=0, y=0;
        if(w_player.Total_piece!=11){
            System.out.println("enter the coordinates of your piece:");
            x = input.nextInt();
            y = input.nextInt();
        }

        switch (piece){
            case "B":
                if(w_player.beeCounter != 0) {
                    if(w_player.Total_piece==11){
                        firstMove(new Bee(10, 10));
                    } else {
                        if(addChecker(x, y)){

                        }
                    }
                    w_player.Total_piece--;
                    w_player.beeCounter = 0;
                }
                break;
            case "a":
                if(w_player.antCounter != 0) {
                    if(w_player.Total_piece==11){
                        firstMove(new Ant(10, 10));
                    }
                    w_player.Total_piece--;
                    w_player.antCounter -= 1;
                }
                break;
            case "b":
                if(w_player.beetleCounter != 0) {
                    if(w_player.Total_piece==11){
                        firstMove(new Beetle(10, 10));
                    }
                    w_player.Total_piece--;
                    w_player.beetleCounter -= 1;
                }
                break;
            case "l":
                if(w_player.locustCounter != 0) {
                    if(w_player.Total_piece==11){
                        firstMove(new Locust(10, 10));
                    }
                    w_player.Total_piece--;
                    w_player.locustCounter -= 1;
                }
                break;
            case "s":
                if(w_player.spiderCounter != 0) {
                    if(w_player.Total_piece==11){
                        firstMove(new Spider(10, 10));
                    }
                    w_player.Total_piece--;
                    w_player.spiderCounter -= 1;
                }
                break;
            case "Move":
                System.out.println("enter the coordinates of your piece:");
                x = input.nextInt();
                y = input.nextInt();
                Piece p=boarder.pieces[x][y];
                while (!hiveDestroy(x, y)){
                    System.out.println("you cant move this piece");
                    System.out.println("enter the coordinates of your piece:");
                    x = input.nextInt();
                    y = input.nextInt();
                    p=boarder.pieces[x][y];
                }
                while (p.player != Players.WHITE){
                    System.out.println("this coordinate doesnt belong to your pieces.\n" +
                            "enter new coordinates:");
                    x = input.nextInt();
                    y = input.nextInt();
                    p=boarder.pieces[x][y];
                }

                if(p instanceof Bee){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        if(moveChecker(x, y, Players.WHITE)) {
                            boarder.pieces[x][y] = p;
                        }
                    }
                } else if(p instanceof Beetle){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        if(moveChecker(x, y, Players.WHITE)) {
                            boarder.pieces[x][y] = p;
                        }
                    }
                } else if(p instanceof Locust){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        if(moveChecker(x, y, Players.WHITE)) {
                            boarder.pieces[x][y] = p;
                        }
                    }
                } else if(p instanceof Spider){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        if(moveChecker(x, y, Players.WHITE)) {
                            boarder.pieces[x][y] = p;
                        }
                    }
                } else if(p instanceof Ant){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        if(moveChecker(x, y, Players.WHITE)) {
                            boarder.pieces[x][y] = p;
                        }
                    }
                }
            default:
                break;
        }
        boarder.printBorder(boarder);
    }

    public static boolean hiveDestroy(int x, int y){
        if(boarder.pieces[x-2][y]!=null && boarder.pieces[x+2][y]!=null && boarder.pieces[x+1][y+1]!=null
                && boarder.pieces[x-1][y+1]!=null && boarder.pieces[x-1][y-1]!=null && boarder.pieces[x+1][y-1]!=null){
            return false;
        }
        return true;
    }

    public static boolean addChecker(int x, int y){
        if(boarder.pieces[x-2][y]!=null && boarder.pieces[x+2][y]!=null && boarder.pieces[x+1][y+1]!=null
                && boarder.pieces[x-1][y+1]!=null && boarder.pieces[x-1][y-1]!=null && boarder.pieces[x+1][y-1]!=null){
            return false;
        }
        return true;
    }

    public static boolean moveChecker(int x, int y, Players p){
        if(p==Players.WHITE){
            if(boarder.pieces[x-2][y]!=null){
                if(boarder.pieces[x-2][y].player==Players.BLACK){
                    return false;
                }
            }
            if(boarder.pieces[x+2][y]!=null){
                if(boarder.pieces[x+2][y].player==Players.BLACK){
                    return false;
                }
            }
            if(boarder.pieces[x+1][y+1]!=null){
                if(boarder.pieces[x+1][y+1].player==Players.BLACK){
                    return false;
                }
            }
            if(boarder.pieces[x-1][y+1]!=null){
                if(boarder.pieces[x-1][y+1].player==Players.BLACK){
                    return false;
                }
            }
            if(boarder.pieces[x-1][y-1]!=null){
                if(boarder.pieces[x-1][y-1].player==Players.BLACK){
                    return false;
                }
            }
            if(boarder.pieces[x+1][y-1]!=null){
                if(boarder.pieces[x+1][y-1].player==Players.BLACK){
                    return false;
                }
            }
        } else {
            if(boarder.pieces[x-2][y]!=null){
                if(boarder.pieces[x-2][y].player==Players.WHITE){
                    return false;
                }
            }
            if(boarder.pieces[x+2][y]!=null){
                if(boarder.pieces[x+2][y].player==Players.WHITE){
                    return false;
                }
            }
            if(boarder.pieces[x+1][y+1]!=null){
                if(boarder.pieces[x+1][y+1].player==Players.WHITE){
                    return false;
                }
            }
            if(boarder.pieces[x-1][y+1]!=null){
                if(boarder.pieces[x-1][y+1].player==Players.WHITE){
                    return false;
                }
            }
            if(boarder.pieces[x-1][y-1]!=null){
                if(boarder.pieces[x-1][y-1].player==Players.WHITE){
                    return false;
                }
            }
            if(boarder.pieces[x+1][y-1]!=null){
                if(boarder.pieces[x+1][y-1].player==Players.WHITE){
                    return false;
                }
            }
        }
        return true;
    }
}
