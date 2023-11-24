
public class Snake {

    //jerwinson-Flores Cunanan
    public enum Direction {
        RIGHT, LEFT, UP, DOWN
    }
    private Direction dir;
    private int mapWidth;
    private int mapHeight;
    private int headY;
    private int headX;
    private int tailLength;
    private int[] tailX;
    private int[] tailY;

    public Snake(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tailLength = 11;
        this.tailX = new int[tailLength];
        this.tailY = new int[tailLength];
        dir = Direction.RIGHT;
        startSnake();
    }

// the initial position of the Snake
    public void startSnake() {
        headX = mapWidth / 2;
        headY = mapHeight / 2;


        for (int i = 0; i < tailLength; i++) {
            tailX[i] = headX;
            tailY[i] = headY - i;
        }
    }

    //jerwinson-Flores Cunanan
    // Christopher Velasquez-Chavez
    // we  get the input of the user and then we create the direction of the snake
    public void direction(char direction){
        // Makes sures the direction cannot go the opposite way if your already going one direction
        if ((direction == 'w' && dir == Direction.DOWN) || (direction == 's' && dir == Direction.UP) || (direction == 'a' && dir == Direction.RIGHT) || (direction == 'd' && dir == Direction.LEFT)) {
            return;
        }
        // Set the enum to the Correct direction for the move method
        switch (direction){
            case 'w':
                dir = Direction.UP;
                break;
            case 'a':
                dir = Direction.LEFT;
                break;
            case 's':
                dir = Direction.DOWN;
                break;
            case'd':
                dir = Direction.RIGHT;
                break;
            default:

        }
    }

    //jerwinson-Flores Cunanan
    // Christopher Velasquez-Chavez

// we make the snake move with the input of the user
    public void move() {

        switch (dir){
            case UP:
                headX--;
                break;
            case DOWN:
                headX++;
                break;
            case RIGHT:
                headY++;
                break;
            case LEFT:
                headY--;
                break;
            default:
                break;
        }
        //Tail follow the head
        for (int i=tailLength-1;i>0; i--){
            tailX[i] = tailX[i - 1];
            tailY[i] = tailY[i - 1];
        }
        tailX[0]=headX;
        tailY[0]=headY;
    }
    //jerwinson-Flores Cunanan
    // to grow the snake by one
    public boolean eatApple(Apple apple,Maze maze){
        int appleX = apple.getX();
        int appleY  = apple.getY();

        if (appleX == getHeadX() && appleY == getHeadY()){
            this.tailLength++;

            int[] newTailX = new int[tailLength];
            int[] newTailY = new int[tailLength];

            System.arraycopy(tailX, 0, newTailX, 0, tailLength - 1);
            System.arraycopy(tailY, 0, newTailY, 0, tailLength - 1);

            newTailX[tailLength - 1] = headX;
            newTailY[tailLength - 1] = headY;

            this.tailX = newTailX;
            this.tailY = newTailY;

            return true;
        } else {
            return false;
        }
    }

    // Christopher Velasquez-Chavez
    // to print the head and the tail of snake.
    public void printSnake(Maze maze){
        maze.clearBoard();


        for (int i = 0; i < tailLength; i++) {
            maze.setCell(tailX[i], tailY[i], 'o');
        }
        maze.setCell(headX, headY, 'S');

    }
    //jerwinson-Flores Cunanan
    //  Christopher Velasquez-Chavez
    // It will see when the Snake Collides with itself and the walls
    public boolean collision(Maze maze) {
      //  Maze maze = new Maze(mapWidth, mapHeight);
        for (int i = 1; i < tailLength - 1; i++) {
            if (headX == tailX[i] && headY == tailY[i]) {
                return true;
            } else if (headX == 0 || headX == mapWidth - 1 || headY == 0 || headY == mapHeight - 1) {
                return true;
            } else if (headX == maze.getPositionX() && headY == maze.getPositionY()) {
                return true;
            }
        }
        return false;
    }
    //Jean Marie Martin Nahayo
    public int getHeadX() {
        return headX;
    }
    //Jean Marie Martin Nahayo
    public int getHeadY() {
        return headY;
    }
    //Jean Marie Martin Nahayo
    public int getTailLength() {
        return tailLength;
    }
    //Jean Marie Martin Nahayo
    public int[] getTailX() {
        return tailX;
    }
    //Jean Marie Martin Nahayo
    public int[] getTailY() {
        return tailY;
    }

}
