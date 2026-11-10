import java.util.Arrays;
//12. Write a switch expression that, when given a string with a compass direction "N", "S", "E", or "W", yields an array of x- and y-offsets. For example, "W" should yield new int[] { -1, 0 }.
class Exercise12{

    static public void main(String[] args){

        String direction = "N";

        int[] offset = switch (direction.toUpperCase()) {

            case "N" -> new int[] { 0, 1};
            case "S" -> new int[] { 0, -1};
            case "E" -> new int[] {1, 0};
            case "W" -> new int[] {-1, 0};
            default -> throw new IllegalArgumentException("Invalid entry");
    };
    System.out.println("Array is ");
    System.out.println(Arrays.toString(offset));

    return;
}
}