import java.util.Scanner;

//11. Write a program that reads a line of text and prints all characters that are not ASCII, together with their Unicode values.
public class Exercise11{

    static public void main(String[] args){

            var scanner = new Scanner(System.in);

            System.out.println("Enter input : ");
            String input = scanner.nextLine();

            int length = input.length();
            
            char[] allCharacters = input.toCharArray();


            for ( int i = 0, j =0; i < length ; i++){
                if(allCharacters[i] > 127){
                    int intCharacter = (int) allCharacters[i];
                    System.out.println(allCharacters[i] + " : " + intCharacter);
       
                }
            }

        return;
    }
}
