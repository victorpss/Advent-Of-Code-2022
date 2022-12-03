import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2_1 {

    static class Scores{

        public static int getScore(Character c){

            if (c.equals('A') || c.equals('X')){ // ROCK
                return 1;
            }
            if (c.equals('B') || c.equals('Y')){ // PAPER
                return 2;
            }
            if (c.equals('C') || c.equals('Z')){ // SCISSORS
                return 3;
            }

            return 0;
        }
    }


    public static void main(String[] args) {

        int myScore = 0;

        try{
            FileReader fr = new FileReader("Puzzle2_input");
            Scanner scan = new Scanner(fr);

            final int DEFEAT_SCORE = 0;
            final int DRAW_SCORE = 3;
            final int WIN_SCORE = 6;

            String line = null;

            while(scan.hasNextLine()){
                line = scan.nextLine();

                char enemyShape = line.charAt(0);
                char myShape = line.charAt(2);


                if(Scores.getScore(enemyShape) == Scores.getScore(myShape)){ //DRAW
                    myScore += DRAW_SCORE + Scores.getScore(myShape);
                }
                else if (Scores.getScore(myShape) - Scores.getScore(enemyShape) == 1 || Scores.getScore(myShape) - Scores.getScore(enemyShape) == -2){ //IF I WON THE ROUND
                    myScore += WIN_SCORE + Scores.getScore(myShape);
                }
                else{ //IF I LOST
                    myScore += DEFEAT_SCORE + Scores.getScore(myShape);
                }

            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch (NullPointerException e){
            System.out.println("Null pointer error.");
        }
        finally {
            System.out.println("Total Score: " + myScore);
        }
    }
}
