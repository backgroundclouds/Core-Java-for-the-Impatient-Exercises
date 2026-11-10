import java.util.Random;
import java.util.Scanner;

//7. Write a program that reads in two integers between 0 and 4294967295, stores them in int variables, and computes and displays their unsigned sum, difference, product, quotient, and remainder. Do not convert them to long values.
public class Exercise7{

    static public void main(String[] args){

        var scanner = new Scanner(System.in);
        

        System.out.println("Enter first integer : ");
        int first = validateUnsignedInteger(scanner);
        System.out.println("Enter second integer : ");
        int second = validateUnsignedInteger(scanner);

        
        System.out.println("sum is : " + (first+second));

        //find greater value for difference 
        // if greater than 0 first integer is largest
        if((Integer.compareUnsigned(first, second)) > 0){
            System.out.println("difference is " + (first - second));
        }
        else{
            System.out.println("difference is " + (second - first));

        }
        System.out.println("product is : " + (first * second));

        System.out.println("quotient is : " + Integer.divideUnsigned(first, second));
        System.out.println("remainder is : " + Integer.remainderUnsigned(first, second));


        var largestInt = Integer.MAX_VALUE;
        System.out.println("largest int is ... " + largestInt);
        unsignedIntegerValues(largestInt);

        String largestIntS = Integer.toString(largestInt);
        var demo2 = Integer.parseUnsignedInt(largestIntS);
        demo2++;
        unsignedIntegerValues(demo2);
        
        return;
    }

    public static int validateUnsignedInteger(Scanner scanner){
        int value = 0;
        boolean validity = false;
        while(!validity){
        try{
            String input = scanner.next();
            value = Integer.parseUnsignedInt(input);
            validity = true;            
        }
        catch(NumberFormatException e){
            System.out.println("Try again. Enter a 32 bit unsigned integer.");
        }
        }
        return value;
    }

    public static void unsignedIntegerValues(int unsigned){
        
        System.out.println("unsigned integer : " + Integer.toUnsignedString(unsigned));
        System.out.println("signed version of unsigned integer: " + unsigned);
        System.out.println("binary string of unsigned integer: " + Integer.toBinaryString(unsigned));
        System.out.println("hex string of unsigned integer: " + Integer.toHexString(unsigned) + "\n");

    }
}