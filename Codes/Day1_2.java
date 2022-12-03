import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Day1_2 {

    public static void main(String[] args) {

        int major = 0;

        ArrayList<Integer> elfs = new ArrayList<>();

        try {
            FileReader fr = new FileReader("Puzzle1_input");

            Scanner scan = new Scanner(fr);

            int actual = 0, sum = 0;
            String line = null;

            while(scan.hasNext()){
                line = scan.nextLine();

                if(line.equals("")){ //if line is empty, reset variable sum
                    sum=0;
                }

                else {
                    actual = Integer.parseInt(line);
                    sum += actual;

                    if(sum>major){
                        major = sum;
                    }

                    elfs.add(sum);
                }
            }

            Collections.sort(elfs, Collections.reverseOrder());

        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        finally {
            int podiumSum = 0;
            for (int i = 0; i<3; i++){
                System.out.println(i+1 + " - " + elfs.get(i));
                podiumSum += elfs.get(i);
            }

            System.out.println("\nSum: " + podiumSum);
        }

    }
}
