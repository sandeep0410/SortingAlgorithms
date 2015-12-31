/**
 * 
 */

/**
 * @author Sandeep
 *
 */
public class MergeSort {
	public static int[] mergeSort(int[] arr){
		if(arr.length>1){
			int mid = arr.length/2;
			int[] left = new int[mid];
			int[] right;
			if(arr.length%2==1)
				right = new int[mid+1];
			else
				right = new int[mid];
			for(int i=0;i<arr.length; i++){
				if(i<mid)
					left[i] = arr[i];
				right[i-mid]=arr[i];
			}
			
			left = mergeSort(left);
			right = mergeSort(right);
			arr = merge(left,right);
		}
		return arr;
	}

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	private static int[] merge(int[] left, int[] right) {
		int[] res = new int[left.length+right.length];
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length){
			if(left[i]<right[j]){
				res[k++]=left[i++];
			}else
				res[k++]=right[j++];
		}
		while(i<left.length)
			res[k++]=left[i++];
		while(j<right.length)
			res[k++] = right[j++];
		return res;
	}
}
