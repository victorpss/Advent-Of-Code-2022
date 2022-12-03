import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Day3_1 {


    public static void main(String[] args) {

        int sum = 0;

        HashSet<Character> hs1 = new HashSet<>();

        try{
            FileReader fr = new FileReader("Puzzle3_input");

            Scanner scan = new Scanner(fr);

            String line = "", secondHalf = "";

            char common = ' ';

            int value = 0;

            while (scan.hasNextLine()){

                line = scan.nextLine();

                for (int i = 0; i < line.length()/2 ; i++){
                    hs1.add(line.charAt(i));
                }

                for (int i = line.length()/2; i<line.length(); i++){
                    secondHalf += line.charAt(i);
                }


                for(int i = 0; i<secondHalf.length(); i++){
                    if(hs1.contains(secondHalf.charAt(i))) {
                        common = secondHalf.charAt(i);
                    }
                }

                value = common - 96; //getting the int value of the common char

                if(value < 0){ //if the common char is uppercase
                    value += 58;
                }

                sum += value;

                //cleaning up the variables
                hs1.clear();
                secondHalf = "";
            }

        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        finally {
            System.out.println("Sum of all priorities: " + sum);
        }
    }

}
