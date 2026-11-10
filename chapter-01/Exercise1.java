import java.util.Formatter;

//Exercise 1
//Write a program that reads an integer and prints it in binary, octal, and hexadecimal. Print the reciprocal as a hexadecimal floating-point number.
public class Exercise1{

    public static void main(String args[]){
        if(args.length == 0){
            System.out.println("no arguments provided");
            return;
        }
        if(args.length > 1){
            System.out.println("Woah daddy, that's too many arguments");
            return;
        }
        int arg = Integer.parseInt(args[0]);

        String binary = Integer.toBinaryString(arg);
        System.out.printf("Integer argument as binary : %s \n", binary);

        String octal = Integer.toOctalString(arg);
        System.out.printf("Integer argument as Octal : %s \n", octal);

        String hex = Integer.toHexString(arg);
        System.out.printf("Integer argument as hexidecimal : %s \n", hex);

        double reciprocal = (1.0/arg);
        String reciprocalHex = Double.toHexString(reciprocal);
        System.out.printf("Reciprocal of Integer argument as Floating Point hexidecimal : %s \n", reciprocalHex);

        return;
    }
}