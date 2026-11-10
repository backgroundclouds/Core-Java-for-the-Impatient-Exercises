import java.util.Random;

//10. Write a program that produces a random string of letters and digits by generating a random long value and printing it in base 36.
public class Exercise10{

    static public void main(String[] args){

        var rand = new Random();
        //generate a random long value
        long value = rand.nextLong();

        //print it in string alpha base 36
        String print = Long.toString(value, 36);
        System.out.println(print);

        return;
    }
}