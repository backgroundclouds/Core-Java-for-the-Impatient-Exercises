import java.text.DecimalFormat;
//Exercise5 - What happens when you cast a double to an int that is larger than the largest possible int value? Try it out.

public class Exercise5{


    public static void main(String[] args){
        var largest_int = Integer.MAX_VALUE;
        System.out.println("largest int is :" + largest_int);

        var largest_dub = Double.MAX_VALUE;


        DecimalFormat df = new DecimalFormat("#,##0");
        String largest_dub_str = df.format(largest_dub);
        System.out.println("largest dub is : " + largest_dub);
        System.out.println("AKA");
        System.out.println( largest_dub_str);

        int castedBoy = (int) largest_dub;
        System.out.println("Casted boy is " + castedBoy);

        return;
    }


}