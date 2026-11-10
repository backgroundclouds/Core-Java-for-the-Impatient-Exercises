import java.util.Scanner;

//8. Write a program that reads a string and prints all of its nonempty substrings.
public class Exercise8{

    static public void main(String[] args){

        Scanner scanny = new Scanner(System.in);
        System.out.println("Give some input : ");
        String someInput = scanny.nextLine();
        int length = someInput.length();
        if(!someInput.isEmpty()){
            for(int i = 0; i < length; i++){
                for(int j = i+1; j <= length; j++){
                    System.out.println(someInput.substring(i, j));
                }
            }
        }
        return;
    }
}