import utils.Players;

import java.util.Scanner;

public class Game {
    static Boarder boarder=new Boarder();
    static Player w_player = new Player();
    static Player b_player = new Player();
    static Scanner input = new Scanner(System.in);
    static String piece = "";
    static int x=0, y=0;
    static Piece p;

    public static void main(String[] args) {
        while (!isGameEnded()){
            withePlayerTurn();
        }
    }

    public static void addNewPiece(int i, int j, Piece piece){
        boarder.currentPiece=piece;
        boarder.pieces[i][j]=piece;
    }

    //check if hive gonna get destroy
    public static boolean hiveDestroy(int x, int y){
        // TODO
        if(boarder.pieces[x-2][y]!=null && boarder.pieces[x+2][y]!=null && boarder.pieces[x+1][y+1]!=null
                && boarder.pieces[x-1][y+1]!=null && boarder.pieces[x-1][y-1]!=null && boarder.pieces[x+1][y-1]!=null){
            return false;
        }
        return true;
    }

    //check if new piece is part of a hive
    public static boolean addChecker(int x, int y){
        if(boarder.pieces[x-2][y]==null && boarder.pieces[x+2][y]==null && boarder.pieces[x+1][y+1]==null
                && boarder.pieces[x-1][y+1]==null && boarder.pieces[x-1][y-1]==null && boarder.pieces[x+1][y-1]==null){
            return false;
        }
        return true;
    }

