import java.util.Scanner;
import java.util.Objects;

//9. Section 1.5.3, "String Comparison" (page 26) has an example of two strings s and t so that s.equals(t) but s != t. Come up with a different example that doesn't use substring.
public class Exercise9{

    static public void main(String[] args){

        var one = new String("highboy");
        var two = new String("lowboy");

        if(one.equalsIgnoreCase(two)){
            System.out.println("String one and two are the same");
        }
        else{
            System.out.println("String one and two are NOT the same!!!!!!");
            
        };



        return;
    }
}