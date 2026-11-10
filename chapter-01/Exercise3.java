public class Exercise3{

    public static void main(String[] args){
        exercise3a(args);
        exercise3b(args);

        return;
    }

    private static void exercise3a(String[] args){
        if(args.length < 3){
        System.out.println("Three arguments needed");
            return;
        }
        if(args.length > 3){
            System.out.println("Woah daddy, that's too many arguments");
            return;
        }
        System.out.println("Exercise 3a");
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int largest = ( a > b) 
        ? (a > c ? a : c)
        : (b > c ? b : c) ;

        System.out.println("largest argument entered is : " + largest + "\n");
        return;
    }

    private static void exercise3b(String[] args){
        if(args.length < 3){
        System.out.println("Three arguments needed");
            return;
        }
        if(args.length > 3){
            System.out.println("Woah daddy, that's too many arguments");
            return;
        }
        System.out.println("Exercise 3b");
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int largest = Math.max(a, b);
        largest = Math.max(largest, c);

        System.out.println("largest argument entered is : " + largest);
        return;

    }



}