import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise20{

    static public void main(String[] args){

        //un-comment for static string testing
        // var scanner = new Scanner(testInput5);

        // var scanner = new Scanner(System.in);
        //use an ArrayList of ArrayLists
        var listOfLists = new ArrayList<ArrayList<Integer>>();
        
        System.out.println("Enter input");

        while(scanner.hasNextLine()){
            //input to string
            String capture = scanner.nextLine().trim();
            
            if(capture.isEmpty()){
                //finish submission when an empty line is submitted
                break;
            }
            //string parsed to string array
            String[] StrNumbers = capture.split("\\s");

            var tempRow = new ArrayList<Integer>(); // initialize a temporary ArrayList, because we don't know the size of any row being created
            
            //string to int
            for( String eye : StrNumbers ){
                int i = Integer.parseInt(eye);
                tempRow.add(i);
            }//pass temporary ArrayList to an index with ArrayLists of ArrayLists
            listOfLists.add(tempRow);
        }
        //make a static array (b/c it's easier to deal with)
        int rows = listOfLists.size();
        int[][] input = new int[rows][];

        for( int i = 0; i < rows ; i++){
            ArrayList<Integer> eachRow = listOfLists.get(i);
            int rowSize = eachRow.size();
            input[i] = new int[rowSize]; // declare an array of matching size within i'th row

            for(int j =0; j < rowSize; j++){
                input[i][j] = eachRow.get(j);
            }
 
        }
        //////////
        ////////Start Testing to see if input is a magic square

        //1. Check to see if input is actually a square
        if(!isInputSquare(input)){
                System.out.println(FAIL_MSG1);
                return;
        }
        //2. Use a while loop to make sure all row sums, column sums, diagonal sums match
        boolean isMagic = true;      //bool for final message
        boolean checkingSums = true; //bool for while loop
        int n = input.length; //row size
        while(checkingSums){        
                //A) Row Sums
                int firstRowSum = 0;
                for(int i =0; i < n ; i++){
                    firstRowSum += input[0][i];
                }
                for(int i = 1; i < n ; i++){
                    int rowSum = 0;
                    for(int j=0; j < n ;j++){
                        rowSum += input[i][j];
                    }
                    if(rowSum != firstRowSum){
                        isMagic = false;
                        checkingSums = false;
                        break;
                    }
                    rowSum = 0; // reset rowSum
                }
                //B) Column Sums
                for( int j =0; j < n; j++){
                    int colSum = 0;
                    for(int i = 0; i < n; i++){
                        colSum += input[i][j];
                    }
                    if(colSum != firstRowSum){
                        isMagic = false;
                        checkingSums = false;
                        break;
                    }
                }
                //C) Diagonal Sums
                int primaryDiagonal =0;
                int secondaryDiagonal =0;
                for(int i =0; i < n ; i++){
                    primaryDiagonal += input[i][i];
                    secondaryDiagonal += input[i][n - 1 - i];
                }
                if(secondaryDiagonal != firstRowSum || primaryDiagonal != firstRowSum){
                    isMagic = false;
                    checkingSums = false;
                    break;
                }
                checkingSums = false; 
        }
    
    //Handle Results
         if(!isMagic){
            System.out.println(FAIL_MSG2);
            return;
        }
        else{
            System.out.print("Input is a magic square");
        }
        return;
    }
    private static boolean isInputSquare(int[][] input){
        int n = input.length; //get row size // ie amount of arrays within
        //make sure each array within has the same length
        for(int i =0; i < n ; i++){
            if (input[i].length != n){
                return false;
            }
        }
        return true;
    }
    private static final String FAIL_MSG1 = """
            Input is not a square.
            Try again.
            """;

    private static final String FAIL_MSG2 = """
            Square is not magic.
            Try again.
            """;

    private static final String testInput1 = """
            16 3 2 13
            5 10 11 8
            9 6 7 12
            4 15 14 1
            """;
    private static final String testInput2 = """
            64 51 2 13 32 19 34 45
            53 58 11 8 21 26 43 40
            57 54 7 12 25 22 39 44
            52 63 14 1 20 31 46 33
            16 3 50 61 48 35 18 29
            5 10 59 56 37 42 27 24
            9 6 55 60 41 38 23 28
            4 15 62 49 36 47 30 17
            """;
    private static final String testInput3 = """
            114 140 3 34 35 1 78 104 75 106 107 73
            7 119 135 28 8 30 79 83 99 100 80 102
            19 14 124 123 23 24 91 86 88 87 95 96
            18 20 130 129 17 13 90 92 94 93 89 85
            25 137 118 9 26 12 97 101 82 81 98 84
            144 113 33 4 2 31 108 77 105 76 74 103
            6 32 111 142 143 109 42 68 39 70 71 37
            115 11 27 136 116 138 43 47 63 64 44 66
            127 122 16 15 131 132 55 50 52 51 59 60
            126 128 22 21 125 121 54 56 58 57 53 49
            133 29 10 117 134 120 61 65 46 45 62 48
            36 5 141 112 110 139 72 41 69 40 38 67
            """;
    private static final String testInput4 = """
            143 109 6 26 19 24 107 73 78 98 91 96
            3 140 115 21 23 25 75 104 79 93 95 97
            31 9 110 130 27 20 103 81 74 94 99 92
            8 28 141 125 10 15 80 100 105 89 82 87
            30 113 142 12 14 16 102 77 106 84 86 88
            112 144 29 13 18 11 76 108 101 85 90 83
            35 1 114 134 127 132 71 37 42 62 55 60
            111 32 7 129 131 133 39 68 43 57 59 61
            139 117 2 22 135 128 67 45 38 58 63 56
            116 136 33 17 118 123 44 64 69 53 46 51
            138 5 34 120 122 124 66 41 70 48 50 52
            4 36 137 121 126 119 40 72 65 49 54 47
            """;

    private static final String testInput5 = """
            35 1 6 26 19 24
            3 32 7 21 23 25
            31 9 2 22 27 20
            8 28 33 17 10 15
            30 5 34 12 14 16
            4 36 29 13 18 11
            """;
}