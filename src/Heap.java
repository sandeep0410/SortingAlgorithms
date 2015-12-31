/**
 * 
 */

/**
 * @author Sandeep
 *
 */
public class Heap {
	int MAX_SIZE = 1000;
	int[] arr = new int[MAX_SIZE];
	int size = 0;

	public void printHeap() {
		if (size == 0)
			System.out.println("Nothing to print");
		for(int i=0; i<size; i++)
			System.out.println(arr[i]);
	}

	public boolean insert(int num) {
		if (size == MAX_SIZE) {
			System.out.println("Heap is full. Can't input more elements");
			return false;
		}
		arr[size++] = num;
		reverseHeapify(size - 1);
		//printHeap();
		return true;
	}

	public void reverseHeapify(int index) {
		if (index == 0)
			return;
		int parent = (index - 1) / 2;
		if (arr[parent] < arr[index]) {
			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
			reverseHeapify(parent);
		} else
			return;
	}

	public int delete() {
		if (size == 0) {
			return -1;
		}
		int ans = arr[size - 1];
		arr[0] = arr[size - 1];
		size--;
		heapify(0);
		//printHeap();
		return ans;
	}

	public void heapify(int index) {
		if (index >= size)
			return;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		if (left < size) {
			if (right < size) {
				if (arr[left] > arr[right] && arr[left] > arr[index]) {
					int temp = arr[left];
					arr[left] = arr[index];
					arr[index] = temp;
					heapify(left);
				} else if (arr[right] > arr[left] && arr[right] > arr[index]) {
					int temp = arr[right];
					arr[right] = arr[index];
					arr[index] = temp;
					heapify(right);
				}
			} else {
				if (arr[left] > arr[index]) {
					int temp = arr[left];
					arr[left] = arr[index];
					arr[index] = temp;
					heapify(left);
				}
			}

		}

	}

}
