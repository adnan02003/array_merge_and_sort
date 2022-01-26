package array_merge_and_sort;

import java.util.Arrays;

public class ArrayMergeAndSort {

	public static void main(String[] args) {
		
		int[] firstArray = {1,3,5,7,8}; 
		int[] secondArray = {2,4,6,9,10};
		
		System.out.println("Array 1 : "+Arrays.toString(firstArray));
		System.out.println("Array 2 : "+Arrays.toString(secondArray));
		
		int[]  mergedArray = merge(firstArray,secondArray);
		 
		System.out.println("Merged : "+Arrays.toString(mergedArray));
		
		quickSort(mergedArray,0,mergedArray.length-1);
		
		System.out.println("Sorted : "+Arrays.toString(mergedArray));

	}
	
	private static int[] merge(int []arr1, int []arr2) {
		
		int length = arr1.length + arr2.length; //add the length of firstArray into secondArray  
		int[] mergedArray = new int[length];    //resultant array  
		int pos = 0;  
		for (int element : arr1) //copying elements of secondArray using for-each loop  
		{  
		mergedArray[pos] = element;  
		pos++;              //increases position by 1  
		}  
		for (int element : arr2) //copying elements of firstArray using for-each loop  
		{  
		mergedArray[pos] = element;  
		pos++;  
		} 
		
		return mergedArray;
		
	}
	
	public static void quickSort(int[] arr, int low, int high) 
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }
         
        if (low >= high){
            return;
        }
 
        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
 
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) 
        {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) 
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot) 
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (i <= j) 
            {
                flip (arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }
     
    public static void flip (int array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
