
public class MergeSortUnique {
    // Main procedure to test
    public static void main(String[] args) {
        int[] array = {52, 21, 11, 4, 52, 21, 91, 72, 89, 31, 72, 72};
        
        System.out.println("Original array:");
        printArray(array);
        
        int[] sortedUniqueArray = mergeSort(array);
        
        System.out.println("\nSorted array with no duplicates:");
        printArray(sortedUniqueArray);
    }
    
    // Procedure MergeSort(array)
    public static int[] mergeSort(int[] array) {
        // First sort the array
        sort(array, 0, array.length - 1);
        
        // Then remove duplicates
        return removeDuplicates(array);
    }
    
    // Procedure Sort(array, left, right)
    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            // Sort first half
            sort(array, left, mid);
            
            // Sort second half
            sort(array, mid + 1, right);
            
            // Merge sorted halves
            merge(array, left, mid, right);
        }
    }
    
    // Procedure Merge(array, left, mid, right)
    private static void merge(int[] array, int left, int mid, int right) {
        // Create temporary arrays
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];
        
        // Fill temporary arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[mid + 1 + i];
        }
        
        // Initialize indices
        int i = 0, j = 0, k = left;
        
        // Merge arrays
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray
        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray
        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    // Procedure RemoveDuplicates(array)
    private static int[] removeDuplicates(int[] array) {
        if (array.length == 0) return array;
        
        // Count unique elements
        int uniqueCount = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                uniqueCount++;
            }
        }
        
        // Create result array
        int[] result = new int[uniqueCount];
        result[0] = array[0];
        int index = 1;
        
        // Fill result array with unique elements
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                result[index] = array[i];
                index++;
            }
        }
        
        return result;
    }
    
    // Procedure PrintArray(array)
    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
