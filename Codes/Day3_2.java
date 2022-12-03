import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Day3_2 {


    public static void main(String[] args) {

        int sum = 0;
        int cont = 1;
        final int CONVERT_LOWERCASE_TO_INT = 96;
        final int CONVERT_UPPERCASE_TO_INT = 58;

        HashSet<Character> hs1 = new HashSet<>();

        try {
            FileReader fr = new FileReader("Puzzle3_input");

            Scanner scan = new Scanner(fr);

            String line = "", secondLine = "", thirdLine = "";

            char common = ' ';

            int value = 0;

            while (scan.hasNextLine()) {

                line = scan.nextLine();

                if (cont == 1) { //if it is the first line out of three
                    for (int i = 0; i < line.length(); i++) {
                        hs1.add(line.charAt(i));
                    }
                } else if (cont == 2) {
                    for (int i = 0; i < line.length(); i++) {
                        secondLine += line.charAt(i);
                    }
                } else {
                    for (int i = 0; i < line.length(); i++) {
                        thirdLine += line.charAt(i);
                    }
                }


                for (int i = 0; i < secondLine.length(); i++) {
                    for(int j = 0; j < thirdLine.length(); j++){

                        if (hs1.contains(secondLine.charAt(i)) && hs1.contains(thirdLine.charAt(j)) && secondLine.charAt(i) == thirdLine.charAt(j)) {
                            common = secondLine.charAt(i);
                            break;
                        }

                    }
                }


                    value = common - CONVERT_LOWERCASE_TO_INT; //getting the integer value of the common char

                    if (value < 0) { //if the common char is uppercase
                        value += CONVERT_UPPERCASE_TO_INT;
                    }


                    //cleaning up the variables
                    if (cont == 3) {
                        sum += value;
                        hs1.clear();
                        secondLine = "";
                        thirdLine = "";
                        cont = 0;
                    }

                    cont++;
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
