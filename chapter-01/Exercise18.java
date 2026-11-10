import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.Arrays;

//Exercise 18
//18. Write a program that prints a lottery combination, picking six distinct numbers between 1 and 49. To pick six distinct numbers, start with an array list filled with 1...49. Pick a random index and remove the element. Repeat six times. Print the result in sorted order.

class Exercise19{
    static public void main(String[] args){

        //pick six numbers from 1 to 49 with an array list
        ArrayList<Integer> lottoPool = new ArrayList<>(48); 
        //Populate list with values 1 through 49
        for(int i = 1; i <= 49; i++){
            int j = i -1;
            lottoPool.add(j, i);
        }

        // Array for selected values
        int[] selects = new int[6];
        int poolSize = 48;

        RandomGenerator rand = RandomGenerator.getDefault();

        for(int i = 0; i < 6; i++){
            int  index = rand.nextInt(poolSize);
            selects[i] = lottoPool.remove(index); 
            poolSize--; //decrement pool of random indexes
        }
        Arrays.sort(selects); 
        for(int i = 0; i < 6; i++){
        System.out.println(selects[i]);
        }
        return;
    } 
}