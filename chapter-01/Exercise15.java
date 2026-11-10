import java.util.Scanner;

//15. Come up with a useful scenario where the fall-through behavior is beneficial for a switch expression or statement. Most web searches will produce examples that make sense for C or C++, where execution falls from case A with no action to case B. In Java, that is not significant because you can use case A, B.

public class Exercise15{
    static public void main(String[] args){

        int points = 0 ;

        var scanner = new Scanner(System.in);
        System.out.println("Enter Gold, Silver, or Bronze");
        String tier = scanner.next();

        // var tier = new String("silver");
        switch(tier.toUpperCase()){
            case "GOLD" : points+=100;
            case "SILVER" : points += 50;
            case "BRONZE" : points +=25;
            default: points+=0; break;
        };

        System.out.println("You have " + points + " points!");

        return;
    }
}