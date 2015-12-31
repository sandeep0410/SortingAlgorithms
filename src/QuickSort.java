/**
 * 
 */

/**
 * @author Sandeep
 *
 */
public class QuickSort {
	public static void quicksort(int[] arr, int start, int end){
		if(start>=end)
			return;
		int i=start, j=start;
		while(j<end){
			if(arr[j]>arr[end])
				j++;
			else{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
				i++;
				j++;
			}
		}
		int temp = arr[end];
		arr[end]=arr[i];
		arr[i]=temp;
		quicksort(arr, start, i-1);
		quicksort(arr,i+1, end);
	}
}
