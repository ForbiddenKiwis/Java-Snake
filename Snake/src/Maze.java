import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
// Christopher Velasquez-Chavez
public class Maze {
    private int counter = 10;
    private List<int[]> walls;
    private final int mazeWidth;
    private final int mazeHeight;
    private Apple apple;
   // private int nbWalls = 3;

    private int positionX;
    private int positionY;
    private char[][] board;

// Christopher Velasquez-Chavez
    // the construtor for the maze
    public Maze(int width, int height) {
        this.mazeWidth = width;
        this.mazeHeight = height;
        this.board = new char[width][height];
        apple = new Apple(mazeWidth, mazeHeight);
        walls = new ArrayList<>();
        initializeMaze();
    }

// to initialize the maze and printing them
    private void initializeMaze() {
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeHeight; j++) {
                if (i == 0 || i == mazeWidth - 1 || j == 0 || j == mazeHeight - 1) {
                    board[i][j] = '#';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 1000; ++i) System.out.println();
        for (int i = 0; i < mazeWidth; i++) {
            for (int j = 0; j < mazeHeight; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("\r");
        }

    }

//    public void randomXYWalls( ){
//        Random random= new Random();
//        for (int i = 0; i < nbWalls; i++){
//            do {
//                this.positionX = random.nextInt(mazeWidth - 2) + 1;
//                this.positionY = random.nextInt(mazeHeight - 2) + 1;
//            } while (checkSnakePos()||checkApplePos());
//
//            walls.add(new int[]{positionX, positionY});
//            setCell(positionX,positionY,'x');
//        }
//
//    }

    public void printWalls(){
        for (int[] wall : walls) {
            setCell(wall[0], wall[1], 'x');
        }
    }

    public boolean checkSnakePos() {
        Snake snake = new Snake(mazeWidth,mazeHeight);
        if (positionX == snake.getHeadX() && positionY == snake.getHeadY()) {
            return true;
        }
        for (int i = 0; i < snake.getTailLength(); i++) {
            if (positionX == snake.getTailX()[i] && positionY == snake.getTailY()[i]) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkApplePos() {
//        if (positionX == apple.getX() && positionY == apple.getY()){
//            return true;
//        }
//        return false;
//    }

    public void clearBoard() {
        for (int i = 1; i < mazeWidth - 1; i++) {
            for (int j = 1; j < mazeHeight - 1; j++) {
                board[i][j] = ' ';
            }
        }
    }

// we set the specify cell to an input like a border, snake head or even the apple
    public void setCell(int x, int y, char value) {
        board[x][y] = value;
    }
    //Jean Marie Martin Nahayo
    public int getPositionX() {
        return positionX;
    }
    //Jean Marie Martin Nahayo
    public int getPositionY() {
        return positionY;
    }
}
