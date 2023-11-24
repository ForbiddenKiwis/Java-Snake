import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        int difficulty = 1000;

        boolean playAgain = true;

        byte inputs = 1;
        boolean validInputs = true;
        //Jean Marie Martin Nahayo
        // Christopher Velasquez-Chavez
        //jerwinson-Flores Cunanan
        // choose the difficulty of the game!
        do {
            System.out.println("Which difficulty do you want to play\n1. Easy\n2. Medium\n3. Hard\n4. Impossible");
            try {

                inputs = scanner.nextByte();
                if (inputs == 1 || inputs == 2 || inputs == 3 || inputs == 4) {
                    validInputs = true;
                    switch (inputs) {
                        case 1:
                            difficulty = 1000;
                            break;
                        case 2:
                            difficulty = 500;
                            break;
                        case 3:
                            difficulty = 250;
                            break;
                        case 4:
                            difficulty = 1;
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Invalid difficulty or input choose \n1. Easy\n2. Medium\n3. Hard\n4. Impossible");
                    validInputs = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid difficulty or input choose \n1. Easy\n2. Medium\n3. Hard\n4. Impossible");
            }
        } while (!validInputs);


        boolean gameOver = false;

        Maze maze = new Maze(15, 30);
        Snake snake = new Snake(15, 30);
        Apple apple = new Apple(15, 30);

        apple.randomXY(maze, snake);

        //jerwinson-Flores Cunanan
        //Thread for the change Direction
        boolean eatApp = false;

        boolean finalGameOver = gameOver;

        Thread snakeDirection = new Thread(() -> {
            while (!finalGameOver) {
                char input = scanner.next().charAt(0);
                snake.direction(input);

            }
        });
        //Jerwinson-Flores Cunanan
        //Thread for when the snake move
        int finalDifficulty = difficulty;
        Thread snakeMove = new Thread(() -> {

            while (true) {
                if (snake.collision(maze)) {
                    System.out.println("You lose\nScore:" + (snake.getTailLength() - 11) + "\nThanks for playing!\n\nCreator: Jerwinson-Flores Cunanan\n\t\t Erfan Omidi\n\t\t Chirstopher Velasquez-Chavez\n\t\t Jean-Marie Martin Nahayo");
                    break;
                } else {
                    snake.move();
                    snake.printSnake(maze);
                    if (snake.eatApple(apple, maze)) {
                        apple.randomXY(maze, snake);
                    }

                    apple.printFruit(maze);
                 //   if (snake.getTailLength() - 11 == 1){
                  //      maze.randomXYWalls();
                   // }
                    maze.printWalls();
                    maze.printBoard();
                    System.out.println("\t\t\t\t\t\tScore: " + (snake.getTailLength() - 11));
                    try {
                        Thread.sleep(finalDifficulty);
                    } catch (InterruptedException e) {
                        System.out.println("You lose\nScore:" + (snake.getTailLength() - 11) + "\nThanks for playing!\nCreator: Jerwinson-Flores Cunanan\nErfan Omidi\nChirstopher Velasquez-Chavez\nJean-Marie Martin Nahayo");
                        break;

                    }
                }
            }
        });
        snakeDirection.start();
        snakeMove.start();
    }
}


