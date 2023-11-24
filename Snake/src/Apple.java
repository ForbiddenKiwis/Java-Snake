import java.util.Random;
public class Apple {
    private  int x;
    private  int y;
    private int mapWidth;
    private int mapHeight;

    // construtor for the apple class
    public Apple(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }
//  Christopher Velasquez-Chavez
    // to get a random XY for the apple position
    public void randomXY(Maze maze,Snake snake){
        Random random= new Random();
        do {
            this.x = random.nextInt(mapWidth - 2) + 1;
            this.y = random.nextInt(mapHeight - 2) + 1;
        } while (checkSnakePos(snake));

        maze.setCell(x,y,'@');
    }
    //Jean Marie Martin Nahayo
    // to print an apple
    public void printFruit(Maze maze){
        maze.setCell(x,y,'@');
    }

    //jerwinson-Flores Cunanan
    // To see if the position of the apple is the same as the head of the snake
    public boolean checkSnakePos(Snake snake){
        if (x == snake.getHeadX() && y == snake.getHeadY()){
            return true;
        }
        for (int i = 0; i < snake.getTailLength(); i++){
            if(x == snake.getTailX()[i] && y == snake.getTailY()[i]){
                return true;
            }
        }
        return false;
    }
    //Jean Marie Martin Nahayo
    public int getX(){
        return x;
    }
    //Jean Marie Martin Nahayo
    public int getY() {
        return y;
    }
}
