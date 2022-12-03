import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day2_2 {

    static class Scores{

        public static int getScore(Character c){

            if (c.equals('A')){ // ROCK
                return 1;
            }
            if (c.equals('B')){ // PAPER
                return 2;
            }
            if (c.equals('C')){ // SCISSORS
                return 3;
            }

            return 0;
        }
    }

    static class VictoryScores{

        public static int getScore(Character c){

            if (c.equals('A')){ // HE PLAYED ROCK, I PLAYED PAPER
                return 2;
            }
            if (c.equals('B')){ // HE PLAYED PAPER, I PLAYED SCISSORS
                return 3;
            }
            if (c.equals('C')){ // HE PLAYED SCISSORS, I PLAYED ROCK
                return 1;
            }

            return 0;
        }
    }

    static class DefeatScores{

        public static int getScore(Character c){

            if (c.equals('A')){ // HE PLAYED ROCK, I PLAYED SCISSORS
                return 3;
            }
            if (c.equals('B')){ // HE PLAYED PAPER, I ROCK
                return 1;
            }
            if (c.equals('C')){ // HE PLAYED SCISSORS, I PLAYED PAPER
                return 2;
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
                char myDecision = line.charAt(2);


                if(myDecision == 'Y'){ //DRAW
                    myScore += DRAW_SCORE + Scores.getScore(enemyShape);
                    System.out.println(myScore + " primeiro");
                }
                else if (myDecision == 'Z'){ //IF I WON THE ROUND
                    myScore += WIN_SCORE + VictoryScores.getScore(enemyShape);
                    System.out.println(myScore + " segundo");
                }
                else{ //IF I LOST
                    myScore += DEFEAT_SCORE + DefeatScores.getScore(enemyShape);
                    System.out.println(myScore + " terceiro");
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
