import utils.Players;

import java.util.Scanner;

public class Game {
    static Boarder boarder=new Boarder();
    static Player w_player = new Player();
    static Player b_player = new Player();
    static Scanner input = new Scanner(System.in);
    static String piece = "";
    static int x=0, y=0;
    static int lastX=0, lastY=0;
    static Piece p;

    public static void main(String[] args) {
        while (!isGameEnded()){
            whitePlayerTurn();
        }
    }

    public static void whitePlayerTurn(){
        System.out.println("white player turn\n");
        if(w_player.Total_piece>=9){
            System.out.println("please choose your piece: ");
            System.out.print("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider");
            if(w_player.beeCounter != 0){
                System.out.println("\nyou cant move pieces before adding Bee");
            } else {
                System.out.println("  6.Move");
            }
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
                if(boarder.pieces[x][y].isExtraBeetleHere){
                    if(boarder.pieces[x][y].extraBeetle.player!=Players.WHITE){
                        System.out.println("you cant move this piece because there is a beetle on it");
                    } else {
                        p=boarder.pieces[x][y].extraBeetle;
                        boarder.pieces[x][y].isExtraBeetleHere=false;
                    }
                } else {
                    p=boarder.pieces[x][y];
                }


                while (!hiveDestroy(x, y)){
                    System.out.println("you cant move this piece");
                    System.out.println("enter the coordinates of your piece:");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y].isExtraBeetleHere){
                        if(boarder.pieces[x][y].extraBeetle.player!=Players.WHITE){
                            System.out.println("you cant move this piece because there is a beetle on it");
                        } else {
                            p=boarder.pieces[x][y].extraBeetle;
                            boarder.pieces[x][y].isExtraBeetleHere=false;
                        }
                    } else {
                        p=boarder.pieces[x][y];
                    }
                }

