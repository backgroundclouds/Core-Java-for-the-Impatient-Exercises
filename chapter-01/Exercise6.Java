import java.math.*;

//6. Write a program that computes the factorial n! = 1 × 2 × ... × n, using BigInteger. Compute the factorial of 1000.
public class Exercise6{

    static public void main(String[] args){
        long n = 1000;
        BigInteger fact = factorial(n);
        System.out.println(fact);

        return;
    }

    public static BigInteger factorial(long n){
        if(n < 0){
            throw new IllegalArgumentException("Value less than Zero not allowed ");
        }

        BigInteger fact = BigInteger.ONE;
        for(long i = 1; i <= n ; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        };
        return fact;

    }


}