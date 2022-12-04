import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day4_1 {

    public static void main(String[] args) {

        int cont = 0;

        try {
            FileReader fr = new FileReader("Puzzle4_input");

            Scanner scan = new Scanner(fr);

            String line = "";


            int[] sections = new int[4]; //sections 0 and 1 = first elf; sections 2 and 3 = second elf


            while ((scan.hasNext())) {

                String aux = "";

                int j = 0;

                line = scan.nextLine();

                for(int i = 0; i < line.length(); i++){

                    Character c = line.charAt(i);

                    if(Character.isDigit(c)){
                        aux += c;
                    }

                    else if (i<line.length()-1){
                        sections[j] = Integer.parseInt(aux);
                        aux = "";
                        j++;
                    }

                    if (i == line.length() - 1){ //getting the last section of the line bc has no - or , after it
                        sections[j] = Integer.parseInt(aux);
                    }

                }


                if (sections[0] >= sections[2] && sections[1] <= sections[3] ||  sections[2] >= sections[0] && sections[3] <= sections[1]) {
                    cont++;
                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        finally {
            System.out.println("Total: "+ cont);
        }
    }
}
