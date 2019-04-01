package trinarysearch;

/**
 * @author Benjamin Finotti
 * September 2nd, 2018
 * Computer Science 333: Algorithms and Data Structures
 * TrinarySearch assignment, splits an array into thirds looking for the "target" number.
 */
public class TrinarySearch {

    public static int trinarySearch(int[] arr, int lowerBound, int upperBound, int target){
        int firstThird = lowerBound + (upperBound - lowerBound)/3;
        int secondThird = firstThird + (upperBound - lowerBound)/3;
        
        if(lowerBound > upperBound){
            return -1;
        }else if(target > arr[secondThird]){
            return trinarySearch(arr, secondThird+1, upperBound, target); //If the target is in the "top" 1/3rd.
        }else if(target > arr[firstThird]){
            return trinarySearch(arr, firstThird+1, secondThird, target); //If the target is in the "middle" 1/3rd.
        }else if(target < arr[firstThird]){
            return trinarySearch(arr, lowerBound, firstThird-1, target); //If the target is in the "bottom" 1/3rd.           
        }else{
            return firstThird;    
        }
    }
    
    public static void main(String[] args) {
        int[] testArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Expecting '2' to be at index 1, found at: " + 
                trinarySearch(testArray1, 0, testArray1.length-1, 2));
        
        int[] testArray2 = {1, 2, 3, 4, 4, 6, 7, 8, 9};
        System.out.println("Expecting '4' to be at the earliest index(3), found at: " + 
                trinarySearch(testArray2, 0, testArray1.length-1, 4));
        
        int[] testArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Looking for '10' which isn't in the array: " + 
                trinarySearch(testArray3, 0, testArray1.length-1, 10));
        
        int[] testArray4 = {1, 2, 3, 4, 5, 6, 9, 9, 9};
        System.out.println("Expecting '9' to be at the earliest index(6), found at: " + 
                trinarySearch(testArray4, 0, testArray1.length-1, 9));
        
        int[] testArray5 = {1, 1, 2, 4, 5, 6, 7, 8, 9};
        System.out.println("Expecting '1' to be at the earliest index(0), found at: " + 
                trinarySearch(testArray5, 0, testArray1.length-1, 1));
    }
    
}
