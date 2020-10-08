package inLab2Stuff;

import java.util.*;
public class RandomNumbers {


    public static void main(String[] args) {
        String R_value = args[0];
        String N_Value = args[1];
        // creating two integers from the command line
        // R creates an Array, and N creates random numbers between 0 and N
        int R = Integer.parseInt(R_value);
        int N = Integer.parseInt(N_Value);

        Random randomGenerator = new Random();
        // creating an array
        int[] myArray = new int[N];
        System.out.println("Length of Array: " + N);

        // filling that array with random integers of Length R
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = randomGenerator.nextInt(R);
        }
        System.out.println("Random Numbers between 0 and " + (R-1) + ": " + Arrays.toString(myArray));
        System.out.println();
        // creating a hashmap object, they serve sort of like a dictionary
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        // populating the hash map with the elements from my array
        for (int i = 0; i < myArray.length; i++) {
            myHashMap.put(myArray[i], 0);
        }
        // keeping track of how many times the same element showed up in my array
        for (int i = 0; i < myArray.length; i++) {
            if (myHashMap.containsKey(myArray[i])) {
                myHashMap.merge(myArray[i], 1, Integer::sum);
            }
        }
        // some formatting to make things look nice
        for (int i = 0; i < myArray.length; i++) {
            if (myHashMap.get(i) == null){
                System.out.println("The element: " + i + " appears 0 times");
            }
            else System.out.println("The element: " + i + " appears " + myHashMap.get(i) + " times");
        }
    }
}
