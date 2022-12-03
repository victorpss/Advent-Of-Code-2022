import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day1_1 {

    public static void main(String[] args) {

        int major = 0;

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

                }

            }

        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        finally {
            System.out.println(major); //print the biggest number
        }

    }
}
