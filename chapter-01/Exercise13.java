import java.util.Arrays;

//13. Write a switch statement that, when given a string with a compass direction "N", "S", "E", or "W", adjusts the variables x and y. For example, "W" should decrement x by 1.
class Exercise13{

    static public void main(String[] args){

        String direction = "N";
        int[] coords = { 10, 4} ;
        System.out.println("Coords are : " + Arrays.toString(coords));
        increment(direction, coords);

        //after
        System.out.println("After switch");
        System.out.println("Coords are : " + Arrays.toString(coords));

    return;
}
public static void increment(String direction, int[] coords){
            switch(direction.toUpperCase()){
            case "N": 
                coords[1] +=1;
                break;
            case "S":
                 coords[1]-=1;
                 break;
            case "E":
                coords[0]+=1;
                break;
            case "W": 
                coords[0]-=1;
            default:
                 throw new IllegalArgumentException("Invalid entry");
    };

    return;
}
}