                while (p.player != Players.WHITE){
                    System.out.println("this coordinate doesnt belong to your pieces.\n" +
                            "enter new coordinates:");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y].isExtraBeetleHere){
                        if(boarder.pieces[x][y].extraBeetle.player!=Players.WHITE){
                            System.out.println("you cant move this piece because there is a beetle on it");
                        } else {
                            p=boarder.pieces[x][y].extraBeetle;
                            boarder.pieces[x][y].isExtraBeetleHere=false;
                        }
                    } else {
                        p=boarder.pieces[x][y];
                    }
                }

                freeSpaces(x, y);
                boarder.pieces[x][y]=null;
                lastX=x;
                lastY=y;

                if(p instanceof Bee){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!isSliding(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);

                } else if(p instanceof Beetle){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                            System.out.println("this coordinate is not available\nenter new coordinates: ");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        boarder.pieces[x][y].isExtraBeetleHere=true;
                        boarder.pieces[x][y].extraBeetle=(Beetle) p;
                        boarder.pieces[x][y].extraBeetle.move(x, y);
                    } else {
                        boarder.pieces[x][y]=p;
                        boarder.pieces[x][y].move(x, y);
                    }
                } else if(p instanceof Locust){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);

                } else if(p instanceof Spider){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!isSliding(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);

                } else if(p instanceof Ant){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!isSliding(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);

                }
                break;
            default:
                break;
        }
        boarder.printBorder(boarder);
        if(!isGameEnded()){
            blackPlayerTurn();
        }
    }

    public static void blackPlayerTurn(){
        System.out.println("black player turn\n");
        if(b_player.Total_piece>=9){
            System.out.println("please choose your piece: ");
            System.out.print("1.Bee  2.Ant  3.Beetle  4.Locust  5.Spider");
            if(b_player.beeCounter != 0){
                System.out.println("\nyou cant move pieces before adding Bee");
            } else {
                System.out.println("  6.Move");
            }
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
                if(boarder.pieces[x][y].isExtraBeetleHere){
                    if(boarder.pieces[x][y].extraBeetle.player!=Players.BLACK){
                        System.out.println("you cant move this piece because there is a beetle on it");
                    } else {
                        p=boarder.pieces[x][y].extraBeetle;
                        boarder.pieces[x][y].isExtraBeetleHere=false;
                    }
                } else {
                    p=boarder.pieces[x][y];
                }

                while (!hiveDestroy(x, y)){
                    System.out.println("you cant move this piece");
                    System.out.println("enter the coordinates of your piece:");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y].isExtraBeetleHere){
                        if(boarder.pieces[x][y].extraBeetle.player!=Players.BLACK){
                            System.out.println("you cant move this piece because there is a beetle on it");
                        } else {
                            p=boarder.pieces[x][y].extraBeetle;
                            boarder.pieces[x][y].isExtraBeetleHere=false;
                        }
                    } else {
                        p=boarder.pieces[x][y];
                    }
                }

                while (p.player != Players.BLACK){
                    System.out.println("this coordinate doesnt belong to your pieces.\n" +
                            "enter new coordinates:");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y].isExtraBeetleHere){
                        if(boarder.pieces[x][y].extraBeetle.player!=Players.BLACK){
                            System.out.println("you cant move this piece because there is a beetle on it");
                        } else {
                            p=boarder.pieces[x][y].extraBeetle;
                            boarder.pieces[x][y].isExtraBeetleHere=false;
                        }
                    } else {
                        p=boarder.pieces[x][y];
                    }
                }

                freeSpaces(x, y);
                boarder.pieces[x][y]=null;
                lastX=x;
                lastY=y;

                if(p instanceof Bee){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!isSliding(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);
                } else if(p instanceof Beetle){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    if(boarder.pieces[x][y]!=null){
                        while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                            System.out.println("this coordinate is not available\nenter new coordinates: ");
                            x = input.nextInt();
                            y = input.nextInt();
                        }
                        boarder.pieces[x][y].isExtraBeetleHere=true;
                        boarder.pieces[x][y].extraBeetle=(Beetle) p;
                        boarder.pieces[x][y].extraBeetle.move(x, y);
                    } else {
                        boarder.pieces[x][y]=p;
                        boarder.pieces[x][y].move(x, y);
                    }
                } else if(p instanceof Locust){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);
                } else if(p instanceof Spider){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!isSliding(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);
                } else if(p instanceof Ant){
                    System.out.println("enter new coordinates: ");
                    x = input.nextInt();
                    y = input.nextInt();
                    while (boarder.pieces[x][y]!=null){
                        System.out.println("this coordinate belongs to another piece.\nenter new coordinates:");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!p.isCoordinateAvailable(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    while (!isSliding(lastX, lastY, x, y)){
                        System.out.println("this coordinate is not available\nenter new coordinates: ");
                        x = input.nextInt();
                        y = input.nextInt();
                    }

                    boarder.pieces[x][y]=p;
                    boarder.pieces[x][y].move(x, y);
                }
                break;
            default:
                break;
        }
        boarder.printBorder(boarder);
    }

    public static void addNewPiece(int i, int j, Piece piece){
        boarder.currentPiece=piece;
        boarder.pieces[i][j]=piece;
        changeSpacesCondition(i, j);
    }

    //check if hive gonna get destroy bu movement
    // TODO
    public static boolean hiveDestroy(int x, int y){
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

    public static void changeSpacesCondition(int x, int y){
        if(boarder.pieces[x-2][y]!=null){
            boarder.pieces[x][y].spaces[0]=1;
            boarder.pieces[x-2][y].spaces[3]=1;
        }
        if(boarder.pieces[x+2][y]!=null){
            boarder.pieces[x][y].spaces[3]=1;
            boarder.pieces[x+2][y].spaces[0]=1;
        }
        if(boarder.pieces[x+1][y+1]!=null){
            boarder.pieces[x][y].spaces[2]=1;
            boarder.pieces[x+1][y+1].spaces[5]=1;
        }
        if(boarder.pieces[x-1][y+1]!=null){
            boarder.pieces[x][y].spaces[1]=1;
            boarder.pieces[x-1][y+1].spaces[4]=1;
        }
        if(boarder.pieces[x-1][y-1]!=null){
            boarder.pieces[x][y].spaces[5]=1;
            boarder.pieces[x-1][y-1].spaces[2]=1;
        }
        if(boarder.pieces[x+1][y-1]!=null){
            boarder.pieces[x][y].spaces[4]=1;
            boarder.pieces[x+1][y-1].spaces[1]=1;
        }
    }

    public static void freeSpaces(int x, int y){
        if(boarder.pieces[x-2][y]!=null){
            boarder.pieces[x][y].spaces[0]=0;
            boarder.pieces[x-2][y].spaces[3]=0;
        }
        if(boarder.pieces[x+2][y]!=null){
            boarder.pieces[x][y].spaces[3]=0;
            boarder.pieces[x+2][y].spaces[0]=0;
        }
        if(boarder.pieces[x+1][y+1]!=null){
            boarder.pieces[x][y].spaces[2]=0;
            boarder.pieces[x+1][y+1].spaces[5]=0;
        }
        if(boarder.pieces[x-1][y+1]!=null){
            boarder.pieces[x][y].spaces[1]=0;
            boarder.pieces[x-1][y+1].spaces[4]=0;
        }
        if(boarder.pieces[x-1][y-1]!=null){
            boarder.pieces[x][y].spaces[5]=0;
            boarder.pieces[x-1][y-1].spaces[2]=0;
        }
        if(boarder.pieces[x+1][y-1]!=null){
            boarder.pieces[x][y].spaces[4]=0;
            boarder.pieces[x+1][y-1].spaces[1]=0;
        }
    }

    public static boolean isGameEnded(){
        Bee w_bee=new Bee(0, 0, Players.WHITE), b_bee=new Bee(0, 0, Players.BLACK);
        boolean w_existence=false, b_existence=false;
        if(b_player.beeCounter!=0 || w_player.beeCounter!=0){
            return false;
        }
        for(int i=0; i<Boarder.col; i++){
            for(int j=0; j<Boarder.row; j++){
                if(boarder.pieces[i][j] instanceof Bee){
                    if(boarder.pieces[i][j].player==Players.WHITE){
                        w_bee=(Bee) boarder.pieces[i][j];
                        w_existence=true;
                    } else {
                        b_bee=(Bee) boarder.pieces[i][j];
                        b_existence=true;
                    }
                }
            }
        }

        boolean w_flag=false;
        boolean b_flag=false;
        if(w_existence){
            for(int i=0; i<6; i++){
                if(w_bee.spaces[i]==0){
                    // pass
                }
            }
            w_flag=true; // white won

        }
        if(b_existence){
            for(int i=0; i<6; i++){
                if(b_bee.spaces[i]==0){
                    //pass
                }
            }
            b_flag=true; //black won
        }

        if(w_flag && b_flag){
            System.out.println("****game ended equal****");
            return true;
        }
        if(w_flag){
            System.out.println("****white player won****");
            return true;
        }
        if(b_flag){
            System.out.println("****black player won****");
            return true;
        }
        return false;
    }

    // TODO
    public static boolean isSliding(int i, int j, int x, int y){
        return true;
    }
}