    //check if adding new piece isn't close to enemy pieces
    public static boolean addColorChecker(int x, int y, Players p){
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

    public static void withePlayerTurn(){
        System.out.println("white player turn\n");
        if(w_player.Total_piece==11){
            System.out.println("please choose your piece: ");
            System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider");
            piece = input.next();
        } else if(w_player.Total_piece==0){
            System.out.println("you are ran out of pieces, just move one piece");
        } else if(w_player.Total_piece==8){
            if (w_player.beeCounter == 0){
                System.out.println("please choose your piece: ");
                System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider  6.Move");
                piece = input.next();
            } else {
                System.out.println("you should add Bee");
                piece = "B";
            }
        } else {
            System.out.println("please choose your piece: ");
            System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider  6.Move");
            piece = input.next();
        }

        if(w_player.Total_piece!=11){
            if(piece.equals("m")){
                System.out.println("enter the coordinates of your piece:");
            } else {
                System.out.println("enter the coordinates you want to add yor piece to:");
            }
            x = input.nextInt();
            y = input.nextInt();
        }

        switch (piece){
            case "B":
                if(w_player.beeCounter != 0) {
                    if(w_player.Total_piece==11){
                        addNewPiece(10, 10, new Bee(10, 10, Players.WHITE));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.WHITE)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Bee(x, y, Players.WHITE));
                    }
                    w_player.Total_piece--;
                    w_player.beeCounter = 0;
                }
                break;
            case "a":
                if(w_player.antCounter != 0) {
                    if(w_player.Total_piece==11){
                        addNewPiece(10, 10, new Ant(10, 10, Players.WHITE));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.WHITE)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Ant(x, y, Players.WHITE));
                    }
                    w_player.Total_piece--;
                    w_player.antCounter -= 1;
                }
                break;
            case "b":
                if(w_player.beetleCounter != 0) {
                    if(w_player.Total_piece==11){
                        addNewPiece(10, 10, new Beetle(10, 10, Players.WHITE));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.WHITE)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Beetle(x, y, Players.WHITE));
                    }
                    w_player.Total_piece--;
                    w_player.beetleCounter -= 1;
                }
                break;
            case "l":
                if(w_player.locustCounter != 0) {
                    if(w_player.Total_piece==11){
                        addNewPiece(10, 10, new Locust(10, 10, Players.WHITE));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.WHITE)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Locust(x, y, Players.WHITE));
                    }
                    w_player.Total_piece--;
                    w_player.locustCounter -= 1;
                }
                break;
            case "s":
                if(w_player.spiderCounter != 0) {
                    if(w_player.Total_piece==11){
                        addNewPiece(10, 10, new Spider(10, 10, Players.WHITE));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.WHITE)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Spider(x, y, Players.WHITE));
                    }
                    w_player.Total_piece--;
                    w_player.spiderCounter -= 1;
                }
                break;
            case "m":
                p=boarder.pieces[x][y];

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
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Beetle){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Locust){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Spider){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Ant){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                }
                break;
            default:
                break;
        }
        boarder.printBorder(boarder);
        blackPlayerTurn();

    }

    public static void blackPlayerTurn(){
        System.out.println("black player turn\n");
        if(b_player.Total_piece==11){
            System.out.println("please choose your piece: ");
            System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider");
            piece = input.next();
        } else if(b_player.Total_piece==0){
            System.out.println("you are ran out of pieces, just move one piece");
        } else if(b_player.Total_piece==8){
            if (b_player.beeCounter == 0){
                System.out.println("please choose your piece: ");
                System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider  6.Move");
                piece = input.next();
            } else {
                System.out.println("you should add Bee");
                piece = "B";
            }
        } else {
            System.out.println("please choose your piece: ");
            System.out.println("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider  6.Move");
            piece = input.next();
        }

        if(piece.equals("m")){
            System.out.println("enter the coordinates of your piece:");
        } else {
            System.out.println("enter the coordinates you want to add yor piece to:");
        }
        x = input.nextInt();
        y = input.nextInt();

        switch (piece){
            case "B":
                if(b_player.beeCounter != 0) {
                    if(b_player.Total_piece==11){
                        while (!addChecker(x, y)){
                            System.out.println("you should add your piece next to the hive.\nenter new coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Bee(x, y, Players.BLACK));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.BLACK)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Bee(x, y, Players.BLACK));
                    }
                    b_player.Total_piece--;
                    b_player.beeCounter = 0;
                }
                break;
            case "a":
                if(b_player.antCounter != 0) {
                    if(b_player.Total_piece==11){
                        while (!addChecker(x, y)){
                            System.out.println("you should add your piece next to the hive.\nenter new coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Ant(x, y, Players.BLACK));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.BLACK)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Ant(x, y, Players.BLACK));
                    }
                    b_player.Total_piece--;
                    b_player.antCounter -= 1;
                }
                break;
            case "b":
                if(b_player.beetleCounter != 0) {
                    if(b_player.Total_piece==11){
                        while (!addChecker(x, y)){
                            System.out.println("you should add your piece next to the hive.\nenter new coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Beetle(x, y, Players.BLACK));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.BLACK)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Beetle(x, y, Players.BLACK));
                    }
                    b_player.Total_piece--;
                    b_player.beetleCounter -= 1;
                }
                break;
            case "l":
                if(b_player.locustCounter != 0) {
                    if(b_player.Total_piece==11){
                        while (!addChecker(x, y)){
                            System.out.println("you should add your piece next to the hive.\nenter new coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Locust(x, y, Players.BLACK));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.BLACK)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Locust(x, y, Players.BLACK));
                    }
                    b_player.Total_piece--;
                    b_player.locustCounter -= 1;
                }
                break;
            case "s":
                if(b_player.spiderCounter != 0) {
                    if(b_player.Total_piece==11){
                        while (!addChecker(x, y)){
                            System.out.println("you should add your piece next to the hive.\nenter new coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Spider(x, y, Players.BLACK));
                    } else {
                        while (!addChecker(x, y) || !addColorChecker(x, y, Players.BLACK)){
                            System.out.println("you cant add your piece here.\nchoose another coordinates:");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        addNewPiece(x, y, new Spider(x, y, Players.BLACK));
                    }
                    b_player.Total_piece--;
                    b_player.spiderCounter -= 1;
                }
                break;
            case "m":
                p=boarder.pieces[x][y];

                while (!hiveDestroy(x, y)){
                    System.out.println("you cant move this piece");
                    System.out.println("enter the coordinates of your piece:");
                    x = input.nextInt();
                    y = input.nextInt();
                    p=boarder.pieces[x][y];
                }

                while (p.player != Players.BLACK){
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
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Beetle){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Locust){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Spider){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                } else if(p instanceof Ant){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]==null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }
                    boarder.pieces[x][y]=p;
                }
                break;
            default:
                break;
        }
        boarder.printBorder(boarder);
    }

    public static boolean isGameEnded(){
        return false;
    }
}
