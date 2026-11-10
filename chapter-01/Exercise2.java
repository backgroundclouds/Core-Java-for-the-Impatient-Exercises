public class Exercise2{

    public static void main(String args[]){

        exercise2a(args);
        exercise2b(args);

        return;
    }

    private static void exercise2a(String[] args){
        if(args.length == 0){
            System.out.println("no arguments provided");
            return;
        }
        if(args.length > 1){
            System.out.println("Woah daddy, that's too many arguments");
            return;
        }
        System.out.println("Exercise 2a");
        int arg = Integer.parseInt(args[0]);

        //normalize
        int normalize = arg % 359;

        //true mod
        int absolute = (359 + normalize) % 359;

        System.out.println("Integer angle entered : " + arg);
        System.out.println("Normalized value is : " + absolute + "\n");


        return;
    }

    private static void exercise2b(String[] args){
        if(args.length == 0){
            System.out.println("no arguments provided");
            return;
        }
        if(args.length > 1){
            System.out.println("Woah daddy, that's too many arguments");
            return;
        }
        System.out.println("Exercise 2b");
        int arg = Integer.parseInt(args[0]);

        int normalize=  Math.floorMod(arg, 359);
        int absolute = Math.floorMod(arg + 359, 359);

        System.out.println("Integer angle entered : " + arg);
        System.out.println("Normalized value is : " + absolute);

        return;
    }


}